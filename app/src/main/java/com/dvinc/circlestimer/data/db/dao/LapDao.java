/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.dvinc.circlestimer.data.db.entities.Lap;

import java.util.List;

@Dao
public interface LapDao {

    @Insert
    void insertAll(List<Lap> laps);

}
