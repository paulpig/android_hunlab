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
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class DraftView extends View 
{
	float preX;
	float preY;
	private Path path;
	private Path path_erase;
	public Paint paint = null;
	public Paint clearPaint=null;
	final int VIEW_WIDTH = 1;
	final int VIEW_HEIGHT = 1;
	private  Timer timer; 
	private boolean is_erase;
	float[] pointPrev; 
    float[] pointStop;
	private List<Watcher> list = new ArrayList<Watcher>();  
	// 瀹氫箟涓�涓唴瀛樹腑鐨勫浘鐗囷紝璇ュ浘鐗囧皢浣滀负缂撳啿鍖�
	Bitmap cacheBitmap = null;
	// 瀹氫箟cacheBitmap涓婄殑Canvas瀵硅薄
	Canvas cacheCanvas = null;
	public DraftView(Context context, AttributeSet set)
	{
		super(context, set);
		// 鍒涘缓涓�涓笌璇iew鐩稿悓澶у皬鐨勭紦瀛樺尯
		is_erase=false;
		cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888);
		cacheCanvas = new Canvas();
		path = new Path();
		path_erase= new Path();
		// 璁剧疆cacheCanvas灏嗕細缁樺埗鍒板唴瀛樹腑鐨刢acheBitmap涓�
		cacheCanvas.setBitmap(cacheBitmap);
		
		clearPaint = new Paint();
		clearPaint.reset();  
		clearPaint.setColor(Color.TRANSPARENT);  
		clearPaint.setAntiAlias(false);  
		clearPaint.setStyle(Paint.Style.STROKE);  
        clearPaint.setStrokeWidth(16);  
        clearPaint.setStrokeJoin(Paint.Join.ROUND);  
        clearPaint.setStrokeCap(Paint.Cap.ROUND);  
        clearPaint.setAlpha(0);     
        clearPaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));  
        clearPaint.setStrokeWidth(10);  
		
		
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
				if(is_erase==false){
					path.moveTo(x, y);
					preX = x;
					preY = y;
				}
				else{
					path_erase.moveTo(x, y);
					preX = x;
					preY = y;
				}
				break;
			case MotionEvent.ACTION_MOVE:
				if(is_erase==false){
					path.quadTo(preX, preY, x, y);
					preX = x;
					preY = y;
				}
				else{
					pointPrev = new float[]{preX,preY};  
				    pointStop= new float[]{event.getX(), event.getY()}; 
					path_erase.quadTo(preX, preY, x, y);
					preX = x;
					preY = y;
					//prev.set(event.getX(), event.getY());   
                    
                    //ImageTouchView.this.setImageBitmap(cacheBitmap);
				}
				break;
			case MotionEvent.ACTION_UP:
				if(is_erase==false)
					cacheCanvas.drawPath(path, paint); // 鈶�
				else
					cacheCanvas.drawPath(path_erase, clearPaint);
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
		//if(is_erase==false)
			canvas.drawPath(path, paint);
	///	else{
			cacheCanvas.drawLine(pointPrev[0],pointPrev[1],pointStop[0],pointStop[1], clearPaint);  
			//canvas.drawPath(path_erase, clearPaint);
		//}
	}
	

	/**
	 * 閲嶇疆鐢荤瑪
	 */
	public void reSetPath(){ 
		Log.i("e","reSetPath");
		path_erase.reset();
		path.reset();
		invalidate();
	}
	
	public void erase(){
		is_erase=true;
	}
}
