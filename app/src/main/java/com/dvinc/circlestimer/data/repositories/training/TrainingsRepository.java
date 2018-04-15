/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.repositories.training;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Lap;
import com.dvinc.circlestimer.data.db.entities.Training;

import java.util.List;

import io.reactivex.Flowable;

public interface TrainingsRepository {

    /**
     * Obtaining all trainings from data source.
     *
     * @return flowable source with trainings list
     */
    Flowable<List<Training>> getAllTrainings();

    /**
     * Adding new training to data source.
     *
     * @param name - new training name
     */
    void addNewTraining(@NonNull String name);

    /**
     * Deleting training from data source.
     *
     * @param trainingId - id number of training
     */
    void deleteTraining(int trainingId);

    /**
     * Getting id of last added training.
     *
     * @return training id
     */
    int getLastAddedTrainingId();

    /**
     * Adding training laps in to data source.
     *
     * @param laps - training laps
     */
    void addLaps(@NonNull List<Lap> laps);

    /**
     * Removing training laps by training id.
     *
     * @param trainingId - training id
     */
    void removeLapsByTrainingId(int trainingId);

    /**
     * Setting current training.
     *
     * @param trainingId - training id
     */
    void updateCurrentTraining(int trainingId);

    /**
     * Getting training laps.
     *
     * @param trainingId - training id
     */
    @NonNull
    List<Lap> getLapsByTrainingId(int trainingId);
}
