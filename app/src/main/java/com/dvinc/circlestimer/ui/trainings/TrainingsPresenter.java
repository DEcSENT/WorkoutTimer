/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.trainings;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.data.repositories.TrainingsRepository;
import com.dvinc.circlestimer.ui.base.BasePresenter;


import javax.inject.Inject;
import javax.inject.Singleton;

//TODO: handle errors messages
//TODO: handle view null
@Singleton
public class TrainingsPresenter extends BasePresenter<TrainingsView> {

    @NonNull
    private TrainingsRepository trainingsRepository;

    @Inject
    TrainingsPresenter(@NonNull TrainingsRepository trainingsRepository) {
        this.trainingsRepository = trainingsRepository;
    }

    void initTrainings() {
        addSubscription(trainingsRepository.getAllTrainings().subscribe(
                list -> getView().showTrainings(list),
                error -> getView().showError(R.string.app_name)
        ));
    }

    void deleteTraining(int trainingId) {
        addSubscription(trainingsRepository.deleteTraining(trainingId).subscribe(
                () -> getView().showDeleteSuccessMessage(),
                error -> getView().showError(R.string.app_name)
        ));
    }
}
