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
	// 瀹氫箟涓�涓唴瀛樹腑鐨勫浘鐗囷紝璇ュ浘鐗囧皢浣滀负缂撳啿鍖�
	Bitmap cacheBitmap = null;
	// 瀹氫箟cacheBitmap涓婄殑Canvas瀵硅薄
	Canvas cacheCanvas = null;
	public DrawView(Context context, AttributeSet set)
	{
		super(context, set);
		// 鍒涘缓涓�涓笌璇iew鐩稿悓澶у皬鐨勭紦瀛樺尯
		cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888);
		cacheCanvas = new Canvas();
		path = new Path();
		// 璁剧疆cacheCanvas灏嗕細缁樺埗鍒板唴瀛樹腑鐨刢acheBitmap涓�
		cacheCanvas.setBitmap(cacheBitmap);
		// 璁剧疆鐢荤瑪鐨勯鑹�
		paint = new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.RED);
		// 璁剧疆鐢荤瑪椋庢牸
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(1);
		// 鍙嶉敮榻�
		paint.setAntiAlias(true);
		paint.setDither(true);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// 鑾峰彇鎷栧姩浜嬩欢鐨勫彂鐢熶綅缃�
		
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
	    		if(timer!=null)
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
				cacheCanvas.drawPath(path, paint); // 鈶�
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
		// 杩斿洖true琛ㄦ槑澶勭悊鏂规硶宸茬粡澶勭悊璇ヤ簨浠�
		return true;
	}

	@SuppressLint("DrawAllocation") @Override
	public void onDraw(Canvas canvas)
	{
		Paint bmpPaint = new Paint();
		// 灏哻acheBitmap缁樺埗鍒拌View缁勪欢涓�
		canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint); // 鈶�
		// 娌跨潃path缁樺埗
		canvas.drawPath(path, paint);
	}
	

	/**
	 * 閲嶇疆鐢荤瑪
	 */
	public void reSetPath(){ 
		path.reset();
		points.clear();
	}
	
	 final Handler handler = new Handler() {   
		  
         @Override  
         public void handleMessage(Message msg) {   
             super.handleMessage(msg);   
             //handler澶勭悊娑堟伅   
             if(msg.what>0){   
                // tv1.setText("" + msg.what);   
             }else{   
                 //鍦╤andler閲屽彲浠ユ洿鏀筓I缁勪欢   
//                 tv1.setText("鐐圭伀锛�");   
                 //timer.cancel();   
             }   
         }   
     };
     public void clearScreen(){
    	 invalidate();
     }
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
