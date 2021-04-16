package com.example.swagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    CardView TopCard,LeftCard,RightCard,BottomCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TopCard = findViewById(R.id.TopCard);
        RightCard = findViewById(R.id.RightCrad);
        LeftCard = findViewById(R.id.LeftCard);
        BottomCard = findViewById(R.id.BottomCard);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.top_bottom);
        TopCard.setAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.left_right);
        LeftCard.setAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.right_left);
        RightCard.setAnimation(animation2);

        Animation animation3 = AnimationUtils.loadAnimation(this,R.anim.bottom_top);
        BottomCard.setAnimation(animation3);

        TopCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,gpay.class);
                startActivity(intent);
            }
        });

    }
}