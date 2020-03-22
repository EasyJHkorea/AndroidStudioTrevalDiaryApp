package com.example.finallogin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
//fnvgh

public class registerRequest extends StringRequest {

    final static private String URL="https://eotjr90.cafe24.com/UserRegister.php";
    private Map<String,String> parameters;

    public registerRequest(String userID, String userPassword, String userGender, String userEmail, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);
        parameters=new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userPassword",userPassword);
        parameters.put("userGender",userGender);
        parameters.put("userEmail",userEmail);

    }
    @Override
    public Map<String,String>getParams(){
        return parameters;
    }

}
