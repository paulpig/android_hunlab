package com.readboy.game;

import java.util.ArrayList;
import java.util.List;

import com.readboy.game.Grade_1.Grade_1_down;
import com.readboy.mentalcalculation.MainActivity;
import com.readboy.mentalcalculation.R;
import com.readboy.HandWrite.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public  abstract class GameActivity  extends Activity{
	final protected int STARTNUM=61;
	protected ImageView back_bt;
	protected TextView type_view;
	protected TextView time_of_game;
	protected TextView content_of_game;
	protected TextView number_of_game;
	protected String problem;
	protected int answer;
	protected boolean is_quit=false;
	protected String intent_type;
	protected String answer_float;
	protected boolean is_float=false;
	protected Button sure;
	protected DrawView dv;      //手写板
	protected EditText answer_of_game;
	protected TextView grade_of_game;
	protected int student_grade;
	protected int student_office=1;    //游戏的关数
	protected ArrayList<Integer> keep_grade;
	protected Object Alock;
	protected int type;  //题目类型
	protected int count_time=0;  //每题的时间
	protected CountDownThread count_down_thread;
	protected boolean stopThread=false;
	protected ImageView draft;
	protected ImageView ranking;
	protected DraftView draft_view;
	protected RelativeLayout liner;
	protected static final int COMPLETED = 0;
	//protected AnimationDrawable animation;
	costomAnimation costom_animation;
	protected ImageView mImageViewFilling = null;
	protected Boolean correct;
	protected int time_temp;
	protected int[]grade_all=new int[3];
	boolean is_show;
	protected boolean is_first_in_game=false;
	protected enterDialog enter_dialog;
	finishDialog finish_dialog;
	protected boolean is_over=true;
	public int time; //倒计时当前的时间
	private boolean isUpNotTouchUpdateNotify=false;
	boolean isScreenOn=true;//判断屏幕亮暗
	private PlaySound playSound;
	int successOrFail=-1;
	final int SUCCESS=100;
	final int FAIL=101;
	private int durationTime;
	private int stayAnimationSuccessTime;
	private int stayAnimationFailTime;
	private List<Integer> resourceIdListSuccess=new ArrayList<Integer>();//存放成功图片id的list
	private List<Integer> resourceIdListFail=new ArrayList<Integer>();//存放失败图片id的list
	final protected int []drawOfGame={10,20,30,400,500,600,700,800,900,1000};
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.game_view);
        findView();
        initView();
        CountTimeThread();
        IsRecoverFromLastActivity(savedInstanceState);
        Log.i("mentalcalculation", "game_activity_onCreative");
    }
	/**
	 * 异常情况下，activity被销毁的时候调用。
	 */
	protected void onSaveInstanceState(Bundle savedInstanceState) {     
	      Log.d("HELLO", "HELLO：当Activity被销毁的时候，不是用户主动按back销毁，例如按了home键");  
	      super.onSaveInstanceState(savedInstanceState);    
	      savedInstanceState.putBoolean("is_over",false ); //这里保存一个用户名  
	      Log.i("mentalcalculation", "game_activity_onSaveInstanceState");
	    }   

	protected void onPause(){
		    super.onPause();
		    //freeAnimationDrawable(animation);
		    /*将结果反馈给上一个界面*/
		    Intent intent=new Intent();
	        intent.putExtra("Type",type);
	        setResult(RESULT_OK,intent);
	        
	        /*将所得的成绩保存到SD卡中*/
	        readFile();
		    updateGradeContent();
		    updateGrade(grade_all[0],grade_all[1]);
		    
		    
		    //判断是否锁屏，锁屏停止定时器
		    PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
		    isScreenOn = pm.isScreenOn();//如果为true，则表示屏幕“亮”了，否则屏幕“暗”了。
		    if(isScreenOn==false){
		    	is_over=false;
		    }
        	is_over=true;
        	
        	time_temp=time;
        	count_down_thread.setStop(true, time_temp);
	        Log.i("mentalcalculation", "game_activity_onPause");
	}
	
	public void onResume() {
	    super.onResume(); 
	    if(is_first_in_game==false){
	    	/*从草稿本和排行榜中返回执行的函数，将时间设置为之前保存的值*/
	    	count_down_thread.setStop(false, 0);
		    count_down_thread.setStartTime(time_temp);
		    Log.i("mentalcalculation", "game_activity_onResume_Not_first");
	    }
	    else{
	    	/*第一次进入游戏中，设置时间*/
	    	count_down_thread.setStartTime(STARTNUM);
	    	is_first_in_game=false;
	    	Log.i("mentalcalculation", "game_activity_onResume_first");
	    }
	    Log.i("mentalcalculation", "game_activity_onResume");
	    
	    //当isUpNotTouchUpdateNotify为true说明
	    if(isUpNotTouchUpdateNotify==true){
	    	//isScreenOn=true;
	    	updateNotify();
	    	isUpNotTouchUpdateNotify=false;
	    }
	}
	
	protected void onDestroy() {
	 	 Log.i("mentalcalculation", "game_activity_onDestory");
        //更新文件中数据
         is_first_in_game=true;
         is_quit=true;
	     stopThread=true;
	     count_down_thread.setTag(stopThread);
	     count_down_thread.setStartTime(1);
        super.onDestroy();
	    }; 
	    
	    
	/**判断是否需要从上一个状态恢复
	 * @param savedInstanceState
	 */
	protected void IsRecoverFromLastActivity(Bundle savedInstanceState){    
		//状态 判断  ,从之前状态获得是否需要恢复
        boolean lastActivityIsNotExist=true;
        if (savedInstanceState != null) {  
            Log.d("mentalcalculation", "HELLO：应用进程被回收后，状态恢复");  
            lastActivityIsNotExist = savedInstanceState.getBoolean("is_over");  
        }  
        if(lastActivityIsNotExist==true){
        	showEnterDialog();
        }
        else{
        	/*z再次异常进入的时候，销毁这个界面，并且返回到从开始界面*/
        	//this.getParent().finish();
//            Intent intent = new Intent();  
//            intent.setClass(GameActivity.this, MainActivity.class);
//            startActivity(intent);
//            this.finish();
        }
	}
	
	
	/**获取到当前进程是否在后台运行
	 * @param context
	 * @return true代表在后台运行，false表示前台运行
	 */
	public boolean isApplicationBroughtToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> tasks = am.getRunningTasks(1);     
        for (ActivityManager.RunningTaskInfo amTask : tasks) 
        { 
        	ComponentName topActivity =amTask.topActivity;
        	if (!topActivity.getPackageName().equals(context.getPackageName())) {
        		return true;
          	}
        } 

        return false;
    }
	/**
	 * 初始化界面
	 */
	protected void initView(){
		//从上一个界面中获取activity的标题
		Intent intent =getIntent();
		String content = intent.getStringExtra("content");
		type=intent.getIntExtra("type",-1);
		type_view.setText(content);
		student_grade=0;
		
		playSound=new PlaySound(this);
		Alock=new Object();
	    backToStartView();
        draftButton();
        addResource();
	}
	
	
	/**
	 * 获取界面
	 */
	protected void findView(){
		back_bt=(ImageView)findViewById(R.id.back_bt);
		type_view=(TextView) findViewById(R.id.type_view);
		time_of_game=(TextView) findViewById(R.id.time_of_game);
		content_of_game=(TextView) findViewById(R.id.content_of_game);
		number_of_game=(TextView) findViewById(R.id.number_of_game);
		//answer_of_game=(EditText) findViewById(R.id.answer_of_game);
		grade_of_game=(TextView) findViewById(R.id.grade_of_game);
		draft=(ImageView) findViewById(R.id.draft);
		ranking=(ImageView) findViewById(R.id.ranking);
		//draft_view=(DraftView) findViewById(R.id.draft_layout);
		liner=(RelativeLayout) findViewById(R.id.relative);
		dv = (DrawView) findViewById(R.id.draw);
		dv.paint.setColor(Color.RED);
		dv.paint.setStrokeWidth(5);
		
		time_of_game.setText(STARTNUM-1+"");
	}
	
	
	/**
	 * 返回键响应事件
	 */
	protected void backToStartView(){
		 back_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 stopThread=true;
		         count_down_thread.setTag(stopThread);
		         /*上个页面回传数据*/
				GameActivity.this.finish();
			}
	 });
	}
	
	
	 /**
	 * 跳转到草稿本界面
	 */
	protected void draftButton(){
		 draft.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					if(time!=0){
						//time_of_game.setText(time+"");
					 is_over=false;
					 Intent intent = new Intent();  
		             intent.setClass(GameActivity.this, draftActivity.class);  
		             startActivity(intent);   
					}
				}
			});
	 }
	
	
	/**
	 * 时间计时线程
	 */
	@SuppressLint("HandlerLeak") 
	protected void CountTimeThread(){
		 Handler time_hander=new Handler(){
			 public void handleMessage(Message msg) {
				Bundle b = msg.getData();
				time = b.getInt("time");
				time_of_game.setText(time+"");
				if(time==0){
					if(is_quit==false)
						showFinishDialog();
						
					grade_of_game.setText("0");
					student_grade=0;
				}
	         }
		};
		 count_down_thread=new CountDownThread(count_time,time_hander);
		 new Thread(count_down_thread).start();
	 }
	
	
	/**
	 * 从 “出题”（supply_project_thread）线程中获取题目
	 * @param type 
	 */
	protected   abstract void GetProAndAns( int type);
	 
	
	
	 
	/**
	 * 判断是否要进行答案的判断，若在屏幕暗的时候，不判断，亮则判断
	 */
	@SuppressWarnings("deprecation")
	public void updateNotify() {
		PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
	    isScreenOn = pm.isScreenOn();//如果为true，则表示屏幕“亮”了，否则屏幕“暗”了。
	    boolean isInBackground=isApplicationBroughtToBackground(this);
		if(isScreenOn==true && isInBackground==false){
			WorkThread thread = null;//判断答案的线程
			thread=new WorkThread(); 
			thread.start();
			Log.i("mentalcalculation", "game_activity_workthread_start");
		}
		else{
			isUpNotTouchUpdateNotify=true;
			Log.i("mentalcalculation", "game_activity_workThread_not_start");
		}
		
	}
	/**
	 * 定时接收后返回处理
	 * @author nuanbing
	 */
	public class WorkThread extends Thread {  
        @Override  
        public void run() {  
            //......处理比较耗时的操作  
              
            //处理完成后给handler发送消息  
            Message msg = new Message();  
            msg.what = COMPLETED;  
            handler.sendMessage(msg);  
        }  
        
	}
	
	/**
	 * 接受worthread反馈的数据，用来判断答案
	 */
	private Handler handler = new Handler() {  
        @Override  
        public void handleMessage(Message msg) {  
            if (msg.what == COMPLETED) {  
        		int count = dv.points.size();
        		short[] prolong = new short[count];
        		for (int i = 0; i < prolong.length; i++) {
        			prolong[i] = dv.points.get(i);
        		}
        		dv.reSetPath();
        		try {
        			judgeHandPut("8", count/2 -1, prolong);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            }  
        }  
    };  
    
    /**
     * 判断该手写的字是否正确，正确播放正确动画，错误播放错误动画
     * @param word	正确的字
     * @param ncout	写了多少点
     * @param polongArray	点阵
     * @return	返回分数， 第一个字返回 5，第二个返回4，其他返回3，没找到返回0
	 * @throws InterruptedException 
     */
	public  int judgeHandPut(String word, int ncout, short[] polongArray) throws InterruptedException
    {
    	short[] rgResultBuff = new short[1024];
    	char[] tempArray;
    	int score = 0;
    	int err = HandWrite.initHandWrite(Environment.getExternalStorageDirectory()+"/Aiwrite.dat");
    	HandWrite.setReconizeEngilish();
    	HandWrite.iHCR_SetParam(HandWrite.iHCR_PARAM.iHCR_PARAM_RECOGMANNER.ordinal(), HandWrite.iHCR_RECOGNITION_SENT_LINE);
    	if(err == 0){
    		return 0;
    	}else{
    		err = HandWrite.reconizePoint(ncout, polongArray,rgResultBuff);
    		if(err <= 0){
    			HandWrite.exitHandWriteInit();
    			return 0;
    		}else{
    			tempArray=new char[err];
    			for(int i=0;i<err;i++){
    				if((int)rgResultBuff[i] == 0){
    					tempArray[i]= '-';
    				}else{
    					tempArray[i]=(char)rgResultBuff[i];
    				}
    			}
    			String str=String.valueOf(tempArray);
    			Log.i("-----str", str);
    			String[] result = str.split("-");//分割字符串
    			Log.i("result",result[0]);
    			String answerStr;
    			if(is_float==false)
    				answerStr = String.valueOf(answer);
    			else{
    				answerStr = answer_float;
    			}
    			
    			for (int i = 0; i < result.length; i++) 
    			{
    				 if(answerStr.equalsIgnoreCase(result[i])){
    					 correct = true;
    					 problem+=answerStr;
    					 content_of_game.setText(problem);
        				 /*播放正确动画*/
    					 Animal(true); 
    					 break;
        			 }
    				 
    			}
    			if(!correct){
    				problem+=result[0];
					content_of_game.setText(problem);
    				Animal(false);
    			}
    			 
    		}
    		Log.i("word score",score + "");
    		correct = false;
    		HandWrite.exitHandWriteInit();
    	}
    	return score;
    }
    
	
	  /**
     * 选择播放动画
     * @param choosing 表示播放动画类型
     */
    @SuppressWarnings("deprecation")
	public void Animal(boolean choosing){
    	if(choosing==true){
    		mImageViewFilling = (ImageView) findViewById(R.id.imageview_animation_list_filling);
    		mImageViewFilling.setVisibility(0);
    		successOrFail=1;
    		durationTime=300;
    		//Resources resources=getBaseContext().getResources();
    		//Drawable right_b = resources.getDrawable(R.drawable.animation_list_filling_success);
    		//mImageViewFilling.setBackgroundDrawable(right_b);
    		//animation=((AnimationDrawable) mImageViewFilling.getBackground());
    		costom_animation.setAnimation(mImageViewFilling, resourceIdListSuccess);
    		UpSuccessAndGrade();
    	}
    	else{
    		mImageViewFilling = (ImageView) findViewById(R.id.imageview_animation_list_filling);
    		mImageViewFilling.setVisibility(0);
    		successOrFail=2;
    		durationTime=100;
    		//Resources resources=getBaseContext().getResources();
    		//Drawable right_b = resources.getDrawable(R.drawable.animation_list_filling_fail);
    		//mImageViewFilling.setBackgroundDrawable(right_b);
    		//animation=((AnimationDrawable) mImageViewFilling.getBackground());
    		costom_animation.setAnimation(mImageViewFilling, resourceIdListFail);
    	}
    	
//    	//在异步线程中执行启动的方法
//    	mImageViewFilling.post(new Runnable() {     
//    		                    @Override
//    		                    public void run() {
//    		                        // TODO Auto-generated method stub
//    		                    	costom_animation.start(false,1000);   //启动动画
//    		                    	playSound.PlaySoundSuccessOrFail(successOrFail);
//    		                    	dv.clearScreen();
//    	                   }
//    		                });
//    	for(int i=0;i<animation.getNumberOfFrames();i++){
//            duration+=animation.getDuration(i);     //计算动画播放的时间
//         }
    	
    	
    	costom_animation.start(false,durationTime);   //启动动画
    	playSound.PlaySoundSuccessOrFail(successOrFail);
    	dv.clearScreen();
    	
    	
    	Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
           public void run() {
        	 costom_animation.stop();
           	 playSound.StopSoundSuccessOrFail(successOrFail);
           	 mImageViewFilling.setVisibility(4);
				 synchronized (Alock) {  
					 Alock.notifyAll();
                  }      
            }
       }, stayAnimationSuccessTime);
    }
    
    
    void addResource(){
    		costom_animation=new costomAnimation();
			resourceIdListSuccess.add(R.drawable.success1);
			resourceIdListSuccess.add(R.drawable.success2);
			resourceIdListSuccess.add(R.drawable.success3);
			resourceIdListSuccess.add(R.drawable.success4);
			resourceIdListSuccess.add(R.drawable.success5);
			resourceIdListSuccess.add(R.drawable.success6);
			stayAnimationSuccessTime=6*300;
			resourceIdListFail.add(R.drawable.fail1);
			resourceIdListFail.add(R.drawable.fail2);
			resourceIdListFail.add(R.drawable.fail3);
			resourceIdListFail.add(R.drawable.fail4);
			resourceIdListFail.add(R.drawable.fail5);
			resourceIdListFail.add(R.drawable.fail6);
			resourceIdListFail.add(R.drawable.fail7);
			resourceIdListFail.add(R.drawable.fail8);
			resourceIdListFail.add(R.drawable.fail9);
			resourceIdListFail.add(R.drawable.fail10);
			resourceIdListFail.add(R.drawable.fail11);
			resourceIdListFail.add(R.drawable.fail12);
			resourceIdListFail.add(R.drawable.fail13);
			resourceIdListFail.add(R.drawable.fail14);
			resourceIdListFail.add(R.drawable.fail15);
			resourceIdListFail.add(R.drawable.fail16);
			resourceIdListFail.add(R.drawable.fail17);
			stayAnimationFailTime=17*100;
    }
    
    
    private void freeAnimationDrawable(AnimationDrawable animationDrawables) {
    	 if (animationDrawables != null) {
    		 Log.i("mentalwubingchao", "animation is not null");
             animationDrawables.stop();
             for (int i = 0; i < animationDrawables.getNumberOfFrames(); i++) {
                 Drawable frame = animationDrawables.getFrame(i);
                 if (frame instanceof BitmapDrawable) {
                     ((BitmapDrawable) frame).getBitmap().recycle();
                 }
                 frame.setCallback(null);
             }
             animationDrawables.setCallback(null);
              
         }
    }
    
	/**
	 * 播放正确动画，并且更新分数和局数
	 */
	protected void UpSuccessAndGrade(){
		 student_grade+=10;
		 grade_of_game.setText(student_grade+"");
		 Log.i("information", "正确");
		 for(int i=0;i<10;i++){
			 if(student_grade>=drawOfGame[i]){
				 continue;
			 }
			 else{
				 number_of_game.setText(i+1+"");
				 student_office=i+1;
				 break;
			 }
		 }
	 }
    
	
	/**
	 * 播放错误动画，什么都不做
	 */
	protected void Fail(){
		//do nothing
	}
    
 
  	/**
  	 * 设置保存的数据 排名，将当前的最佳数据写入到sd卡中
  	 * @param fist_grade 第一名分数
  	 * @param second_grade 第二名分数
  	 * @param third_grade 第三名分数
  	 */
  	public void updateGrade(int fist_grade,int office){
  		String name="test";
  		SharedPreferences mySharedPreferences= getSharedPreferences(name, 
  		Activity.MODE_PRIVATE); 
  		SharedPreferences.Editor editor = mySharedPreferences.edit(); 
  		editor.putInt("first_grade"+intent_type, fist_grade); 
  		editor.putInt("office_grade"+intent_type, office);
  		editor.commit(); 
  	}
  	
  	
  	/**从sd卡中获取保存排名的数据
  	 * 
  	 */
  	public void readFile(){
  		String name="test";
  		SharedPreferences sharedPreferences= getSharedPreferences(name, 
  				Activity.MODE_PRIVATE); 
  		// 使用getString方法获得value，注意第2个参数是value的默认值 
  		grade_all[0]=sharedPreferences.getInt("first_grade"+intent_type, 0); 
  		grade_all[1]=sharedPreferences.getInt("office_grade"+intent_type, 1);
  				
  	}
  	
  	
  	/**
  	 * 更新名次
  	 */
  	public void updateGradeContent(){
  		if(student_grade>=grade_all[0]){
  			grade_all[0]=student_grade;
  		}
  		if(student_office>=grade_all[1]){
  			grade_all[1]=student_office;
  		}
  	}
  	
	
  	
  	
  	/**
     * 显示开始的提示界面
     */
    public void showEnterDialog(){
    	String name="test";
	  	SharedPreferences sharedPreferences=GameActivity.this.getSharedPreferences(name, 
	  				Activity.MODE_PRIVATE); 	
	  				// 使用getString方法获得value，注意第2个参数是value的默认值 
	  	
	  	//控制是否显示
	  	is_show=sharedPreferences.getBoolean("is_show", true); 
	  	//is_show=true;
	  	if(is_show){
		        //错误在这里
	  			enter_dialog=new enterDialog(this,count_down_thread); 
	  			//设置监听事件
	  		  	enter_dialog.setbackKey();
    			enter_dialog.setRemind_next_timeListenEvent( new OnClickListener() {                   
    				public void onClick(View v) {
						enter_dialog.dismiss();
						count_time=STARTNUM;
						count_down_thread.setStartTime(count_time);
			}
			});
    			}
    			else{
    						count_time=STARTNUM;
							count_down_thread.setStartTime(count_time);
							is_first_in_game=true;
    				}
    }
    
  	/**
  	 * 显示结束的界面，统计回合的得分
  	 */
  	public void showFinishDialog(){
  		finish_dialog=new finishDialog(this,student_office,student_grade,intent_type);
        	finish_dialog.setClickQuitEvent( new OnClickListener() { 
      			@Override                  
      			public void onClick(View v) {
      			    // TODO Auto-generated method stub
      				finish_dialog.dismiss();
      			    GameActivity.this.finish();      
      			}
      			});
    	  	
    	  	//继续游戏的监听
        	finish_dialog.setClickContinueEvent( new OnClickListener() { 
      			@Override                  
      			public void onClick(View v) {
      			    // TODO Auto-generated method stub
      				finish_dialog.dismiss();
      				
    				count_time=STARTNUM;
      			    count_down_thread.setStartTime(count_time);
      			    grade_of_game.setText("0");
      			    student_grade=0;
      			    student_office=1;
    				number_of_game.setText("1");
    				
    				//重新出题
    				dv.clearScreen();
    				synchronized (Alock) {  
   					 Alock.notifyAll();
                     }    
      			}
      			});
        }
	
  	
}
