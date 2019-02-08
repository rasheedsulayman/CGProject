package com.r4sh33d.cgproject;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.r4sh33d.cgproject.gl_engine.MyGLSurfaceView;
import com.r4sh33d.cgproject.shapes.Polygon;

import timber.log.Timber;


public class OpenGLES20Activity extends AppCompatActivity {

    public static final String EXTRA_ELEMENT_TYPE = "element_type";
    public static final String EXTRA_POLYGON_CONFIG = "polygon_config";

    private GLSurfaceView mGLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        Intent intent = getIntent();
        ElementType elementType = (ElementType) intent.getSerializableExtra(EXTRA_ELEMENT_TYPE);
        PolygonConfig polygonConfig = intent.getParcelableExtra(EXTRA_POLYGON_CONFIG);
        Polygon polygon = new Polygon(polygonConfig, elementType);
        Timber.d("The polygon is: " + polygonConfig);

        mGLView = new MyGLSurfaceView(this , elementType, polygonConfig);
        setContentView(mGLView);
    }
}