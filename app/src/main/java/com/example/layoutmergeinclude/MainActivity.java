package com.example.layoutmergeinclude;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.two_buttons);
        View view1 = findViewById(R.id.text_views);
        Log.d(TAG, "two_buttons: " + view);
        Log.d(TAG, "text_views: " + view1);
    }
}
