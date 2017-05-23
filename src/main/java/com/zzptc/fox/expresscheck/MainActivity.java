package com.zzptc.fox.expresscheck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.zzptc.fox.expresscheck.activity.CheckActivity;
import com.zzptc.fox.expresscheck.activity.WelcomeActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    int x = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            sp = getSharedPreferences("panduan",MODE_PRIVATE);

            boolean isFirst = sp.getBoolean("isfirst",true);

        //判断是否第一次进入
            if(isFirst){

                sp.edit().putBoolean("isfirst",false).commit();

                startActivity(new Intent(this, WelcomeActivity.class));
            }else{
                startActivity(new Intent(this, CheckActivity.class));
            }

            finish();


  }

    }
