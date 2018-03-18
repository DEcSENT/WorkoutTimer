/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.repositories;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.TrainingsDatabase;
import com.dvinc.circlestimer.data.db.entities.Lap;
import com.dvinc.circlestimer.data.db.entities.Training;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class TrainingsRepository {

    /**
     * Default lap name.
     */
    private static final String DEFAULT_LAP_NAME = "Lap";

    /**
     * Default lap cell color in hex.
     */
    private static final String DEFAULT_LAP_COLOR = "#FFFFFF";

    /**
     * Default lap time in seconds.
     */
    private static final int DEFAULT_LAP_TIME = 30;

    @NonNull
    private final TrainingsDatabase trainingsDatabase;

    public TrainingsRepository(@NonNull TrainingsDatabase trainingsDatabase) {
        this.trainingsDatabase = trainingsDatabase;
    }

    /**
     * Obtaining all trainings from data source
     *
     * @return flowable source with trainings list.
     */
    public Flowable<List<Training>> getAllTrainings() {
        return trainingsDatabase
                .trainingsDao()
                .getAllTrainings()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Adding new training to data source.
     *
     * @param name        - new training name.
     * @param defaultLaps - count of default laps.
     * @return - completable source.
     */
    public Completable addNewTraining(@NonNull String name, @IntRange(from = 0) int defaultLaps) {
        return Completable.fromAction(() -> addTraining(name))
                .andThen(Single.fromCallable(this::getTrainingId))
                .flatMapCompletable(trainingId -> {
                    List<Lap> laps = new ArrayList<>();
                    for (int i = 0; i < defaultLaps; i++) {
                        laps.add(new Lap(trainingId, i, DEFAULT_LAP_NAME, DEFAULT_LAP_COLOR, DEFAULT_LAP_TIME));
                    }
                    return Completable.fromAction(() -> addLaps(laps));
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private void addTraining(@NonNull String trainingName) {
        trainingsDatabase.trainingsDao().addTraining(new Training(trainingName, false));
    }

    private int getTrainingId() {
        return trainingsDatabase.trainingsDao().getLastAddedTrainingId();
    }

    private void addLaps(@NonNull List<Lap> laps) {
        trainingsDatabase.lapsDao().insertAll(laps);
    }
}
