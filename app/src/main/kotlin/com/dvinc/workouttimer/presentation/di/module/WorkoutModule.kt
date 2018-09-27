/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.module

import com.dvinc.workouttimer.data.mapper.workout.WorkoutDataMapper
import com.dvinc.workouttimer.data.mapper.workout.WorkoutMapper
import com.dvinc.workouttimer.data.repository.workout.WorkoutDataRepository
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import dagger.Binds
import dagger.Module

@Module
abstract class WorkoutModule {

    @Binds
    abstract fun provideWorkoutRepository(repository: WorkoutDataRepository): WorkoutRepository

    @Binds
    abstract fun provideWorkoutMapper(mapper: WorkoutDataMapper): WorkoutMapper
}
