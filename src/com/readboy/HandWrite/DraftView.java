package com.readboy.HandWrite;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;



public class DraftView extends View 
{
	float preX;
	float preY;
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
	//private Vector<Bitmap> cacheBitmap=new Vector<Bitmap>();
	Canvas cacheCanvas = null;
	boolean is_move=false;
	boolean is_write=true;
	float dx_move=0;
	float dy_move=0;
	float startX=0;
	float startY=0;
	int current_path;
	int screen_width = 0;                //屏幕宽度
	int screen_height = 0;               //屏幕高度
	int current_file_name = 0;           //当前bitmap文件下标
	private Bitmap currentBitmap = null; //当前bitmap
	private int saveThreadNum = 0;		 //记录当前执行的保存文件线程数
	private int max_bitmap_index = 0;
	private int is_detele[]=new int[100];
	final private int LEFT=5;
	final private int RIGHT=6;
	//ArrayList<integer> files_deleted = new ArrayList<integer>();  //保存删除的草稿本下标
	HashSet<Integer> files_deleted = new HashSet<Integer>(); 
	@SuppressWarnings("deprecation")
	public DraftView(Context context, AttributeSet set) throws IOException
	{
		super(context, set);
		
		initData();
	}

	
	/**
	 * 初始化数据，将is_detele初始化
	 */
	private void initData(){
		for(int i=1;i<=100;i++){
			is_detele[i-1]=i;
		}
		is_erase=false;
		current_path=0;
		
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		screen_width = wm.getDefaultDisplay().getWidth();
		screen_height = wm.getDefaultDisplay().getHeight();
		
		Bitmap bitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888);
		//saveBitMap(bitmap, "0");
		
		currentBitmap = bitmap;
		cacheCanvas = new Canvas();
		
		path=new Path();
		path_erase=(new Path());
		
		//画布中设置位图
		cacheCanvas.setBitmap(currentBitmap);
		current_file_name = 0;
		is_clear=false;
		
		
		//橡皮擦的画笔
		clearPaint = new Paint();
		clearPaint.setAntiAlias(true);
		clearPaint.setDither(true);
		clearPaint.setColor(Color.TRANSPARENT);  
		clearPaint.setStyle(Paint.Style.STROKE);
		clearPaint.setStrokeJoin(Paint.Join.ROUND); 
		clearPaint.setStrokeCap(Paint.Cap.ROUND);
		clearPaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
		clearPaint.setStrokeWidth(20.6f);   

		//设置画笔
		paint = new Paint(Paint.DITHER_FLAG);
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(3.0f);
		paint.setAntiAlias(true);
		paint.setDither(true);
	}
	
	
	/* (non-Javadoc)
	 * 点击事件
	 * @see android.view.View#onTouchEvent(android.view.MotionEvent)
	 */
	@SuppressLint("ClickableViewAccessibility") @Override
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

	
	private void touchMove(float upx, float upy)
	{  
		 float dx = Math.abs(downx-upx);  
		 float dy = Math.abs(downy-upy);  
		 if (dx >= 4 || dy >= 4) {
		      path.quadTo(downx, downy, (downx + upx)/2, (downy + upy)/2); 
		      path_erase.quadTo(downx, downy, (downx + upx)/2, (downy + upy)/2); 
		      downx = upx;  
		      downy = upy;  
		 }  
	}  

	/* (non-Javadoc)
	 * 移动画布
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
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
			//canvas.drawBitmap(cacheBitmap.elementAt(current_path), -dx_move, -dy_move, new Paint());
			canvas.drawBitmap(currentBitmap, -dx_move, -dy_move, new Paint());
		}
		else if(is_move==true){
			Log.i("move", "dx_move:"+dx_move+"\ndy_move:"+dy_move);
			canvas.drawBitmap(currentBitmap, -dx_move, -dy_move, new Paint());
		}
	}

	/**
	 * 刷新画笔
	 */
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
	public boolean deleteButton(int leftOrRight){
		
		int temp_current=current_file_name;
		
		files_deleted.add(Integer.valueOf(current_file_name));
		
		if(leftOrRight==LEFT){
			if(leftButton(1)==false){
				files_deleted.remove(Integer.valueOf(temp_current));
				return false;
			}
		}
		else if(leftOrRight==RIGHT){
			if(rightButton(1)==false){
				files_deleted.remove(Integer.valueOf(temp_current));
				return false;
			}
		}
		return true;
	}
	
	

	/**
	 * left按钮功能
	 * @param step
	 * @return 
	 */
	public boolean leftButton(int step){
		
		int temp=0;
		//前向遍历找到最近的一个没有被删除的bitmap
		for (int i = current_file_name-1; i >=0; i--) {
			if(!files_deleted.contains(Integer.valueOf(i))){
				temp++;
				if(temp==step){
					current_file_name=i;
					break;
				}
			}
		}
		
		Log.i("mentalwubingchao", "find index leftbutton is ok");
		
		
		is_write=true;
		rePostion();
		
		
		try {
			GetOrBuildFromSD(current_file_name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		invalidate();
		
		return true;
		
		
	}
	
	
	/**
	 * 创建或者得到图片
	 * @throws IOException 
	 */
	public void GetOrBuildFromSD(int current_name) throws IOException{
		
		Bitmap bitmap = getBitMapWithName(String.valueOf(current_name));
		currentBitmap = bitmap;
		cacheCanvas.setBitmap(currentBitmap);
		
	}
	
	
	/**
	 * 保存图片到本地的线程
	 */
	public void  savaThread(){
		if(saveThreadNum>0)
			return;
		
		final int temp_index = current_file_name;
		final Bitmap tempmap = currentBitmap;
		
		//增加线程计数,保存图片
		saveThreadNum++;
		Thread thread=new Thread(new Runnable()  
	    {  
	        @Override  
	        public void run()
	        {
	            try {
					saveBitMap(tempmap, String.valueOf(temp_index));
					tempmap.recycle();
					saveThreadNum--;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//currentBitmap.recycle(); 
	        }  
	    });  
	    thread.start();
	}
	
	
	
	

	/**
	 * right按钮功能
	 */
	public boolean rightButton(int temp_right){
		
		//前后遍历找到最近的一个没有被删除的bitmap
		int temp = 0;
		for (int i = current_file_name+1; i <=max_bitmap_index ; i++) {
			if(!files_deleted.contains(Integer.valueOf(i))){
				temp++;
				if(temp==temp_right){
					current_file_name=i;
					break;
				}
			}
		}
		
		is_write=true;
		rePostion();
		
		try {
			GetOrBuildFromSD(current_file_name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.i("mentalwubingchao", "find index rightbutton is ok");
		
		invalidate();
		return true;
	}
	
	
	//添加按钮
	public boolean addButton(int temp_add) throws IOException{ 
		//增加草稿本之后增加草稿本计数
		max_bitmap_index+=temp_add;
		current_file_name = max_bitmap_index;
		
		try {
			GetOrBuildFromSD(current_file_name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		is_write=true;
		rePostion();
		
		
		invalidate();
		return true;
	}
	
	public void rePostion(){
		startX=0;
		startY=0;
		dx_move=0;
		dy_move=0;
	}
	
	 /** 
     * 保存文件 
     * @param bm 
     * @param fileName 
     * @throws IOException 
     */  
    public void saveBitMap(Bitmap bm, String fileName) throws IOException { 
    	String path = Environment.getExternalStorageDirectory().getPath() +"/BitMapCacheFiles/";     
        Log.i("filePath:", path);
    	File dirFile = new File(path);  
       	if(!dirFile.exists()){ 
            dirFile.mkdir();  
        }  
        File myCaptureFile = new File(path + fileName);  
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));  
        bm.compress(Bitmap.CompressFormat.PNG, 100, bos); 
        //bm.recycle();
        bos.flush();  
        bos.close();  
    }
    
    /**
     * 根据文件名字获取文件,不存在文件则创建文件
     * @param fileName
     * @return
     * @throws IOException
     */
    public Bitmap getBitMapWithName(String fileName) throws IOException{
    	String path = Environment.getExternalStorageDirectory().getPath() +"/BitMapCacheFiles/"+fileName;
    	
    	File file = new File(path);
    	Bitmap bitmap = null;
    	
    	if(file.exists()){
    		bitmap=BitmapFactory.decodeFile(path);
    		Log.i("mentalwubingchao", "file is exit!");
    	}
    	else{
    		bitmap=Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,Config.ARGB_8888);  
    		Log.i("mentalwubingchao", "file is not exit!");
    	}
    	
    	//复制bitmap以设置可修改属性
    	Bitmap bmp2 = bitmap.copy(bitmap.getConfig(), true);
		bitmap.recycle();
		return bmp2;
    }
    
    
    public void clearCurrentBitMap(){
    	currentBitmap.recycle();
    }
}
