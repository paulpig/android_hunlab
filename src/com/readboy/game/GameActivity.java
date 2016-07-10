package com.readboy.game;

import java.util.ArrayList;

import com.readboy.mentalcalculation.R;
import com.readboy.HandWrite.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
	final private int STARTNUM=60;
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
	protected DrawView dv;      //��д��
	protected EditText answer_of_game;
	protected TextView grade_of_game;
	protected int student_grade;
	protected int student_office=1;
	protected ArrayList<Integer> keep_grade;
	protected Object Alock;
	protected int type;  //��Ŀ����
	protected int count_time=0;  //ÿ���ʱ��
	protected CountDownThread count_down_thread;
	protected boolean stopThread=false;
	protected ImageView draft;
	protected ImageView ranking;
	protected DraftView draft_view;
	protected RelativeLayout liner;
	protected static final int COMPLETED = 0;
	protected AnimationDrawable animation;
	protected ImageView mImageViewFilling = null;
	protected Boolean correct;
	protected int time_temp;
	protected int[]grade_all=new int[3];
	boolean is_show;
	boolean is_first_in_game=false;
	enterDialog enter_dialog;
	finishDialog finish_dialog;
	protected boolean is_over=true;
	public int time; //����ʱ��ǰ��ʱ��
	final protected int []drawOfGame={10,20,30,400,500,600,700,800,900,1000};
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.game_view);
        findView();
        initView();
        Alock=new Object();
        backToStartView();
        //CountTimeThread();
        draftButton();
        CountTimeThread();
        //new startThread(this).start();
        showEnterDialog();
       
        //new showEnterDia(this).start();
       
    }
	
	protected void onDestroy() {
		         Log.i("lalala", "onDestroy");
		         //enter_dialog.dismiss();
		         //finish_dialog.dismiss();
		         //�����ļ�������
			     
			      
		         super.onDestroy();
		    };       
	
		    
    
	protected void onPause(){
		    super.onPause();
		    Intent intent=new Intent();
	        intent.putExtra("Type",type);
	        setResult(RESULT_OK,intent);
	        Log.i("lalala", "onPause");
	        
	        readFile();
		    updateGradeContent();
		    updateGrade(grade_all[0],grade_all[1]);
	        
	        
	        if(is_over==true){
		        //��������������
	        	is_quit=true;
		        stopThread=true;
		        count_down_thread.setTag(stopThread);
		        count_down_thread.setStartTime(1);
		        //handler.removeCallbacks(count_down_thread);
	        }
	        else{
	        	is_over=true;
	        	time_temp=time;
	        	count_down_thread.setStop(true, time_temp);
	        }
	        
	}
	
	
	
	public void onResume() {
	    super.onResume();  // Always call the superclass method first 
	    if(is_first_in_game==false){
	    	count_down_thread.setStop(false, 0);
		    count_down_thread.setStartTime(time_temp);
	    }
	    else{
	    	count_down_thread.setStartTime(STARTNUM);
	    	is_first_in_game=false;
	    }
	    Log.i("lalala","onresume");

	}
	/**
	 * ��ʼ������
	 */
	protected void initView(){
		Intent intent =getIntent();
		String content = intent.getStringExtra("content");
		type=intent.getIntExtra("type",-1);
		type_view.setText(content);
		student_grade=0;
		
	}
	
	
	/**
	 * ��ȡ����
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
	}
	
	
	/**
	 * ���ؼ���Ӧ�¼�
	 */
	protected void backToStartView(){
		 back_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 stopThread=true;
		         count_down_thread.setTag(stopThread);
		         /*�ϸ�ҳ��ش�����*/
				GameActivity.this.finish();
			}
	 });
	}
	
	
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
	 * ʱ���ʱ�߳�
	 */
	@SuppressLint("HandlerLeak") 
	protected void CountTimeThread(){
		 Handler time_hander=new Handler(){
			 public void handleMessage(Message msg) {
				Bundle b = msg.getData();
				time = b.getInt("time");
				time_of_game.setText(time+"");
				//Log.i("stopThread", "no");
				if(time==0){
					//showFinishDialog();
					//finish_dialog.show();
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
	 * �� �����⡱��supply_project_thread���߳��л�ȡ�߳�
	 * @param type 
	 */
	protected   abstract void GetProAndAns( int type);
	 
	/**
	 * �ж�����Ĵ���ȷ�ԣ�
	 * ��ȷ���³��⣬
	 * ������
	 */
	protected  abstract void IsRight();

	/**
	 * ������ȷ���������Ҹ��·����;���
	 */
	protected void UpSuccessAndGrade(){
		 student_grade+=10;
		 grade_of_game.setText(student_grade+"");
		 Log.i("information", "��ȷ");
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
	 *  ���Ŵ��󶯻�
	 */
	protected void UpFail(){
		 Log.i("information", "����");
	 }
 
	/**
     * �жϸ���д�����Ƿ���ȷ
     * @param word	��ȷ����
     * @param ncout	д�˶��ٵ�
     * @param polongArray	����
     * @return	���ط����� ��һ���ַ��� 5���ڶ�������4����������3��û�ҵ�����0
	 * @throws InterruptedException 
     */
	public  int judgeHandPut(String word, int ncout, short[] polongArray) throws InterruptedException
    {
    	short[] rgResultBuff = new short[1024];
    	char[] tempArray;
    	int score = 0;
    	//Log.e("judgeHandPut",word + "");
    	int err = HandWrite.initHandWrite(Environment.getExternalStorageDirectory()+"/Aiwrite.dat");
    	//HandWrite.iHCR_SetParam(HandWrite.iHCR_PARAM.iHCR_PARAM_LANGUAGE.ordinal(), HandWrite.iHCR_LANGUAGE_Numerals);
    	//HandWrite.iHCR_SetParam(HandWrite.iHCR_PARAM.iHCR_PARAM_MAXCANDNUM.ordinal(), 10);
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
    			String[] result = str.split("-");//�ָ��ַ���
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
    					 //����textview��λ�þ���
    					 //content_of_game.set
    					 //content_of_game.setGravity(Gravity.CENTER);
        				 /*������ȷ����*/
    					 Animal(true); 
    					 break;
        			 }
    				 
    			}
    			if(!correct){
    				//problem+=result[0];
    				//content_of_game.setText(problem);
    				problem+=result[0];
					content_of_game.setText(problem);
					//content_of_game.setGravity(Gravity.CENTER);
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
     * ѡ�񲥷Ŷ���
     * @param choosing ��ʾ���Ŷ�������
     */
    @SuppressWarnings("deprecation")
	public void Animal(boolean choosing){
    	int duration=0;  // duration�Ǽ�¼��һ���������ŵ���ʱ��
    	if(choosing==true){
    		mImageViewFilling = (ImageView) findViewById(R.id.imageview_animation_list_filling);
    		mImageViewFilling.setVisibility(0);
    		Resources resources=getBaseContext().getResources();
    		Drawable right_b = resources.getDrawable(R.drawable.animation_list_filling_success);
    		mImageViewFilling.setBackgroundDrawable(right_b);
    		animation=((AnimationDrawable) mImageViewFilling.getBackground());
    		UpSuccessAndGrade();
    	}
    	else{
    		mImageViewFilling = (ImageView) findViewById(R.id.imageview_animation_list_filling);
    		mImageViewFilling.setVisibility(0);
    		Resources resources=getBaseContext().getResources();
    		Drawable right_b = resources.getDrawable(R.drawable.animation_list_filling_fail);
    		mImageViewFilling.setBackgroundDrawable(right_b);
    		animation=((AnimationDrawable) mImageViewFilling.getBackground());
    	}
    	
    	//���첽�߳���ִ�������ķ���
    	mImageViewFilling.post(new Runnable() {    
    		                     
    		                    @Override
    		                    public void run() {
    		                        // TODO Auto-generated method stub
    		                    	animation.start();   //��������
    		                    	dv.clearScreen();
    	                   }
    		                });
    	for(int i=0;i<animation.getNumberOfFrames();i++){
            duration+=animation.getDuration(i);     //���㶯�����ŵ�ʱ��
         }
    	
    	Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
           public void run() {
           	 animation.stop();
           	 mImageViewFilling.setVisibility(4);
				 synchronized (Alock) {  
					 Alock.notifyAll();
                  }      
            }
       }, duration);
    }

   
    
    
    
    
    
	public void updateNotify() {
		new WorkThread().start(); 
	}
	/**
	 * ��ʱ���պ󷵻ش���
	 * @author nuanbing
	 */
	public class WorkThread extends Thread {  
        @Override  
        public void run() {  
            //......����ȽϺ�ʱ�Ĳ���  
              
            //������ɺ��handler������Ϣ  
            Message msg = new Message();  
            msg.what = COMPLETED;  
            handler.sendMessage(msg);  
        }  
        
	}
	
	private Handler handler = new Handler() {  
        @Override  
        public void handleMessage(Message msg) {  
            if (msg.what == COMPLETED) {  
            	//stateText.setText("completed");
            	// TODO Auto-generated method stub
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
    
    
    
    
    
    /*�����̴߳�����ʼ�ͽ�������*/
    public void showEnterDialog(){
    	String name="test";
	  	SharedPreferences sharedPreferences=GameActivity.this.getSharedPreferences(name, 
	  				Activity.MODE_PRIVATE); 	
	  				// ʹ��getString�������value��ע���2��������value��Ĭ��ֵ 
	  	is_show=sharedPreferences.getBoolean("is_show", true); 
	  	//is_show=true;
	  	if(is_show){
		        //����������
	  			enter_dialog=new enterDialog(this); 
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
	  	//���ü����¼�
	  	enter_dialog.setbackKey();
    }
    

    
    
    
  	/**
  	 * ���ñ�������� ����
  	 * @param fist_grade ��һ������
  	 * @param second_grade �ڶ�������
  	 * @param third_grade ����������
  	 */
  	public void updateGrade(int fist_grade,int office){
  		//ʵ����SharedPreferences���󣨵�һ���� 
  		String name="test";
  		SharedPreferences mySharedPreferences= getSharedPreferences(name, 
  		Activity.MODE_PRIVATE); 
  		//ʵ����SharedPreferences.Editor���󣨵ڶ����� 
  		SharedPreferences.Editor editor = mySharedPreferences.edit(); 
  		//��putString�ķ����������� 
  		editor.putInt("first_grade"+intent_type, fist_grade); 
  		editor.putInt("office_grade"+intent_type, office);
  		//�ύ��ǰ���� 
  		editor.commit(); 
  	}
  	
  	//��ȡ���������
  	public void readFile(){
  		String name="test";
  		SharedPreferences sharedPreferences= getSharedPreferences(name, 
  				Activity.MODE_PRIVATE); 
  		// ʹ��getString�������value��ע���2��������value��Ĭ��ֵ 
  		grade_all[0]=sharedPreferences.getInt("first_grade"+intent_type, 0); 
  		grade_all[1]=sharedPreferences.getInt("office_grade"+intent_type, 1);
  				
  	}
  	
  	
  	/**
  	 * ��������
  	 */
  	public void updateGradeContent(){
  		if(student_grade>=grade_all[0]){
  			grade_all[0]=student_grade;
  		}
  		if(student_office>=grade_all[1]){
  			grade_all[1]=student_office;
  		}
  	}
  	
	
  	//��ʾ�����Ľ���
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
    	  	
    	  	//������Ϸ�ļ���
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
      			}
      			});
        }
	
  	
}
