package com.r4sh33d.cgproject.gl_engine;


import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.r4sh33d.cgproject.ElementType;
import com.r4sh33d.cgproject.PolygonConfig;
import com.r4sh33d.cgproject.shapes.Polygon;
import com.r4sh33d.cgproject.shapes.Square;
import com.r4sh33d.cgproject.shapes.Triangle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import timber.log.Timber;

public class BasicPrimitiveGLRenderer implements GLSurfaceView.Renderer {

    private  ElementType elementType;
    private  PolygonConfig polygonConfig;
    private Polygon polygon;

    public BasicPrimitiveGLRenderer(ElementType elementType, PolygonConfig polygonConfig) {
        this.elementType = elementType;
        this.polygonConfig = polygonConfig;
    }

    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        polygon = new Polygon(polygonConfig, elementType);
    }

    public void onDrawFrame(GL10 unused) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        polygon.draw();
       // mTriangle.draw();
    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    public static int loadShader(int type, String shaderCode){
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }
}