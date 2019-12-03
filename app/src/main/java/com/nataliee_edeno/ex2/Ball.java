package com.nataliee_edeno.ex2;

import android.graphics.Color;
import android.graphics.RectF;

public class Ball
{
    private float x, y;
    private RectF rec;

    public Ball (float x, float y)
    {
        this.x = x /100;
        this.y = this.x;


        rec = new RectF();

    }

    public RectF getRect(){
        return rec;
    }

}
