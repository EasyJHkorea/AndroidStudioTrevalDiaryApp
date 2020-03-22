package com.example.finallogin;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Categorypost extends AppCompatActivity {
    private int gender;
    private int age;
    private int city;
    private int day;
    private int money;
    private int who;
    private int type;
    private ListView categorylistView;
    private PostListadapter categoryadapter;
    private List<receivepost> categorylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorypost);

        categorylistView=(ListView)findViewById(R.id.categorylist);
        categorylist=new ArrayList<receivepost>();
        categoryadapter=new PostListadapter(getApplicationContext(),categorylist);
        categorylistView.setAdapter(categoryadapter);

        final Intent intent=getIntent();

        gender=intent.getIntExtra("gender",-1);
        age=intent.getIntExtra("age",-1);
        city=intent.getIntExtra("city",-1);
        day=intent.getIntExtra("day",-1);
        money=intent.getIntExtra("money",-1);
        who=intent.getIntExtra("who",-1);
        type=intent.getIntExtra("type",-1);
        new BackgroudTask3().execute();


    }


    class BackgroudTask3 extends AsyncTask<Void,Void,String> {
        String target;

        @Override
        protected void onPreExecute() {
            try {
                target = "https://eotjr90.cafe24.com/text_category.php?gender="
                        + URLEncoder.encode(String.valueOf(gender), "UTF-8")
                        + "&age=" + URLEncoder.encode(String.valueOf(age), "UTF-8")
                        + "&city=" + URLEncoder.encode(String.valueOf(city), "UTF-8")
                        + "&day=" + URLEncoder.encode(String.valueOf(day), "UTF-8")
                        + "&money=" + URLEncoder.encode(String.valueOf(money), "UTF-8")
                        + "&who=" + URLEncoder.encode(String.valueOf(who), "UTF-8")
                        + "&type=" + URLEncoder.encode(String.valueOf(type), "UTF-8");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuilder.append(temp + "Wn");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate();
        }


        @Override
        public void onPostExecute(String result) {
            if (result != null) {
                try {
                    categorylist.clear();
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    int count = 0;
                    String address;
                    String userid;
                    String time;
                    String textone;
                    String texttwo;
                    String textthree;
                    String star;
                    String ind;

                    while (count < jsonArray.length()) {
                        JSONObject object = jsonArray.getJSONObject(count);
                        textone = object.getString("textone");
                        texttwo = object.getString("texttwo");
                        textthree = object.getString("textthree");
                        address = object.getString("address");
                        time = object.getString("time");
                        userid = object.getString("userid");
                        star = object.getString("star");
                        ind=object.getString("ind");
                        receivepost receivepost = new receivepost(address, userid, time, textone, texttwo, textthree, star,ind);
                        categorylist.add(receivepost);
                        count++;


                    }
                    if (count == 0) {

                        AlertDialog dialog;
                        AlertDialog.Builder builder = new AlertDialog.Builder(Categorypost.this);
                        dialog = builder.setMessage("게시글이 없습니다.")
                                .create();
                        dialog.show();
                    }
                    categoryadapter.notifyDataSetChanged();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(Categorypost.this, "오류입니다.", Toast.LENGTH_SHORT).show();
            }


        }


    }}
