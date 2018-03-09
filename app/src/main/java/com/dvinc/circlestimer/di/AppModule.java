/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.di;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.ProgramsDatabase;
import com.dvinc.circlestimer.data.repositories.ProgramsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @NonNull
    private Context context;

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
    ProgramsDatabase provideCityDataBase() {
        return Room.databaseBuilder(context,
                ProgramsDatabase.class, "programDatabase").build();
    }

    @Provides
    @Singleton
    ProgramsRepository provideProgramsRepository(ProgramsDatabase programsDatabase) {
        return new ProgramsRepository(programsDatabase);
    }
}
