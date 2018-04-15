/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.interactors.trainings;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Lap;
import com.dvinc.circlestimer.data.db.entities.Training;
import com.dvinc.circlestimer.data.repositories.training.TrainingsRepository;
import com.dvinc.circlestimer.di.qualifiers.IoScheduler;
import com.dvinc.circlestimer.di.qualifiers.UiScheduler;
import com.dvinc.circlestimer.domain.entities.TrainingItem;
import com.dvinc.circlestimer.domain.mappers.TrainingMapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;

public class TrainingsInteractorImpl implements TrainingsInteractor {

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
    private TrainingsRepository repository;

    @NonNull
    private final Scheduler schedulerIo;

    @NonNull
    private final Scheduler schedulerUi;

    @Inject
    public TrainingsInteractorImpl(@NonNull TrainingsRepository repository,
                                   @NonNull @IoScheduler Scheduler schedulerIo,
                                   @NonNull @UiScheduler Scheduler schedulerUi) {
        this.repository = repository;
        this.schedulerIo = schedulerIo;
        this.schedulerUi = schedulerUi;
    }

    @Override
    public Flowable<List<TrainingItem>> getAllTrainings() {
        return repository.getAllTrainings()
                .map(rawList -> {
                    final List<TrainingItem> mappedItems = new ArrayList<>();
                    for (Training training : rawList) {
                        List<Lap> trainingLaps = repository.getLapsByTrainingId(training.getUid());
                        int lapsCount = trainingLaps.size();
                        int totalTime = 0;
                        for (Lap lap : trainingLaps) {
                            totalTime += lap.getLapTime();
                        }
                        mappedItems.add(TrainingMapper.mapTraining(training, lapsCount, totalTime));

                    }
                    return mappedItems;
                })
                .subscribeOn(schedulerIo)
                .observeOn(schedulerUi);
    }

    @Override
    public Completable addNewTraining(@NonNull String name, int defaultLaps) {
        return Completable.fromAction(() -> repository.addNewTraining(name))
                .andThen(Single.fromCallable(() -> repository.getLastAddedTrainingId()))
                .flatMapCompletable(trainingId -> {
                    List<Lap> laps = new ArrayList<>();
                    for (int i = 0; i < defaultLaps; i++) {
                        laps.add(new Lap(trainingId, i, DEFAULT_LAP_NAME, DEFAULT_LAP_COLOR, DEFAULT_LAP_TIME));
                    }
                    return Completable.fromAction(() -> repository.addLaps(laps));
                })
                .subscribeOn(schedulerIo)
                .observeOn(schedulerUi);
    }

    @Override
    public Completable deleteTraining(int trainingId) {
        return Completable.fromAction(() -> repository.deleteTraining(trainingId))
                .andThen(Completable.fromAction(() -> repository.removeLapsByTrainingId(trainingId)))
                .subscribeOn(schedulerIo)
                .observeOn(schedulerUi);
    }

    @Override
    public Completable setCurrentTraining(@NonNull TrainingItem training) {
        return Completable.fromAction(() -> repository.updateCurrentTraining(training.getId()))
                .subscribeOn(schedulerIo)
                .observeOn(schedulerUi);
    }
}
