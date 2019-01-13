/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.entity.exercise

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.dvinc.workouttimer.data.database.entity.workout.WorkoutEntity

@Entity(tableName = "exercise",
        foreignKeys = [ForeignKey(entity = WorkoutEntity::class,
                parentColumns = ["uid"],
                childColumns = ["workout_id"],
                onDelete = CASCADE)],
        indices = [Index("workout_id")])
data class ExerciseEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,

        @ColumnInfo(name = "workout_id")
        val workoutId: Int,

        @ColumnInfo(name = "name")
        val name: String,

        @ColumnInfo(name = "description")
        val description: String,

        @ColumnInfo(name = "time")
        val time: Long,

        @ColumnInfo(name = "type")
        val type: ExerciseTypeEntity
)
