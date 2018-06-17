/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/17/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.entities;

import android.support.annotation.NonNull;

public class LapItem {

    private int uid;

    private final int trainingId;

    private final int orderNumber;

    private final String lapName;

    private final String lapColor;

    private final int lapTime;

    public LapItem(int trainingId, int orderNumber, @NonNull String lapName, @NonNull String lapColor, int lapTime) {
        this.trainingId = trainingId;
        this.orderNumber = orderNumber;
        this.lapName = lapName;
        this.lapColor = lapColor;
        this.lapTime = lapTime;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public int getUid() {
        return uid;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getLapName() {
        return lapName;
    }

    public String getLapColor() {
        return lapColor;
    }

    public int getLapTime() {
        return lapTime;
    }
}
