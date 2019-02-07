package com.r4sh33d.cgproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r4sh33d.cgproject.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuFragment extends Fragment {


    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }



    @OnClick(R.id.gl_points)
    public void onClickGlPoints(){

    }

    @OnClick(R.id.gl_lines)
    public void onClickGlLines(){

    }

    @OnClick(R.id.gl_lines)
    public void onClickGlTriangles(){

    }


    @OnClick(R.id.gl_lines)
    public void onClickGlPolygons(){

    }
}

