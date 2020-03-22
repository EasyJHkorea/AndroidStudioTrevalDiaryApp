package com.example.finallogin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CategoryRequest extends StringRequest {

    final static private String URL="https://eotjr90.cafe24.com/categoryRegister.php";
    private Map<String,String> parameters;

    public CategoryRequest(int choice[], Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);
        parameters=new HashMap<>();
        parameters.put("gender",Integer.toString(choice[0]));
        parameters.put("age",Integer.toString(choice[1]));
        parameters.put("city",Integer.toString(choice[2]));
        parameters.put("day",Integer.toString(choice[3]));
        parameters.put("money",Integer.toString(choice[4]));
        parameters.put("who",Integer.toString(choice[5]));
        parameters.put("type",Integer.toString(choice[6]));
    }

    @Override
    public Map<String,String>getParams(){
        return parameters;
    }

}