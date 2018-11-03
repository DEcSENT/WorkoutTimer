/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.module

import androidx.lifecycle.ViewModel
import com.dvinc.workouttimer.data.mapper.exercise.ExerciseDataMapper
import com.dvinc.workouttimer.data.mapper.exercise.ExerciseMapper
import com.dvinc.workouttimer.data.mapper.workout.WorkoutDataMapper
import com.dvinc.workouttimer.data.mapper.workout.WorkoutMapper
import com.dvinc.workouttimer.data.repository.exercise.mock.ExerciseDataRepositoryMock
import com.dvinc.workouttimer.data.repository.workout.WorkoutDataRepository
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import com.dvinc.workouttimer.presentation.di.annotation.ViewModelKey
import com.dvinc.workouttimer.presentation.di.scope.ExerciseScope
import com.dvinc.workouttimer.presentation.ui.exercise.ExerciseViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@ExerciseScope
abstract class ExerciseModule {

    @Binds
    abstract fun provideExerciseRepository(repository: ExerciseDataRepositoryMock): ExerciseRepository

    @Binds
    abstract fun provideWorkoutRepository(repository: WorkoutDataRepository): WorkoutRepository

    @Binds
    abstract fun provideExerciseMapper(mapper: ExerciseDataMapper): ExerciseMapper

    @Binds
    abstract fun provideWorkoutMapper(mapper: WorkoutDataMapper): WorkoutMapper

    @Binds
    @IntoMap
    @ViewModelKey(ExerciseViewModel::class)
    abstract fun provideExerciseViewModel(viewModel: ExerciseViewModel): ViewModel
}
