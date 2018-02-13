/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.circle_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * This class is under construction.
 */
public class CircleView  extends View {

    private final static int CIRCLE_RADIUS_PX = 150;
    private final static float ONE_ANGLE_SECOND = 6f;

    /**
     * Initial start value for acr. Don't ask me why -90, this is android...
     */
    private final static int DEFAULT_START_ARC_ANGLE = -90;
    private final static int DEFAULT_FINISH_ARC_ANGLE = 360;

    private float startArcAngle;
    private float finishArcAngle;

    private int screenHeightPx;
    private int screenWidthPx;
    private float screenDensity;

    private Point centerPoint;
    private Paint circlePaint;
    private RectF circle;

    private Handler handler;

    private int secondLaps;
    private int minuteLaps;

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getScreenParams(context);
        calculateCenterPoint();
        setUpSecondsCircle();

        handler = new Handler();
    }

    private Runnable secondsLapRunnable = new Runnable() {
        @Override
        public void run() {
            recalculateCoordinates();
        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc (circle, startArcAngle, finishArcAngle, false, circlePaint);
    }

    public void setTime(int minute, int second) {
        startArcAngle = DEFAULT_START_ARC_ANGLE;
        finishArcAngle = DEFAULT_FINISH_ARC_ANGLE;
        startArcAngle = startArcAngle - second * ONE_ANGLE_SECOND;
        finishArcAngle = finishArcAngle - (finishArcAngle - second * ONE_ANGLE_SECOND);

        invalidate();
    }

    public void start() {
        handler.post(secondsLapRunnable);
    }

    public void stop() {
        handler.removeCallbacks(secondsLapRunnable);
    }

    private void recalculateCoordinates() {
        startArcAngle += ONE_ANGLE_SECOND;
        finishArcAngle -= ONE_ANGLE_SECOND;
        invalidate();

        if (finishArcAngle > 0) {
            handler.postDelayed(secondsLapRunnable, 1000);
        } else {
            handler.removeCallbacks(secondsLapRunnable);
        }
    }

    private void getScreenParams(@NonNull Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        screenHeightPx = displayMetrics.heightPixels;
        screenWidthPx = displayMetrics.widthPixels;
        screenDensity = displayMetrics.density;
    }

    private void calculateCenterPoint() {
        centerPoint = new Point(screenWidthPx / 2, screenHeightPx / 2);
    }

    private void setUpSecondsCircle() {
        float radiusDp = CIRCLE_RADIUS_PX * screenDensity;
        circle = new RectF(centerPoint.x - radiusDp, centerPoint.y - radiusDp, centerPoint.x + radiusDp, centerPoint.y + radiusDp);

        circlePaint = new Paint();
        circlePaint.setColor(Color.RED);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(5);
        circlePaint.setStyle(Paint.Style.STROKE);
    }

    public interface onTimeChanged {

        void onSecondChanged(int secondValue);

        void onMinuteChanged(int minuteValue);

        void onFinish();
    }
}
