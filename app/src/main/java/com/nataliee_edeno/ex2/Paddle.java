package com.nataliee_edeno.ex2;


import android.graphics.RectF;

public class Paddle
{

    private float x, y , len, hei;
    private RectF rec;


    public Paddle(float x, float y)
    {
        len = x / 8;
        hei = y / 25;

        rec = new RectF(x/2 -200 ,y -30 ,x/2 +len, y -30 +hei );
       // canvas.drawRect(canvasW/2 - 200,canvasH - 30,canvasW/2 + len  ,canvasH - 30 + hei  ,pen);

    }
    public RectF getRect(){
        return rec;
    }
}
