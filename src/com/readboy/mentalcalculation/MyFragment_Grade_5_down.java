package com.readboy.mentalcalculation;

import com.readboy.game.Grade_5.Grade_5_down;
import com.readboy.game.Grade_5.Grade_5_top;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MyFragment_Grade_5_down extends Fragment{
	 private FragmentActivity activity;
	  TextView tv;
	  View view;
	  private TextView tv1;
	  private TextView tv2;
	  private TextView tv3;
	  private TextView tv4;
	  private TextView tv5;
	  private TextView tv6;
	  private TextView tv7;
	  private TextView tv8;
	  private TextView tv9;
	  private TextView tv10;
	  private TextView tv11;
	  private TextView tv12;
	  private TextView tv13;
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
	    return view;
	  }
	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_5_down_11);
		  tv2=(TextView)view.findViewById(R.id.grade_5_down_12);
		  tv3=(TextView)view.findViewById(R.id.grade_5_down_13);
		  tv4=(TextView)view.findViewById(R.id.grade_5_down_14);
		  
		  
		  tv5=(TextView)view.findViewById(R.id.grade_5_down_21);
		  tv6=(TextView)view.findViewById(R.id.grade_5_down_22);
		  tv7=(TextView)view.findViewById(R.id.grade_5_down_23);
		  
		  tv8=(TextView)view.findViewById(R.id.grade_5_down_31);
		  tv9=(TextView)view.findViewById(R.id.grade_5_down_32);
		  tv10=(TextView)view.findViewById(R.id.grade_5_down_33); 
		  tv11=(TextView)view.findViewById(R.id.grade_5_down_34);
		  tv12=(TextView)view.findViewById(R.id.grade_5_down_35);
		  tv13=(TextView)view.findViewById(R.id.grade_5_down_36);
		  
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
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_5_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
}
