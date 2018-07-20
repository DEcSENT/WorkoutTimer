/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.interactors.trainings;

import android.support.annotation.NonNull;

import com.dvinc.workouttimer.data.repositories.laps.LapsRepository;
import com.dvinc.workouttimer.data.repositories.training.TrainingsRepository;
import com.dvinc.workouttimer.di.qualifiers.IoScheduler;
import com.dvinc.workouttimer.di.qualifiers.UiScheduler;
import com.dvinc.workouttimer.domain.entities.TrainingItem;
import com.dvinc.workouttimer.domain.mappers.LapsMapper;
import com.dvinc.workouttimer.domain.mappers.TrainingsMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;

@Deprecated
public class TrainingsInteractorImpl implements TrainingsInteractor {

    @NonNull
    private TrainingsRepository trainingsRepository;

    @NonNull
    private LapsRepository lapsRepository;

    @NonNull
    private final Scheduler schedulerIo;

    @NonNull
    private final Scheduler schedulerUi;

    @NonNull
    private final LapsMapper lapsMapper;

    @NonNull
    private final TrainingsMapper trainingsMapper;

    @Inject
    public TrainingsInteractorImpl(@NonNull TrainingsRepository trainingsRepository,
                                   @NonNull LapsRepository lapsRepository,
                                   @NonNull @IoScheduler Scheduler schedulerIo,
                                   @NonNull @UiScheduler Scheduler schedulerUi,
                                   @NonNull LapsMapper lapsMapper,
                                   @NonNull TrainingsMapper trainingsMapper) {
        this.trainingsRepository = trainingsRepository;
        this.lapsRepository = lapsRepository;
        this.schedulerIo = schedulerIo;
        this.schedulerUi = schedulerUi;
        this.lapsMapper = lapsMapper;
        this.trainingsMapper = trainingsMapper;
    }

    @Override
    public Flowable<List<TrainingItem>> getAllTrainings() {
        return trainingsRepository.getAllTrainings()
                .map(trainings -> trainingsMapper.map(trainings, lapsRepository.getAllLaps()))
                .subscribeOn(schedulerIo)
                .observeOn(schedulerUi);
    }

    //TODO: Check way of getting last training id
    @Override
    public Completable addNewTraining(@NonNull String name, int defaultLapsAmount) {
        return Completable.fromAction(() -> trainingsRepository.addNewTraining(name))
                .andThen(Single.fromCallable(() -> trainingsRepository.getLastAddedTrainingId()))
                .map(trainingId -> lapsMapper.generateDefaultLaps(trainingId, defaultLapsAmount))
                .flatMapCompletable(defaultLaps -> Completable.fromAction(() -> lapsRepository.addLaps(defaultLaps)))
                .subscribeOn(schedulerIo)
                .observeOn(schedulerUi);
    }

    @Override
    public Completable deleteTraining(int trainingId) {
        return Completable.fromAction(() -> trainingsRepository.deleteTraining(trainingId))
                .andThen(Completable.fromAction(() -> lapsRepository.removeLapsByTrainingId(trainingId)))
                .subscribeOn(schedulerIo)
                .observeOn(schedulerUi);
    }

    @Override
    public Completable setCurrentTraining(@NonNull TrainingItem training) {
        return Completable.fromAction(() -> trainingsRepository.updateCurrentTraining(training.getId()))
                .subscribeOn(schedulerIo)
                .observeOn(schedulerUi);
    }
}
