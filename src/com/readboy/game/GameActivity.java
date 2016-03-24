package com.readboy.game;

import java.util.ArrayList;

import com.readboy.mentalcalculation.R;

import com.readboy.HandWrite.*;
import com.readboy.mentalcalculation.MainActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
	protected DrawView dv;      //��д��
	protected EditText answer_of_game;
	protected TextView grade_of_game;
	protected int student_grade;
	protected ArrayList<Integer> keep_grade;
	protected Object Alock;
	protected int type;  //��Ŀ����
	protected int count_time=10;
	protected CountDownThread count_down_thread;
	protected boolean stopThread=false;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.game_view);
        findView();
        initView();
        backToStartView();
        CountTimeThread();
    }
	
	protected void onDestroy() {
		         System.out.println("-----------onDestroy------");
		         stopThread=true;
		         count_down_thread.setTag(stopThread);
		         super.onDestroy();
		    };       
	
	
	/*��ʼ������*/
	protected void initView(){
		Intent intent =getIntent();
		String content = intent.getStringExtra("content");
		type=intent.getIntExtra("type",-1);
		type_view.setText(content);
		student_grade=0;
		
	}
	
	
	/*��ȡ��ͼ*/
	protected void findView(){
		back_bt=(ImageView)findViewById(R.id.back_bt);
		type_view=(TextView) findViewById(R.id.type_view);
		time_of_game=(TextView) findViewById(R.id.time_of_game);
		content_of_game=(TextView) findViewById(R.id.content_of_game);
		sure=(Button)findViewById(R.id.sure);
		//answer_of_game=(EditText) findViewById(R.id.answer_of_game);
		grade_of_game=(TextView) findViewById(R.id.grade_of_game);
		dv = (DrawView) findViewById(R.id.draw);
		dv.paint.setColor(Color.RED);
		dv.paint.setStrokeWidth(5);
	}
	
	/*�������ؼ�*/
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
	 
	
	
	/*ʱ���ʱ�߳�*/
	protected void CountTimeThread(){
		 Handler time_hander=new Handler(){
			 public void handleMessage(Message msg) {
	             // process incoming messages here
				Bundle b = msg.getData();
				int time = b.getInt("time");
				time_of_game.setText(time+"");
				Log.i("stopThread", "no");
				if(time==0){
					//content_of_game.setText("ʱ�䵽��");
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
	
	 
	 /*�� �����⡱��supply_project_thread���߳��л�ȡ�߳�*/
	protected   abstract void GetProAndAns( int type);
		/* Handler problem_hander=new Handler(){
			 public void handleMessage(Message msg) {
	             // process incoming messages here
				Log.i("information", "receive_problem");
				Bundle b = msg.getData();
				answer = b.getInt("answer");
				problem=b.getString("problem");
				content_of_game.setText(problem);
	         }
		};
		SupplyProjectGrade_1_AddInFive supply_project_thread=new SupplyProjectGrade_1_AddInFive(problem_hander,Alock);
		new Thread(supply_project_thread).start();*/
	 
	 
	 /*�ж�����Ĵ���ȷ�ԣ���ȷ���³��⣬������*/
	protected  abstract void IsRight();
		/* sure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 int in_put_answer=Integer.parseInt(answer_of_game.getText().toString());  
				 if(in_put_answer==answer){
					// ������ȷ���������·���
					 UpSuccessAndGrade();
					 
					 synchronized (Alock) {  
						 Alock.notifyAll();  
	                     Log.v("information","notify");  
	                    }                     
				 }
				 
				 else{
					// ���Ŵ��󶯻�
					 UpFail();
					 
				 }
			}
		});*/

	 
	 
	 /*������ȷ���������Ҹ��·���*/
	protected void UpSuccessAndGrade(){
		 student_grade+=10;
		 grade_of_game.setText(student_grade+"");
		 Log.i("information", "��ȷ");
	 }
	 
	 
	 /*���Ŵ��󶯻�*/
	protected void UpFail(){
		 Log.i("information", "����");
	 }
}
