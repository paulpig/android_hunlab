package com.readboy.HandWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

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
	//private Path path;
	//private Path path_erase;
	private Path path;
	private Path path_erase;
	public Paint paint = null;
	public Paint clearPaint=null;
	final int VIEW_WIDTH = 2000;
	final int VIEW_HEIGHT = 1200;
	private boolean is_erase;
	float[] pointPrev; 
    float[] pointStop;
    private boolean is_clear;
    private float downx = 0,downy = 0;  
    Random rand = new Random();
	//Bitmap cacheBitmap = null;
	//Bitmap pureBitmp=null;
	private Vector<Bitmap> cacheBitmap=new Vector<Bitmap>();
	Canvas cacheCanvas = null;
	boolean is_move=false;
	boolean is_write=true;
	float dx_move=0;
	float dy_move=0;
	float startX=0;
	float startY=0;
	int current_path;
	public DraftView(Context context, AttributeSet set)
	{
		super(context, set);
		is_erase=false;
		current_path=0;
		cacheBitmap.addElement(Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888));
		//pureBitmp = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
		//		Config.ARGB_8888);
		cacheCanvas = new Canvas();
		
		path=new Path();
		path_erase=(new Path());
		cacheCanvas.setBitmap(cacheBitmap.elementAt(current_path));
		//cacheCanvas.drawBitmap(pureBitmp, 0, 0, null);  
		is_clear=false;
		
		
		
		clearPaint = new Paint();  
		//clearPaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));  
		clearPaint.setAntiAlias(true);   
		clearPaint.setDither(true);  
		//clearPaint.setColor(Color.BLUE);
		clearPaint.setColor(Color.TRANSPARENT);  
		clearPaint.setStyle(Paint.Style.STROKE);    
		clearPaint.setStrokeJoin(Paint.Join.ROUND);    
		clearPaint.setStrokeCap(Paint.Cap.ROUND);
		clearPaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));  
		clearPaint.setStrokeWidth(20.6f);   

		
		paint = new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(1);
		paint.setAntiAlias(true);
		paint.setDither(true);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		
		 int action = event.getAction();  
		         switch (action) {  
		         case MotionEvent.ACTION_DOWN:  
		           downx = event.getX()+startX;  
		           downy = event.getY()+startY;  
		           path.moveTo(downx, downy);  
		           path_erase.moveTo(downx, downy);
		           break;  
		         case MotionEvent.ACTION_MOVE:  
		           float upx = event.getX()+startX;  
		           float upy = event.getY()+startY; 
		           if(is_move==true){
		        	   dx_move=downx-upx+startX;
		        	   dy_move=downy-upy+startY;
		           }
			       if(is_move==false)
			    	   touchMove(upx, upy); 
		           chooseWhichAction();
		           invalidate();  
		           break;  
		         case MotionEvent.ACTION_UP:  
		        	 chooseWhichAction();
		        	 if(is_move==true){
		        		 startX=dx_move;
		        		 startY=dy_move;
		        	 }
		           path.reset();  
		           invalidate();  
		           break;  
		         case MotionEvent.ACTION_CANCEL:  
		           break;  
		         default:  
		           break;  
		         }  
		        return true;  
	}

	
	private void touchMove(float upx, float upy){  
		        float dx = Math.abs(downx-upx);  
		        float dy = Math.abs(downy-upy);  
		          if (dx >= 4 || dy >= 4) {  
		            path.quadTo(downx, downy, (downx + upx)/2, (downy + upy)/2); 
		            path_erase.quadTo(downx, downy, (downx + upx)/2, (downy + upy)/2); 
		            downx = upx;  
		            downy = upy;  
		         }  
		    }  

	
	
	@SuppressLint("DrawAllocation") @Override
	public void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);  
		if(is_clear==true){
			canvas.drawPath(path, new Paint());
			cacheCanvas.drawColor(Color.TRANSPARENT, Mode.CLEAR); 
			startX=0;
			startY=0;
			dx_move=0;
			dy_move=0;
			is_clear=false;
		}
		else if(is_move==false){
			canvas.drawBitmap(cacheBitmap.elementAt(current_path), -dx_move, -dy_move, new Paint());
		}
		else if(is_move==true){
			canvas.drawBitmap(cacheBitmap.elementAt(current_path), -dx_move, -dy_move, new Paint());
		}
	}

	public void reSetPath(){ 
		Log.i("e","reSetPath");
		path_erase.reset();
		path.reset();
		is_clear=true;
		//cacheCanvas.drawPath(path, paint);
		invalidate();
	}
	
	public void chooseWhichAction(){
		if(is_erase==true){
			 cacheCanvas.drawPath(path_erase, clearPaint);  
		}
		if(is_write==true){
			 cacheCanvas.drawPath(path, paint);  
		}
	}
	
	//擦除按钮功能
	public void erase(){
		is_erase=true;
		is_write=false;
		is_move=false;
		path_erase.reset();
		
	}
	
	//写按钮功能
	public void write(){
		is_erase=false;
		is_write=true;
		is_move=false;
	}
	
	//移动按钮功能
	public void move(){
		is_move=true;
		is_write=false;
		is_erase=false;
	}
	//删除按钮功能
	public void deleteButton(int num){
		cacheBitmap.removeElementAt(num);
		current_path=0;
		is_write=true;
		rePostion();
		cacheCanvas.setBitmap(cacheBitmap.elementAt(current_path));
		invalidate();
	}
	
	//left按钮功能
	public void leftButton(int num){
		current_path=num;
		is_write=true;
		rePostion();
		cacheCanvas.setBitmap(cacheBitmap.elementAt(current_path));
		invalidate();
	}
	//right按钮功能
	public void rightButton(int num){
		current_path=num;
		is_write=true;
		rePostion();
		cacheCanvas.setBitmap(cacheBitmap.elementAt(current_path));
		invalidate();
	}
	
	//添加按钮
	public void addButton(int num){
		cacheBitmap.addElement(Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888));
		current_path=num;
		is_write=true;
		rePostion();
		cacheCanvas.setBitmap(cacheBitmap.elementAt(current_path));
		invalidate();
	}
	
	public void rePostion(){
		startX=0;
		startY=0;
		dx_move=0;
		dy_move=0;
	}
}
