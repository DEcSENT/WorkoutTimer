/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.timeCircle;

import android.content.res.Resources;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * Test class.
 */
class CircleViewHelper {

    @NonNull
    private final Resources resources;

    CircleViewHelper(@NonNull Resources resources) {
        this.resources = resources;
    }

    @NonNull
    Point calculateCenterPoint() {
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int screenHeightPx = displayMetrics.heightPixels;
        int screenWidthPx = displayMetrics.widthPixels;
        return new Point(screenWidthPx / 2, screenHeightPx / 2);
    }
}
