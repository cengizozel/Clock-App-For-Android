package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Timer extends AppCompatActivity {

    private Button bWorldClock;
    private Button bAlarm;
    private Button bStopwatch;

    private static final long START_TIME_IN_MILLIS = 60000;

    private TextView tvCountDown;
    private Button bStartPause;
    private Button bReset;

    private CountDownTimer cdt;

    private boolean isTimerRunning;

    private long timeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        setTitle("Timer");

        bWorldClock = findViewById(R.id.button_world_clock);
        bWorldClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWC();
            }
        });

        bAlarm = findViewById(R.id.button_alarm);
        bAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlarm();
            }
        });

        bStopwatch = findViewById(R.id.button_stopwatch);
        bStopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSW();
            }
        });

        tvCountDown = findViewById(R.id.text_view_countdown);
        bStartPause = findViewById(R.id.button_start_pause);
        bReset = findViewById(R.id.button_reset);

        bStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    public void openWC() {
        Intent intent = new Intent(this, WorldClock.class);
        this.startActivity(intent);
        this.overridePendingTransition(0, 0);
    }

    public void openAlarm() {
        Intent intent = new Intent(this, Alarm.class);
        this.startActivity(intent);
        this.overridePendingTransition(0, 0);
    }

    public void openSW() {
        Intent intent = new Intent(this, Stopwatch.class);
        this.startActivity(intent);
        this.overridePendingTransition(0, 0);
    }

    private void startTimer() {
        cdt = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                isTimerRunning = false;
                bStartPause.setText("start");
                bStartPause.setVisibility(View.INVISIBLE);
                bReset.setVisibility(View.INVISIBLE);
            }
        }.start();

        isTimerRunning = true;
        bStartPause.setText("pause");
        bReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        cdt.cancel();
        isTimerRunning = false;
        bStartPause.setText("start");
        bReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        bReset.setVisibility(View.INVISIBLE);
        bStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        tvCountDown.setText(timeLeftFormatted);
    }
}