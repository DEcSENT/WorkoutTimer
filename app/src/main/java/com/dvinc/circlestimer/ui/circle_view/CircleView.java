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
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * This class is under construction.
 */
public class CircleView extends View {

    private final static int CIRCLE_RADIUS_DP = 150;
    private final static float ONE_ANGLE_SECOND = 6f;
    private final static float CIRCLE_STROKE_WIDTH = 5;
    private final static int SECOND_DELAY = 1000;
    private final static int ONE_MINUTE_SECONDS = 60;

    /**
     * Initial start value for acr. Don't ask me why -90, this is android...
     */
    private final static int DEFAULT_START_ARC_ANGLE = -90;
    private final static int DEFAULT_FINISH_ARC_ANGLE = 360;

    private float startArcAngle;
    private float finishArcAngle;
    private int minute;
    private int seconds;

    @Nullable
    private Paint circlePaint;
    @Nullable
    private RectF circle;

    private final Handler handler = new Handler();

    public interface onTimeChanged {

        void onTimeChanged(@IntRange(from = 0, to = 1000) int minuteValue, @IntRange(from = 0, to = 59) int secondValue);

        void onFinish();
    }

    private final Runnable secondsLapRunnable = new Runnable() {
        @Override
        public void run() {
            recalculateCoordinates();
        }
    };

    public CircleView(@NonNull Context context) {
        super(context);
        initCircleView();
    }

    public CircleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initCircleView();
    }

    public CircleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCircleView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (circle != null && circlePaint != null) {
            canvas.drawArc(circle, startArcAngle, finishArcAngle, false, circlePaint);
        }
    }

    public void setTime(@IntRange(from = 0, to = 1000) int minuteValue, @IntRange(from = 0, to = 59) int secondValue) {
        minute = minuteValue;
        seconds = secondValue;

        startArcAngle = DEFAULT_START_ARC_ANGLE;
        finishArcAngle = DEFAULT_FINISH_ARC_ANGLE;
        startArcAngle = startArcAngle - seconds * ONE_ANGLE_SECOND;
        finishArcAngle = seconds * ONE_ANGLE_SECOND;

        invalidate();
    }

    public void start() {
        handler.post(secondsLapRunnable);
    }

    public void stop() {
        handler.removeCallbacks(secondsLapRunnable);
    }

    private void initCircleView() {
        setUpSecondsCircle();
    }

    private void recalculateCoordinates() {
        startArcAngle += ONE_ANGLE_SECOND;
        finishArcAngle -= ONE_ANGLE_SECOND;
        invalidate();

        if (finishArcAngle > 0) {
            handler.postDelayed(secondsLapRunnable, SECOND_DELAY);
        } else {
            handler.removeCallbacks(secondsLapRunnable);
        }
    }

    private void setUpSecondsCircle() {
        CircleViewHelper circleViewHelper = new CircleViewHelper(getContext());
        Point centerPoint = circleViewHelper.calculateCenterPoint();
        float radius = Dimens.dpToPx(CIRCLE_RADIUS_DP);
        circle = new RectF(centerPoint.x - radius, centerPoint.y - radius, centerPoint.x + radius, centerPoint.y + radius);

        circlePaint = new Paint();
        circlePaint.setColor(Color.RED);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(CIRCLE_STROKE_WIDTH);
        circlePaint.setStyle(Paint.Style.STROKE);
    }
}
