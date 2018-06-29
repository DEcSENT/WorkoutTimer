/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.ui.base

interface MessageView {

    fun showMessage(message: String)

    fun showError(error: String)
}
