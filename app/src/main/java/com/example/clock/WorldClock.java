package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class WorldClock extends AppCompatActivity {

    private Button bAlarm;
    private Button bStopwatch;
    private Button bTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_clock);
        setTitle("World Clock");

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

        bTimer = findViewById(R.id.button_timer);
        bTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimer();
            }
        });
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

    public void openTimer() {
        Intent intent = new Intent(this, Timer.class);
        this.startActivity(intent);
        this.overridePendingTransition(0, 0);
    }
}