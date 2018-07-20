/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.module

import com.dvinc.workouttimer.data.repository.workout.WorkoutDataRepository
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import com.dvinc.workouttimer.presentation.mapper.workout.WorkoutPresentationMapper
import dagger.Module
import dagger.Provides

@Module
class WorkoutScreenModule {

    @Provides
    fun provideWorkoutRepository(): WorkoutRepository = WorkoutDataRepository()

    @Provides
    fun provideWorkoutPresentationMapper(): WorkoutPresentationMapper = WorkoutPresentationMapper()
}
 