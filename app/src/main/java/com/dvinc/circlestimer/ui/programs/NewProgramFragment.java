/*
 * Copyright (c) 2018 by Denis Verentsov (decsent@Yandex.ru)
 * All rights reserved.
 */

package com.dvinc.circlestimer.ui.programs;

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
import android.widget.EditText;

import com.dvinc.circlestimer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//TODO: write code for laps spinner
public class NewProgramFragment extends DialogFragment {

    public static final String TAG = "NewProgramFragment";

    @BindView(R.id.new_program_nameEditText) EditText newProgramEditText;

    private Unbinder unbinder;

    @Nullable
    private NewProgramListener newProgramListener;

    interface NewProgramListener {
        void onNewProgramAdded(String programName, int defaultLapsCount);
    }

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
        View view = inflater.inflate(R.layout.fragment_new_program, container);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.new_program_cancelButton)
    void onClickCancel(View view) {
        dismiss();
    }

    @OnClick(R.id.new_program_addButton)
    void onClickAddProgram(View view) {
        if (newProgramListener != null) {
            String newProgramName = newProgramEditText.getText().toString();
            newProgramListener.onNewProgramAdded(newProgramName, 0);
        }
    }

    void setNewProgramListener(@NonNull NewProgramListener newProgramListener) {
        this.newProgramListener = newProgramListener;
    }
}
