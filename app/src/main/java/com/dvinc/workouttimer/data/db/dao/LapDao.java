/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dvinc.workouttimer.data.db.entities.Lap;

import java.util.List;

@Dao
@Deprecated
public interface LapDao {

    @Insert
    void insertAll(List<Lap> laps);

    @Query("DELETE FROM Laps WHERE training_id =:trainingId")
    void removeLaps(int trainingId);

    @Query("SELECT * FROM Laps WHERE training_id =:trainingId")
    List<Lap> getLaps(int trainingId);

    @Query("SELECT * FROM Laps")
    List<Lap> getAllLaps();
}
