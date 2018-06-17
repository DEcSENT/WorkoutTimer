/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.repositories.training;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.TrainingsDatabase;
import com.dvinc.circlestimer.data.db.entities.Lap;
import com.dvinc.circlestimer.data.db.entities.Training;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class TrainingsRepositoryImpl implements TrainingsRepository {

    @NonNull
    private final TrainingsDatabase trainingsDatabase;

    @Inject
    public TrainingsRepositoryImpl(@NonNull TrainingsDatabase trainingsDatabase) {
        this.trainingsDatabase = trainingsDatabase;
    }

    @Override
    public Flowable<List<Training>> getAllTrainings() {
        return trainingsDatabase
                .trainingsDao()
                .getAllTrainings();
    }

    @Override
    public void addNewTraining(@NonNull String name) {
        trainingsDatabase.trainingsDao().addTraining(new Training(name, false));
    }

    @Override
    public void deleteTraining(int trainingId) {
        trainingsDatabase.trainingsDao().removeTraining(trainingId);
    }

    @Override
    public int getLastAddedTrainingId() {
        return trainingsDatabase.trainingsDao().getLastAddedTrainingId();
    }

    @Override
    public void updateCurrentTraining(int trainingId) {
        trainingsDatabase.trainingsDao().setCurrentTraining(trainingId);
    }

    @Override
    public Training getCurrentTraining() {
        return trainingsDatabase.trainingsDao().getCurrentTraining();
    }
}
