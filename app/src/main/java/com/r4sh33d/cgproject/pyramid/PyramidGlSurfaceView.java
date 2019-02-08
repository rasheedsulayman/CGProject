package com.r4sh33d.cgproject.pyramid;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;


public class PyramidGlSurfaceView extends GLSurfaceView {

    PyramidRenderer pyramidRender;

    public PyramidGlSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(3);
        super.setEGLConfigChooser(8 , 8, 8,
                8, 16, 0);
        pyramidRender = new PyramidRenderer(context);
        setRenderer(pyramidRender);
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }


    private static final float TOUCH_SCALE_FACTOR = 0.015f;
    private float mPreviousX;
    private float mPreviousY;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        int i = e.getAction();

        if (i == MotionEvent.ACTION_MOVE) {
            float dx = x - mPreviousX;

            pyramidRender.setX(pyramidRender.getX() - (dx * TOUCH_SCALE_FACTOR));
            float dy = y - mPreviousY;
            pyramidRender.setY(pyramidRender.getY() - (dy * TOUCH_SCALE_FACTOR));
        }

        mPreviousX = x;
        mPreviousY = y;
        return true;
    }

}
