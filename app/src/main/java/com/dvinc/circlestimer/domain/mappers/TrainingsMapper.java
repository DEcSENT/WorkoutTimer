/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.mappers;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Lap;
import com.dvinc.circlestimer.data.db.entities.Training;
import com.dvinc.circlestimer.domain.entities.TrainingItem;

import java.util.ArrayList;
import java.util.List;

/**
 * This is prototype class for mapping.
 */
public class TrainingsMapper {

    //TODO: Think about optimisation
    @NonNull
    public List<TrainingItem> map(@NonNull List<Training> trainings, @NonNull List<Lap> laps) {
        final List<TrainingItem> mappedItems = new ArrayList<>();
        for (Training training : trainings) {
            int lapsCount = 0;
            int totalTime = 0;
            for (Lap lap : laps) {
                if (lap.getTrainingId() == training.getUid()) {
                    lapsCount++;
                    totalTime += lap.getLapTime();
                }
            }
            mappedItems.add(mapTraining(training, lapsCount, totalTime));
        }
        return mappedItems;
    }

    @NonNull
    private TrainingItem mapTraining(@NonNull Training training, int lapsCount, long totalTime) {
        return new TrainingItem(training.getUid(), training.getTrainingName(), training.isCurrentTraining(), lapsCount, totalTime);
    }
}
