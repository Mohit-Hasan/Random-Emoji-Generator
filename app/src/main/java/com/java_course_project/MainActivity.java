package com.java_course_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RandomEmojiCanvas canvasTop, canvasBottom;
    private Button startButtonTop, startButtonBottom, logoutButton;
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (!isLoggedIn) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        setContentView(R.layout.activity_main);

        canvasTop = findViewById(R.id.canvasTop);
        canvasBottom = findViewById(R.id.canvasBottom);
        startButtonTop = findViewById(R.id.starButtonTop);
        startButtonBottom = findViewById(R.id.starButtonBottom);
        logoutButton = findViewById(R.id.logoutButton);
        scoreTextView = findViewById(R.id.scoreTextView);

        RandomEmojiCanvas.setScoreTextView(scoreTextView);

        startButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startButtonTop.getText().toString().equals("Start")) {
                    startButtonTop.setText("Stop");
                    canvasTop.startRandomEmojis();
                } else {
                    startButtonTop.setText("Start");
                    canvasTop.stopRandomEmojis();
                }
            }
        });

        startButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startButtonBottom.getText().toString().equals("Start")) {
                    startButtonBottom.setText("Stop");
                    canvasBottom.startRandomEmojis();
                } else {
                    startButtonBottom.setText("Start");
                    canvasBottom.stopRandomEmojis();
                }
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }


    private void logout() {
        SharedPreferences preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
