/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.presentation.di.module

import com.dvinc.circlestimer.data.repository.workout.WorkoutDataRepository
import com.dvinc.circlestimer.domain.repository.workout.WorkoutRepository
import com.dvinc.circlestimer.presentation.mapper.workout.WorkoutPresentationMapper
import dagger.Module
import dagger.Provides

@Module
class WorkoutScreenModule {

    @Provides
    fun provideWorkoutRepository(): WorkoutRepository = WorkoutDataRepository()

    @Provides
    fun provideWorkoutPresentationMapper(): WorkoutPresentationMapper = WorkoutPresentationMapper()
}
 