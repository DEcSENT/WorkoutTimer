/*
 * Copyright (c) 2019 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.entity.workout

import androidx.room.Embedded
import androidx.room.Relation
import com.dvinc.workouttimer.data.database.entity.exercise.ExerciseEntity

/**
 * Wrapper for Room relations.
 * Contains Workout with Exercises.
 */
class WorkoutWithExercisesWrapper {

    @Embedded
    var workout: WorkoutEntity? = null

    @Relation(
            parentColumn = "uid",
            entityColumn = "workout_id",
            entity = ExerciseEntity::class
    )
    var exercises: List<ExerciseEntity>? = null
}
