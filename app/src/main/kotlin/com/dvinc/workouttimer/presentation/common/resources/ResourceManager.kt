/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.resources

import android.support.annotation.ArrayRes
import android.support.annotation.ColorRes
import android.support.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes resId: Int): String

    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String

    fun getStringArray(@ArrayRes resId: Int): List<String>

    fun getColor(@ColorRes colorResId: Int): Int
}
