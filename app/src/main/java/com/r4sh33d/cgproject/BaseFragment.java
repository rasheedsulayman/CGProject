package com.r4sh33d.cgproject;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

    public void replaceFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.view_container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}
