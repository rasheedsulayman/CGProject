package com.r4sh33d.cgproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.r4sh33d.cgproject.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicPrimitiveFragment extends Fragment {


    public static BasicPrimitiveFragment newInstance () {

        Bundle args = new Bundle();

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
        View view =  inflater.inflate(R.layout.fragment_basic_primitive, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
