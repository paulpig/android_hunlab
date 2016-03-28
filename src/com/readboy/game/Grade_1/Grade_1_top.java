package com.readboy.game.Grade_1;

import com.readboy.mentalcalculation.R;
import com.readboy.HandWrite.*;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import com.readboy.game.GameActivity;
import com.readboy.game.Watcher;
import com.readboy.game.GameActivity.WorkThread;

public class Grade_1_top extends GameActivity implements Watcher{

	protected Object Alock;
	
	Supply_Grade_1_top supply_project_thread;
	 
	
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
	
	
}


