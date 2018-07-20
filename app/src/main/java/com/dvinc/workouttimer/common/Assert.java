/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.common;

import com.dvinc.workouttimer.BuildConfig;

public final class Assert {

    private Assert() {
    }

    public static <T> void assertNotNull(T object, String message) {
        if (!BuildConfig.DEBUG || object != null) {
            return;
        }
        throw new IllegalArgumentException(message);
    }

    public static <T> void assertNull(T object, String message) {
        if (!BuildConfig.DEBUG || object == null) {
            return;
        }
        throw new IllegalArgumentException(message);
    }
}
