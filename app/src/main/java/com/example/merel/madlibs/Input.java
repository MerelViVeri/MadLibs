package com.example.merel.madlibs;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/*
 * Merel van den Hurk
 * This activity handles the user input for the blanks. Prompts user for
 * a new word according to the placeholders in the text. When all blanks
 * have been filled in, continues to next activity (Result.java)
 */

public class Input extends AppCompatActivity {

    // initialize variables
    Story story;
    EditText inputField;
    TextView remainderCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // get text file and read it
        Context context = getApplicationContext();
        AssetManager am = context.getAssets();
        InputStream stream = null;
        try {
            stream = am.open("madlib2_university.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        story = new Story(stream);

        // initialize input field hint
        inputField = (EditText) findViewById(R.id.inputField);
        inputField.setHint(story.getNextPlaceholder());

        // get number of placeholders and initialize remainder text
        remainderCount = (TextView) findViewById(R.id.remainderCount);
        remainderCount.setText("" + story.getPlaceholderCount());
    }

    public void fillBlank(View view) {
        String userInput = inputField.getText().toString();
        story.fillInPlaceholder(userInput);

        // checks if all placeholders have been filled in yet
        if (story.isFilledIn()) {
            String storyText = story.toString();
            Intent intent = new Intent(Input.this, Result.class);
            intent.putExtra("FINISHED_STORY", storyText);
            startActivity(intent);
        } else {
            inputField.setHint(story.getNextPlaceholder());
            inputField.setText("");
            remainderCount.setText("" + story.getPlaceholderRemainingCount());
        }
    }
}


