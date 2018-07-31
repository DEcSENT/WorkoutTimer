/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Training")
@Deprecated
public class Training {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "training_name")
    private final String trainingName;

    @ColumnInfo(name = "current_training")
    private final boolean isCurrentTraining;

    public Training(@NonNull String trainingName, boolean isCurrentTraining) {
        this.trainingName = trainingName;
        this.isCurrentTraining = isCurrentTraining;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public boolean isCurrentTraining() {
        return isCurrentTraining;
    }
}
