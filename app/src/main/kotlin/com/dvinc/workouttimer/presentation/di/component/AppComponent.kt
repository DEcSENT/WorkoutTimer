/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.component

import com.dvinc.workouttimer.presentation.di.module.AppModule
import com.dvinc.workouttimer.presentation.di.module.DataModule
import com.dvinc.workouttimer.presentation.di.module.CommonModule
import com.dvinc.workouttimer.presentation.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    CommonModule::class,
    ViewModelModule::class])
interface AppComponent {

    fun getWorkoutComponent(): WorkoutComponent

    fun getExerciseComponent(): ExerciseComponent

    fun getNewWorkoutComponent(): NewWorkoutComponent

    fun getNewExerciseComponent(): NewExerciseComponent
}
