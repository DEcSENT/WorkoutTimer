/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/18/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.repositories.laps;

import android.support.annotation.NonNull;

import com.dvinc.workouttimer.data.db.TrainingsDatabase;
import com.dvinc.workouttimer.data.db.entities.Lap;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
public class LapsRepositoryImpl implements LapsRepository {

    @NonNull
    private final TrainingsDatabase trainingsDatabase;

    @Inject
    public LapsRepositoryImpl(@NonNull TrainingsDatabase trainingsDatabase) {
        this.trainingsDatabase = trainingsDatabase;
    }

    @Override
    public void addLaps(@NonNull List<Lap> laps) {
        trainingsDatabase.lapsDao().insertAll(laps);
    }

    @Override
    public void removeLapsByTrainingId(int trainingId) {
        trainingsDatabase.lapsDao().removeLaps(trainingId);
    }

    @NonNull
    @Override
    public List<Lap> getLapsByTrainingId(int trainingId) {
        return trainingsDatabase.lapsDao().getLaps(trainingId);
    }

    @NonNull
    @Override
    public List<Lap> getAllLaps() {
        return  trainingsDatabase.lapsDao().getAllLaps();
    }
}
