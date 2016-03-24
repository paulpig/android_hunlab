package com.readboy.HandWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.readboy.game.Watched;
import com.readboy.game.Watcher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class DrawView extends View implements Watched
{
	float preX;
	float preY;
	private Path path;
	public Paint paint = null;
	final int VIEW_WIDTH = 1;
	final int VIEW_HEIGHT = 1;
	private  Timer timer; 
	private List<Watcher> list = new ArrayList<Watcher>();  
	public List<Short> points = new ArrayList<Short>();
	// 定义一个内存中的图片，该图片将作为缓冲区
	Bitmap cacheBitmap = null;
	// 定义cacheBitmap上的Canvas对象
	Canvas cacheCanvas = null;
	public DrawView(Context context, AttributeSet set)
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
		paint.setColor(Color.RED);
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
				points.add((short)x);
	    		points.add((short)y);
	    		timer.cancel();
				break;
			case MotionEvent.ACTION_MOVE:
				path.quadTo(preX, preY, x, y);
				preX = x;
				preY = y;
				
				points.add((short)x);
	    		points.add((short)y);
				
				break;
			case MotionEvent.ACTION_UP:
				cacheCanvas.drawPath(path, paint); // ①
				points.add((short) -1);
	    		points.add((short) -1);
	    		
	    		
	    		timer = new Timer();  
	    		timer.schedule(new TimerTask() {
					//int i=10;
					@Override
					public void run() {
						// TODO Auto-generated method stub
//						Log.i("yao",Thread.currentThread().getName()); 
//						Message msg =new Message();
//						msg.what=i--;
//						handler.sendMessage(msg);
						notifyWatcher();
					}
				}, 2000);
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
	
	 final Handler handler = new Handler() {   
		  
         @Override  
         public void handleMessage(Message msg) {   
             super.handleMessage(msg);   
             //handler处理消息   
             if(msg.what>0){   
                // tv1.setText("" + msg.what);   
             }else{   
                 //在handler里可以更改UI组件   
//                 tv1.setText("点火！");   
                 //timer.cancel();   
             }   
         }   
     };

	@Override
	public void add(Watcher watcher) {
		// TODO Auto-generated method stub
		 list.add(watcher); 
	}

	@Override
	public void remove(Watcher watcher) {
		// TODO Auto-generated method stub
		list.remove(watcher);  
	}

	@Override
	public void notifyWatcher() {
		// TODO Auto-generated method stub
		for (Watcher watcher : list) {  
            watcher.updateNotify();  
        }  
	}   
}
