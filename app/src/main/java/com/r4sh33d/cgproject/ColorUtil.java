package com.r4sh33d.cgproject;

import android.graphics.Color;
import android.support.annotation.ColorInt;

import org.intellij.lang.annotations.Flow;

public class ColorUtil {

    public static float[] getColorArray(int colorInt) {
        return new float[]{
                (float) Color.red(colorInt)/255,
                (float) Color.green(colorInt)/255,
                (float) Color.blue(colorInt)/255,
                (float) Color.alpha(colorInt)
        };
    }
}
