/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.crashlytics.android.Crashlytics;
import com.dvinc.workouttimer.di.components.AppComponent;
import com.dvinc.workouttimer.di.components.DaggerAppComponent;
import com.dvinc.workouttimer.di.modules.AppModule;

import com.facebook.stetho.Stetho;

import io.fabric.sdk.android.Fabric;

public class App extends Application {

    @NonNull
    private AppComponent appComponent;

    //TODO: To new App class
    @SuppressLint("StaticFieldLeak")
    @NonNull
    private static Context context;

    @NonNull
    public static App get(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildDi();
        Stetho.initializeWithDefaults(this);

        context = this;

        Fabric.with(this, new Crashlytics());
    }

    private AppComponent buildDi() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return appComponent;
    }

    @NonNull
    public static Context getContext() {
        return context;
    }
}
