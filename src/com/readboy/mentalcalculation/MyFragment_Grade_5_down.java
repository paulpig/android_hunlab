package com.readboy.mentalcalculation;

import com.readboy.game.Grade_5.Grade_5_down;
import com.readboy.game.Grade_5.Grade_5_top;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class MyFragment_Grade_5_down extends Fragment{
	 private FragmentActivity activity;
	 private int show_num=-1;
	  view tv;
	  View view;
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
	  private view tv13;
	  final private int MULANDDIV=1;  //分数加法的含义和同分母分数加法的计算方法
	  final private int CANDIVALL=2;	//分数加法的简算
	  final private int SEVENDIV=3;  //分数加减混合运算的运算顺序
	  final private int DIVSPACE=4;		//分数减法的含义和同分母分数减法的计算方法
	  final private int DIVWAY=5;		//同分母分数连加、连减的计算方法
	  final private int MULDIV=6;		//异分母分数加、减法的计算方法
	  
	  
	  final private int  MULANDADD=7;		//分数化成小数的方法
	  final private int NULANDSUB=8;		//求两个数最大公因数的方法
	  final private int ADDANDSUB=9;		//求两个数最小公倍数的方法
	  
	  
	  final private int SMALLBRACKET=10;		//长方体表面积的计算方法
	  final private int UNKOWNNUM=11;		//长方体的体积的计算公式
	  final private int ADDTHENSUB=12;		//正方体表面积的计算方法
	  final private int SUBTHENADD=13;		//正方体的体积公式
	  final String[]intent_content={"长方体表面积的计算方法","正方体表面积的计算方法","长方体的体积的计算公式","正方体的体积公式",
			  						"求两个数最大公因数的方法","求两个数最小公倍数的方法","分数化成小数的方法",
			  						"分数加法的含义和同分母分数加法的计算方法","分数减法的含义和同分母分数减法的计算方法","同分母分数连加、连减的计算方法",
			  						"异分母分数加、减法的计算方法","分数加减混合运算的运算顺序","分数加法的简算"};
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
		  view = inflater.inflate(R.layout.grade_5_down, container,
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
		  tv1=(view)view.findViewById(R.id.grade_5_down_11);
		  tv2=(view)view.findViewById(R.id.grade_5_down_12);
		  tv3=(view)view.findViewById(R.id.grade_5_down_13);
		  tv4=(view)view.findViewById(R.id.grade_5_down_14);
		  
		  
		  tv5=(view)view.findViewById(R.id.grade_5_down_21);
		  tv6=(view)view.findViewById(R.id.grade_5_down_22);
		  tv7=(view)view.findViewById(R.id.grade_5_down_23);
		  
		  tv8=(view)view.findViewById(R.id.grade_5_down_31);
		  tv9=(view)view.findViewById(R.id.grade_5_down_32);
		  tv10=(view)view.findViewById(R.id.grade_5_down_33); 
		  tv11=(view)view.findViewById(R.id.grade_5_down_34);
		  tv12=(view)view.findViewById(R.id.grade_5_down_35);
		  tv13=(view)view.findViewById(R.id.grade_5_down_36);
		  
		  
		  
		  
		  tv1.setText(intent_content[0]);
		  tv2.setText(intent_content[1]);
		  tv3.setText(intent_content[2]);
		  tv4.setText(intent_content[3]);
		  
		  tv5.setText(intent_content[4]);
		  tv6.setText(intent_content[5]);
		  tv7.setText(intent_content[6]);
		  tv8.setText(intent_content[7]);
		  tv9.setText(intent_content[8]);
		  tv10.setText(intent_content[9]);
		  tv11.setText(intent_content[10]);
		  tv12.setText(intent_content[11]);
		  tv13.setText(intent_content[12]);
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],SMALLBRACKET);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],ADDTHENSUB);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],UNKOWNNUM);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],SUBTHENADD);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],NULANDSUB);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],ADDANDSUB);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],MULANDADD);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],MULANDDIV);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],DIVSPACE);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],DIVWAY);     
				}
			});
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],MULDIV);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],SEVENDIV);    
				}
			});
		  tv13.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[12],CANDIVALL);     
				}
			});
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_5_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivityForResult(intent,type);   
	  }
	  
	  
	  /*重新从文件中读取最大值*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="51"+type;   //不同年级的修改
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
			Log.i("lalala", "onActivity()");
			
			setData(requestCode);
			
			
			switch(requestCode){
				case SMALLBRACKET:
					Log.i("lalala", "onActivity().in");
					setGrade(tv1,SMALLBRACKET);
					tv1.setColor(true);
					break;
				case ADDTHENSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv2,ADDTHENSUB);
					tv2.setColor(true);
					break;
				case UNKOWNNUM:
					Log.i("lalala", "onActivity().in");
					setGrade(tv3,UNKOWNNUM);
					tv3.setColor(true);
					break;
				case SUBTHENADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv4,SUBTHENADD);
					tv4.setColor(true);
					break;
				case NULANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv5,NULANDSUB);
					tv5.setColor(true);
					break;
				case ADDANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv6,ADDANDSUB);
					tv6.setColor(true);
					break;
				case MULANDADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv7,MULANDADD);
					tv7.setColor(true);
					break;
				case MULANDDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv8,MULANDDIV);
					tv8.setColor(true);
					break;
				case DIVSPACE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv9,DIVSPACE);
					tv9.setColor(true);
					break;
				case DIVWAY:
					Log.i("lalala", "onActivity().in");
					setGrade(tv10,DIVWAY);
					tv10.setColor(true);
					break;
				case MULDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv11,MULDIV);
					tv11.setColor(true);
					break;
				case SEVENDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv12,SEVENDIV);
					tv12.setColor(true);
					break;
				case CANDIVALL:
					Log.i("lalala", "onActivity().in");
					setGrade(tv13,CANDIVALL);
					tv13.setColor(true);
					break;
			}
		}
		  
		 //进入界面之后的更新星星的个数
		 public  void refreshData(){
			 setGrade(tv1,SMALLBRACKET);
			 setGrade(tv2,ADDTHENSUB);
			 setGrade(tv3,UNKOWNNUM);
			 setGrade(tv4,SUBTHENADD);
			 setGrade(tv5,NULANDSUB);
			 setGrade(tv6,ADDANDSUB);
			 setGrade(tv7,MULANDADD);
			 setGrade(tv8,MULANDDIV);
			 setGrade(tv9,DIVSPACE);
			 setGrade(tv10,DIVWAY);
			 setGrade(tv11,MULDIV);
			 setGrade(tv12,SEVENDIV);
			 setGrade(tv13,CANDIVALL);
		  }
		 
		 
		 /*全部清空为蓝色*/
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
			 tv13.setColor(false);
		 }
		 
		 /*显示开始的图片颜色*/
		 public void setStartColor(int num){
			 switch(num){
				case SMALLBRACKET:
				
					tv1.setColor(true);
					break;
				case ADDTHENSUB:
				
					tv2.setColor(true);
					break;
				case UNKOWNNUM:
					
					tv3.setColor(true);
					break;
				case SUBTHENADD:
					
					tv4.setColor(true);
					break;
				case NULANDSUB:
					
					tv5.setColor(true);
					break;
				case ADDANDSUB:
					
					tv6.setColor(true);
					break;
				case MULANDADD:
				
					tv7.setColor(true);
					break;
				case MULANDDIV:
					
					tv8.setColor(true);
					break;
				case DIVSPACE:
					
					tv9.setColor(true);
					break;
				case DIVWAY:
					
					tv10.setColor(true);
					break;
				case MULDIV:
					
					tv11.setColor(true);
					break;
				case SEVENDIV:
					
					tv12.setColor(true);
					break;
				case CANDIVALL:
					
					tv13.setColor(true);
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
	  		editor.putInt("grade_4_top",-1);
	  		editor.putInt("grade_4_down",-1);
	  		editor.putInt("grade_5_top",-1);
	  		editor.putInt("grade_5_down",requestCode);
	  		editor.putInt("grade_6_top",-1);
	  		//提交当前数据 
	  		editor.commit(); 
			}
		
		//获取文件中的是否为粉色的数据
		public void getData(){
			String name="test";
	  		SharedPreferences mySharedPreferences= getActivity().getSharedPreferences(name, 
	  		Activity.MODE_PRIVATE); 
	  		show_num =mySharedPreferences.getInt("grade_5_down", -1); 
		}
		
	  
}
