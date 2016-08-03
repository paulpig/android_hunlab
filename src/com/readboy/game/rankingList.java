package com.readboy.game;



import com.readboy.mentalcalculation.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class rankingList extends Activity{
	private TextView grade_view;
	private TextView office_view;
	private TextView content_view;
	private RelativeLayout relative_layout;
	private String game_type; //用于储存数据库的名字
	private int grade_intent; 
	private int office_intent;
	private int[]grade_all=new int[2];
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.ranking_list);
        init();
        getIntentContent();
        ListenAllScreen();
        ListenButton();
        readFile();
        updateGradeContent();
        updateGrade(grade_all[0],grade_all[1]);
        showTextView();
	}
	
	public void init(){
		office_view=(TextView) findViewById(R.id.fist_ranking);
		grade_view=(TextView) findViewById(R.id.second_ranking);
		content_view=(TextView) findViewById(R.id.textview);
		relative_layout=(RelativeLayout) findViewById(R.id.relative_views);
	}

	/**
	 * 监听整个屏幕
	 */
	public void ListenAllScreen(){
		relative_layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				rankingList.this.finish();
			}
		});
	}

	/**
	 * 监听显示内容
	 */
	public void ListenButton(){
		
		content_view.setOnClickListener(null);
		//content_view.setClickable(false);
	}
	
	/** 
	 * 更新分数排名
	 * @param fist_grade
	 * @param second_grade
	 * @param third_grade
	 */
	public void updateGrade(int fist_grade,int second_grade){
		//实例化SharedPreferences对象（第一步） 
		String name="test";
		SharedPreferences mySharedPreferences= getSharedPreferences(name, 
		Activity.MODE_PRIVATE); 
		//实例化SharedPreferences.Editor对象（第二步） 
		SharedPreferences.Editor editor = mySharedPreferences.edit(); 
		//用putString的方法保存数据 
		editor.putInt("first_grade"+game_type, grade_all[1]); 
  		editor.putInt("office_grade"+game_type,grade_all[0]);
		//提交当前数据 
		editor.commit(); 
	}
	
	/**
	 * 获取数据
	 */
	public void readFile(){
		String name="test";
		SharedPreferences sharedPreferences= getSharedPreferences(name, 
				Activity.MODE_PRIVATE); 
				// 使用getString方法获得value，注意第2个参数是value的默认值 
		grade_all[1]=sharedPreferences.getInt("first_grade"+game_type,0); 
		grade_all[0]=sharedPreferences.getInt("office_grade"+game_type,0); 
				
	}
	
	//将内容显示出来
	public void showTextView(){
		office_view.setText(Integer.toString(grade_all[0]));
		grade_view.setText(Integer.toString(grade_all[1]));
	}
	
	
	//获得传递过来的数据
	public void getIntentContent(){
		Intent intent =getIntent();
		grade_intent = intent.getIntExtra("grade",-1);
		office_intent=intent.getIntExtra("office", -1);
		game_type=intent.getStringExtra("game_type");	
	}
	
	
	//更新分数数组内容
	public void updateGradeContent(){
		if(grade_intent>=grade_all[1]){
			grade_all[1]=grade_intent;
		}
		if(office_intent>=grade_all[0] ){
			grade_all[0]=office_intent;
		}
		
	}
	
}
