package com.readboy.game.Grade_1;

import com.readboy.mentalcalculation.R;
import com.readboy.HandWrite.*;
import android.R.bool;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.readboy.game.GameActivity;
import com.readboy.game.Watched;
import com.readboy.game.Watcher;

public class Grade_1_top extends GameActivity implements Watcher{

	protected Object Alock;
	private Boolean correct;
	Supply_Grade_1_top supply_project_thread;
	private static final int COMPLETED = 0; 
	private AnimationDrawable animation;
	private ImageView mImageViewFilling = null;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Alock=new Object();
        correct = false;
		GetProAndAns(type);
		initTimer();
		IsRight();
    }
	
	protected void initTimer(){
		//Watched watched = new DrawView();  
		dv.add(this);
	}
	
	protected void GetProAndAns(int type){
		 Handler problem_hander=new Handler(){
			 public void handleMessage(Message msg) {
	             // process incoming messages here
				Log.i("information", "receive_problem");
				Bundle b = msg.getData();
				answer = b.getInt("answer");
				problem=b.getString("problem");
				content_of_game.setText(problem);
	         }
		};
		supply_project_thread=new Supply_Grade_1_top(problem_hander,Alock,type);
		new Thread(supply_project_thread).start();
	 }
	
	 
	protected void IsRight(){
	 }
	
	protected void onDestroy() {
		System.out.println("-----------onDestroy------");
        stopThread=true;
        count_down_thread.setTag(stopThread);
        supply_project_thread.setTag(stopThread);
        super.onDestroy();
	}
	
	
	/**
     * �жϸ���д�����Ƿ���ȷ
     * @param word	��ȷ����
     * @param ncout	д�˶��ٵ�
     * @param polongArray	����
     * @return	���ط����� ��һ���ַ��� 5���ڶ�������4����������3��û�ҵ�����0
	 * @throws InterruptedException 
     */
    @SuppressWarnings("unused")
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
    			String[] result = str.split("");//�ָ��ַ���
    			String answerStr = String.valueOf(answer);
    			
    			for (int i = 1; i < result.length; i++) 
    			{
    				 if(answerStr.equalsIgnoreCase(result[i])){
    					 correct = true;
    					 problem+=answerStr;
    					 content_of_game.setText(problem);
    					 //correct = false;
        				 /*������ȷ����*/
    					 Animal(true);              
        			 }
    				 break;
    			}
    			if(!correct){
    				/*���Ŵ��󶯻�*/
//    				for(int i=0;i<result.length;i++){
//    					if(result[i]<='9'||result[i]>='0'){
//    						
//    					}
//    				}
    				problem+=result[1];
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
   
    
    
    /*ѡ�񲥷Ŷ���*/
    public void Animal(boolean choosing){
    	int duration=0;  // duration�Ǽ�¼��һ���������ŵ���ʱ��
    	if(choosing==true){
    		mImageViewFilling = (ImageView) findViewById(R.id.imageview_animation_list_filling);
    		mImageViewFilling.setVisibility(0);
    		Resources resources=getBaseContext().getResources();
    		Drawable right_b = resources.getDrawable(R.drawable.animation_list_filling_success);
    		mImageViewFilling.setBackgroundDrawable(right_b);
    		animation=((AnimationDrawable) mImageViewFilling.getBackground());
    	}
    	else{
    		mImageViewFilling = (ImageView) findViewById(R.id.imageview_animation_list_filling);
    		mImageViewFilling.setVisibility(0);
    		Resources resources=getBaseContext().getResources();
    		Drawable right_b = resources.getDrawable(R.drawable.animation_list_filling_fail);
    		mImageViewFilling.setBackgroundDrawable(right_b);
    		animation=((AnimationDrawable) mImageViewFilling.getBackground());
    	}
    	mImageViewFilling.post(new Runnable() {    //���첽�߳���ִ�������ķ���
    		                     
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
    		            	 UpSuccessAndGrade();
        					 synchronized (Alock) {  
           					 Alock.notifyAll();
                               }      
    		             }
    		        }, duration);
    }

	@Override
	public void updateNotify() {
		new WorkThread().start(); 
	}
	
	private class WorkThread extends Thread {  
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
}


