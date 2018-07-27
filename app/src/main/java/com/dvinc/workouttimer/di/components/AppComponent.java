/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.di.components;

import com.dvinc.workouttimer.di.modules.AppModule;
import com.dvinc.workouttimer.di.modules.DataModule;
import com.dvinc.workouttimer.di.modules.InteractorsModule;
import com.dvinc.workouttimer.di.modules.MapperModule;
import com.dvinc.workouttimer.presentation.di.module.NewApplicationModule;
import com.dvinc.workouttimer.presentation.ui.workout.WorkoutFragment;
import com.dvinc.workouttimer.ui.laps.LapsFragment;
import com.dvinc.workouttimer.ui.trainings.TrainingsFragment;
import com.dvinc.workouttimer.ui.newtraining.NewTrainingFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        DataModule.class,
        InteractorsModule.class,
        MapperModule.class,
        NewApplicationModule.class})
public interface AppComponent {
    void inject(TrainingsFragment trainingsFragment);
    void inject(NewTrainingFragment newTrainingFragment);
    void inject(LapsFragment lapsFragment);

    void inject(WorkoutFragment workoutFragment);
}
