/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.ui.newtraining;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.dvinc.workouttimer.R;
import com.dvinc.workouttimer.domain.interactors.trainings.TrainingsInteractor;
import com.dvinc.workouttimer.ui.base.BasePresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class NewTrainingPresenter extends BasePresenter<NewTrainingView> {

    @NonNull
    private final TrainingsInteractor interactor;

    @Inject
    NewTrainingPresenter(@NonNull TrainingsInteractor interactor) {
        this.interactor = interactor;
    }

    void addNewTraining(@NonNull String name, @IntRange(from = 0) int defaultLaps) {
        addSubscription(interactor.addNewTraining(name, defaultLaps)
                .subscribe(
                        () -> getView().onSuccessfullyAddedTraining(),
                        (error) -> getView().showError(R.string.new_training_error_message)));
    }
}
