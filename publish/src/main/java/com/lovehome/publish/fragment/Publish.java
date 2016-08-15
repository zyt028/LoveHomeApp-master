package com.lovehome.publish.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lovehome.publish.R;

/**
 * Created by Administrator on 2016/8/9.
 */
public class Publish extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.release_pager_tatle_layout, null);

        return v;

    }

}