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
import com.dvinc.workouttimer.data.repository.exercise.ExerciseDataRepository
import com.dvinc.workouttimer.data.repository.workout.WorkoutDataRepository
import com.dvinc.workouttimer.domain.repository.exercise.ExerciseRepository
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import com.dvinc.workouttimer.presentation.di.annotation.ViewModelKey
import com.dvinc.workouttimer.presentation.ui.new_workout.NewWorkoutViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewWorkoutModule {

    @Binds
    abstract fun provideWorkoutRepository(repository: WorkoutDataRepository): WorkoutRepository

    @Binds
    abstract fun provideExerciseRepository(exerciseRepository: ExerciseDataRepository): ExerciseRepository

    @Binds
    abstract fun provideWorkoutMapper(mapper: WorkoutDataMapper): WorkoutMapper

    @Binds
    abstract fun provideExerciseMapper(mapper: ExerciseDataMapper): ExerciseMapper

    @Binds
    @IntoMap
    @ViewModelKey(NewWorkoutViewModel::class)
    abstract fun provideExerciseViewModel(viewModel: NewWorkoutViewModel): ViewModel
}
