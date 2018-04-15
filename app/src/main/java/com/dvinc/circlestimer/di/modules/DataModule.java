/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.dvinc.circlestimer.data.db.TrainingsDatabase;
import com.dvinc.circlestimer.data.repositories.training.TrainingsRepository;
import com.dvinc.circlestimer.data.repositories.training.TrainingsRepositoryImpl;
import com.dvinc.circlestimer.di.qualifiers.IoScheduler;
import com.dvinc.circlestimer.di.qualifiers.UiScheduler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class DataModule {
    @Provides
    @Singleton
    TrainingsDatabase provideTrainingDataBase(Context context) {
        return Room.databaseBuilder(context, TrainingsDatabase.class, "trainingDatabase").build();
    }

    @Provides
    @Singleton
    TrainingsRepository provideTrainingsRepository(TrainingsDatabase trainingsDatabase,
                                                   @IoScheduler Scheduler schedulerIo,
                                                   @UiScheduler Scheduler schedulerUi) {
        return new TrainingsRepositoryImpl(trainingsDatabase, schedulerIo, schedulerUi);
    }

    @Provides
    @IoScheduler
    Scheduler provideIoScheduler() {
        return Schedulers.io();
    }

    @Provides
    @UiScheduler
    Scheduler provideUiScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
