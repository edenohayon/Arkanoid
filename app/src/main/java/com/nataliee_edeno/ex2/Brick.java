package com.nataliee_edeno.ex2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.graphics.RectF;


public class Brick {

    private RectF rect;

    private boolean isVisible;

    public Brick(int row, int column, int width, int height){

        isVisible = true;

        int padding = 1;

        rect = new RectF(column * width + padding,
                row * height + padding,
                column * width + width - padding,
                row * height + height - padding);
    }

    public RectF getRect(){
        return this.rect;
    }

    public void setInvisible(){
        isVisible = false;
    }

    public boolean getVisibility(){
        return isVisible;
    }
    public void draw(Canvas canvas)
    {
        Paint rectPen = new Paint();
        rectPen.setStyle(Paint.Style.STROKE);
        rectPen.setStrokeWidth(5);
        rectPen.setColor(Color.YELLOW);

        if(getVisibility()) {
                canvas.drawRect(rect, rectPen);
            }

    }


}
