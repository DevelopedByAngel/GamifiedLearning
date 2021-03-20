package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.round;

public class Game extends AppCompatActivity {

    Button left,down,up,right;
    ImageView user,target,canvas;
    TextView i;
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
        canvas=(ImageView)findViewById(R.id.canvas) ;
        i=(TextView)findViewById(R.id.i);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;
        final int tx=(round(width/2+width/4)/100)*100;
        final int ty=(round(height/2+height/4)/100)*100;
        Bitmap bg=Bitmap.createBitmap(tx,ty,Bitmap.Config.ARGB_8888);
        final int x=tx/10;
        final int y=ty/10;
        canvas.setBackgroundDrawable(new BitmapDrawable(bg));
        canvas.setImageDrawable(null);
        Canvas c=new Canvas(bg);
        Paint p=new Paint();
        p.setColor(Color.BLACK);

        c.drawLine(x,y,10*x,y,p);
        c.drawLine(0,2*y,3*x,2*y,p);
        c.drawLine(4*x,1*y,4*x,3*y,p);
        c.drawLine(6*x,y,6*x,4*y,p);
        c.drawLine(5*x,2*y,5*x,3*y,p);
        c.drawLine(0,3*y,2*x,3*y,p);
        c.drawLine(200,300,200,500,p);
        c.drawLine(200,500,100,500,p);
        c.drawLine(100,500,100,400,p);
        c.drawLine(300,300,300,600,p);
        c.drawLine(300,400,500,400,p);
        c.drawLine(400,500,500,500,p);
        c.drawLine(500,500,500,700,p);
        c.drawLine(0,600,400,600,p);
        target.setTranslationX(tx);
        target.setTranslationY(ty);
        move();
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getTranslationX()<tx)
                {
                    user.setTranslationX(user.getTranslationX()+x);
                }
                checkWin();

            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getTranslationX()>0)
                {
                    user.setTranslationX(user.getTranslationX()-x);
                }
                checkWin();
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getTranslationY()>0)
                {
                    user.setTranslationY(user.getTranslationY()-y);
                }
                checkWin();
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getTranslationY()<ty)
                {
                    user.setTranslationY(user.getTranslationY()+y);
                }
                checkWin();
            }
        });
    }
    public void checkWin()
    {
        if(user.getTranslationX()>=target.getTranslationX() && user.getTranslationY()>=target.getTranslationY())
        {
            i.setText(i.getText()+"win");
        }
    }
    public void move()
    {

        canvas.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                i.setText(motionEvent.getX()+"_"+motionEvent.getY());
                user.setTranslationX(motionEvent.getX());
                user.setTranslationY(motionEvent.getY());
                checkWin();
                return  true;
            }
        });
    }
}