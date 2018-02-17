package com.dvinc.circlestimer.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.ui.circle_view.CircleView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.circleView) CircleView circleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        circleView.setTime(0, 50);
    }

    @OnClick(R.id.startButton)
    void onStartClick(@NonNull View v) {
        circleView.start();
    }

    @OnClick(R.id.finishButton)
    void onPauseClick(@NonNull View v) {
        circleView.stop();
    }

    @OnClick(R.id.stopButton)
    void onStopClick(@NonNull View v) {
        circleView.stop();
        circleView.setTime(0, 25);
    }

}
