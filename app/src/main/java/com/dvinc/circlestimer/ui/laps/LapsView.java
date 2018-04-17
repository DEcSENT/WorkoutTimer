/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/17/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.laps;

import com.dvinc.circlestimer.domain.entities.LapItem;
import com.dvinc.circlestimer.ui.base.MvpView;

import java.util.List;

interface LapsView extends MvpView {

    void showLaps(List<LapItem> list);
}
