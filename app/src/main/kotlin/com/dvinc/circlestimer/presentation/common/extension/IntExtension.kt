/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.common.extension

import com.dvinc.circlestimer.App

fun Int.dp(): Int {
    if (this == 0) {
        return 0
    }
    val metrics = App.getContext().resources?.displayMetrics
    return (this * requireNotNull(metrics) { "Metrics is null" }.density).toInt()
}
