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
import com.dvinc.workouttimer.presentation.di.provider.DiProvider
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber
import com.squareup.leakcanary.RefWatcher

class WorkoutApp : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        private lateinit var refWatcher: RefWatcher

        fun getRefWatcher(): RefWatcher {
            return refWatcher
        }
    }

    override fun onCreate() {
        super.onCreate()
        WorkoutApp.context = this
        initDi()
        initTools()
    }

    private fun initDi() {
        DiProvider.buildDi(this)
    }

    private fun initTools() {
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else ReleaseTree())
        Fabric.with(this, Crashlytics())
        Stetho.initializeWithDefaults(this)
        setupLeakCanary()
    }

    private fun setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        refWatcher = LeakCanary.install(this)
    }
}
