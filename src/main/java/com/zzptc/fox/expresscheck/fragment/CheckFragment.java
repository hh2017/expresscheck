package com.zzptc.fox.expresscheck.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.zzptc.fox.expresscheck.Query;
import com.zzptc.fox.expresscheck.R;
import com.zzptc.fox.expresscheck.Utils;
import com.zzptc.fox.expresscheck.activity.TraceActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckFragment extends Fragment {

    @Bind(R.id.spinner)
    Spinner spinner;
    @Bind(R.id.e_danhao)
    EditText e_danDao;
    @Bind(R.id.btn_query)
    Button btn_query;

    private String mExpressName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check, container, false);
        ButterKnife.bind(this, view);
        getActivity();

        // 建立数据源
        final String[] mItems = getResources().getStringArray(R.array.spinner);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner.setAdapter(adapter);

        final String[] spinners = getResources().getStringArray(R.array.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mExpressName = Utils.mExpressMap.get(spinners[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        return view;
    }


    @OnClick({R.id.btn_query})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_query:
                String text = e_danDao.getText().toString();

                if (text != null & text.length() != 0) {
                    new Thread() {
                        @Override
                        public void run() {
                            Query api = new Query();
                            try {
                                //返回快递公司的编号
                                final String result = api.getOrderTracesByJson(mExpressName, e_danDao.getText().toString());
                                Log.e("ceshi", result);
                                //跳转到activity要在主线程里跳转
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(getActivity(), TraceActivity.class);
                                        intent.putExtra("result_key", result);
                                        startActivity(intent);
                                        e_danDao.setText("");
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                } else {
                    Toast.makeText(getActivity(), getString(R.string.input_bianhao), Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
