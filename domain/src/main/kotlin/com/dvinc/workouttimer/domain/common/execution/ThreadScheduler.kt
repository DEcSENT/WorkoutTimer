/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.common.execution

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class ThreadScheduler @Inject constructor() {

    protected open fun ui(): Scheduler = AndroidSchedulers.mainThread()

    protected open fun io(): Scheduler = Schedulers.io()

    fun <T> ioToUiSingle() = { upstream: Single<T> -> upstream.subscribeOn(io()).observeOn(ui()) }

    fun <T> ioToUiObservable() = { upstream: Observable<T> -> upstream.subscribeOn(io()).observeOn(ui()) }

    fun <T> ioToUiFlowable() = { upstream: Flowable<T> -> upstream.subscribeOn(io()).observeOn(ui()) }

    fun <T> ioToUiMaybe() = { upstream: Maybe<T> -> upstream.subscribeOn(io()).observeOn(ui()) }

    fun ioToUiCompletable() = { upstream: Completable -> upstream.subscribeOn(io()).observeOn(ui()) }
}
