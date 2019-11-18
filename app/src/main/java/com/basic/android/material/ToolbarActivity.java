package com.basic.android.material;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.basic.android.R;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-11-18 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class ToolbarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Title主标题");
        toolbar.setSubtitle("subtitle子标题");
        toolbar.setLogo(R.drawable.drawable_icon);
        setSupportActionBar(toolbar);
    }
}
