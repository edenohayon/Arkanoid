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

  //  private float ballcx, ballcy,ballcr, len, hei;
    private int canvasW, canvasH, sX,sY;

    //game object
    private Ball ball;
    private Paddle paddle;
    private Brick[] bricks;
    private int numBricks;

    private boolean gameOn = false;

    public GameView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
/*        pen = new Paint();
        pen.setColor(Color.WHITE);
        pen.setStyle(Paint.Style.FILL);
        pen.setStrokeWidth(2);*/
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);


        // bg color
        canvas.drawColor(Color.rgb(255,204,255));

        //draw object game
        ball.draw(canvas);
        paddle.draw(canvas);
        // Draw the bricks if visible
        for(int i = 0; i < numBricks; i++){
            if(bricks[i].getVisibility()) {
                bricks[i].draw(canvas);
            }
        }

        // move/update all object game
        ball.move(canvasW, canvasH);

        // Check for ball colliding with a brick
        for(int i = 0; i < numBricks; i++){

            if (bricks[i].getVisibility())
                ball.checkCollision(bricks[i]);



        }


        invalidate();
    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);

        canvasW = w;
        canvasH = h;

        ball = new Ball(canvasW,canvasH,25);
        paddle = new Paddle(canvasW,canvasH);
        // Up to 200 bricks
        bricks = new Brick[200];
        numBricks = 0;

        int brickWidth = canvasW / 8;
        int brickHeight = canvasH / 10;

        //todo - make numners filnals
        for(int column = 0; column < 8; column ++ ){
            for(int row = 0; row < 5; row ++ ){
                bricks[numBricks] = new Brick(row, column, brickWidth, brickHeight);
                numBricks ++;
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //player touched the screen
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(!gameOn) {
                ball.setDx(-3); // todo - number needs to be random
                ball.setDy(-3);
                gameOn = true;
            }
        }

        return true;
    }
}
