/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.model.exercise

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
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
