/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.module

import com.dvinc.workouttimer.data.mapper.exercise.ExerciseDataMapper
import com.dvinc.workouttimer.data.mapper.exercise.ExerciseMapper
import com.dvinc.workouttimer.data.mapper.workout.WorkoutDataMapper
import com.dvinc.workouttimer.data.mapper.workout.WorkoutMapper
import com.dvinc.workouttimer.data.repository.exercise.ExerciseDataRepository
import com.dvinc.workouttimer.data.repository.workout.WorkoutDataRepository
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import dagger.Binds
import dagger.Module

@Module
abstract class NewExerciseModule {

    @Binds
    abstract fun provideWorkoutRepository(repository: WorkoutDataRepository): WorkoutRepository

    @Binds
    abstract fun provideExerciseRepository(exerciseRepository: ExerciseDataRepository): ExerciseRepository

    @Binds
    abstract fun provideWorkoutMapper(mapper: WorkoutDataMapper): WorkoutMapper

    @Binds
    abstract fun provideExerciseMapper(mapper: ExerciseDataMapper): ExerciseMapper
}
