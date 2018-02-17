/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.circle_view;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * Test class.
 */
class CircleViewHelper {

    private Context context;

    CircleViewHelper(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    Point calculateCenterPoint() {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int screenHeightPx = displayMetrics.heightPixels;
        int screenWidthPx = displayMetrics.widthPixels;
        return new Point(screenWidthPx / 2, screenHeightPx / 2);
    }
}
