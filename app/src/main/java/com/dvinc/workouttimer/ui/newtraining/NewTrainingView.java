/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.ui.newtraining;

import com.dvinc.workouttimer.ui.base.ErrorView;
import com.dvinc.workouttimer.ui.base.MvpView;

interface NewTrainingView extends MvpView, ErrorView {
    void onSuccessfullyAddedTraining();
}
