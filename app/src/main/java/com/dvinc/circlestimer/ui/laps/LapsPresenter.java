/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/17/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.laps;

import com.dvinc.circlestimer.domain.interactors.laps.LapsInteractor;
import com.dvinc.circlestimer.ui.base.BasePresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

//TODO: remove this singleton annotation
@Singleton
class LapsPresenter extends BasePresenter<LapsView> {

    @Inject
    LapsInteractor interactor;

    @Inject
    LapsPresenter(LapsInteractor lapsInteractor) {
        interactor = lapsInteractor;
    }

    void initLapsView() {
        //TODO: load laps list from interactor here
    }
}
