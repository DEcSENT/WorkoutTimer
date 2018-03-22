/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.trainings;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.data.db.entities.Training;
import com.dvinc.circlestimer.ui.base.ErrorView;
import com.dvinc.circlestimer.ui.base.MvpView;

import java.util.List;

public interface TrainingsView extends MvpView, ErrorView {
    void showTrainings(@NonNull List<Training> trainings);
}