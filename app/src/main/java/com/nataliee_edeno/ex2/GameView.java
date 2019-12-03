package com.nataliee_edeno.ex2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;


public class GameView extends View {

    private Paint pen;
    private float ballcx, ballcy,ballcr, len, hei;
    private int canvasW, canvasH, sX,sY;
    private Ball ball;
    public Paddle padd;

    public GameView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        pen = new Paint();
        pen.setColor(Color.WHITE);
        pen.setStyle(Paint.Style.FILL);
        pen.setStrokeWidth(2);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);


        // bg color
        canvas.drawColor(Color.rgb(255,204,255));

////        Log.d("debug size x", String.valueOf(j));
////        Log.d("debug size y", String.valueOf(f));
//        Log.d("debug canvasW", String.valueOf(canvasW));
//        Log.d("debug canvasH", String.valueOf(canvasH));
//        Log.d("debug ballcx", String.valueOf(ballcx));
//      Log.d("debug ballcy", String.valueOf(ballcy));

        //ball
//        ball = new Ball(canvasW,canvasH);
//        canvas.drawRect(ball.getRect(),pen);

        canvas.drawCircle(ballcx,canvasH-50,20,pen);
//draw rectangle
        padd = new Paddle(canvasW,canvasH);
        canvas.drawRect(padd.getRect(), pen);

        if(ballcx + 100 < canvasW)
        {
            ballcx += 5;
            ballcy -= 2;
        }
//        else
//        {
//            ballcx = canvasW / 2;
//        }
//        else if(ballcy +100 < canvasH)
//        {
//            ballcx -= 100;
//            ballcy += 20;
//        }




        invalidate();
    }

    public void moveBall()
    {
        Random rnd = new Random();
        ballcx = (float)rnd.nextInt(canvasW);
        ballcy = (float)rnd.nextInt(canvasH);
        invalidate(); // call onDraw()
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);

        canvasW = w;
        canvasH = h;

        ballcx = canvasW / 2;
        ballcy = canvasH / 2;
    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event)
//    {
//        ballcx = event.getX();
//        ballcy = event.getY();
//        return true;
//    }
}
