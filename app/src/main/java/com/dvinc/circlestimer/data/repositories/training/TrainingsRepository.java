/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.repositories.training;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Training;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface TrainingsRepository {

    Flowable<List<Training>> getAllTrainings();

    Completable addNewTraining(@NonNull String name, @IntRange(from = 0) int defaultLaps);

    Completable deleteTraining(int trainingId);

    Completable setCurrentTraining(@NonNull Training training);
}
