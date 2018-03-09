/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.dvinc.circlestimer.di.AppComponent;
import com.dvinc.circlestimer.di.AppModule;
import com.dvinc.circlestimer.di.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    public static App get(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildDi();
    }

    private AppComponent buildDi() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
