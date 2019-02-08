package com.r4sh33d.cgproject;

import android.opengl.GLES20;

public enum ElementType {

    POINTS(GLES20.GL_POINTS), LINES(GLES20.GL_LINES), TRIANGLES(GLES20.GL_TRIANGLES),
    RECTANGLES(GLES20.GL_TRIANGLE_FAN), POLYGONS(GLES20.GL_TRIANGLE_FAN);

    public int openGLDrawMode;

    ElementType(int openGLDrawMode) {
        this.openGLDrawMode = openGLDrawMode;
    }

    @Override
    public String toString() {
        return "ElementType{" +
                "openGLDrawMode=" + openGLDrawMode +
                '}';
    }
}
