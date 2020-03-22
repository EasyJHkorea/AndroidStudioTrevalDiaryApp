package com.example.finallogin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.Rating;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class PostListadapter extends BaseAdapter {

    private Context context;
    private List<receivepost> postList;
    ImageView imageView;
    String imgUrl = "https://eotjr90.cafe24.com/photos/";
    Bitmap bmImg;
    back task;


    public PostListadapter(Context context, List<receivepost> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int i) {
        return postList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.post_item, null);
        TextView textone = (TextView) v.findViewById(R.id.text1);
        TextView texttwo = (TextView) v.findViewById(R.id.text2);
        TextView textthree = (TextView) v.findViewById(R.id.text3);
        TextView address = (TextView) v.findViewById(R.id.address);
        TextView time = (TextView) v.findViewById(R.id.Date);
        TextView userid = (TextView) v.findViewById(R.id.userid);
        final TextView ind = (TextView) v.findViewById(R.id.idx);
        RatingBar star = (RatingBar) v.findViewById(R.id.rating2);


        textone.setText(postList.get(i).getTextone());
        texttwo.setText(postList.get(i).getTexttwo());
        textthree.setText(postList.get(i).getTextthree());
        address.setText(postList.get(i).getAddress());
        time.setText(postList.get(i).getTime());
        userid.setText(postList.get(i).getUserid());
        star.setRating(Float.parseFloat(postList.get(i).getStar()));
        ind.setText(postList.get(i).getInd());
        v.setTag(postList.get(i).getTextone());


        final String Userid = userid.getText().toString();
        final String Ind = ind.getText().toString();

        task = new back();
        imageView = (ImageView) v.findViewById(R.id.postImage);
        task.execute(imgUrl + Ind + ".jpg");


        ImageButton commentButton = (ImageButton) v.findViewById(R.id.message);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), commentActivity.class);
                intent.putExtra("writeUserId", Userid);
                intent.putExtra("ind", Ind);
                v.getContext().startActivity(intent);

            }
        });
        return v;
    }

    private class back extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            // TODO Auto-generated method stub
            try {
                URL myFileUrl = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();

                InputStream is = conn.getInputStream();

                bmImg = BitmapFactory.decodeStream(is);




            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmImg;
        }


        protected void onPostExecute(Bitmap img) {

            imageView.setImageBitmap(bmImg);
        }


    }


}











