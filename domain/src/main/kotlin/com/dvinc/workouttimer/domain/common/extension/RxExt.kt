/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.common.extension

import io.reactivex.CompletableTransformer
import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> getIoToMainTransformerObservable(): ObservableTransformer<T, T> {
    return ObservableTransformer { objectObservable ->
        objectObservable
                .subscribeOn(getIoScheduler())
                .observeOn(getMainThreadScheduler())
    }
}

fun <T> getIoToMainTransformerSingle(): SingleTransformer<T, T> {
    return SingleTransformer { objectObservable ->
        objectObservable
                .subscribeOn(getIoScheduler())
                .observeOn(getMainThreadScheduler())
    }
}

fun <T> getIoToMainTransformerFlowable(): FlowableTransformer<T, T> {
    return FlowableTransformer { objectObservable ->
        objectObservable
                .subscribeOn(getIoScheduler())
                .observeOn(getMainThreadScheduler())
    }
}

fun getIoToMainTransformerCompletable(): CompletableTransformer {
    return CompletableTransformer { objectObservable ->
        objectObservable
                .subscribeOn(getIoScheduler())
                .observeOn(getMainThreadScheduler())
    }
}

private fun getIoScheduler() = Schedulers.io()

private fun getMainThreadScheduler() = AndroidSchedulers.mainThread()
 