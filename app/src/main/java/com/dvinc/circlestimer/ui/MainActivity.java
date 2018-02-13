package com.dvinc.circlestimer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    void onClickStart() {
        circleView.start();
    }

    @OnClick(R.id.finishButton)
    void onClickPause() {
        circleView.stop();
    }

    @OnClick(R.id.stopButton)
    void onClickStop() {
        circleView.stop();
        circleView.setTime(0, 25);
    }

}
