/*
 * Copyright (c) 2018 by Denis Verentsov
 * Date: 4/26/2018
 * Email: decsent@yandex.ru
 * All rights reserved.
 */

package com.dvinc.workouttimer.di.modules;

import com.dvinc.workouttimer.domain.mappers.LapsMapper;
import com.dvinc.workouttimer.domain.mappers.TrainingsMapper;

import dagger.Module;
import dagger.Provides;

@Module
public class MapperModule {

    @Provides
    LapsMapper provideLapsMapper() {
        return new LapsMapper();
    }

    @Provides
    TrainingsMapper provideTrainingsMapper() {
        return new TrainingsMapper();
    }
}