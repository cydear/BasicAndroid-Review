package com.basic.android;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-14 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class SVGActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);

        findViewById(R.id.image1).setOnClickListener(view -> {
            ((Animatable) ((ImageView) view).getDrawable()).start();
        });

        findViewById(R.id.image2).setOnClickListener(view -> {
            ((Animatable) ((ImageView) view).getDrawable()).start();
        });

        findViewById(R.id.image3).setOnClickListener(view -> {
            ((Animatable) ((ImageView) view).getDrawable()).start();
        });

        findViewById(R.id.image4).setOnClickListener(view -> {
            ((Animatable) ((ImageView) view).getDrawable()).start();
        });
    }
}
