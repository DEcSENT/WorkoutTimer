/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.component

import com.dvinc.workouttimer.presentation.di.module.WorkoutModule
import com.dvinc.workouttimer.presentation.di.scope.WorkoutScope
import com.dvinc.workouttimer.presentation.ui.workout.WorkoutFragment
import dagger.Subcomponent

@WorkoutScope
@Subcomponent(modules = [WorkoutModule::class])
interface WorkoutComponent {

    fun inject(target: WorkoutFragment)
}
