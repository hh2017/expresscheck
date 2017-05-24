package com.zzptc.fox.expresscheck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
public class MoreActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_more)
    Toolbar toolbarMore;
    @Bind(R.id.tv_haoping)
    TextView tvHaoping;
    @Bind(R.id.l_xieyi)
    LinearLayout lXieyi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.toolbar_more,R.id.tv_haoping,R.id.l_xieyi})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_more:
                finish();
                break;

            case R.id.tv_haoping:
                Toast.makeText(MoreActivity.this, "五星好评，评论不超过15个字，去广告概率更高", Toast.LENGTH_LONG).show();
                break;

            case R.id.l_xieyi:
                Intent intent_xieYi = new Intent(MoreActivity.this, XieyiActivity.class);
                startActivity(intent_xieYi);
                break;

            default:
                break;
        }
    }
}
