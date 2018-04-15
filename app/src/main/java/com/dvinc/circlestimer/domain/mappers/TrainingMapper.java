/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.mappers;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Training;
import com.dvinc.circlestimer.domain.entities.TrainingItem;

/**
 * This is prototype class for mapping.
 */
public class TrainingMapper {

    @NonNull
    public static TrainingItem mapTraining(@NonNull Training training, int lapsCount, long totalTime) {
        return new TrainingItem(training.getUid(), training.getTrainingName(), training.isCurrentTraining(), lapsCount, totalTime);
    }
}
