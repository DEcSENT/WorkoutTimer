/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.programs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.data.db.entities.ProgramEntity;

import java.util.ArrayList;
import java.util.List;

public class ProgramsAdapter extends RecyclerView.Adapter<ProgramsAdapter.MyViewHolder> {

    private List<ProgramEntity> programsEntitiesList = new ArrayList<>();

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView programNameTextView;

        MyViewHolder(View view) {
            super(view);
            programNameTextView = view.findViewById(R.id.programName);
        }
    }

    ProgramsAdapter() {
    }

    void setList(List<ProgramEntity> list) {
        this.programsEntitiesList = list;
        notifyDataSetChanged();
    }

    @Override
    public ProgramsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_program, parent, false);
        return new ProgramsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProgramsAdapter.MyViewHolder holder, final int position) {
        final ProgramEntity program = programsEntitiesList.get(position);
        holder.programNameTextView.setText(program.getProgramName());
    }

    @Override
    public int getItemCount() {
        return programsEntitiesList.size();
    }
}
