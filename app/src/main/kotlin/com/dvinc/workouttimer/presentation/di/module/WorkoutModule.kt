/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.module

import androidx.lifecycle.ViewModel
import com.dvinc.workouttimer.data.mapper.workout.WorkoutDataMapper
import com.dvinc.workouttimer.data.mapper.workout.WorkoutMapper
import com.dvinc.workouttimer.data.repository.workout.WorkoutDataRepository
import com.dvinc.workouttimer.domain.repository.workout.WorkoutRepository
import com.dvinc.workouttimer.presentation.di.annotation.ViewModelKey
import com.dvinc.workouttimer.presentation.ui.workout.WorkoutViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class WorkoutModule {

    @Binds
    abstract fun provideWorkoutRepository(repository: WorkoutDataRepository): WorkoutRepository

    @Binds
    abstract fun provideWorkoutMapper(mapper: WorkoutDataMapper): WorkoutMapper

    @Binds
    @IntoMap
    @ViewModelKey(WorkoutViewModel::class)
    abstract fun provideExerciseViewModel(viewModel: WorkoutViewModel): ViewModel
}
