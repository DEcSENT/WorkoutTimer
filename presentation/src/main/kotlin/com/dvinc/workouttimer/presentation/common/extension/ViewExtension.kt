/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.extension

import android.view.View
import android.view.ViewPropertyAnimator

fun View.toggleGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.makeGone() {
    this.visibility = View.GONE
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.animateFadeOutWithDuration(duration: Long): ViewPropertyAnimator {
    return this.animate()
            .setDuration(duration)
            .alpha(0.0f)
}

fun View.animateFadeInWithDuration(duration: Long): ViewPropertyAnimator {
    return this.animate()
            .setDuration(duration)
            .alpha(1.0f)
}
