package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Math.round;

public class Game extends AppCompatActivity {

    Button left,down,up,right;
    ImageView user,target;
    float x,y;
    float tx,ty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        left=(Button)findViewById(R.id.left);
        down=(Button)findViewById(R.id.down);
        up=(Button)findViewById(R.id.up);
        right=(Button)findViewById(R.id.right);
        user=(ImageView)findViewById(R.id.user);
        target=(ImageView)findViewById(R.id.target);
        TextView i=(TextView)findViewById(R.id.i);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;
        final int tx=(round(width/2+width/4)/100)*100;
        final int ty=(round(height/2+height/4)/100)*100;
        target.setTranslationX(tx);
        target.setTranslationY(ty);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getTranslationX()<=tx)
                {
                    user.setTranslationX(user.getTranslationX()+100);
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getTranslationX()>=0)
                {
                    user.setTranslationX(user.getTranslationX()-100);
                }
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getTranslationY()<=0)
                {
                    user.setTranslationX(user.getTranslationY()-100);
                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getTranslationY()<=ty)
                {
                    user.setTranslationX(user.getTranslationY()+100);
                }
            }
        });
    }
}