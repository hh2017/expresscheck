package com.zzptc.fox.expresscheck.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zzptc.fox.expresscheck.beans.ExpressCheckBean;
import com.zzptc.fox.expresscheck.fragment.MyselfFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @auther : wanderders
 * @date : 2016/8/1
 * @instructions : viewpager换页的适配器
 *
 */

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter{
    //用于储存所有的fragment
    private ArrayList<Fragment> mFragments;


    public MyFragmentStatePagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;

    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


}
