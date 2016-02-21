package com.example.merel.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * Merel van den Hurk
 * This activity displays the finished story with the user's input
 */

public class Result extends AppCompatActivity {

    TextView finishedStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        finishedStory = (TextView) findViewById(R.id.finishedStory);

        // get intent from previous activity
        Bundle extras = getIntent().getExtras();
        String storyText = extras.getString("FINISHED_STORY");

        finishedStory.setText(storyText);
    }
}
