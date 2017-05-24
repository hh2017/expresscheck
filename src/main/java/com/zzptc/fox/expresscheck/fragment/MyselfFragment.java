package com.zzptc.fox.expresscheck.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zzptc.fox.expresscheck.Myhelps.DBDao;
import com.zzptc.fox.expresscheck.R;
import com.zzptc.fox.expresscheck.adapter.RecordItemAdapter;
import com.zzptc.fox.expresscheck.beans.ExpressCheckBean;

import java.util.List;

/**
 * @auther : wanderders
 * @date : 2016/9/19
 * @instructions : 显示快递查询历史记录
 */
public class MyselfFragment extends Fragment {

    private ListView lv_record;

    private DBDao mDbdao;
    private RecordItemAdapter adapter;
    private List<ExpressCheckBean> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myself, container, false);

        mDbdao = new DBDao(getContext());

        lv_record = (ListView) view.findViewById(R.id.lv_record);
        mList = mDbdao.selectAllExpre();
        adapter = new RecordItemAdapter(mList, getContext());
        lv_record.setAdapter(adapter);

        lv_record.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, final long id) {
                new AlertDialog.Builder(getActivity())
                        .setTitle(getString(R.string.hint))
                        .setMessage(getString(R.string.delete))
                        .setPositiveButton(getString(R.string.flase), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(getString(R.string.ture), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mDbdao.delete(mList.get(position).getTv_date());
                                mList.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        }).show();
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        registerForContextMenu(lv_record);

        return view;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if(adapter != null){
                adapter.update(mDbdao.selectAllExpre());
            }
        }
    }
}
