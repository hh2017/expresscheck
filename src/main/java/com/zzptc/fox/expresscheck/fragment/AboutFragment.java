package com.zzptc.fox.expresscheck.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzptc.fox.expresscheck.R;
import com.zzptc.fox.expresscheck.activity.MoreActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    @Bind(R.id.more)
    TextView more;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.more})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.more:
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
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
