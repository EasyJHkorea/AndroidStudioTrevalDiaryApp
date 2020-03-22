package com.example.finallogin;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class commentActivity extends AppCompatActivity {

    private EditText commentText;

    private ListView commentListView;
    //courseListView
    private commentlistAdapter Adaper;
    //adapter
    private List<receivecomment> commentList;

    private String writeuserid;
    private String ind;
    private String commentdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);


        Intent intent=getIntent();
        writeuserid=intent.getStringExtra("writeUserId");
        ind=intent.getStringExtra("ind");

        //idx값 받아오기
        final String commentuserid=SuccessActivity.usetidtestt;
        commentText=(EditText)findViewById(R.id.commentText);
        Button commentButton=(Button)findViewById(R.id.commentButton);

        commentListView=(ListView)findViewById(R.id.commentListView);
        commentList=new ArrayList<receivecomment>();
        Adaper=new commentlistAdapter(getApplicationContext(),commentList);
        commentListView.setAdapter(Adaper);

        new BackgroudTask().execute();
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String comment=commentText.getText().toString();

                long now=System.currentTimeMillis();
                Date date=new Date(now);

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                commentdate=sdf.format(date);

                Response.Listener<String> responseLister=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse =new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success){
                                Toast.makeText(commentActivity.this,"comment를 작성하였습니다.",Toast.LENGTH_LONG).show();
                                commentText.setText("");
                                new BackgroudTask().execute();
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                commentRequest commentRequest = new commentRequest(writeuserid,commentuserid,comment,commentdate,ind,responseLister);
                //idx값 받아오면 변경하기
                RequestQueue queue= Volley.newRequestQueue(commentActivity.this);
                queue.add(commentRequest);
                //여기까지 서버에 내용 전송하는 과정



                //다음은 listview에 받는 과정


            }
        });

    }



    class BackgroudTask extends AsyncTask<Void,Void,String>
    {

        String target;

        protected void onPreExecute(){

            try {
                target = "https://eotjr90.cafe24.com/commentView.php?ind="
                        + URLEncoder.encode(ind, "UTF-8")
                + "&writeuserid=" + URLEncoder.encode(writeuserid, "UTF-8");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            } }


        // idx,writeuserid전송

        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder=new StringBuilder();
                while ((temp=bufferedReader.readLine())!=null){
                    stringBuilder.append(temp+"Wn");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;

        }

        @Override
        public void onProgressUpdate(Void...values){super.onProgressUpdate();}


        @Override
        public void onPostExecute(String result){
            try {
                commentList.clear();
                JSONObject jsonObject=new JSONObject(result);
                JSONArray jsonArray=jsonObject.getJSONArray("response");
                int count=0;
                String commentuserid;
                String comment;
                String commentdate;

                while (count<jsonArray.length())
                {
                    JSONObject object=jsonArray.getJSONObject(count);
                    commentuserid=object.getString("commentuserid");
                    comment=object.getString("comment");
                    commentdate=object.getString("commentdate");

                    receivecomment receivecomment=new receivecomment(commentuserid,comment,commentdate);
                    commentList.add(receivecomment);

                    count++;
                }


                Adaper.notifyDataSetChanged();

            }
            catch (Exception e){
                e.printStackTrace();
            }



        }




    }



}
