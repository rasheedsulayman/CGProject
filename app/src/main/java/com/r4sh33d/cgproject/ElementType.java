package com.r4sh33d.cgproject;

import android.opengl.GLES20;

public enum ElementType {

    POINTS(GLES20.GL_POINTS), LINES(GLES20.GL_LINES), TRIANGLE(GLES20.GL_TRIANGLES),
    POLYGONS(GLES20.GL_TRIANGLE_FAN);

    public int openGLDrawMode;

    ElementType(int openGLDrawMode) {
        this.openGLDrawMode = openGLDrawMode;
    }

}
