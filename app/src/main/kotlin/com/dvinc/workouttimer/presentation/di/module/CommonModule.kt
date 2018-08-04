/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.module

import com.dvinc.workouttimer.presentation.common.resources.ResourceDataManager
import com.dvinc.workouttimer.presentation.common.resources.ResourceManager
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class CommonModule {

    @Binds
    @Singleton
    abstract fun provideResourceManager(manager: ResourceDataManager): ResourceManager
}
