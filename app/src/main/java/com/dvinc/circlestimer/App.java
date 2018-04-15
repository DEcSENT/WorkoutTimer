/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.dvinc.circlestimer.di.components.AppComponent;
import com.dvinc.circlestimer.di.components.DaggerAppComponent;
import com.dvinc.circlestimer.di.modules.AppModule;

import com.facebook.stetho.Stetho;

public class App extends Application {

    @NonNull
    private AppComponent appComponent;

    @NonNull
    public static App get(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildDi();
        Stetho.initializeWithDefaults(this);
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
}
