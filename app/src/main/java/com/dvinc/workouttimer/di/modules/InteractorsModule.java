/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.workouttimer.di.modules;

import android.support.annotation.NonNull;

import com.dvinc.workouttimer.data.repositories.laps.LapsRepository;
import com.dvinc.workouttimer.data.repositories.training.TrainingsRepository;
import com.dvinc.workouttimer.di.qualifiers.IoScheduler;
import com.dvinc.workouttimer.di.qualifiers.UiScheduler;
import com.dvinc.workouttimer.domain.interactors.laps.LapsInteractor;
import com.dvinc.workouttimer.domain.interactors.laps.LapsInteractorImpl;
import com.dvinc.workouttimer.domain.interactors.trainings.TrainingsInteractor;
import com.dvinc.workouttimer.domain.interactors.trainings.TrainingsInteractorImpl;
import com.dvinc.workouttimer.domain.mappers.LapsMapper;
import com.dvinc.workouttimer.domain.mappers.TrainingsMapper;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

@Module
public class InteractorsModule {

    @Provides
    TrainingsInteractor provideTrainingsInteractor(@NonNull TrainingsRepository repository,
                                                   @NonNull LapsRepository lapsRepository,
                                                   @IoScheduler Scheduler schedulerIo,
                                                   @UiScheduler Scheduler schedulerUi,
                                                   @NonNull LapsMapper lapsMapper,
                                                   @NonNull TrainingsMapper trainingsMapper) {
        return new TrainingsInteractorImpl(repository, lapsRepository, schedulerIo, schedulerUi, lapsMapper, trainingsMapper);
    }

    @Provides
    LapsInteractor provideLapsInteractor(@NonNull TrainingsRepository repository,
                                         @NonNull LapsRepository lapsRepository,
                                         @IoScheduler Scheduler schedulerIo,
                                         @UiScheduler Scheduler schedulerUi,
                                         @NonNull LapsMapper lapsMapper) {
        return new LapsInteractorImpl(repository, lapsRepository, schedulerIo, schedulerUi, lapsMapper);
    }
}
