package com.readboy.HandWrite;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DraftView extends View {
	
	float preX;
	float preY;
	private Path path;
	public Paint paint = null;
	final int VIEW_WIDTH = 1;
	final int VIEW_HEIGHT = 1;
	public List<Short> points = new ArrayList<Short>();
	// 定义一个内存中的图片，该图片将作为缓冲区
	Bitmap cacheBitmap = null;
	// 定义cacheBitmap上的Canvas对象
	Canvas cacheCanvas = null;

	public DraftView(Context context, AttributeSet set)
	{
		super(context, set);
		// 创建一个与该View相同大小的缓存区
		cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888);
		cacheCanvas = new Canvas();
		path = new Path();
		// 设置cacheCanvas将会绘制到内存中的cacheBitmap上
		cacheCanvas.setBitmap(cacheBitmap);
		// 设置画笔的颜色
		paint = new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.GRAY);
		// 设置画笔风格
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(1);
		// 反锯齿
		paint.setAntiAlias(true);
		paint.setDither(true);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// 获取拖动事件的发生位置
		float x = event.getX();
		float y = event.getY();
		switch (event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				path.moveTo(x, y);
				preX = x;
				preY = y;
				break;
			case MotionEvent.ACTION_MOVE:
				path.quadTo(preX, preY, x, y);
				preX = x;
				preY = y;
				
				break;
			case MotionEvent.ACTION_UP:
				cacheCanvas.drawPath(path, paint); // ①
				break;
		}
		invalidate();
		// 返回true表明处理方法已经处理该事件
		return true;
	}

	@SuppressLint("DrawAllocation") @Override
	public void onDraw(Canvas canvas)
	{
		Paint bmpPaint = new Paint();
		// 将cacheBitmap绘制到该View组件上
		canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint); // ②
		// 沿着path绘制
		canvas.drawPath(path, paint);
	}
	

	/**
	 * 重置画笔
	 */
	public void reSetPath(){ 
		path.reset();
		points.clear();
	}
	
	
	/*
	 * 橡皮擦功能
	 * */
	
	public void erasePaint(){
		
	}
	
	
	
	public void clearScreen(){
   	 invalidate();
    }
	
	
}
