package com.readboy.mentalcalculation;

import com.readboy.game.Grade_4.Grade_4_top;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MyFragment_Grade_4_top extends Fragment {
	  private FragmentActivity activity;
	  private int show_num=-1;
	  view tv;
	  View view ;
	  private view tv1;
	  private view tv2;
	  private view tv3;
	  private view tv4;
	  final private int MULANDDIV=1;  //几百几十除以整十数的口算
	  final private int CANDIVALL=2;	//整十数除以整十数的口算
	  final private int SEVENDIV=3;  //几百几十乘一位数的口算方法
	  final private int DIVSPACE=4;		//两位数乘一位数的口算方法
	  private String []intent_content={"两位数乘一位数的口算方法","几百几十乘一位数的口算方法","整十数除以整十数的口算","几百几十除以整十数的口算"};
	  /**
	   * 把activity造型为FragmentActivity
	   */
	  @Override
	  public void onAttach(Activity activity) {
	    // TODO Auto-generated method stub
	    super.onAttach(activity);
	    this.activity = (FragmentActivity) activity;
	  }

	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    //设置布局
	   view = inflater.inflate(R.layout.grade_4_top, container,
	        false);
	   init();
	   ListenEvent();
	   refreshData();
	 //得到关于实现粉色的数据
	   getData();
	   if(show_num==-1)
		   setAllBlue();
	   else{
		   setAllBlue();
		   setStartColor(show_num);
	   }
	    return view;
	  }

	  public void init(){
		  tv1=(view)view.findViewById(R.id.grade_4_top_11);
		  
		  
		  tv2=(view)view.findViewById(R.id.grade_4_top_12);
		  
		  
		  tv3=(view)view.findViewById(R.id.grade_4_top_21);
		  
		  tv4=(view)view.findViewById(R.id.grade_4_top_22);
		  
		  tv1.setText(intent_content[0]);
		  tv2.setText(intent_content[1]);
		  tv3.setText(intent_content[2]);
		  tv4.setText(intent_content[3]);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],DIVSPACE);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],SEVENDIV);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],CANDIVALL);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],MULANDDIV);    
				}
			});  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_4_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivityForResult(intent,type);   
	  }
	  
	  
	  /*重新从文件中读取最大值*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="40"+type;   //不同年级的修改
	  	SharedPreferences sharedPreferences= getActivity().getSharedPreferences(name, 
	  				Activity.MODE_PRIVATE); 
	  	int top_grade=sharedPreferences.getInt("first_grade"+intent_type, 0); 
	  	judgeGrade(top_grade,tv);
	  }
	  
	  
	  
	  //设置星星的个数
	  public void judgeGrade(int topGrade,view tv){
		  if(topGrade/20 <6)
			  tv.setStarNum((int)(topGrade/20));
		  else{
			  tv.setStarNum(5);
		  }
	  }
	  
	  
	  /*接受下一个界面返回的值*/
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
			
			
			setData(requestCode);
			
			
			Log.i("lalala", "onActivity()");
			switch(requestCode){
				case DIVSPACE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv1,DIVSPACE);
					tv1.setColor(true);
					break;
				case SEVENDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv2,SEVENDIV);
					tv2.setColor(true);
					break;
				case CANDIVALL:
					Log.i("lalala", "onActivity().in");
					setGrade(tv3,CANDIVALL);
					tv3.setColor(true);
					break;
				case MULANDDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv4,MULANDDIV);
					tv4.setColor(true);
					break;
			
			}
		}
		  
		 //进入界面之后的更新星星的个数
		 public  void refreshData(){
			 setGrade(tv1,DIVSPACE);
			 setGrade(tv2,SEVENDIV);
			 setGrade(tv3,CANDIVALL);
			 setGrade(tv4,MULANDDIV);
		  }
		 
		 
		 /*全部清空为蓝色*/
		 public void setAllBlue(){
			 tv1.setColor(false);
			 tv2.setColor(false);
			 tv3.setColor(false);
			 tv4.setColor(false);
		 }
		 
		 /*显示开始的图片颜色*/
		 public void setStartColor(int num){
			 switch(num){
			 case DIVSPACE:
					
					tv1.setColor(true);
					break;
				case SEVENDIV:
					
					tv2.setColor(true);
					break;
				case CANDIVALL:
					
					tv3.setColor(true);
					break;
				case MULANDDIV:
					
					tv4.setColor(true);
					break;
		 }
		 }

	//设置文件中数据
		public void setData(int requestCode){
			String name="test";
	  		SharedPreferences mySharedPreferences= getActivity().getSharedPreferences(name, 
	  		Activity.MODE_PRIVATE); 
	  		//实例化SharedPreferences.Editor对象（第二步） 
	  		SharedPreferences.Editor editor = mySharedPreferences.edit(); 
	  		//用putString的方法保存数据 
	  		editor.putInt("grade_1_top", -1); 
	  		editor.putInt("grade_1_down",-1);
	  		editor.putInt("grade_2_top",-1);
	  		editor.putInt("grade_2_down",-1);
	  		editor.putInt("grade_3_top",-1);
	  		editor.putInt("grade_3_down",-1);
	  		editor.putInt("grade_4_top",requestCode);
	  		editor.putInt("grade_4_down",-1);
	  		editor.putInt("grade_5_top",-1);
	  		editor.putInt("grade_5_down",-1);
	  		editor.putInt("grade_6_top",-1);
	  		//提交当前数据 
	  		editor.commit(); 
			}
		
		//获取文件中的是否为粉色的数据
		public void getData(){
			String name="test";
	  		SharedPreferences mySharedPreferences= getActivity().getSharedPreferences(name, 
	  		Activity.MODE_PRIVATE); 
	  		show_num =mySharedPreferences.getInt("grade_4_top", -1); 
		}
		
	  
	  }

	  
	  
