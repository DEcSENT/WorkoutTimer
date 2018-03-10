/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.programs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dvinc.circlestimer.App;
import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.data.db.entities.ProgramEntity;
import com.dvinc.circlestimer.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class ProgramsFragment extends BaseFragment implements ProgramsView {

    @BindView(R.id.programsRecyclerView) RecyclerView programsRecyclerView;

    @Inject
    ProgramsPresenter programsPresenter;

    private final ProgramsAdapter programsAdapter = new ProgramsAdapter();

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_programs;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get(getActivity()).getAppComponent().inject(this);

        programsRecyclerView.setAdapter(programsAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        programsRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onResume() {
        super.onResume();
        programsPresenter.attachView(this);
        programsPresenter.initPrograms();

    }

    @Override
    public void onPause() {
        super.onPause();
        programsPresenter.detachView();
    }

    @Override
    public void showError(int stringResID) {
        //TODO
    }

    @Override
    public void showPrograms(List<ProgramEntity> programsList) {
        programsAdapter.setList(programsList);
    }

    @OnClick(R.id.button_add_new_program)
    void onClickNewProgramButton(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            NewProgramFragment newProgramFragment = new NewProgramFragment();
            newProgramFragment.setNewProgramListener(new NewProgramFragment.NewProgramListener() {
                @Override
                public void onNewProgramAdded(String programName, int defaultLapsCount) {
                    //TODO: call presenter method here
                }
            });
            newProgramFragment.show(getFragmentManager(), NewProgramFragment.TAG);
        }
    }
}
