package com.r4sh33d.cgproject.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.r4sh33d.cgproject.R;

public abstract class BaseFragment extends Fragment {

    public void replaceFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.view_container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }



    public void showToast(String message) {
        if (getContext() != null) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public void setToolbarTitle(String title) {
        ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar();
        ab.setTitle(title);
    }
}
