package com.basic.android;

import android.content.Intent;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.basic.android.material.CollapsingToolbarActivity;
import com.basic.android.material.CoordinatorActivity;
import com.basic.android.material.CoordinatorLayoutActivity;
import com.basic.android.material.ToolbarActivity;

import java.util.List;

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

        findViewById(R.id.btn_surfaceview).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, SurfaceViewActivity.class));
        });

        findViewById(R.id.btn_svg).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, SVGActivity.class));
        });

        findViewById(R.id.btn_pulldown).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, PullDownAnimationActivity.class));
        });

        findViewById(R.id.btn_coordinator).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, CoordinatorActivity.class));
        });

        findViewById(R.id.btn_toolbar).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ToolbarActivity.class));
        });

        findViewById(R.id.btn_coordianator_layout).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));
        });

        findViewById(R.id.btn_collapsing_toolbar_layout).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, CollapsingToolbarActivity.class));
        });
    }
}
