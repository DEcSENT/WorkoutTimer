/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.trainings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.dvinc.circlestimer.App;
import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.domain.entities.TrainingItem;
import com.dvinc.circlestimer.ui.base.BaseFragment;
import com.dvinc.circlestimer.ui.newtraining.NewTrainingFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class TrainingsFragment extends BaseFragment implements TrainingsView {

    @BindView(R.id.fragment_workout_recycler) RecyclerView trainingsRecyclerView;

    @Inject
    TrainingsPresenter trainingsPresenter;

    private final TrainingsAdapter trainingsAdapter = new TrainingsAdapter();

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_workout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get(getActivity()).getAppComponent().inject(this);

        trainingsRecyclerView.setAdapter(trainingsAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        trainingsRecyclerView.setLayoutManager(layoutManager);

        trainingsAdapter.setOnClickTrainingListener(new TrainingsAdapter.TrainingClickListener() {
            @Override
            public void onItemClick(@NonNull TrainingItem item) {
                if (!item.isCurrentTraining()) trainingsPresenter.onTrainingClick(item);
            }

            @Override
            public void onLongItemClick(@NonNull TrainingItem item) {
                Toast.makeText(getContext(), "Edit me!", Toast.LENGTH_LONG).show();
            }
        });

        setupSwipeToDelete();
    }

    @Override
    public void onResume() {
        super.onResume();
        trainingsPresenter.attachView(this);
        trainingsPresenter.initTrainings();
    }

    @Override
    public void onPause() {
        super.onPause();
        trainingsPresenter.detachView();
    }

    @Override
    public void showError(int stringResId) {
        //TODO
    }

    @Override
    public void showTrainings(@NonNull List<TrainingItem> trainings) {
        trainingsAdapter.setList(trainings);
    }

    @Override
    public void showMessage(int message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.fragment_workout_add_button)
    void onClickNewTrainingButton(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            NewTrainingFragment newTrainingFragment = new NewTrainingFragment();
            newTrainingFragment.show(getFragmentManager(), NewTrainingFragment.TAG);
        }
    }

    private void setupSwipeToDelete() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                TrainingItem selectedItem = trainingsAdapter.getItem(position);
                if ( selectedItem != null && !selectedItem.isCurrentTraining()) {
                    showDeleteDialog(selectedItem);
                }

                trainingsAdapter.notifyItemChanged(position);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(trainingsRecyclerView);
    }

    private void showDeleteDialog(TrainingItem item) {
        if (getContext() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(R.string.delete_training_dialog_header);
            builder.setPositiveButton(R.string.delete_training_dialog_positive_btn,
                    (dialogInterface, i) -> trainingsPresenter.deleteTraining(item.getId()));
            builder.setNegativeButton(R.string.delete_training_dialog_negative_btn,
                    (dialogInterface, i) -> dialogInterface.cancel());
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
