package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Stopwatch extends AppCompatActivity {

    private Button bWorldClock;
    private Button bAlarm;
    private Button bTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        setTitle("Stopwatch");

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

        bTimer = findViewById(R.id.button_timer);
        bTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimer();
            }
        });
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

    public void openTimer() {
        Intent intent = new Intent(this, Timer.class);
        this.startActivity(intent);
        this.overridePendingTransition(0, 0);
    }
}