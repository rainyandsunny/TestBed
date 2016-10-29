package com.swjtu.deanstar.testbed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.swjtu.deanstar.testbed.util.ScreenUtil;

/**
 * Created by yhp5210 on 2016/10/29.
 */

public class CanvasView extends View {


    private Paint mPaint;
    private Context mContext;
    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mContext = context;
    }
    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {


        //位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动，如下
      /*  mPaint.setColor(Color.BLACK);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,100,mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,100,mPaint);*/
        //将坐标系移动一段距离绘制一个圆形，之后再移动一段距离绘制一个圆形，两次移动是可叠加的

        Point sizePoint = ScreenUtil.getScreenSize(mContext);
        int width = sizePoint.x;
        int height = sizePoint.y;

        canvas.translate(width/2,height/2);
        RectF rect = new RectF(0,-400,400,0);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rect,mPaint);
        canvas.scale(0.5f,0.5f);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect,mPaint);
        super.onDraw(canvas);
    }
}
