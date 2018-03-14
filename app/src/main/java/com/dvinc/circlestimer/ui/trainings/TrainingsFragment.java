/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.trainings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dvinc.circlestimer.App;
import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.data.db.entities.Training;
import com.dvinc.circlestimer.ui.base.BaseFragment;
import com.dvinc.circlestimer.ui.trainings.newtraining.NewTrainingFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class TrainingsFragment extends BaseFragment implements TrainingsView {

    @BindView(R.id.rv_trainings) RecyclerView trainingsRecyclerView;

    @Inject
    TrainingsPresenter trainingsPresenter;

    private final TrainingsAdapter trainingsAdapter = new TrainingsAdapter();

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_trainings;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get(getActivity()).getAppComponent().inject(this);

        trainingsRecyclerView.setAdapter(trainingsAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        trainingsRecyclerView.setLayoutManager(layoutManager);
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
    public void showTrainings(@NonNull List<Training> trainings) {
        trainingsAdapter.setList(trainings);
    }

    @OnClick(R.id.btn_trainings_add_training)
    void onClickNewTrainingButton(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            NewTrainingFragment newTrainingFragment = new NewTrainingFragment();
            newTrainingFragment.show(getFragmentManager(), NewTrainingFragment.TAG);
        }
    }
}
