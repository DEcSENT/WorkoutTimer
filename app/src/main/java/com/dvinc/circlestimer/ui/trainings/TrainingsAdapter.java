/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.trainings;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.domain.entities.TrainingItem;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class TrainingsAdapter extends RecyclerView.Adapter<TrainingsAdapter.MyViewHolder> {

    private List<TrainingItem> trainingsList = new ArrayList<>();
    @Nullable
    private TrainingClickListener clickListener;

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView trainingNameTextView;
        private TextView trainingCurrentText;
        private TextView trainingLaps;
        private TextView trainingTime;

        MyViewHolder(View view) {
            super(view);
            trainingNameTextView = view.findViewById(R.id.item_workout_name);
            trainingCurrentText = view.findViewById(R.id.item_workout_active);
            trainingLaps = view.findViewById(R.id.item_workout_total_exercises_value);
            trainingTime = view.findViewById(R.id.item_wotkout_exercises_total_time_value);
        }
    }

    void setList(List<TrainingItem> list) {
        this.trainingsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrainingsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_workout, parent, false);
        return new TrainingsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingsAdapter.MyViewHolder holder, final int position) {
        final TrainingItem training = trainingsList.get(position);
        holder.trainingNameTextView.setText(training.getName());
        holder.trainingCurrentText.setVisibility(training.isCurrentTraining() ? View.VISIBLE : View.INVISIBLE);
        holder.trainingLaps.setText(String.valueOf(training.getLapsCount()));
        holder.trainingTime.setText(String.valueOf(training.getTotalTime()));

        holder.itemView.setOnClickListener(view -> {
            if (clickListener != null) {
                clickListener.onItemClick(training);
            }
        });
        holder.itemView.setOnLongClickListener(v -> {
            if (clickListener != null) {
                clickListener.onLongItemClick(training);
            }
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return trainingsList.size();
    }

    public void setOnClickTrainingListener(@NonNull TrainingClickListener listener) {
        clickListener = listener;
    }

    @Nullable
    TrainingItem getItem(int itemPosition) {
        if (trainingsList.size() > 0) {
            return trainingsList.get(itemPosition);
        } else {
            return null;
        }
    }

    interface TrainingClickListener {
        void onItemClick(@NonNull TrainingItem item);
        void onLongItemClick(@NonNull TrainingItem item);
    }
}
