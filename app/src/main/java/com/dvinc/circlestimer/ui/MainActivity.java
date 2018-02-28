package com.dvinc.circlestimer.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.ui.timeсircle.CircleView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.circleView) CircleView circleView;
    @BindView(R.id.timeTextView) TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        circleView.setTime(1, 50);
        circleView.setTimeChangeListener(new CircleView.TimeChangeListener() {
            @Override
            public void onTimeChanged(int minutes, int seconds) {
                String currentTime = String.format(Locale.US, "%d:%d", minutes, seconds);
                timeTextView.setText(currentTime);
            }

            @Override
            public void onFinish() {

            }
        });
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
