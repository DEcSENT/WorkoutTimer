/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.component

import com.dvinc.workouttimer.presentation.di.module.NewWorkoutModule
import com.dvinc.workouttimer.presentation.di.scope.NewWorkoutScope
import com.dvinc.workouttimer.presentation.ui.new_workout.NewWorkoutFragment
import dagger.Subcomponent

@NewWorkoutScope
@Subcomponent(modules = [NewWorkoutModule::class])
interface NewWorkoutComponent {

    fun inject(target: NewWorkoutFragment)
}
