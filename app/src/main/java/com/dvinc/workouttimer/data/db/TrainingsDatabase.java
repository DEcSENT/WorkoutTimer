/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dvinc.workouttimer.data.database.dao.ExerciseDao;
import com.dvinc.workouttimer.data.database.dao.WorkoutDao;
import com.dvinc.workouttimer.data.db.dao.LapDao;
import com.dvinc.workouttimer.data.db.dao.TrainingDao;
import com.dvinc.workouttimer.data.db.entities.Lap;
import com.dvinc.workouttimer.data.db.entities.Training;
import com.dvinc.workouttimer.data.model.exercise.ExerciseEntity;
import com.dvinc.workouttimer.data.model.workout.WorkoutEntity;

@Database(entities = {Training.class, Lap.class, WorkoutEntity.class, ExerciseEntity.class}, version = 1)
public abstract class TrainingsDatabase extends RoomDatabase {

    public abstract TrainingDao trainingsDao();

    public abstract LapDao lapsDao();

    public abstract WorkoutDao workoutDao();

    public abstract ExerciseDao exerciseDao();
}