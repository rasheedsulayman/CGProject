package com.r4sh33d.cgproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.opengl_demo_button)
    public void onClickOpenGLDemoButton(){
        Timber.d("Button clicked");
        startActivity(new Intent(this, OpenGLES20Activity.class));
    }
}
