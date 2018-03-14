/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.TrainingsDatabase;
import com.dvinc.circlestimer.data.repositories.TrainingsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @NonNull
    private final Context context;

    public AppModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    TrainingsDatabase provideCityDataBase() {
        return Room.databaseBuilder(context,
                TrainingsDatabase.class, "trainingDatabase").build();
    }

    @Provides
    @Singleton
    TrainingsRepository provideTrainingsRepository(TrainingsDatabase trainingsDatabase) {
        return new TrainingsRepository(trainingsDatabase);
    }
}
