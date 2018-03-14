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
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class TrainingsRepository {

    @NonNull
    private final TrainingsDatabase trainingsDatabase;

    public TrainingsRepository(@NonNull TrainingsDatabase trainingsDatabase) {
        this.trainingsDatabase = trainingsDatabase;
    }

    public Flowable<List<Training>> getAllTrainings() {
        return trainingsDatabase
                .trainingsDao()
                .getAllTrainings()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable addNewTraining(@NonNull String trainingName) {
        return Completable.fromAction(() -> trainingsDatabase
                .trainingsDao()
                .addTraining(new Training(trainingName, false)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
