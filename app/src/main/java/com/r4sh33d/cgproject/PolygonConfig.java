package com.r4sh33d.cgproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class PolygonConfig implements Parcelable {

    public float[] color;
    public float[] polygonCoord;
    public boolean animate;

    public PolygonConfig(float[] color, float[] polygonCoord, boolean animate) {
        this.color = color;
        this.polygonCoord = polygonCoord;
        this.animate = animate;
    }

    protected PolygonConfig(Parcel in) {
        color = in.createFloatArray();
        polygonCoord = in.createFloatArray();
        animate = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloatArray(color);
        dest.writeFloatArray(polygonCoord);
        dest.writeByte((byte) (animate ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PolygonConfig> CREATOR = new Creator<PolygonConfig>() {
        @Override
        public PolygonConfig createFromParcel(Parcel in) {
            return new PolygonConfig(in);
        }

        @Override
        public PolygonConfig[] newArray(int size) {
            return new PolygonConfig[size];
        }
    };


    @Override
    public String toString() {
        return "PolygonConfig{" +
                "color=" + Arrays.toString(color) +
                ", polygonCoord=" + Arrays.toString(polygonCoord) +
                ", animate=" + animate +
                '}';
    }
}
