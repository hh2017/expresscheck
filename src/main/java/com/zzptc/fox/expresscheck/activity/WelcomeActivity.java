package com.zzptc.fox.expresscheck.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.zzptc.fox.expresscheck.MainActivity;
import com.zzptc.fox.expresscheck.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 * @auther : wanderders
 * @date : 2016/8/1
 * @instructions :
 *
 */
public class WelcomeActivity extends AppCompatActivity {

    @Bind(R.id.iv_welcome)
    ImageView iv_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.welcome_alpha_anim);
        iv_welcome.startAnimation(alpha);
        //给动画添加监听器  当动画结束之后  跳转到主界面 并结束当前activity
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
