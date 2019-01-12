/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.application

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.dvinc.workouttimer.BuildConfig
import io.fabric.sdk.android.Fabric
import com.dvinc.workouttimer.presentation.common.timber.ReleaseTree
import com.dvinc.workouttimer.presentation.di.component.DaggerAppComponent
import com.dvinc.workouttimer.presentation.di.component.AppComponent
import com.dvinc.workouttimer.presentation.di.component.ExerciseComponent
import com.dvinc.workouttimer.presentation.di.component.NewWorkoutComponent
import com.dvinc.workouttimer.presentation.di.component.WorkoutComponent
import com.dvinc.workouttimer.presentation.di.component.NewExerciseComponent
import com.dvinc.workouttimer.presentation.di.module.AppModule
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber
import com.squareup.leakcanary.RefWatcher

class WorkoutApp : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        private lateinit var refWatcher: RefWatcher

        fun get(context: Context): WorkoutApp {
            return context.applicationContext as WorkoutApp
        }

        fun getRefWatcher(): RefWatcher {
            return refWatcher
        }
    }

    lateinit var appComponent: AppComponent

    private var workoutComponent: WorkoutComponent? = null

    private var exerciseComponent: ExerciseComponent? = null

    private var newWorkoutComponent: NewWorkoutComponent? = null

    private var newExerciseComponent: NewExerciseComponent? = null

    override fun onCreate() {
        super.onCreate()
        WorkoutApp.context = this
        appComponent = buildDI()
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else ReleaseTree())
        Fabric.with(this, Crashlytics())
        Stetho.initializeWithDefaults(this)
        setupLeakCanary()
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

    private fun buildDI(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    private fun setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        refWatcher = LeakCanary.install(this)
    }
}
