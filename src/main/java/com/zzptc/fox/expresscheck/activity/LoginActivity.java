package com.zzptc.fox.expresscheck.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zzptc.fox.expresscheck.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_login)
    Toolbar toolbar_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toolbar_login})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_login:
                finish();
                break;
            default:
                break;
        }
    }
}
