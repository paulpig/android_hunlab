package com.readboy.game;

import java.util.ArrayList;

import com.readboy.game.Grade_1.Grade_1_top;
import com.readboy.mentalcalculation.R;

import com.readboy.HandWrite.*;
import com.readboy.mentalcalculation.MainActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public  abstract class GameActivity  extends Activity{
	protected ImageView back_bt;
	protected TextView type_view;
	protected TextView time_of_game;
	protected TextView content_of_game;
	protected String problem;
	protected int answer;
	protected float answer_float;
	protected boolean is_float;
	protected Button sure;
	protected DrawView dv;      //手写板
	protected EditText answer_of_game;
	protected TextView grade_of_game;
	protected int student_grade;
	protected ArrayList<Integer> keep_grade;
	protected Object Alock;
	protected int type;  //题目类型
	protected int count_time=100;
	protected CountDownThread count_down_thread;
	protected boolean stopThread=false;
	protected ImageView draft;
	protected ImageView ranking;
	protected DraftView draft_view;
	protected RelativeLayout liner;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.game_view);
        findView();
        initView();
        backToStartView();
        CountTimeThread();
        draftButton();
    }
	
	protected void onDestroy() {
		         System.out.println("-----------onDestroy------");
		         stopThread=true;
		         count_down_thread.setTag(stopThread);
		         super.onDestroy();
		    };       
	
	
	/*初始化界面*/
	protected void initView(){
		Intent intent =getIntent();
		String content = intent.getStringExtra("content");
		type=intent.getIntExtra("type",-1);
		type_view.setText(content);
		student_grade=0;
		
	}
	
	
	/*获取视图*/
	protected void findView(){
		back_bt=(ImageView)findViewById(R.id.back_bt);
		type_view=(TextView) findViewById(R.id.type_view);
		time_of_game=(TextView) findViewById(R.id.time_of_game);
		content_of_game=(TextView) findViewById(R.id.content_of_game);
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
	
	/*监听返回键*/
	protected void backToStartView(){
		 back_bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 stopThread=true;
		         count_down_thread.setTag(stopThread);
				GameActivity.this.finish();
			}
		});
	 }
	 protected void draftButton(){
		 draft.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					 Intent intent = new Intent();  
		             intent.setClass(GameActivity.this, draftActivity.class);  
		             startActivity(intent);   
				}
			});
	 }
	
	
	/*时间计时线程*/
	protected void CountTimeThread(){
		 Handler time_hander=new Handler(){
			 public void handleMessage(Message msg) {
	             // process incoming messages here
				Bundle b = msg.getData();
				int time = b.getInt("time");
				time_of_game.setText(time+"");
				Log.i("stopThread", "no");
				if(time==0){
					//content_of_game.setText("时间到啦");
					//sure.setVisibility(4);
					//keep_grade.add(Integer.parseInt(grade_of_game.getText().toString()));
					grade_of_game.setText("0");
					student_grade=0;
				}
	         }
		};
		 count_down_thread=new CountDownThread(count_time,time_hander);
		 new Thread(count_down_thread).start();
	 }
	
	 
	 /*从 “出题”（supply_project_thread）线程中获取线程*/
	protected   abstract void GetProAndAns( int type);
	 
	 
	 /*判断输入的答案正确性，正确重新出题，错误无*/
	protected  abstract void IsRight();

	

	 
	 /*播放正确动画，并且更新分数*/
	protected void UpSuccessAndGrade(){
		 student_grade+=10;
		 grade_of_game.setText(student_grade+"");
		 Log.i("information", "正确");
	 }
	 
	 
	 /*播放错误动画*/
	protected void UpFail(){
		 Log.i("information", "错误");
	 }
}
