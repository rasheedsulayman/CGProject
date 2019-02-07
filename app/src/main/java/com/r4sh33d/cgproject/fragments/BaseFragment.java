package com.r4sh33d.cgproject.fragments;

import android.support.v4.app.Fragment;

import com.r4sh33d.cgproject.R;

public abstract class BaseFragment extends Fragment {

    public void replaceFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.view_container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}
