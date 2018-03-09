/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.data.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "ProgramsTable")
public class ProgramEntity {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "program_name")
    private String programName;

    @ColumnInfo(name = "current_program")
    private boolean isCurrentProgram;

    public ProgramEntity(String programName, boolean isCurrentProgram) {
        this.programName = programName;
        this.isCurrentProgram = isCurrentProgram;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public boolean isCurrentProgram() {
        return isCurrentProgram;
    }

    public void setCurrentProgram(boolean currentProgram) {
        isCurrentProgram = currentProgram;
    }
}
