/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.model.exercise

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "exercise")
data class ExerciseEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Int,

        @ColumnInfo(name = "workout_id")
        val workoutId: Int,

        @ColumnInfo(name = "name")
        val name: String,

        @ColumnInfo(name = "description")
        val description: String,

        @ColumnInfo(name = "time")
        val time: Long
)
