/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.module

import com.dvinc.workouttimer.data.repository.exercise.mock.ExerciseDataRepositoryMock
import com.dvinc.workouttimer.data.repository.workout.mock.WorkoutDataRepositoryMock
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import dagger.Binds
import dagger.Module

//TODO: Refactor this module when old DI will be deleted
@Module
abstract class NewApplicationModule {

    @Binds
    abstract fun provideWorkoutRepository(repository: WorkoutDataRepositoryMock): WorkoutRepository

    @Binds
    abstract fun provideExerciseRepository(repository: ExerciseDataRepositoryMock): ExerciseRepository
}
