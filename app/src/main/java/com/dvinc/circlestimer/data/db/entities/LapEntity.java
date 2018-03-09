/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "LapsTable")
public class LapEntity {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "order_number")
    private int orderNumber;

    @ColumnInfo(name = "lap_name")
    private String lapName;

    @ColumnInfo(name = "lap_color")
    private String lapColor;

    @ColumnInfo(name = "lap_time")
    private int lapTime;

    public LapEntity(int orderNumber, String lapName, String lapColor, int lapTime) {
        this.orderNumber = orderNumber;
        this.lapName = lapName;
        this.lapColor = lapColor;
        this.lapTime = lapTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }

    public String getLapColor() {
        return lapColor;
    }

    public void setLapColor(String lapColor) {
        this.lapColor = lapColor;
    }

    public int getLapTime() {
        return lapTime;
    }

    public void setLapTime(int lapTime) {
        this.lapTime = lapTime;
    }
}
