/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.converter

import android.arch.persistence.room.TypeConverter
import com.dvinc.workouttimer.data.model.exercise.ExerciseTypeEntity

object ExerciseTypeConverter {

    @TypeConverter
    @JvmStatic
    fun fromType(type: ExerciseTypeEntity): String = type.name

    @TypeConverter
    @JvmStatic
    fun toType(name: String): ExerciseTypeEntity = ExerciseTypeEntity.valueOf(name)
}
