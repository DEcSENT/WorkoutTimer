/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/17/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.interactors.laps;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.repositories.laps.LapsRepository;
import com.dvinc.circlestimer.di.qualifiers.IoScheduler;
import com.dvinc.circlestimer.di.qualifiers.UiScheduler;
import com.dvinc.circlestimer.domain.entities.LapItem;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;

public class LapsInteractorImpl implements LapsInteractor {

    @NonNull
    private LapsRepository repository;

    @NonNull
    private final Scheduler schedulerIo;

    @NonNull
    private final Scheduler schedulerUi;

    @Inject
    public LapsInteractorImpl(@NonNull LapsRepository lapsRepository,
                              @NonNull @IoScheduler Scheduler schedulerIo,
                              @NonNull @UiScheduler Scheduler schedulerUi) {
        this.repository = repository;
        this.schedulerIo = schedulerIo;
        this.schedulerUi = schedulerUi;
    }

    @Override
    public Flowable<List<LapItem>> getLaps() {
        //TODO: load lap of current training and map them
        return null;
    }
}
