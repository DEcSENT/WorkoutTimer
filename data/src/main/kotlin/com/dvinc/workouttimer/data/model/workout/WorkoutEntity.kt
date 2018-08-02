/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.model.workout

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "workout")
data class WorkoutEntity(

        @PrimaryKey(autoGenerate = true)
        var uid: Int,

        @ColumnInfo(name = "id")
        val id: Int,

        @ColumnInfo(name = "name")
        val name: String,

        @ColumnInfo(name = "description")
        val description: String,

        @ColumnInfo(name = "active")
        val isActive: Boolean
)
