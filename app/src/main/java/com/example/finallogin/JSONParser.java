package com.example.finallogin;


import android.content.ContentValues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JSONParser {
    public static JSONObject uploadImage(String imageUploadUrl, String sourceImageFile) {
        final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*");
        //인덱스 번호 확인(데이터베이스)
        String idx="";

        // HttpURLConnection 참조 변수.
        HttpURLConnection urlConn = null;
        // URL 뒤에 붙여서 보낼 파라미터.
        StringBuffer sbParams = new StringBuffer();

        try{
            URL url = new URL("https://eotjr90.cafe24.com/searching_index.php");
            urlConn = (HttpURLConnection) url.openConnection();

            // [2-1]. urlConn 설정.
            urlConn.setRequestMethod("POST"); // URL 요청에 대한 메소드 설정 : POST.
            urlConn.setRequestProperty("Accept-Charset", "UTF-8"); // Accept-Charset 설정.
            urlConn.setRequestProperty("Context_Type", "application/x-www-form-urlencoded;cahrset=UTF-8");

            // [2-2]. parameter 전달 및 데이터 읽어오기.
            String strParams = sbParams.toString(); //sbParams에 정리한 파라미터들을 스트링으로 저장. 예)id=id1&pw=123;
            OutputStream os = urlConn.getOutputStream();
            os.write(strParams.getBytes("UTF-8")); // 출력 스트림에 출력.
            os.flush(); // 출력 스트림을 플러시(비운다)하고 버퍼링 된 모든 출력 바이트를 강제 실행.
            os.close(); // 출력 스트림을 닫고 모든 시스템 자원을 해제.
            // [2-3]. 연결 요청 확인.
            // 실패 시 null을 리턴하고 메서드를 종료.
            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK)
                return null;

            // [2-4]. 읽어온 결과물 리턴.
            // 요청한 URL의 출력물을 BufferedReader로 받는다.
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));

            // 출력물의 라인과 그 합에 대한 변수.
            String line;

            // 라인을 받아와 합친다.
            while ((line = reader.readLine()) != null){
                idx += line;
            }

            idx = idx.replace("\"", "");

        } catch (MalformedURLException e) { // for URL.
            e.printStackTrace();
        } catch (IOException e) { // for openConnection().
            e.printStackTrace();
        } finally {
            if (urlConn != null)
                urlConn.disconnect();
        }

        try {
            File sourceFile = new File(sourceImageFile);
            Log.d("TAG", "File...::::" + sourceFile + " : " + sourceFile.exists());
            String filename = sourceImageFile.substring(sourceImageFile.lastIndexOf("/")+1);

            Log.d("TAG", "File2...::::" + filename);

            idx = (Integer.toString(Integer.parseInt(idx) + 1));

            // 사진 전송 php
            RequestBody requestBody2 = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("idx", idx)
                    .addFormDataPart("uploaded_file", filename, RequestBody.create(MultipartBody.FORM, sourceFile))
                    .addFormDataPart("result", "photo_image")
                    .build();

            JSONObject jsonObject = new JSONObject();
            try{
                jsonObject.put("idx", idx.toString());

            }catch (JSONException e){
                e.printStackTrace();
            }


            Request request2 = new Request.Builder()
                    .url(imageUploadUrl)
                    .post(requestBody2)
                    .build();

            OkHttpClient client2 = new OkHttpClient();
            Response response2 = client2.newCall(request2).execute();

            Log.d("TAG", "File3...::::" + response2);

            if (response2 != null) {
                if (response2.isSuccessful()) {
                    String res = response2.body().string();
                    Log.e("TAG", "Error: " + res);
                    return new JSONObject(res);
                }
            }


        } catch (UnknownHostException | UnsupportedEncodingException e) {
            Log.e("TAG", "Error: " + e.getLocalizedMessage());
        } catch (Exception e) {
            Log.e("TAG", "Other Error: " + e.getLocalizedMessage());
        }
        return null;
    }
}


