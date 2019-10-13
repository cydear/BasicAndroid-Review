package com.basic.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_util).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, UtilActivity.class));
        });

        findViewById(R.id.btn_scroller).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ScrollerActivity.class));
        });
    }
}
