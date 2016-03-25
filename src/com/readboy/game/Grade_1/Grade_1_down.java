package com.readboy.game.Grade_1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;

import com.readboy.mentalcalculation.R;
import com.readboy.game.GameActivity;

public class Grade_1_down extends GameActivity{

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
				answer = b.getInt("answer");
				problem=b.getString("problem");
				content_of_game.setText(problem);
	         }
		};
		Supply_Grade_1_down supply_project_thread=new Supply_Grade_1_down(problem_hander,Alock,type);
		new Thread(supply_project_thread).start();
	 }
	
	 
	protected void IsRight(){
		 sure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 int in_put_answer=Integer.parseInt(answer_of_game.getText().toString());  
				 if(in_put_answer==answer){
					 /*播放正确动画并更新分数*/
					 //UpSuccessAndGrade();
					 
					 synchronized (Alock) {  
						 Alock.notifyAll();  
	                     Log.v("information","notify");  
	                    }                     
				 }
				 
				 else{
					 /*播放错误动画*/
					 //UpFail();
					 
				 }
			}
		});
	 }
}
