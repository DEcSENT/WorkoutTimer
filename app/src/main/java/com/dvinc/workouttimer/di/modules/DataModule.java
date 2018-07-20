/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.dvinc.workouttimer.data.db.TrainingsDatabase;
import com.dvinc.workouttimer.data.repositories.laps.LapsRepository;
import com.dvinc.workouttimer.data.repositories.laps.LapsRepositoryImpl;
import com.dvinc.workouttimer.data.repositories.training.TrainingsRepository;
import com.dvinc.workouttimer.data.repositories.training.TrainingsRepositoryImpl;
import com.dvinc.workouttimer.di.qualifiers.IoScheduler;
import com.dvinc.workouttimer.di.qualifiers.UiScheduler;

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
    TrainingsRepository provideTrainingsRepository(TrainingsDatabase trainingsDatabase) {
        return new TrainingsRepositoryImpl(trainingsDatabase);
    }

    @Provides
    @Singleton
    LapsRepository provideLapsRepository(TrainingsDatabase trainingsDatabase) {
        return new LapsRepositoryImpl(trainingsDatabase);
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
