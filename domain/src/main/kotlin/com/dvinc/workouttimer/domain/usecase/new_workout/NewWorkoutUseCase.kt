/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.domain.usecase.new_workout

import io.reactivex.Completable
import javax.inject.Inject

class NewWorkoutUseCase @Inject constructor() {

    fun addNewWorkout(name: String, description: String): Completable {
        //TODO: add workout
        return Completable.complete()
    }
}
