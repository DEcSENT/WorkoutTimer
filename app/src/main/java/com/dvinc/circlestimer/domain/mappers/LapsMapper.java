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
    /**
     * Default lap name.
     */
    private static final String DEFAULT_LAP_NAME = "Lap";

    /**
     * Default lap cell color in hex.
     */
    private static final String DEFAULT_LAP_COLOR = "#FFFFFF";

    /**
     * Default lap time in seconds.
     */
    private static final int DEFAULT_LAP_TIME = 30;

    @NonNull
    public List<LapItem> map(@NonNull List<Lap> laps) {
        List<LapItem> mappedLaps = new ArrayList<>();

        for (Lap lap : laps) {
            mappedLaps.add(mapLap(lap));
        }

        return mappedLaps;
    }

    @NonNull
    public List<Lap> generateDefaultLaps(int trainingId, int defaultLapsAmount) {
        List<Lap> laps = new ArrayList<>();
        for (int i = 0; i < defaultLapsAmount; i++) {
            laps.add(new Lap(trainingId, i, DEFAULT_LAP_NAME, DEFAULT_LAP_COLOR, DEFAULT_LAP_TIME));
        }
        return laps;
    }

    @NonNull
    private LapItem mapLap(@NonNull Lap lap) {
        return new LapItem(lap.getUid(), lap.getOrderNumber(), lap.getLapName(), lap.getLapColor(), lap.getLapTime());
    }
}
