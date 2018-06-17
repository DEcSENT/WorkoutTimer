/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/18/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.repositories.laps;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Lap;

import java.util.List;

public interface LapsRepository {

    /**
     * Adding training laps in to data source.
     *
     * @param laps - training laps
     */
    void addLaps(@NonNull List<Lap> laps);

    /**
     * Removing training laps by training id.
     *
     * @param trainingId - training id
     */
    void removeLapsByTrainingId(int trainingId);

    /**
     * Getting training laps.
     *
     * @param trainingId - training id
     */
    @NonNull
    List<Lap> getLapsByTrainingId(int trainingId);

    @NonNull
    List<Lap> getAllLaps();
}
