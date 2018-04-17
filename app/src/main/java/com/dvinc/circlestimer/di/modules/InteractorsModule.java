/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.di.modules;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.repositories.training.TrainingsRepository;
import com.dvinc.circlestimer.di.qualifiers.IoScheduler;
import com.dvinc.circlestimer.di.qualifiers.UiScheduler;
import com.dvinc.circlestimer.domain.interactors.laps.LapsInteractor;
import com.dvinc.circlestimer.domain.interactors.laps.LapsInteractorImpl;
import com.dvinc.circlestimer.domain.interactors.trainings.TrainingsInteractor;
import com.dvinc.circlestimer.domain.interactors.trainings.TrainingsInteractorImpl;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

@Module
public class InteractorsModule {

    @Provides
    TrainingsInteractor provideTrainingsInteractor(@NonNull TrainingsRepository repository,
                                                   @IoScheduler Scheduler schedulerIo,
                                                   @UiScheduler Scheduler schedulerUi) {
        return new TrainingsInteractorImpl(repository, schedulerIo, schedulerUi);
    }

    @Provides
    LapsInteractor provideLapsInteractor(@NonNull TrainingsRepository repository,
                                              @IoScheduler Scheduler schedulerIo,
                                              @UiScheduler Scheduler schedulerUi) {
        return new LapsInteractorImpl(repository, schedulerIo, schedulerUi);
    }
}
