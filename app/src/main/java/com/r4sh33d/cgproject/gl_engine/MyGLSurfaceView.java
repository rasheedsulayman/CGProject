package com.r4sh33d.cgproject.gl_engine;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.r4sh33d.cgproject.shapes.Polygon;

public  class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;



    public MyGLSurfaceView(Context context , Polygon polygon){
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        mRenderer = new MyGLRenderer(polygon);

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
