/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/26/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.circlestimer.di.modules;

import com.dvinc.circlestimer.domain.mappers.LapsMapper;

import dagger.Module;
import dagger.Provides;

@Module
public class MapperModule {

    @Provides
    LapsMapper provideLapsMapper() {
        return new LapsMapper();
    }
}
