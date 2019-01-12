/*
 * Copyright (c) 2019 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.provider

import android.content.Context
import com.dvinc.workouttimer.presentation.di.component.*
import com.dvinc.workouttimer.presentation.di.module.AppModule

object DiProvider {

    private lateinit var appComponent: AppComponent

    private var workoutComponent: WorkoutComponent? = null

    private var exerciseComponent: ExerciseComponent? = null

    private var newWorkoutComponent: NewWorkoutComponent? = null

    private var newExerciseComponent: NewExerciseComponent? = null

    fun buildDi(context: Context) {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(context))
                .build()
    }

    fun getWorkoutComponent(): WorkoutComponent? {
        if (workoutComponent == null) {
            workoutComponent = appComponent.getWorkoutComponent()
        }

        return workoutComponent
    }

    fun clearWorkoutComponent() {
        workoutComponent = null
    }

    fun getExerciseComponent(): ExerciseComponent? {
        if (exerciseComponent == null) {
            exerciseComponent = appComponent.getExerciseComponent()
        }

        return exerciseComponent
    }

    fun clearExerciseComponent() {
        exerciseComponent = null
    }

    fun getNewWorkoutComponent(): NewWorkoutComponent? {
        if (newWorkoutComponent == null) {
            newWorkoutComponent = appComponent.getNewWorkoutComponent()
        }

        return newWorkoutComponent
    }

    fun clearNewWorkoutComponent() {
        newWorkoutComponent = null
    }

    fun getNewExerciseComponent(): NewExerciseComponent? {
        if (newExerciseComponent == null) {
            newExerciseComponent = appComponent.getNewExerciseComponent()
        }

        return newExerciseComponent
    }

    fun clearNewExerciseComponent() {
        newWorkoutComponent = null
    }
}
