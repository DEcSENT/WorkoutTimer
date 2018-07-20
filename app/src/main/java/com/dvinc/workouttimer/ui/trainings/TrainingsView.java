/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.ui.trainings;

import android.support.annotation.NonNull;

import com.dvinc.workouttimer.domain.entities.TrainingItem;
import com.dvinc.workouttimer.ui.base.ErrorView;
import com.dvinc.workouttimer.ui.base.MessageView;
import com.dvinc.workouttimer.ui.base.MvpView;

import java.util.List;

public interface TrainingsView extends MvpView, ErrorView, MessageView {
    void showTrainings(@NonNull List<TrainingItem> trainings);
}
