/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.base;

import android.support.annotation.StringRes;

public interface ErrorView {

    void showError(@StringRes int stringResID);

}