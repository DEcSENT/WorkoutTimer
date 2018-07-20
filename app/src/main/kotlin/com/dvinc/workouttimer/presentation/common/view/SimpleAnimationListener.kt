/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.common.view

import android.animation.Animator

open class SimpleAnimationListener : Animator.AnimatorListener {

    override fun onAnimationRepeat(animation: Animator?) {
        //Override me if you want
    }

    override fun onAnimationEnd(animation: Animator?) {
        //Override me if you want
    }

    override fun onAnimationCancel(animation: Animator?) {
        //Override me if you want
    }

    override fun onAnimationStart(animation: Animator?) {
        //Override me if you want
    }
}
 