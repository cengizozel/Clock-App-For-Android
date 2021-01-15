package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);

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