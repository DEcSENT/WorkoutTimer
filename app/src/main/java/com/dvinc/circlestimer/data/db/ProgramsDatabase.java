/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dvinc.circlestimer.data.db.dao.LapDAO;
import com.dvinc.circlestimer.data.db.dao.ProgramDAO;
import com.dvinc.circlestimer.data.db.entities.LapEntity;
import com.dvinc.circlestimer.data.db.entities.ProgramEntity;

@Database(entities = {ProgramEntity.class, LapEntity.class}, version = 1)
public abstract class ProgramsDatabase extends RoomDatabase {

    public abstract ProgramDAO programsDao();

    public abstract LapDAO lapsDao();
}