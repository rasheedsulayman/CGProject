package com.r4sh33d.cgproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r4sh33d.cgproject.ElementType;
import com.r4sh33d.cgproject.R;
import com.r4sh33d.cgproject.pyramid.PyramidActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuFragment extends BaseFragment {

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbarTitle("CSC 514 Demo App");
    }

    @OnClick(R.id.gl_points)
    public void onClickGlPoints(){
        replaceFragment(BasicPrimitiveFragment.newInstance(ElementType.POINTS));
    }

    @OnClick(R.id.gl_lines)
    public void onClickGlLines(){
        replaceFragment(BasicPrimitiveFragment.newInstance(ElementType.LINES));

    }

    @OnClick(R.id.gl_triangles)
    public void onClickGlTriangles(){
        replaceFragment(BasicPrimitiveFragment.newInstance(ElementType.TRIANGLES));

    }

    @OnClick(R.id.gl_rectangles)
    public void onClickGlRectangles(){
        replaceFragment(BasicPrimitiveFragment.newInstance(ElementType.RECTANGLES));
    }

    @OnClick(R.id.gl_polygons)
    public void onClickGlPolygons(){
        replaceFragment(BasicPrimitiveFragment.newInstance(ElementType.POLYGONS));
    }


    @OnClick(R.id.gl_rotating_pyramid)
    public void onClickRotatingPyramid(){
        startActivity(new Intent(getContext() , PyramidActivity.class));
    }
}

