/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.entity.workout

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout")
data class WorkoutEntity(

        @PrimaryKey(autoGenerate = true)
        var uid: Int = 0,

        @ColumnInfo(name = "name")
        val name: String,

        @ColumnInfo(name = "description")
        val description: String,

        @ColumnInfo(name = "active")
        val isActive: Boolean,

        @ColumnInfo(name = "total_exercises")
        val exerciseCount: Int,

        @ColumnInfo(name = "total_time")
        val totalTime: Long
)
