/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.assert

import com.dvinc.workouttimer.BuildConfig

@Deprecated("Delete after migration to viewModels")
class Assert {

    companion object {

        fun <T> assertNotNull(obj: T, message: String) {
            if (!BuildConfig.DEBUG || obj != null) {
                return
            }
            throw IllegalArgumentException(message)
        }

        fun <T> assertNull(obj: T, message: String) {
            if (!BuildConfig.DEBUG || obj == null) {
                return
            }
            throw IllegalArgumentException(message)
        }
    }
}
