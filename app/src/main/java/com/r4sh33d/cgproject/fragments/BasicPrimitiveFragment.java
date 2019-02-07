package com.r4sh33d.cgproject.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.r4sh33d.cgproject.ElementType;
import com.r4sh33d.cgproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicPrimitiveFragment extends BaseFragment {
    @BindView(R.id.triangle_type_card_view_layout)
    CardView trianglesCardView;

    @BindView(R.id.vertices_card_view_layout)
    CardView verticesCardView;

    @BindView(R.id.animate_check_box)
    AppCompatCheckBox animateCheckBox;

    @BindView(R.id.color_image_view)
    ImageView colorImageView;

    private String elementDetails = "";
    private String pageTitle = "";
    private String toolbarTitle = "";
    float polygonCoords[];


    int colorPicked;
    ElementType elementType;


    private static final String ELEMENT_TYPE_KEY = "element_type_key";

    public static BasicPrimitiveFragment newInstance(ElementType elementType) {
        Bundle args = new Bundle();
        args.putSerializable(ELEMENT_TYPE_KEY, elementType);
        BasicPrimitiveFragment fragment = new BasicPrimitiveFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public BasicPrimitiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic_primitive, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        elementType = (ElementType) getArguments().getSerializable(ELEMENT_TYPE_KEY);
        colorPicked = Color.BLUE; // Default color
        colorImageView.setBackgroundColor(Color.BLUE);
        configureScreen();
    }


    public void configureScreen() {

        switch (elementType) {
            case POINTS:
                break;
            case LINES:
                break;
            case TRIANGLES:
                break;
            case POLYGONS:
                break;
        }
    }


}
