/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.dvinc.circlestimer.data.db.TrainingsDatabase;
import com.dvinc.circlestimer.data.repositories.TrainingsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
        return new TrainingsRepository(trainingsDatabase);
    }
}
