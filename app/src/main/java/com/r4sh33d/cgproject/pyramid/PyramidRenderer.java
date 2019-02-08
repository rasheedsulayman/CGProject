package com.r4sh33d.cgproject.pyramid;

import android.content.Context;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PyramidRenderer implements GLSurfaceView.Renderer {
    private int mWidth;
    private int mHeight;
    public static String TAG = "myRenderer";
    public Pyramid mPyramid;
    private float mRotationAngle = 0;
    private float mTransY=0;
    private float mTransX=0;
    private static final float Z_NEAR_VIEW  = 1f;
    private static final float Z_FAR_VIEW  = 40f;

    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    private final float[] mRotationMatrix = new float[16];


    public PyramidRenderer(Context context) {}

    @Override
    public void onSurfaceCreated(GL10 glUnused, EGLConfig config) {
        GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        mPyramid = new Pyramid();
    }

    public static final float fovy = 53.13f;

    @Override
    public void onSurfaceChanged(GL10 glUnused, int width, int height) {
        mWidth = width;
        mHeight = height;
        GLES30.glViewport(0, 0, mWidth, mHeight);
        float aspect = (float) width / height;
        Matrix.perspectiveM(mProjectionMatrix, 0, fovy, aspect, Z_NEAR_VIEW, Z_FAR_VIEW);
    }

    @Override
    public void onDrawFrame(GL10 glUnused) {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT | GLES30.GL_DEPTH_BUFFER_BIT);
        GLES30.glEnable(GLES30.GL_DEPTH_TEST);
        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f,
                0f, 0f, 1.0f, 0.0f);
        Matrix.setIdentityM(mRotationMatrix, 0);
        Matrix.translateM(mRotationMatrix, 0, mTransX, mTransY, 0);
        Matrix.rotateM(mRotationMatrix, 0, mRotationAngle, 0.4f, 1.0f, 0.6f);
        Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mRotationMatrix, 0);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mMVPMatrix, 0);
        mPyramid.draw(mMVPMatrix);
        mRotationAngle+=.5;
    }

    public float getY() {
        return mTransY;
    }

    public void setY(float mY) {
        mTransY = mY;
    }

    public float getX() {
        return mTransX;
    }

    public void setX(float mX) {
        mTransX = mX;
    }


    public static int LoadShader(int type, String shaderSrc) {
        int shader;
        int[] compiledProgram = new int[1];
        shader = GLES30.glCreateShader(type);
        if (shader == 0) {
            return 0;
        }
        GLES30.glShaderSource(shader, shaderSrc);
        GLES30.glCompileShader(shader);
        GLES30.glGetShaderiv(shader, GLES30.GL_COMPILE_STATUS, compiledProgram, 0);
        if (compiledProgram[0] == 0) {
            Log.e(TAG, GLES30.glGetShaderInfoLog(shader));
            GLES30.glDeleteShader(shader);
            return 0;
        }
        return shader;
    }
}
