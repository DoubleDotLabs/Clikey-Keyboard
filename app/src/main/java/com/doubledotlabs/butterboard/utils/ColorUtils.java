package com.doubledotlabs.butterboard.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;

public class ColorUtils {

    @ColorInt
    public static int getDefaultColor(Context context) {
        return Color.BLACK;
    }

    public static boolean isColorDark(int color) {
        return (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255 < 0.5;
    }

    @ColorInt
    public static int darkColor(@ColorInt int color) {
        return Color.argb(255, addToColorPart(Color.red(color), -70), addToColorPart(Color.green(color), -70), addToColorPart(Color.blue(color), -70));
    }

    @ColorInt
    public static int lightColor(@ColorInt int color) {
        return Color.argb(255, addToColorPart(Color.red(color), 70), addToColorPart(Color.green(color), 70), addToColorPart(Color.blue(color), 70));
    }

    private static int addToColorPart(int colorPart, int variable) {
        return Math.max(0, Math.min(255, colorPart + variable));
    }

    public static int muteColor(int color, int variant) {
        int mutedColor = Color.argb(255, (int) (127.5 + Color.red(color)) / 2, (int) (127.5 + Color.green(color)) / 2, (int) (127.5 + Color.blue(color)) / 2);
        switch (variant % 3) {
            case 1:
                return Color.argb(255, Color.red(mutedColor) + 10, Color.green(mutedColor) + 10, Color.blue(mutedColor) + 10);
            case 2:
                return Color.argb(255, Color.red(mutedColor) - 10, Color.green(mutedColor) - 10, Color.blue(mutedColor) - 10);
            default:
                return mutedColor;
        }
    }

}
