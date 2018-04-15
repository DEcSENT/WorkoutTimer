/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Laps")
public class Lap {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "training_id")
    private final int trainingId;

    @ColumnInfo(name = "order_number")
    private final int orderNumber;

    @ColumnInfo(name = "lap_name")
    private final String lapName;

    @ColumnInfo(name = "lap_color")
    private final String lapColor;

    @ColumnInfo(name = "lap_time")
    private final int lapTime;

    public Lap(int trainingId, int orderNumber, @NonNull String lapName, @NonNull String lapColor, int lapTime) {
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
