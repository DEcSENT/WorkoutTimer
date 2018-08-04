/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.component

import com.dvinc.workouttimer.presentation.di.module.*
import com.dvinc.workouttimer.presentation.ui.exercise.ExerciseFragment
import com.dvinc.workouttimer.presentation.ui.workout.WorkoutFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    CommonModule::class,
    WorkoutModule::class])
interface AppComponent {

    fun inject(target: WorkoutFragment)

    fun getExerciseComponent(): ExerciseComponent
}
