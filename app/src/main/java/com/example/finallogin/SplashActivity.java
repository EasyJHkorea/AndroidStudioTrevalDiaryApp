package com.example.finallogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

    protected void onCreate(Bundle savdInstanceState){
        super.onCreate(savdInstanceState);

        try{
            Thread.sleep(3000);

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
