/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    fun insert(obj: T): Long

    @Insert
    fun insert(objs: List<T>): List<Long>

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)
}
