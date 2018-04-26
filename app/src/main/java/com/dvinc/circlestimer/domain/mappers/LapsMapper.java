/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/18/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.mappers;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Lap;
import com.dvinc.circlestimer.domain.entities.LapItem;

import java.util.ArrayList;
import java.util.List;

/**
 * This is prototype class for mapping.
 */
public class LapsMapper {

    @NonNull
    public List<LapItem> map(@NonNull List<Lap> laps) {
        List<LapItem> mappedLaps = new ArrayList<>();

        for (Lap lap : laps) {
            mappedLaps.add(mapLap(lap));
        }

        return mappedLaps;
    }

    @NonNull
    private LapItem mapLap(@NonNull Lap lap) {
        return new LapItem(lap.getUid(), lap.getOrderNumber(), lap.getLapName(), lap.getLapColor(), lap.getLapTime());
    }
}
