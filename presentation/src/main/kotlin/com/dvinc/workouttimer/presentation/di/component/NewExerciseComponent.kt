/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.presentation.di.component

import com.dvinc.workouttimer.presentation.di.module.NewExerciseModule
import com.dvinc.workouttimer.presentation.di.scope.NewExerciseScope
import com.dvinc.workouttimer.presentation.ui.new_exercise.NewExerciseFragment
import dagger.Subcomponent

@NewExerciseScope
@Subcomponent(modules = [NewExerciseModule::class])
interface NewExerciseComponent {

    fun inject(target: NewExerciseFragment)
}
