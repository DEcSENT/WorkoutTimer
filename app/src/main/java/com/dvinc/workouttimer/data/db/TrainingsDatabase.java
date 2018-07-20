/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dvinc.workouttimer.data.db.dao.LapDao;
import com.dvinc.workouttimer.data.db.dao.TrainingDao;
import com.dvinc.workouttimer.data.db.entities.Lap;
import com.dvinc.workouttimer.data.db.entities.Training;

@Database(entities = {Training.class, Lap.class}, version = 1)
public abstract class TrainingsDatabase extends RoomDatabase {

    public abstract TrainingDao trainingsDao();

    public abstract LapDao lapsDao();
}