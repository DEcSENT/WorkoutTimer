/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.component

import com.dvinc.workouttimer.presentation.di.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    CommonModule::class])
interface AppComponent {

    fun getWorkoutComponent(): WorkoutComponent

    fun getExerciseComponent(): ExerciseComponent
}
