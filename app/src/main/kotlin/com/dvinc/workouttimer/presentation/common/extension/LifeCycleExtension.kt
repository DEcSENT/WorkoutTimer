/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle. Observer
import androidx.lifecycle.LiveData

inline fun <reified T : ViewModel> Fragment.obtainViewModel(
        viewModelFactory: ViewModelProvider.Factory
): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : Any, reified L : LiveData<T>> LifecycleOwner.observe(
        liveData: L,
        noinline block: (T) -> Unit
) {
    liveData.observe(this, Observer<T> { observer ->
        observer?.let {
            block.invoke(observer)
        }
    })
}
