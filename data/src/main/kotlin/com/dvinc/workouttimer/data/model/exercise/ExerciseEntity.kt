/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.model.exercise

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.dvinc.workouttimer.data.common.DEFAULT_INTEGER
import com.dvinc.workouttimer.data.common.DEFAULT_LONG
import com.dvinc.workouttimer.data.common.DEFAULT_STRING

@Entity(tableName = "exercise")
data class ExerciseEntity(

        @PrimaryKey(autoGenerate = true)
        var uid: Int = DEFAULT_INTEGER,

        @ColumnInfo(name = "workout_id")
        var workoutId: Int = DEFAULT_INTEGER,

        @ColumnInfo(name = "name")
        var name: String = DEFAULT_STRING,

        @ColumnInfo(name = "description")
        var description: String = DEFAULT_STRING,

        @ColumnInfo(name = "time")
        var time: Long = DEFAULT_LONG
)
