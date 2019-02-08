package com.r4sh33d.cgproject.pyramid;


import android.opengl.GLES30;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Pyramid {
    private int mLinkedProgram;
    private int mMVPMatrixHandle;
    private int mColorHandle;
    private FloatBuffer mVertices;

    float pyramidSize = 0.45f;
    float[] mVerticesData = new float[]{

            // FRONT
            0.0f, pyramidSize, 0.0f, // top
            -pyramidSize, -pyramidSize, pyramidSize, // front-left
            pyramidSize, -pyramidSize, pyramidSize, // front-right
            // RIGHT
            0.0f, pyramidSize, 0.0f, // top
            pyramidSize, -pyramidSize, pyramidSize, // front-right
            pyramidSize, -pyramidSize, -pyramidSize, // back-right
            // BACK
            0.0f, pyramidSize, 0.0f, // top
            pyramidSize, -pyramidSize, -pyramidSize, // back-right
            -pyramidSize, -pyramidSize, -pyramidSize, // back-left
            // LEFT
            0.0f, pyramidSize, 0.0f, // top
            -pyramidSize, -pyramidSize, -pyramidSize, // back-left
            -pyramidSize, -pyramidSize, pyramidSize, // front-left

            //Buttom
            // Triangle 1
            -pyramidSize, -pyramidSize, -pyramidSize, // back-left
            -pyramidSize, -pyramidSize, pyramidSize, // front-left
            pyramidSize, -pyramidSize, pyramidSize, // front-right
            // Triangle 2
            pyramidSize, -pyramidSize, pyramidSize, // front-right
            pyramidSize, -pyramidSize, -pyramidSize, // back-right
            -pyramidSize, -pyramidSize, -pyramidSize // back-left
    };


    float[] colorRed = new float[]{
            1.0f, 0.0f, 0.f, 1.0f
    };

    float[] colorBlue = new float[]{
            0.0f, 0.0f, 1.0f, 1.0f
    };

    float[] colorGreen = new float[]{
            0.0f, 1.0f, 0.0f, 1.0f
    };

    float[] colorCyan = new float[]{
            0.0f, 1.0f, 1.0f, 1.0f
    };


    //vertex shader code
    String vShaderStr =
            "#version 300 es 			  \n"
                    + "uniform mat4 uMVPMatrix;     \n"
                    + "in vec4 vPosition;           \n"
                    + "void main()                  \n"
                    + "{                            \n"
                    + "   gl_Position = uMVPMatrix * vPosition;  \n"
                    + "}                            \n";
    //fragment shader code.
    String fShaderStr =
            "#version 300 es		 			          	\n"
                    + "precision mediump float;					  	\n"
                    + "uniform vec4 vColor;	 			 		  	\n"
                    + "out vec4 fragColor;	 			 		  	\n"
                    + "void main()                                  \n"
                    + "{                                            \n"
                    + "  fragColor = vColor;                    	\n"
                    + "}                                            \n";

    String TAG = "Pyramid";

    //constructor
    public Pyramid() {
        //first setup the mVertices correctly.
        mVertices = ByteBuffer
                .allocateDirect(mVerticesData.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer()
                .put(mVerticesData);
        mVertices.position(0);

        int vertexShader;
        int fragmentShader;
        int programObject;
        int[] linked = new int[1];

        vertexShader = PyramidRenderer.LoadShader(GLES30.GL_VERTEX_SHADER, vShaderStr);
        fragmentShader = PyramidRenderer.LoadShader(GLES30.GL_FRAGMENT_SHADER, fShaderStr);

        programObject = GLES30.glCreateProgram();

        if (programObject == 0) {
            Log.e(TAG, "So some kind of error, but what?");
            return;
        }

        GLES30.glAttachShader(programObject, vertexShader);
        GLES30.glAttachShader(programObject, fragmentShader);
        GLES30.glBindAttribLocation(programObject, 0, "vPosition");
        GLES30.glLinkProgram(programObject);
        GLES30.glGetProgramiv(programObject, GLES30.GL_LINK_STATUS, linked, 0);

        if (linked[0] == 0) {
            GLES30.glDeleteProgram(programObject);
            return;
        }
        mLinkedProgram = programObject;
    }


    public void draw(float[] mvpMatrix) {

        GLES30.glUseProgram(mLinkedProgram);
        mMVPMatrixHandle = GLES30.glGetUniformLocation(mLinkedProgram, "uMVPMatrix");
        DeviceUtils.checkGlError("glGetUniformLocation");

        mColorHandle = GLES30.glGetUniformLocation(mLinkedProgram, "vColor");


        GLES30.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);
        DeviceUtils.checkGlError("glUniformMatrix4fv");

        int VERTEX_POS_INDX = 0;
        mVertices.position(VERTEX_POS_INDX);
        GLES30.glVertexAttribPointer(VERTEX_POS_INDX, 3, GLES30.GL_FLOAT,
                false, 0, mVertices);
        GLES30.glEnableVertexAttribArray(VERTEX_POS_INDX);


        int startPos = 0;
        int verticesPerface = 3;

        //front
        GLES30.glUniform4fv(mColorHandle, 1, colorRed, 0);
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, startPos, verticesPerface);
        startPos += verticesPerface;

        //right
        GLES30.glUniform4fv(mColorHandle, 1, colorCyan, 0);
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, startPos, verticesPerface);
        startPos += verticesPerface;

        //back
        GLES30.glUniform4fv(mColorHandle, 1, colorRed, 0);
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, startPos, verticesPerface);
        startPos += verticesPerface;

        //left
        GLES30.glUniform4fv(mColorHandle, 1, colorCyan, 0);
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, startPos, verticesPerface);
        startPos += verticesPerface;


        //The two triangles that make up the downward face
        GLES30.glUniform4fv(mColorHandle, 1, colorGreen, 0);
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, startPos, verticesPerface);
        startPos += verticesPerface;

        GLES30.glUniform4fv(mColorHandle, 1, colorGreen, 0);
        GLES30.glDrawArrays(GLES30.GL_TRIANGLES, startPos, verticesPerface);
        startPos += verticesPerface;
    }

}
