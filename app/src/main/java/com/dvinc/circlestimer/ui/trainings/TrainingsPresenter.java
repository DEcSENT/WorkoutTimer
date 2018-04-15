/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.trainings;

import android.support.annotation.NonNull;

import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.data.db.entities.Training;
import com.dvinc.circlestimer.domain.interactors.trainings.TrainingsInteractor;
import com.dvinc.circlestimer.ui.base.BasePresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

//TODO: handle errors messages
//TODO: handle view null
//TODO: update string res for messages
@Singleton
public class TrainingsPresenter extends BasePresenter<TrainingsView> {

    @NonNull
    private final TrainingsInteractor interactor;

    @Inject
    TrainingsPresenter(@NonNull TrainingsInteractor interactor) {
        this.interactor = interactor;
    }

    void initTrainings() {
        addSubscription(interactor.getAllTrainings().subscribe(
                list -> getView().showTrainings(list),
                error -> getView().showError(R.string.app_name)
        ));
    }

    void deleteTraining(int trainingId) {
        addSubscription(interactor.deleteTraining(trainingId).subscribe(
                () -> getView().showMessage(R.string.message_delete_training_success),
                error -> getView().showError(R.string.app_name)
        ));
    }

    void onTrainingClick(@NonNull Training training) {
        addSubscription(interactor.setCurrentTraining(training).subscribe(
                () -> getView().showMessage(R.string.message_training_new_current_training),
                error -> getView().showError(R.string.app_name)
        ));
    }
}
