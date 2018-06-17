/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.newtraining;

import com.dvinc.circlestimer.ui.base.ErrorView;
import com.dvinc.circlestimer.ui.base.MvpView;

interface NewTrainingView extends MvpView, ErrorView {
    void onSuccessfullyAddedTraining();
}
