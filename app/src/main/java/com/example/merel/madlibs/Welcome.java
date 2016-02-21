package com.example.merel.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
 * Merel van den Hurk
 * This activity serves only as a welcome screen where the button starts the next activity (Input.java)
 */

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
    
    public void startApp(View view) {
        Intent intent = new Intent(Welcome.this, Input.class);
        startActivity(intent);
    }
}
