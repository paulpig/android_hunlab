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
	// ����һ���ڴ��е�ͼƬ����ͼƬ����Ϊ������
	Bitmap cacheBitmap = null;
	// ����cacheBitmap�ϵ�Canvas����
	Canvas cacheCanvas = null;

	public DraftView(Context context, AttributeSet set)
	{
		super(context, set);
		// ����һ�����View��ͬ��С�Ļ�����
		cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888);
		cacheCanvas = new Canvas();
		path = new Path();
		// ����cacheCanvas������Ƶ��ڴ��е�cacheBitmap��
		cacheCanvas.setBitmap(cacheBitmap);
		// ���û��ʵ���ɫ
		paint = new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.GRAY);
		// ���û��ʷ��
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(1);
		// �����
		paint.setAntiAlias(true);
		paint.setDither(true);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// ��ȡ�϶��¼��ķ���λ��
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
				cacheCanvas.drawPath(path, paint); // ��
				break;
		}
		invalidate();
		// ����true�����������Ѿ�������¼�
		return true;
	}

	@SuppressLint("DrawAllocation") @Override
	public void onDraw(Canvas canvas)
	{
		Paint bmpPaint = new Paint();
		// ��cacheBitmap���Ƶ���View�����
		canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint); // ��
		// ����path����
		canvas.drawPath(path, paint);
	}
	

	/**
	 * ���û���
	 */
	public void reSetPath(){ 
		path.reset();
		points.clear();
	}
	
	
	/*
	 * ��Ƥ������
	 * */
	
	public void erasePaint(){
		
	}
	
	
	
	public void clearScreen(){
   	 invalidate();
    }
	
	
}
