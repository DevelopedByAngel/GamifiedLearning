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
        Bitmap bg=Bitmap.createBitmap(720,1080, Bitmap.Config.ARGB_8888);
        final int x=tx/10;
        final int y=ty/10;
        canvas.setBackgroundDrawable(new BitmapDrawable(bg));
        canvas.setImageDrawable(null);
        Canvas c=new Canvas(bg);
        Paint p=new Paint();
        p.setColor(Color.BLACK);
        c.drawLine(100,100,1000,100,p);
        c.drawLine(0,200,300,200,p);
        c.drawLine(400,100,400,300,p);
        c.drawLine(600,100,600,400,p);
        c.drawLine(500,200,500,300,p);
        c.drawLine(0,300,200,300,p);
        c.drawLine(200,300,200,500,p);
        c.drawLine(200,500,100,500,p);
        c.drawLine(100,500,100,400,p);
        c.drawLine(300,300,300,600,p);
        c.drawLine(300,400,500,400,p);
        c.drawLine(400,500,500,500,p);
        c.drawLine(500,500,500,700,p);
        c.drawLine(0,600,400,600,p);
        c.drawLine(200,700,1000,700,p);
        c.drawLine(0,800,500,800,p);
        target.setTranslationX(tx);
        target.setTranslationY(ty);
        move(tx,ty);
    }
    public Boolean pass(float x,float y)
    {
//        float[] pos1={100,0,400,600,500,0,200,200,100,300,300,400,500,0,200,0};
//        float[] pos2={100,200,100,100,200,300,300,500,500,300,400,500,500,600,700,800};
//        float[] pos3={1000,300,400,600,500,200,200,100,100,300,500,500,500,400,1000,500};
//        float[] pos4={100,200,300,400,300,300,500,500,400,600,400,500,700,600,700,800};
        i.setText(round(x/100)*100);
        return true;
    }
    public void checkWin()
    {
        if(user.getTranslationX()>=target.getTranslationX() && user.getTranslationY()>=target.getTranslationY())
        {
            i.setText(i.getText()+"win");
        }
    }
    public void move(final float tx,final float ty)
    {

        canvas.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x=motionEvent.getX();
                float y=motionEvent.getY();
                if(x>=0)
                {
                    user.setTranslationX(motionEvent.getX());
                    checkWin();
                }
                if(y>=0)
                {
                    user.setTranslationY(motionEvent.getY());
                    checkWin();
                }
//                Boolean a=pass(x,y);
                i.setText(user.getTranslationX()+"_"+user.getTranslationY()+"_"+(round(x/100))*100);
                return  true;
            }
        });
    }
}