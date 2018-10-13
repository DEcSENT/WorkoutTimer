/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.resources

import android.content.Context
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import javax.inject.Inject

class ResourceDataManager @Inject constructor(val context: Context) : ResourceManager {

    override fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }

    override fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
        return context.getString(resId, *formatArgs)
    }

    override fun getStringArray(resId: Int): List<String> {
        return context.resources.getStringArray(resId).toList()
    }

    override fun getColor(colorResId: Int): Int {
        return ContextCompat.getColor(context, colorResId)
    }
}
