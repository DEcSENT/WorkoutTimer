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
    private final static float CIRCLE_STROKE_WIDTH_PX = 5;
    private final static int SECOND_DELAY = 1000;

    /**
     * Initial start value for acr. Don't ask me why -90, this is android...
     */
    private final static int DEFAULT_START_ARC_ANGLE = -90;
    private final static int DEFAULT_FINISH_ARC_ANGLE = 360;

    private float startArcAngle;
    private float finishArcAngle;
    private int minutes;
    private int seconds;

    private final Paint circlePaint;
    private final RectF circle;

    private final Handler handler = new Handler();

    public interface onTimeChanged {

        void onTimeChanged(@IntRange(from = 0) int minuteValue, @IntRange(from = 0, to = 59) int secondValue);

        void onFinish();
    }

    private final Runnable secondsLapRunnable = new Runnable() {
        @Override
        public void run() {
            calculateCircleParams();
        }
    };

    public CircleView(@NonNull Context context) {
        this(context, null);
    }

    public CircleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        CircleViewHelper circleViewHelper = new CircleViewHelper(getContext());
        Point centerPoint = circleViewHelper.calculateCenterPoint();
        float radius = Dimens.dpToPx(CIRCLE_RADIUS_DP);
        circle = new RectF(centerPoint.x - radius, centerPoint.y - radius, centerPoint.x + radius, centerPoint.y + radius);

        circlePaint = new Paint();
        circlePaint.setColor(Color.RED);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(CIRCLE_STROKE_WIDTH_PX);
        circlePaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(circle, startArcAngle, finishArcAngle, false, circlePaint);
    }

    public void setTime(@IntRange(from = 0) int minutes, @IntRange(from = 0, to = 59) int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;

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

    private void calculateCircleParams() {
        if (seconds != 0) {
            startArcAngle += ONE_ANGLE_SECOND;
            finishArcAngle -= ONE_ANGLE_SECOND;
            seconds -= 1;
            handler.postDelayed(secondsLapRunnable, SECOND_DELAY);
        } else if (minutes != 0) {
            setDefaultArcValues();
            minutes -= 1;
            seconds = 59;
            handler.postDelayed(secondsLapRunnable, SECOND_DELAY);
        } else {
            setDefaultArcValues();
            handler.removeCallbacks(secondsLapRunnable);
        }

        invalidate();
    }

    private void setDefaultArcValues() {
        startArcAngle = DEFAULT_START_ARC_ANGLE;
        finishArcAngle = DEFAULT_FINISH_ARC_ANGLE;
    }
}
