/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.laps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.dvinc.circlestimer.App;
import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.domain.entities.LapItem;
import com.dvinc.circlestimer.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

public class LapsFragment extends BaseFragment implements LapsView {

    @Inject
    LapsPresenter presenter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_laps;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.get(getActivity()).getAppComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
        presenter.initLapsView();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void showLaps(List<LapItem> list) {
        //TODO: update laps list here
    }
}
