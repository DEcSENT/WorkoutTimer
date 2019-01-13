/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.component

import com.dvinc.workouttimer.presentation.di.module.ExerciseModule
import com.dvinc.workouttimer.presentation.di.scope.ExerciseScope
import com.dvinc.workouttimer.presentation.ui.exercise.ExerciseFragment
import dagger.Subcomponent

@ExerciseScope
@Subcomponent(modules = [ExerciseModule::class])
interface ExerciseComponent {

    fun inject(target: ExerciseFragment)
}
