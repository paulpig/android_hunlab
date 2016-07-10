package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_down;
import com.readboy.game.Grade_1.Grade_1_top;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MyFragment_Grade_1_down extends Fragment {
	  private FragmentActivity activity;
	  private int show_num=-1;
	  private view tv;
	  View view;
	  String whichChoose;
	  private view tv1;
	  private view tv2;
	  private view tv3;
	  private view tv4;
	  private view tv5;
	  private view tv6;
	  private view tv7;
	  private view tv8;
	  private view tv9;
	  private view tv10;
	  private view tv11;
	  private view tv12;
	  private String []intent_content={"十几减9的计算方法","十几减几的计算方法",
			  "整十数加一位数的计算方法","与整十数加一位数对应的减法计算方法",
			  "整数数加整十数的计算方法","整十数减整十数的计算方法","两位数加一位数（不进位）的计算方法",
			  "两位数加整十数的计算方法","两位数加一位数（进位）的计算方法","两位数减一位数（不退位）的计算方法",
			  "整十数减整十数的计算方法","两位数减一位数（退位）的计算方法"};
	  
	  final private int TENSUBNINE=1;  //十几减9 的计算方法
	  final private int TENSUBWHAT=2;	//十几减几的计算方法
	  
	  
	  final private int NOTWOADDONE=3;  //两位数加一位数（不进位）的计算方法
	  final private int TWOADDONE=4;		//两位数加一位数（进位）的计算方法
	  final private int TWOADDTEN=5;		//两位数加整十数的计算方法
	  final private int NOTWOSUBONE=6;		//两位数减一位数（不退位）的计算方法
	  final private int  TWOSUBONE=7;		//两位数减一位数（退位）的计算方法
	  final private int TWOSUBTEN=8;		//两位数减整十数的计算方法
	  final private int TENADDTEN=9;		//整十数加整十数的计算方法
	  final private int TENSUBTEN=10;		//整十数减整十数的计算方法
	  
	  
	  
	  final private int TWOSUBTHIS=11;			//与整十数加一位数对应的减法计算方法
	  final private int TENADDONE=12;			//整十数加一位数的计算方法
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
	    view = inflater.inflate(R.layout.grade_1_down, container,
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
		  tv1=(view)view.findViewById(R.id.grade_1_down_11);
		  tv1.setText(intent_content[0]);
		  tv2=(view)view.findViewById(R.id.grade_1_down_12);
		  tv2.setText(intent_content[1]);
		  
		  
		  tv3=(view)view.findViewById(R.id.grade_1_down_21);
		  tv3.setText(intent_content[2]);
		  tv4=(view)view.findViewById(R.id.grade_1_down_22);
		  tv4.setText(intent_content[3]);
		  
		  tv5=(view)view.findViewById(R.id.grade_1_down_31);
		  tv5.setText(intent_content[4]);
		  tv6=(view)view.findViewById(R.id.grade_1_down_32);
		  tv6.setText(intent_content[5]);
		  tv7=(view)view.findViewById(R.id.grade_1_down_33);
		  tv7.setText(intent_content[6]);
		  tv8=(view)view.findViewById(R.id.grade_1_down_34);
		  tv8.setText(intent_content[7]);
		  tv9=(view)view.findViewById(R.id.grade_1_down_35);
		  tv9.setText(intent_content[8]);
		  tv10=(view)view.findViewById(R.id.grade_1_down_36);
		  tv10.setText(intent_content[9]);
		  tv11=(view)view.findViewById(R.id.grade_1_down_37);
		  tv11.setText(intent_content[10]);
		  tv12=(view)view.findViewById(R.id.grade_1_down_38);
		  tv12.setText(intent_content[11]);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],TENSUBNINE);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],TENSUBWHAT);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],TENADDONE);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],TWOSUBTHIS);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],TENADDTEN);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],TENSUBTEN);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],NOTWOADDONE);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],TWOADDTEN);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],TWOADDONE);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],NOTWOSUBONE);     
				}
			});
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],TWOSUBTEN);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],TWOSUBONE);    
				}
			});
		  
		 
		  
	  }
	  
	  /*重新从文件中读取最大值*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="11"+type;   //不同年级的修改
	  	SharedPreferences sharedPreferences= getActivity().getSharedPreferences(name, 
	  				Activity.MODE_PRIVATE); 
	  				// 使用getString方法获得value，注意第2个参数是value的默认值 
	  	int top_grade=sharedPreferences.getInt("fist_grade"+intent_type, 0);
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
	  
	  
	  
	  /*跳转到游戏界面*/
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_1_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivityForResult(intent,type);    
	  }
	 
	  
	  
	 /*接受下一个界面返回的值*/
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.i("lalala", "onActivity()");
		
		setData(requestCode);
		
		
		switch(requestCode){
			case TENSUBNINE:
				Log.i("lalala", "onActivity().in");
				setGrade(tv1,TENSUBNINE);
				tv1.setColor(true);
				break;
			case TENSUBWHAT:
				setGrade(tv2,TENSUBWHAT);
				tv2.setColor(true);
				break;
			case TENADDONE:
				Log.i("lalala", "onActivity().in");
				 setGrade(tv3,TENADDONE);
				 tv3.setColor(true);
				break;
			case TWOSUBTHIS:
				setGrade(tv4,TWOSUBTHIS);
				tv4.setColor(true);
				break;
			case TENADDTEN:
				Log.i("lalala", "onActivity().in");
				 setGrade(tv5,TENADDTEN);
				 tv5.setColor(true);
				break;
			case TENSUBTEN:
				 setGrade(tv6,TENSUBTEN);
				 tv6.setColor(true);
				break;
				
			case NOTWOADDONE:
				Log.i("lalala", "onActivity().in");
				 setGrade(tv7,NOTWOADDONE);
				 tv7.setColor(true);
				break;
			case TWOADDTEN:
				setGrade(tv8,TWOADDTEN);
				tv8.setColor(true);
				break;
			case TWOADDONE:
				Log.i("lalala", "onActivity().in");
				 setGrade(tv9,TWOADDONE);
				 tv9.setColor(true);
				break;
			case NOTWOSUBONE:
				setGrade(tv10,NOTWOSUBONE);
				tv10.setColor(true);
				break;
			case TWOSUBTEN:
				Log.i("lalala", "onActivity().in");
				setGrade(tv11,TWOSUBTEN);
				tv11.setColor(true);
				break;
			case TWOSUBONE:
				setGrade(tv12,TWOSUBONE);
				tv12.setColor(true);
				break;
		}
	}
	  
	  
	 public  void refreshData(){
		 setGrade(tv1,TENSUBNINE);
		 setGrade(tv2,TENSUBWHAT);
		 setGrade(tv3,TENADDONE);
		 setGrade(tv4,TWOSUBTHIS);
		 setGrade(tv5,TENADDTEN);
		 setGrade(tv6,TENSUBTEN);
		 setGrade(tv7,NOTWOADDONE);
		 setGrade(tv8,TWOADDTEN);
		 setGrade(tv9,TWOADDONE);
		 setGrade(tv10,NOTWOSUBONE);
		 setGrade(tv11,TWOSUBTEN);
		 setGrade(tv12,TWOSUBONE);
	  }
	 
	 
	 /*显示开始的图片颜色*/
	 public void setStartColor(int num){
		 switch(num){
			case TENSUBNINE:
				tv1.setColor(true);
				break;
			case TENSUBWHAT:
				
				tv2.setColor(true);
				break;
			case TENADDONE:
				
				 tv3.setColor(true);
				break;
			case TWOSUBTHIS:
				
				tv4.setColor(true);
				break;
			case TENADDTEN:
				
				 tv5.setColor(true);
				break;
			case TENSUBTEN:
				
				 tv6.setColor(true);
				break;
				
			case NOTWOADDONE:
				
				 tv7.setColor(true);
				break;
			case TWOADDTEN:
				
				tv8.setColor(true);
				break;
			case TWOADDONE:
				
				 tv9.setColor(true);
				break;
			case NOTWOSUBONE:
				
				tv10.setColor(true);
				break;
			case TWOSUBTEN:
				
				tv11.setColor(true);
				break;
			case TWOSUBONE:
				tv12.setColor(true);
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
  		editor.putInt("grade_1_down",requestCode);
  		editor.putInt("grade_2_top",-1);
  		editor.putInt("grade_2_down",-1);
  		editor.putInt("grade_3_top",-1);
  		editor.putInt("grade_3_down",-1);
  		editor.putInt("grade_4_top",-1);
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
  		show_num =mySharedPreferences.getInt("grade_1_down", -1); 
	}
	
	
	 public void setAllBlue(){
		 tv1.setColor(false);
		 tv2.setColor(false);
		 tv3.setColor(false);
		 tv4.setColor(false);
		 tv5.setColor(false);
		 tv6.setColor(false);
		 tv7.setColor(false);
		 tv8.setColor(false);
		 tv9.setColor(false);
		 tv10.setColor(false);
		 tv11.setColor(false);
		 tv12.setColor(false);
	 }
	
	  }

	  
	  
