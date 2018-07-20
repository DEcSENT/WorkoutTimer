/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.workouttimer.ui.newtraining;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.dvinc.workouttimer.App;
import com.dvinc.workouttimer.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class NewTrainingFragment extends DialogFragment implements NewTrainingView {

    public static final String TAG = "NewTrainingFragment";

    @BindView(R.id.fragment_new_workout_name) EditText newTrainingEditText;
    @BindView(R.id.fragment_new_workout_laps_spinner) Spinner lapsSpinner;

    private Unbinder unbinder;

    @Inject
    NewTrainingPresenter newTrainingPresenter;

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        if (dialog.getWindow() != null) {
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_training, container);
        unbinder = ButterKnife.bind(this, view);

        App.get(getActivity().getApplicationContext()).getAppComponent().inject(this);

        if (getContext() != null) {
            ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(getContext(), R.array.default_laps, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            lapsSpinner.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        newTrainingPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        newTrainingPresenter.detachView();
        unbinder.unbind();
    }

    @OnClick(R.id.fragment_new_workout_cancel_button)
    void onClickCancel(View view) {
        dismiss();
    }

    @OnClick(R.id.fragment_new_workout_add_button)
    void onClickAddTraining(View view) {
        String name = newTrainingEditText.getText().toString();
        String selectedValue = lapsSpinner.getSelectedItem().toString();
        int laps = Integer.valueOf(selectedValue);

        newTrainingPresenter.addNewTraining(name, laps);
    }

    @Override
    public void showError(int stringResId) {
        if (getContext() != null) {
            Toast.makeText(getContext(), getContext().getResources().getString(stringResId), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSuccessfullyAddedTraining() {
        dismiss();
    }
}
