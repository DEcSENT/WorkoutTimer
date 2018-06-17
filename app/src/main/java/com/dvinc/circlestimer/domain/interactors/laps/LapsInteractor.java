/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/17/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.domain.interactors.laps;

import com.dvinc.circlestimer.domain.entities.LapItem;

import java.util.List;

import io.reactivex.Flowable;

public interface LapsInteractor {

    Flowable<List<LapItem>> getLaps();
}
