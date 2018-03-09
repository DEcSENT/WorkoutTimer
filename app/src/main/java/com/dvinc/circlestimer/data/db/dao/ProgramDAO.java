/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dvinc.circlestimer.data.db.entities.ProgramEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ProgramDAO {

    @Insert
    void addProgram(ProgramEntity programEntity);

    @Query("SELECT * FROM ProgramsTable")
    Single<List<ProgramEntity>> getAllPrograms();
}
