package com.example.finallogin;

import android.Manifest;
import android.app.Notification;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.finallogin.R.layout.activity_post;
import static com.example.finallogin.R.layout.fui_idp_button_facebook;
import static java.lang.Float.valueOf;

//2019.08.22
public class Post extends FragmentActivity implements OnMapReadyCallback {

    Context mContext;

    private static final int PICK_FROM_CAMERA = 1; //카메라 촬영으로 사진 가져오기
    private static final int PICK_FROM_ALBUM = 2; //앨범에서 사진 가져오기
    private static final int CROP_FROM_CAMERA = 3; // 가져온 사진을 자르기 위한 변수

    private Uri mImageCaptureUri;
    private Bitmap mImageBitmap;
    String imagePath;

    private int Gender;
    private int Age;
    private int City;
    private int Day;
    private int Money;
    private int Who;
    private int Type;
    private String User;

    private String str;
    private TextView STAR;


    private Button selectButton, mapButton, postButton, categoryButton;
    private EditText text1,text2,text3,mapText;
    private AlertDialog dialog;
    final static int SELECT_IMAGE = 1;
    private GoogleMap mMap;
    private Geocoder geocoder;
    ImageView imageView;
    private final String items[]={"사진 촬영","앨범","취소"};

    ProgressDialog progressDialog; // API 26에서 deprecated

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_post);


        mapText = (EditText) findViewById(R.id.maptext);
        mapButton = (Button) findViewById(R.id.mapbutton);
        STAR=(TextView)findViewById(R.id.rating);

        final EditText text1 = (EditText) findViewById(R.id.text1);
        final EditText text2 = (EditText) findViewById(R.id.text2);
        final EditText text3 = (EditText) findViewById(R.id.text3);
        RatingBar Star=(RatingBar)findViewById(R.id.ratingBar1);
        Star.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    STAR.setText(""+rating);

            }
        });


        mContext = getApplicationContext();





        if (Build.VERSION.SDK_INT >= 23) {
            PermissionCheck permissionCheck = new PermissionCheck(Post.this);
            if (permissionCheck.checkPermissions() == false) {
                finish();
            }
        }
        selectButton = (Button) findViewById(R.id.select);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGallery();
            }
        });

        imageView = (ImageView) findViewById(R.id.imageview1);


        // 선택된 사진을 받아 서버에 업로드한다.

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        final Intent intent=getIntent();

        Gender=intent.getIntExtra("gender",-1);
        Age=intent.getIntExtra("age",-1);
        City=intent.getIntExtra("city",-1);
        Day=intent.getIntExtra("day",-1);
        Money=intent.getIntExtra("money",-1);
        Who=intent.getIntExtra("who",-1);
        Type=intent.getIntExtra("type",-1);
        User=SuccessActivity.usetidtestt;


        postButton = (Button) findViewById(R.id.postbutton);
        postButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String gender=Integer.toString(Gender);
                        String age=Integer.toString(Age);
                        String city=Integer.toString(City);
                        String day=Integer.toString(Day);
                        String money=Integer.toString(Money);
                        String who=Integer.toString(Who);
                        String type=Integer.toString(Type);

                        String textone=text1.getText().toString();
                        String texttwo=text2.getText().toString();
                        String textthree=text3.getText().toString();
                        String star=STAR.getText().toString();
                        String address=str;
                String userid=User;

                int a;



                long now=System.currentTimeMillis();
                Date date=new Date(now);

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String time=sdf.format(date);

                Response.Listener<String> responseLister=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse =new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success){
                                image();
                                Toast.makeText(Post.this,"게시글이 작성 되었습니다.",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(Post.this,SuccessActivity.class);
                                startActivity(intent);
                                finish();

                            }

                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                postRequest postRequest = new postRequest(textone,texttwo,textthree,gender,age,city,day,money,who,type,time,star,address,userid,responseLister);
                RequestQueue queue= Volley.newRequestQueue(Post.this);
                queue.add(postRequest);

            }

        });


    }
    //
    private class ImageUploadTask extends AsyncTask<String, Integer, Boolean> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(Post.this);
            progressDialog.setMessage("이미지 업로드중....");
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(String... params) {

            try {
                JSONObject jsonObject = JSONParser.uploadImage(params[0], params[1]);
                if (jsonObject != null) {
                    return jsonObject.getString("result").equals("success");
                }
            } catch (JSONException e) {
                Log.i("TAG", "Error : " + e.getLocalizedMessage());
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (progressDialog != null)
                progressDialog.dismiss();

            if (aBoolean) {
                Toast.makeText(getApplicationContext(), "파일 업로드 성공", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "파일 업로드 실패", Toast.LENGTH_LONG).show();
            }

            // 임시 파일 삭제 (카메라로 사진 촬영한 이미지)
            if (mImageCaptureUri != null) {
                File file = new File(mImageCaptureUri.getPath());
                if (file.exists()) {
                    file.delete();
                }
                mImageCaptureUri = null;
            }

            imagePath = "";
            imageView.setVisibility(View.INVISIBLE);

        }
    }

    // 사진 선택을 위해 갤러리를 호출
    private void getGallery() {
        // File System.
        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_PICK);

        // Chooser of file system options.
        final Intent chooserIntent = Intent.createChooser(galleryIntent, "Select Image");
        startActivityForResult(chooserIntent, PICK_FROM_ALBUM);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        switch (requestCode) {
            case PICK_FROM_ALBUM: {
                // URI 정보를 이용하여 이미지(사진) 정보를 가져온다.
                if (data == null) {
                    Toast.makeText(mContext, "Unable to Pickup Image", Toast.LENGTH_SHORT).show();
                    return;
                }
                Uri selectedImageUri = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(selectedImageUri, filePathColumn, null, null, null);

                if (cursor != null) {
                    cursor.moveToFirst();

                    imagePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));

                    Picasso.with(mContext).load(new File(imagePath))
                            .into(imageView); // 피카소 라이브러를 이용하여 선택한 이미지를 imageView에 출력
                    cursor.close();

                } else {
                    Snackbar.make(findViewById(R.id.parentView), "Unable to Load Image", Snackbar.LENGTH_LONG).setAction("Try Again", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getGallery();
                        }
                    }).show();
                }


                imageView.setVisibility(View.VISIBLE);
                break;
            }

            case PICK_FROM_CAMERA: {
                // 이미지를 가져온 이후의 리사이즈할 이미지 크기를 결정
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mImageCaptureUri, "image/*");

                // CROP할 이미지를 125*170 크기로 저장
//                intent.putExtra("outputX", 125); // CROP한 이미지의 x축 크기
//                intent.putExtra("outputY", 170); // CROP한 이미지의 y축 크기
//                intent.putExtra("aspectX", 1); // CROP 박스의 X축 비율
//                intent.putExtra("aspectY", 1); // CROP 박스의 Y축 비율
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);

                startActivityForResult(intent, CROP_FROM_CAMERA); // CROP_FROM_CAMERA case문 이동
                break;
            }

            case CROP_FROM_CAMERA: {
                // CROP 된 이후의 이미지를 넘겨 받음
                final Bundle extras = data.getExtras();
                if (extras != null) {
                    //mImageBitmap = extras.getParcelable("data"); // CROP된 BITMAP
                    mImageBitmap = (Bitmap) data.getExtras().get("data"); // CROP된 BITMAP
                    // 레이아웃의 이미지칸에 CROP된 BITMAP을 보여줌
                    saveCropImage(mImageBitmap, imagePath); //  CROP 된 이미지를 외부저장소, 앨범에 저장
                    break;
                }

                Picasso.with(mContext).load(new File(imagePath))
                        .into(imageView); // 피카소 라이브러를 이용하여 선택한 이미지를 imageView에 출력


                imageView.setVisibility(View.VISIBLE);
                break;
            }

        }

    }


    // Bitmap 을 저장하는 메소드
    private void saveCropImage(Bitmap bitmap, String filePath) {
        File copyFile = new File(filePath);
        BufferedOutputStream bos = null;
        try {
            copyFile.createNewFile();
            bos = new BufferedOutputStream(new FileOutputStream(copyFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos); // 이미지가 클 경우 OutOfMemoryException 발생이 예상되어 압축
            // sendBroadcast를 통해 Crop된 사진을 앨범에 보이도록 갱신한다.
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(copyFile)));

            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */



    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        geocoder = new Geocoder(this);

        // 맵 터치 이벤트 구현 //
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
            @Override
            public void onMapClick(LatLng point) {
                MarkerOptions mOptions = new MarkerOptions();
                // 마커 타이틀
                mOptions.title("마커 좌표");
                Double latitude = point.latitude; // 위도
                Double longitude = point.longitude; // 경도
                // 마커의 스니펫(간단한 텍스트) 설정
                mOptions.snippet(latitude.toString() + ", " + longitude.toString());
                // LatLng: 위도 경도 쌍을 나타냄
                mOptions.position(new LatLng(latitude, longitude));
                // 마커(핀) 추가
                googleMap.addMarker(mOptions);
            }
        });
        ////////////////////

        // 버튼 이벤트
        mapButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                str=mapText.getText().toString();
                List<Address> addressList = null;
                try {
                    // editText에 입력한 텍스트(주소, 지역, 장소 등)을 지오 코딩을 이용해 변환
                    addressList = geocoder.getFromLocationName(
                            str, // 주소
                            10); // 최대 검색 결과 개수
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(addressList.get(0).toString());
                // 콤마를 기준으로 split
                String []splitStr = addressList.get(0).toString().split(",");
                String address = splitStr[0].substring(splitStr[0].indexOf("\"") + 1,splitStr[0].length() - 2); // 주소
                System.out.println(address);

                String latitude = splitStr[10].substring(splitStr[10].indexOf("=") + 1); // 위도
                String longitude = splitStr[12].substring(splitStr[12].indexOf("=") + 1); // 경도
                System.out.println(latitude);
                System.out.println(longitude);

                // 좌표(위도, 경도) 생성
                LatLng point = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
                // 마커 생성
                MarkerOptions mOptions2 = new MarkerOptions();
                mOptions2.title("search result");
                mOptions2.snippet(address);
                mOptions2.position(point);
                // 마커 추가
                mMap.addMarker(mOptions2);
                // 해당 좌표로 화면 줌
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point,15));
            }
        });
        ////////////////////

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void clearClick(View v) {
        switch (v.getId()) {
            case R.id.text1:
                text1.setText(null);
                break;
            case R.id.text2:
                text2.setText(null);
                break;
            case R.id.text3:
                text3.setText(null);
            case R.id.maptext:
                mapText.setText(null);
                break;

        }
    }

    private void image() {
        if (!TextUtils.isEmpty(imagePath)) {
            if (NetworkHelper.checkConnection(mContext)) { // 인터넷 연결 체크
                String ImageUploadURL = "https://eotjr90.cafe24.com/image2.php";
                new ImageUploadTask().execute(ImageUploadURL, imagePath);
                finish();
            } else {
                Toast.makeText(mContext, "인터넷 연결을 확인하세요", Toast.LENGTH_LONG).show();

            }
        } else {
            Toast.makeText(mContext, "먼저 업로드할 파일을 선택하세요", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressDialog.dismiss();
    }
}
