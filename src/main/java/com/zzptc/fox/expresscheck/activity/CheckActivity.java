package com.zzptc.fox.expresscheck.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zzptc.fox.expresscheck.R;
import com.zzptc.fox.expresscheck.adapter.MyFragmentStatePagerAdapter;
import com.zzptc.fox.expresscheck.beans.ExpressCheckBean;
import com.zzptc.fox.expresscheck.fragment.AboutFragment;
import com.zzptc.fox.expresscheck.fragment.CheckFragment;
import com.zzptc.fox.expresscheck.fragment.GuideFragment;
import com.zzptc.fox.expresscheck.fragment.MyselfFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 * @auther : wanderders
 * @date : 2016/8/1
 * @instructions : 主界面显示
 *
 */
public class CheckActivity extends FragmentActivity {

    @Bind(R.id.rg_btn)
    RadioGroup rg_btn;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private ArrayList<Fragment> al;

    private MyselfFragment mMyselfFragment;
    private List<ExpressCheckBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        ButterKnife.bind(this);


        mMyselfFragment = new MyselfFragment();

        //储存需要的fragment
        al = new ArrayList<>();
        al.add(new CheckFragment());
        al.add(new MyselfFragment());
        al.add(new GuideFragment());
        al.add(new AboutFragment());

        final MyFragmentStatePagerAdapter adapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), al);
        viewpager.setAdapter(adapter);

        onClick();
    }

    void onClick() {
        rg_btn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = 0;
                switch (checkedId) {
                    case R.id.r_select:
                        position = 0;
                        break;
                    case R.id.r_myself:
                        position = 1;
                        mMyselfFragment.update();
                        Toast.makeText(CheckActivity.this,"嘿嘿",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.r_guide:
                        position = 2;
                        break;
                    case R.id.r_about:
                        position = 3;
                        break;
                }
                viewpager.setCurrentItem(position);
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rg_btn.check(R.id.r_select);
                        break;
                    case 1:
                        rg_btn.check(R.id.r_myself);
                        Toast.makeText(CheckActivity.this,"嘿嘿",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        rg_btn.check(R.id.r_guide);
                        break;
                    case 3:
                        rg_btn.check(R.id.r_about);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}