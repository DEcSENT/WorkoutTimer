/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Training;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface TrainingDao {

    @Insert
    void addTraining(@NonNull Training training);

    @Query("SELECT * FROM Training")
    @NonNull
    Flowable<List<Training>> getAllTrainings();
}
