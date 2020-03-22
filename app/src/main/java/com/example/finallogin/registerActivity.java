package com.example.finallogin;

import android.net.nsd.NsdManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class registerActivity extends AppCompatActivity {

    private String userID;
    private String userPassword;
    private String userGender;
    private String userEmail;
    private AlertDialog dialog;
    private boolean validate=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText idText = (EditText)findViewById(R.id.idText);
        final EditText passwordText =(EditText)findViewById(R.id.passwordText);
        final EditText emailText=(EditText)findViewById(R.id.emailText);

        RadioGroup genderGroup = (RadioGroup)findViewById(R.id.genderGroup);
        int genderGroupID=genderGroup.getCheckedRadioButtonId();
        userGender=((RadioButton)findViewById(genderGroupID)).getText().toString();

        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                RadioButton genderButton=(RadioButton)findViewById(i);
                userGender=genderButton.getText().toString();
            }
        });

        final Button validateButton = (Button)findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID=idText.getText().toString();
                if(validate){

                    return;
                }
                if(userID.equals("")){
                    AlertDialog.Builder builder=new AlertDialog.Builder(registerActivity.this,R.style.MyAlertDialogStyle);
                    dialog = builder.setMessage("아이디는 빈칸일 수 없습니다.")
                            .setPositiveButton("확인",null)
                            .create();
                    dialog.show();
                    return;


                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success =jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder=new AlertDialog.Builder(registerActivity.this, R.style.MyAlertDialogStyle);
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .setPositiveButton("확인",null)
                                        .create();
                                dialog.show();
                                idText.setEnabled(false);
                                validate=true;

                                   /* idText.setBackground(getResources().getColor(R.id.colorGray));
                                    validateButton.setBackgroundColor(getResources().getColor(R.id.colorGray));*/
                            }

                            else{
                                AlertDialog.Builder builder=new AlertDialog.Builder(registerActivity.this, R.style.MyAlertDialogStyle);
                                dialog = builder.setMessage("사용할 수 없는 아이디입니다.")
                                        .setNegativeButton("확인",null)
                                        .create();
                                dialog.show();

                            }

                        }
                        catch (Exception e){

                            e.printStackTrace();
                        }

                    }
                };

                ValidateRequest validateRequest=new ValidateRequest(userID,responseListener);
                RequestQueue queue= Volley.newRequestQueue(registerActivity.this);
                queue.add(validateRequest);

            }
        });

        Button registerButton =(Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID=idText.getText().toString();
                String userPassword=passwordText.getText().toString();
                String userEmail=emailText.getText().toString();


                if(!validate){
                    AlertDialog.Builder builder=new AlertDialog.Builder(registerActivity.this, R.style.MyAlertDialogStyle);
                    dialog = builder.setMessage("아이디 중복확인을 해주세요..")
                            .setNegativeButton("확인",null)
                            .create();
                    dialog.show();
                    return;

                }
                if(userID.equals("")||userPassword.equals("")||userGender.equals("")||userEmail.equals("")){
                    AlertDialog.Builder builder=new AlertDialog.Builder(registerActivity.this, R.style.MyAlertDialogStyle);
                    dialog = builder.setMessage("빈칸을 입력해주세요.")
                            .setNegativeButton("확인",null)
                            .create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success =jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder=new AlertDialog.Builder(registerActivity.this, R.style.MyAlertDialogStyle);
                                dialog = builder.setMessage("회원등록에 성공하였습니다.")
                                        .setPositiveButton("확인",null)
                                        .create();
                                dialog.show();
                                finish();
                            }

                            else{
                                AlertDialog.Builder builder=new AlertDialog.Builder(registerActivity.this, R.style.MyAlertDialogStyle);
                                dialog = builder.setMessage("회원등록에 실패했습니다.")
                                        .setNegativeButton("확인",null)
                                        .create();
                                dialog.show();

                            }

                        }
                        catch (Exception e){

                            e.printStackTrace();
                        }
                    }
                };

                registerRequest registerRequest=new registerRequest(userID,userPassword,userGender,userEmail,responseListener);
                RequestQueue queue= Volley.newRequestQueue(registerActivity.this);
                queue.add(registerRequest);


            }
        });
    }

    protected void onStop(){
        super.onStop();
        if(dialog!=null){
            dialog.dismiss();
            dialog=null;
        }

    }
}