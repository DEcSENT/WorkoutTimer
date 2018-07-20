/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/17/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.workouttimer.ui.laps;

import com.dvinc.workouttimer.domain.entities.LapItem;
import com.dvinc.workouttimer.ui.base.MvpView;

import java.util.List;

interface LapsView extends MvpView {

    void showLaps(List<LapItem> list);
}
