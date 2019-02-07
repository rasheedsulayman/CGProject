package com.r4sh33d.cgproject;

import android.support.annotation.NonNull;
import android.view.View;

public class ViewUtils {
    public static void show(@NonNull View... views) {
        for (View view : views) {
            show(view);
        }
    }

    public static void hide(@NonNull View... views) {
        for (View view : views) {
            hide(view);
        }
    }
}
