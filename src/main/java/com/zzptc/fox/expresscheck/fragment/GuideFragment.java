package com.zzptc.fox.expresscheck.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zzptc.fox.expresscheck.R;
import com.zzptc.fox.expresscheck.adapter.ListItemAdapter;
import com.zzptc.fox.expresscheck.beans.GuideMessage;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends Fragment {

    @Bind(R.id.list_item)
    ListView list_item;

    int position = 0;
    private List<GuideMessage> mGuideMessages;
    private ListItemAdapter mAdapter;


    //快递名字
    private String[] name = new String[]{"AAE全球专递", "BHT", "DHL", "D速快递", "EMS", "FedEx", "TNT", "UPS", "一邦速递", "中国邮政", "中通速递", "中邮物流", "中铁快运", "亚风速递", "京广速递",
            "优速物流", "佳吉物流", "信丰物流", "元智捷诚快递", "全一快递", "全日通快递", "全晨快递", "全集通物流", "圆通速递", "大田物流", "天地华宇", "天天快递", "宅急送",
            "安信达快递", "安捷快递", "希伊艾斯快递", "广东邮政物流", "德邦物流", "快捷速递", "急先达", "新邦物流", "星晨急便", "汇通快运", "港中能达物流", "源伟丰快递",
            "申通快递", "百福东方", "盛辉物流", "联昊通物流", "越丰物流", "运通快递", "远成物流", "速尔物流", "鑫飞鸿物流快递", "韵达快运", "顺丰快递", "飞康达物流", "龙邦物流"};


    //快递图标
    private int[] pic = new int[]{R.drawable.aae, R.drawable.bht, R.drawable.dhl, R.drawable.dsukuaidi, R.drawable.ems, R.drawable.fedex, R.drawable.tnt, R.drawable.ups, R.drawable.yibangwuliu,
            R.drawable.guangdongyouzhengwuliu, R.drawable.zhongtong, R.drawable.zhongyouwuliu, R.drawable.zhongtiewuliu, R.drawable.yafengsudi, R.drawable.jinguangsudikuaijian,
            R.drawable.anxindakuaidi, R.drawable.anjiekuaidi, R.drawable.cces, R.drawable.guangdongyouzhengwuliu, R.drawable.debangwuliu, R.drawable.kuaijiesudi, R.drawable.jixianda,
            R.drawable.xinbangwuliu, R.drawable.xingchengjibian, R.drawable.huitongkuaidi, R.drawable.ganzhongnengda, R.drawable.yuanweifeng, R.drawable.shentong, R.drawable.baifudongfang,
            R.drawable.shenghuiwuliu, R.drawable.lianhaowuliu, R.drawable.yuefengwuliu, R.drawable.yuntongkuaidi, R.drawable.yuanchengwuliu, R.drawable.suer, R.drawable.xinhongyukuaidi,
            R.drawable.yunda, R.drawable.shunfeng, R.drawable.feikangda, R.drawable.longbanwuliu
    };


    //快递电话
    private String[] phone = new String[]{"400-6100-400", "010-58633508", "400-810-8000", "0531-83165757", "11185", "400-886-1888", "400-820-8388", "4008-000-666", "11185", "021-59130789",
            "11185", "95105366", "400-628-0018", "400-660-6488", "400-1111-119", "4008205566", "400-660-5656", "4008-306-333", "0532-89657811", "400-678-1515", "020-86298999",
            "0769-82026703", "021-62966050", "021-69777888", "400-808-6666", "4007-160-170", "400-6789-000", "021-54224681", "0532-81636315", "4006-773-777", "020-38181677",
            "400-8304-888", "400-886-5988", "400-880-8188", "400-6688-400", "021-52967798", "021-62215731", "400-601-2228", "0571-82122222", "010-57169000", "0591-83657777",
            "0769-88620000", "(852)23909969", "0769-38804886", "400-820-1646", "4008822168", "021-69781999", "021-39207888", "4008-111-111", "010-84223376", "0769-88921111"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        ButterKnife.bind(this, view);

        mGuideMessages = new ArrayList<>();
        mAdapter = new ListItemAdapter(name, pic, phone, getContext());
        list_item.setAdapter(mAdapter);
        list_item.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                GuideFragment.this.position = position;
                return false;
            }
        });
        registerForContextMenu(list_item);

        return view;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1, 1, 1, "呼叫");
        super.onCreateContextMenu(menu, v, menuInfo);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        GuideMessage message = new GuideMessage(name[position], pic[position], phone[position]);

        int itemId = item.getItemId();

        switch (itemId) {
            case 1:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + message.getPhone()));
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
