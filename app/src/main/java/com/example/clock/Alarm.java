package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Alarm extends AppCompatActivity {

    Button bWorldClock;
    Button bStopwatch;
    Button bTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        setTitle("Alarm");

        bWorldClock = findViewById(R.id.button_world_clock);
        bWorldClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWC();
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

    public void openWC() {
        Intent intent = new Intent(this, WorldClock.class);
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