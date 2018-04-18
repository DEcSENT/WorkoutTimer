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

/**
 * This is prototype class for mapping.
 */
public class LapMapper {

    @NonNull
    public static LapItem mapLap(@NonNull Lap lap) {
        return new LapItem(lap.getUid(), lap.getOrderNumber(), lap.getLapName(), lap.getLapColor(), lap.getLapTime());
    }
}
