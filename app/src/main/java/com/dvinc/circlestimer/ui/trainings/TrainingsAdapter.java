/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.trainings;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.data.db.entities.Training;

import java.util.ArrayList;
import java.util.List;

public class TrainingsAdapter extends RecyclerView.Adapter<TrainingsAdapter.MyViewHolder> {

    private List<Training> trainingsList = new ArrayList<>();

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView trainingNameTextView;
        private TextView trainingCurrentText;

        MyViewHolder(View view) {
            super(view);
            trainingNameTextView = view.findViewById(R.id.tv_item_training_name);
            trainingCurrentText = view.findViewById(R.id.tv_item_training_current);
        }
    }

    void setList(List<Training> list) {
        this.trainingsList = list;
        notifyDataSetChanged();
    }

    @Override
    public TrainingsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_training, parent, false);
        return new TrainingsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrainingsAdapter.MyViewHolder holder, final int position) {
        final Training training = trainingsList.get(position);
        holder.trainingNameTextView.setText(training.getTrainingName());
        holder.trainingCurrentText.setVisibility(training.isCurrentTraining() ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return trainingsList.size();
    }
}
