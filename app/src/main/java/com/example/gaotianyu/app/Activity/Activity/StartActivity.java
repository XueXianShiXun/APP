package com.example.gaotianyu.app.Activity.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gaotianyu.app.Activity.User.UserManage;
import com.example.gaotianyu.app.R;

public class StartActivity extends AppCompatActivity {
    private static final int GO_MAIN = 0;
    private static final int GO_LOGIN = 1;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case GO_MAIN:
                    Intent intent1 = new Intent(StartActivity.this,MainActivity.class);
                    startActivity(intent1);
                    finish();
                    break;
                case GO_LOGIN:
                    Intent intent2 = new Intent(StartActivity.this,LoginActivity.class);
                    startActivity(intent2);
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        if(UserManage.getInstance().hasUserInfo(this)){
            Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(GO_MAIN,2000);
        }else {
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageAtTime(GO_LOGIN,2000);
        }
    }
}