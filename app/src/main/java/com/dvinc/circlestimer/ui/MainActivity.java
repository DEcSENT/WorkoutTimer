package com.dvinc.circlestimer.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dvinc.circlestimer.R;
import com.dvinc.circlestimer.ui.programs.ProgramsFragment;
import com.dvinc.circlestimer.ui.timeсircle.CircleView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.circleview_main) CircleView circleView;
    @BindView(R.id.tv_main_time) TextView timeTextView;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_item_programs:
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.ll_main_container, new ProgramsFragment(), "test").commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.btn_main_start)
    void onStartClick(@NonNull View v) {
        circleView.start();
    }

    @OnClick(R.id.btn_main_finish)
    void onPauseClick(@NonNull View v) {
        circleView.stop();
    }

    @OnClick(R.id.btn_main_stop)
    void onStopClick(@NonNull View v) {
        circleView.stop();
        circleView.setTime(0, 25);
    }

}
