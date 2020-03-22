package com.example.finallogin;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class postRequest extends StringRequest {

    final static private String URL="https://eotjr90.cafe24.com/text.php";
    private Map<String,String> parameters;

    public postRequest(String textone,String texttwo,String textthree,String gender,String age,String city,String day,String money,String who,String type,String time,String star,String address,String userid,Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);
        parameters=new HashMap<>();
        parameters.put("textone",textone);
        parameters.put("texttwo",texttwo);
        parameters.put("textthree",textthree);
        parameters.put("gender",gender);
        parameters.put("age",age);
        parameters.put("city",city);
        parameters.put("day",day);
        parameters.put("money",money);
        parameters.put("who",who);
        parameters.put("type",type);
        parameters.put("time",time);
        parameters.put("star",star);
        parameters.put("address",address);
        parameters.put("userid",userid);


    }
    @Override
    public Map<String,String>getParams(){
        return parameters;
    }


}
