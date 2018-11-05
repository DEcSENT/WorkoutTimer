/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dvinc.workouttimer.presentation.common.application.WorkoutApp

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getFragmentLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectDependencies()
        initViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        clearDependencies()
        setupLeakCanaryRefWatcher()
    }

    /**
     * Getting fragment layout resource id.
     *
     * @return - fragment layout id.
     */
    @LayoutRes
    protected abstract fun getFragmentLayoutId(): Int

    /**
     * Use this method for injecting dependencies via Dagger.
     */
    abstract fun injectDependencies()

    /**
     * Use this method for clearing Dagger dependencies.
     */
    abstract fun clearDependencies()

    /**
     * Use this method for obtaining viewModel and observing liveData.
     */
    abstract fun initViewModel()

    private fun setupLeakCanaryRefWatcher() {
        WorkoutApp.getRefWatcher().watch(this)
    }
}
