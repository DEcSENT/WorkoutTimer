/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.support.annotation.NonNull;

import com.dvinc.workouttimer.data.db.entities.Training;

import java.util.List;

import io.reactivex.Flowable;

@Dao
@Deprecated
public abstract class TrainingDao {

    @Insert
    public abstract void addTraining(@NonNull Training training);

    @Query("DELETE FROM Training WHERE uid = :trainingId")
    public abstract void removeTraining(int trainingId);

    @Query("SELECT * FROM Training")
    public abstract Flowable<List<Training>> getAllTrainings();

    @Query("SELECT * FROM Training ORDER BY uid DESC LIMIT 1")
    public abstract int getLastAddedTrainingId();

    @Query("SELECT * FROM Training WHERE current_training = 1")
    public abstract Training getCurrentTraining();

    @Transaction
    public void setCurrentTraining(int trainingId) {
        deleteCurrentTraining();
        updateCurrentTraining(trainingId);
    }

    @Query("UPDATE Training SET current_training = 1 WHERE uid = :trainingId")
    abstract void updateCurrentTraining(int trainingId);

    @Query("UPDATE Training SET current_training = 0 WHERE current_training = 1")
    abstract void deleteCurrentTraining();
}
