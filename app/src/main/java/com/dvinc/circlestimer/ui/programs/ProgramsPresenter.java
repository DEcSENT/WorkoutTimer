/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.programs;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.data.repositories.ProgramsRepository;
import com.dvinc.circlestimer.ui.base.BasePresenter;


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProgramsPresenter extends BasePresenter<ProgramsView> {

    @NonNull
    private ProgramsRepository programsRepository;

    @Inject
    ProgramsPresenter(@NonNull ProgramsRepository programsRepository) {
        this.programsRepository = programsRepository;
    }

    void initPrograms() {
        addSubscription(programsRepository.getAllPrograms().subscribe(
                list -> getView().showPrograms(list),
                error -> getView().showError(R.string.app_name)
        ));
    }
}
