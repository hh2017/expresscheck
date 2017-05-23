package com.zzptc.fox.expresscheck.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzptc.fox.expresscheck.R;
import com.zzptc.fox.expresscheck.beans.GuideMessage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @auther : wanderders
 * @date : 2016/7/23
 * @instructions :
 *
 */
public class ListItemAdapter extends BaseAdapter {

    private List<GuideMessage> mGuideMessages;
    private LayoutInflater mLayoutInflater;


    public ListItemAdapter(String[] name, int[] pic, String[] phone, Context context) {
        mGuideMessages = new ArrayList<GuideMessage>();
        mLayoutInflater = LayoutInflater.from(context);
        for (int i = 0; i < pic.length; i++) {
            GuideMessage message = new GuideMessage(name[i], pic[i], phone[i]);
            mGuideMessages.add(message);
        }
    }

    @Override
    public int getCount() {
        return mGuideMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return mGuideMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            //将条目布局 转化成 convertView
            convertView = mLayoutInflater.inflate(R.layout.list_item, parent, false);

            viewHolder.iv_guide = (ImageView) convertView.findViewById(R.id.iv_guide);
            viewHolder.tv_guidename = (TextView) convertView.findViewById(R.id.tv_guidename);
            viewHolder.tv_guidephone = (TextView) convertView.findViewById(R.id.tv_guidephone);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        GuideMessage message = mGuideMessages.get(position);

        viewHolder.iv_guide.setImageResource(message.getPic());
        viewHolder.tv_guidename.setText(message.getName());
        viewHolder.tv_guidephone.setText(message.getPhone());

        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.WHITE);
        } else {
            convertView.setBackgroundColor(Color.LTGRAY);

        }
        return convertView;
    }


    class ViewHolder {
        ImageView iv_guide;
        TextView tv_guidename;
        TextView tv_guidephone;
    }

}
