package com.r4sh33d.cgproject.gl_engine;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.r4sh33d.cgproject.ElementType;
import com.r4sh33d.cgproject.PolygonConfig;

public  class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context ,  ElementType elementType, PolygonConfig polygonConfig){
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        mRenderer = new MyGLRenderer(elementType, polygonConfig);

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
       // setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

}
