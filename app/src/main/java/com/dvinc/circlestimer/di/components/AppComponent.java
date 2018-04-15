/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.di.components;

import com.dvinc.circlestimer.di.modules.AppModule;
import com.dvinc.circlestimer.di.modules.DataModule;
import com.dvinc.circlestimer.di.modules.InteractorsModule;
import com.dvinc.circlestimer.ui.trainings.TrainingsFragment;
import com.dvinc.circlestimer.ui.trainings.newtraining.NewTrainingFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, InteractorsModule.class})
public interface AppComponent {
    void inject(TrainingsFragment trainingsFragment);
    void inject(NewTrainingFragment newTrainingFragment);
}
