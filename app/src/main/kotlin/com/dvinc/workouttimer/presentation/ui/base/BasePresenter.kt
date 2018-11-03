/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.base

import com.dvinc.workouttimer.presentation.common.assert.Assert
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

@Deprecated("Delete after migration to viewModels")
abstract class BasePresenter<T : BaseMvpView> {

    private var view: T? = null
    private val compositeDisposable = CompositeDisposable()

    open fun attachView(view: T) {
        Assert.assertNull(this.view, "View should be null while attach")
        this.view = view
    }

    fun detachView() {
        compositeDisposable.clear()
        Assert.assertNotNull(view, "View should not be null while detach")
        view = null
    }

    protected fun getView(): T? {
        return view
    }

    protected fun addSubscription(d: Disposable) {
        compositeDisposable.add(d)
    }
}
