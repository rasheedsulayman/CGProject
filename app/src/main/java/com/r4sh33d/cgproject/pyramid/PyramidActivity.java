package com.r4sh33d.cgproject.pyramid;

import android.app.Activity;
import android.os.Bundle;

public class PyramidActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DeviceUtils.detectOpenGLES30(this)) {
            setContentView(new PyramidGlSurfaceView(this));
        } else {
            finish();
        }
    }
}
