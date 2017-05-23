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
 * @date : 2016/10/27
 * @instructions :
 *
 */
public class RecordActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_record)
    Toolbar toolbar_record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.toolbar_record})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_record:
                finish();
                break;
            default:
                break;
        }
    }
}
