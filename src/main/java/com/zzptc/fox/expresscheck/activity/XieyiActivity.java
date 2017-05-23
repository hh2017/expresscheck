package com.zzptc.fox.expresscheck.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zzptc.fox.expresscheck.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * @auther : wanderders
 * @date : 2016/10/31
 * @instructions :
 *
 */
public class XieyiActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_xieyi)
    Toolbar toolbarXieyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xieyi);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toolbar_xieyi})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_xieyi:
                finish();
                break;
            default:
                break;
        }
    }
}
