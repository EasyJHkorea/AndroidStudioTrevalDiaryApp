package com.example.finallogin;

import android.content.Intent;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class commentRequest extends StringRequest {

    final static private String URL="https://eotjr90.cafe24.com/commentRegister.php";
    private Map<String,String> parameters;

    public commentRequest(String writeuserid,String commentuserid,String comment,String commentdate,String ind, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);
        parameters=new HashMap<>();

        parameters.put("writeuserid",writeuserid);
        parameters.put("commentuserid",commentuserid);
        parameters.put("comment",comment);
        parameters.put("commentdate",commentdate);
        parameters.put("ind", ind);

    }

    @Override
    public Map<String,String>getParams(){
        return parameters;
    }

}
