/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.repositories;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.ProgramsDatabase;
import com.dvinc.circlestimer.data.db.entities.ProgramEntity;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class ProgramsRepository {

    @NonNull
    private ProgramsDatabase programsDatabase;

    public ProgramsRepository(@NonNull ProgramsDatabase programsDatabase) {
        this.programsDatabase = programsDatabase;
    }

    public Single<List<ProgramEntity>> getAllPrograms() {
        //For test adding 2 program
        return Completable.fromAction(() -> {
            for (int i = 0; i < 2; i++) {
                programsDatabase.programsDao().addProgram(new ProgramEntity("Program: " + i, false));
            }
        }).andThen(programsDatabase
                .programsDao()
                .getAllPrograms())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
