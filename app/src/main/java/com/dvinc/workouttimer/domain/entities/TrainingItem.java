/*
 * Copyright (c) 2018 by Denis Verentsov
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.entities;

import android.support.annotation.NonNull;

public class TrainingItem {

    private final int id;

    private final String name;

    private final boolean isCurrentTraining;

    private final int lapsCount;

    private final long totalTime;

    public TrainingItem(int id,
                        @NonNull String trainingName,
                        boolean isCurrentTraining,
                        int lapsCount,
                        long totalTime) {
        this.id = id;
        this.name = trainingName;
        this.isCurrentTraining = isCurrentTraining;
        this.lapsCount = lapsCount;
        this.totalTime = totalTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCurrentTraining() {
        return isCurrentTraining;
    }

    public int getLapsCount() {
        return lapsCount;
    }

    public long getTotalTime() {
        return totalTime;
    }
}
