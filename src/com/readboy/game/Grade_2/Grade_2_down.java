package com.readboy.game.Grade_2;

import com.readboy.mentalcalculation.R;
import com.readboy.HandWrite.*;

import android.content.Intent;
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
import android.widget.ImageView;

import com.readboy.game.GameActivity;
import com.readboy.game.Watcher;
import com.readboy.game.rankingList;
import com.readboy.game.GameActivity.WorkThread;

public class Grade_2_down extends GameActivity implements Watcher{

	//protected Object Alock;
	
	Supply_Grade_2_down supply_project_thread;
	 
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        correct = false;
		GetProAndAns(type);
		initTimer();
		IsRight();
		intent_type="21"+type;
		rankingListen();
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
		supply_project_thread=new Supply_Grade_2_down(problem_hander,Alock,type);
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
	
	
	//��ͬҳ��Ĵ���rankingList�����ݲ���ͬ,�������ݣ�1.�������ݵ�xml����  2.��ǰ�ķ���
	protected void rankingListen(){
		 ranking.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					is_over=false;
					 Intent intent = new Intent();  
		             intent.setClass(Grade_2_down.this, rankingList.class);
		             intent.putExtra("game_type",intent_type);
		             intent.putExtra("grade",student_grade);
		             intent.putExtra("office", student_office);
		             startActivity(intent);
				}
			});
	}
	
	
}


