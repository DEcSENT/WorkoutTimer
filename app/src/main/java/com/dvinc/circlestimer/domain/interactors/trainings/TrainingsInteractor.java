/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.interactors.trainings;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Training;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface TrainingsInteractor {

    /**
     * Getting all trainings.
     *
     * @return - flowable source with list of trainings.
     */
    Flowable<List<Training>> getAllTrainings();

    /**
     * Adding new training.
     *
     * @param name        - training name
     * @param defaultLaps - count of default laps
     * @return - completable source
     */
    Completable addNewTraining(@NonNull String name, @IntRange(from = 0) int defaultLaps);

    /**
     * Deleting training by training id
     *
     * @param trainingId - training id
     * @return - completable source
     */
    Completable deleteTraining(int trainingId);

    /**
     * Setting current training.
     *
     * @param training - current training
     * @return - completable source
     */
    Completable setCurrentTraining(@NonNull Training training);
}
