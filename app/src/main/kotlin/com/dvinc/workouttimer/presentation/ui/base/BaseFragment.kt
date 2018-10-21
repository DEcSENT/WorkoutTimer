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

    /**
     * Getting fragment layout resource id.
     *
     * @return - fragment layout id.
     */
    @LayoutRes
    protected abstract fun getFragmentLayoutId(): Int

    override fun onDestroy() {
        super.onDestroy()
        setupLeakCanaryRefWatcher()
    }

    private fun setupLeakCanaryRefWatcher() {
        WorkoutApp.getRefWatcher().watch(this)
    }
}
