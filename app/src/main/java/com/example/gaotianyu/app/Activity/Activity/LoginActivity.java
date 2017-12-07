package com.example.gaotianyu.app.Activity.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gaotianyu.app.Activity.User.UserManage;
import com.example.gaotianyu.app.R;

public class LoginActivity extends AppCompatActivity {
    private EditText editText_user;
    private EditText editText_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText_user = (EditText) findViewById(R.id.et_user);
        editText_pwd = (EditText) findViewById(R.id.et_pwd);
        Button button_login = (Button)findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String user_name = editText_user.getText().toString();
                                    String pwd = editText_pwd.getText().toString();
                                    UserManage.getInstance().saveUserinfo(LoginActivity.this,user_name,pwd);
                                    Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();
                            /*
                            OkHttpClient client = new OkHttpClient();
                            //上传数据
                            RequestBody requestBody = new FormBody.Builder()
                                    .add("username",user_name)
                                    .add("password",pwd)
                                    .build();
                            Request request = new Request.Builder()
                                    .url("")//服务器网址
                                    .post(requestBody)
                                    .build();
                            //获得返回数据
                            Response response = client.newCall(request).execute();

                            */

                                }
                            });

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });

    }
}
