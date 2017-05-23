package com.zzptc.fox.expresscheck.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zzptc.fox.expresscheck.Myhelps.DBDao;
import com.zzptc.fox.expresscheck.R;
import com.zzptc.fox.expresscheck.Utils;
import com.zzptc.fox.expresscheck.beans.Bean;
import com.zzptc.fox.expresscheck.beans.ExpressCheckBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @auther : wanderders
 * @date : 2016/11/3
 * @instructions :
 */
public class TraceActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_trace)
    Toolbar toolbarTrace;
    @Bind(R.id.tv_company)
    TextView tv_company;
    @Bind(R.id.tv_bianhao)
    TextView tv_bianhao;
    @Bind(R.id.lv_trace)
    ListView lv_trace;

    private DBDao dbdao;
    private List<String> list = new ArrayList<String>();
    private ArrayAdapter traceListItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace);
        ButterKnife.bind(this);
        dbdao = new DBDao(this);

        /**
         * 从意图中把值拿回来
         */
        String result = getIntent().getStringExtra("result_key");

        traceListItemAdapter = new ArrayAdapter<String>(this, R.layout.trace_list_item, list);
        //json解析数据
        try {
            JSONObject jsonObject = new JSONObject(result);
            final Bean bean = new Gson().fromJson(String.valueOf(jsonObject), Bean.class);
            String LogisticCode = bean.getLogisticCode();
            String ShipperCode = bean.getShipperCode();

            List<Bean.TracesBean> Traces = bean.getTraces();
            if (Traces != null) {
                for (int i = 0; i < Traces.size(); i++) {
                    //这是一个类似数组，不是真的数组，解析出来再添加回到集合里
                    String AcceptTime = Traces.get(i).getAcceptTime();
                    String AcceptStation = Traces.get(i).getAcceptStation();
                    list.add(AcceptTime);
                    list.add(AcceptStation);
                }
            }
            tv_bianhao.setText(getString(R.string.danHao) + LogisticCode);


            /**把获取到的快递公司编码转化为文字显示在TextView上*/
            HashMap<String, String> map = Utils.mExpressMap;
            Collection<String> collection = map.values();
            Iterator<String> iterator = collection.iterator();
            Collection<String> keys = map.keySet();
            Iterator<String> key_i = keys.iterator();
            String key = "";
            while (iterator.hasNext() && key_i.hasNext()) {
                String code = iterator.next();
                key = key_i.next();
                if (code != null) {
                    if (ShipperCode.equals(code)) {
                        tv_company.setText(getString(R.string.company) + key);
                        break;
                    }
                }

            }

            /**获取系统时间*/
            SimpleDateFormat formatter = new SimpleDateFormat(getString(R.string.systemTime));
            Date date = new Date(System.currentTimeMillis());
            String str = formatter.format(date);

            ExpressCheckBean bean1 = new ExpressCheckBean();
            bean1.setTv_date(str);
            bean1.setTv_danhao(LogisticCode);
            bean1.setTv_companyname(key);
            dbdao.insert(bean1);
            lv_trace.setAdapter(traceListItemAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @OnClick({R.id.toolbar_trace})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_trace:
                finish();
                break;
            default:
                break;
        }
    }
}
