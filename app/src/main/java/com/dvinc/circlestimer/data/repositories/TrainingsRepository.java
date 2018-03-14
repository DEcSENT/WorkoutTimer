/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.repositories;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.TrainingsDatabase;
import com.dvinc.circlestimer.data.db.entities.Training;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class TrainingsRepository {

    @NonNull
    private final TrainingsDatabase trainingsDatabase;

    public TrainingsRepository(@NonNull TrainingsDatabase trainingsDatabase) {
        this.trainingsDatabase = trainingsDatabase;
    }

    public Single<List<Training>> getAllTrainings() {
        //For test adding 2 program
        return Completable.fromAction(() -> {
            for (int i = 0; i < 2; i++) {
                trainingsDatabase.trainingsDao().addTraining(new Training("Training: " + i, false));
            }
        }).andThen(trainingsDatabase
                .trainingsDao()
                .getAllTrainings())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
