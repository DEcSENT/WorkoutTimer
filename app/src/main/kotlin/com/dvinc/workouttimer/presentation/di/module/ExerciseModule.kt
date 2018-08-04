/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.module

import com.dvinc.workouttimer.data.mapper.exercise.ExerciseDataMapper
import com.dvinc.workouttimer.data.mapper.exercise.ExerciseMapper
import com.dvinc.workouttimer.data.repository.exercise.mock.ExerciseDataRepositoryMock
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import dagger.Binds
import dagger.Module

@Module
abstract class ExerciseModule {

    @Binds
    abstract fun provideExerciseRepository(repository: ExerciseDataRepositoryMock): ExerciseRepository

    @Binds
    abstract fun provideExerciseMapper(mapper: ExerciseDataMapper): ExerciseMapper
}
