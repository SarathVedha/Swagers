package com.example.swagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView player,logo;
    private static int splash_screen = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        player = findViewById(R.id.Player);
        logo = findViewById(R.id.Logo);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.screen_top_bottom);
        player.setAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.screen_bottom_top);
        logo.setAnimation(animation1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
                finish();
            }
        },splash_screen);

    }
}