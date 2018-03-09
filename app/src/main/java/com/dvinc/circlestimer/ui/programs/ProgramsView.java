/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.programs;

import com.dvinc.circlestimer.data.db.entities.ProgramEntity;
import com.dvinc.circlestimer.ui.base.ErrorView;
import com.dvinc.circlestimer.ui.base.MvpView;

import java.util.List;

public interface ProgramsView extends MvpView, ErrorView {

    void showPrograms(List<ProgramEntity> programsList);

}
