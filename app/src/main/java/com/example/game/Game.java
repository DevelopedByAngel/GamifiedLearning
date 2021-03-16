package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Game extends AppCompatActivity {

    Button left,down,up,right;
    ImageView user;
    float x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        left=(Button)findViewById(R.id.left);
        down=(Button)findViewById(R.id.down);
        up=(Button)findViewById(R.id.up);
        right=(Button)findViewById(R.id.right);
        user=(ImageView)findViewById(R.id.user);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x=user.getTranslationX();
                if(x<=0)
                {
                    user.setTranslationX(x-50);
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x=user.getTranslationX();
                if(x>=350)
                {
                    user.setTranslationX(x+50);
                }
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y=user.getTranslationY();
                if(y<=0)
                {
                    user.setTranslationY(y-50);
                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y=user.getTranslationY();
                if(y>=600)
                {
                    user.setTranslationY(y+50);
                }
            }
        });
    }
}