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
import com.dvinc.workouttimer.presentation.di.component.AppComponent
import com.dvinc.workouttimer.presentation.di.component.DaggerAppComponent
import com.dvinc.workouttimer.presentation.di.component.ExerciseComponent
import com.dvinc.workouttimer.presentation.di.module.AppModule
import timber.log.Timber

class WorkoutApp : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        fun get(context: Context): WorkoutApp {
            return context.applicationContext as WorkoutApp
        }
    }

    lateinit var appComponent: AppComponent

    private var exerciseComponent: ExerciseComponent? = null

    override fun onCreate() {
        super.onCreate()
        WorkoutApp.context = this
        appComponent = buildDI()
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else ReleaseTree())
        Fabric.with(this, Crashlytics())
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

    private fun buildDI(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}
