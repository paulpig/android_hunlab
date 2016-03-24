package com.readboy.game.Grade_3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;

import com.readboy.mentalcalculation.R;
import com.readboy.game.GameActivity;

public class Grade_3_down extends GameActivity{

	protected Object Alock;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Alock=new Object();
		GetProAndAns(type);
		IsRight();
    }
	
	
	protected void GetProAndAns(int type){
		 Handler problem_hander=new Handler(){
			 public void handleMessage(Message msg) {
	             // process incoming messages here
				Log.i("information", "receive_problem");
				Bundle b = msg.getData();
				if(!b.getBoolean("is_float")){
					answer = b.getInt("answer");
					is_float=false;
				}
				else{
					answer_float= b.getFloat("answer");
					is_float=true;
				}
				problem=b.getString("problem");
				content_of_game.setText(problem);
	         }
		};
		Supply_Grade_3_down supply_project_thread=new Supply_Grade_3_down(problem_hander,Alock,type);
		new Thread(supply_project_thread).start();
	 }
	
	 
	protected void IsRight(){
		 sure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(is_float==false){
					 int in_put_answer=Integer.parseInt(answer_of_game.getText().toString());  
					 if(in_put_answer==answer){
						 /*播放正确动画并更新分数*/
						 UpSuccessAndGrade();
						 
						 synchronized (Alock) {  
							 Alock.notifyAll();  
		                     Log.v("information","notify");  
		                    }                     
					 }
					 
					 else{
						 /*播放错误动画*/
						 UpFail();
						 
					 }
				}
			else{
				float in_put_answer=Float.parseFloat(answer_of_game.getText().toString()); 
				float change_result=(float)((int)(in_put_answer*100)/100.0);
				 if(in_put_answer==change_result){
					 /*播放正确动画并更新分数*/
					 UpSuccessAndGrade();
					 
					 synchronized (Alock) {  
						 Alock.notifyAll();  
	                     Log.v("information","notify");  
	                    }                     
				 }
				 
				 else{
					 /*播放错误动画*/
					 UpFail();
					 
				 }
			}
			}
		});
	 }
}
