/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dvinc.circlestimer.common.Assert;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<T extends MvpView> {

    @Nullable
    private T view;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void attachView(@NonNull T view) {
        Assert.assertNull(view, "View should be null while attach");
        this.view = view;
    }

    public void detachView() {
        compositeDisposable.clear();
        Assert.assertNotNull(view, "View should not be null while detach");
        view = null;
    }

    @Nullable
    protected T getView() {
        return view;
    }

    protected void addSubscription(@NonNull Disposable d) {
        compositeDisposable.add(d);
    }
}
