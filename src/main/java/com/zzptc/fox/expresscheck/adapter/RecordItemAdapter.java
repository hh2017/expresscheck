package com.zzptc.fox.expresscheck.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zzptc.fox.expresscheck.R;
import com.zzptc.fox.expresscheck.beans.ExpressCheckBean;

import java.util.List;

/**
 * @auther : wanderders
 * @date : 2016/10/27
 * @instructions :
 */
public class RecordItemAdapter extends BaseAdapter {

    private List<ExpressCheckBean> mRecordMessages;
    private LayoutInflater mLayoutInflater;

    public RecordItemAdapter(List<ExpressCheckBean> recordMessages, Context context) {
        this.mRecordMessages = recordMessages;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void update(List<ExpressCheckBean> data) {
        mRecordMessages.clear();
        mRecordMessages.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mRecordMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return mRecordMessages.get(position);
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
            convertView = mLayoutInflater.inflate(R.layout.record_item, parent, false);

            viewHolder.tv_companyname = (TextView) convertView.findViewById(R.id.tv_companyname);
            viewHolder.tv_danhao = (TextView) convertView.findViewById(R.id.tv_danhao);
            viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ExpressCheckBean message = mRecordMessages.get(position);

        viewHolder.tv_companyname.setText(message.getTv_companyname());
        viewHolder.tv_danhao.setText(message.getTv_danhao());
        viewHolder.tv_date.setText(message.getTv_date());

        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.WHITE);
        } else {
            convertView.setBackgroundColor(Color.LTGRAY);

        }

        return convertView;
    }

    class ViewHolder {
        TextView tv_companyname;
        TextView tv_danhao;
        TextView tv_date;
    }
}
