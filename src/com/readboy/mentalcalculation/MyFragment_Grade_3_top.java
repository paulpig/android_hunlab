package com.readboy.mentalcalculation;

import com.readboy.game.Grade_1.Grade_1_top;
import com.readboy.game.Grade_3.Grade_3_top;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyFragment_Grade_3_top extends Fragment {
	  private FragmentActivity activity;
	  TextView tv;
	  View view ;
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
	  
	  final private int MULANDDIV=1;  //两、三位数乘一位数不连续进位的笔算乘法
	  final private int CANDIVALL=2;	//两位数乘一位数(不进位)的笔算乘法
	  final private int SEVENDIV=3;  //末尾带0的三位数乘一位数
	  final private int DIVSPACE=4;		//中间带0 的三位数乘一位数
	  
	  
	  final private int DIVWAY=5;		//同分母分数加法
	  final private int MULDIV=6;		//同分母分数减法
	  final private int  MULANDADD=7;		//一减去几分之几
	  
	  
	  final private int NULANDSUB=8;		//长方形的周长
	  
	  
	  final private int ADDANDSUB=9;		//两位数加两位数的连续进位加法
	  
	  
	  final private int SMALLBRACKET=10;		//余数和除数的关系
	  
	  private String []intent_content={"两位数加两位数的连续进位加法","长方形的周长","余数和除数的关系",
			  "两位数乘一位数(不进位)的笔算乘法","两、三位数乘一位数不连续进位的笔算乘法","中间带0 的三位数乘一位数","中间带0 的三位数乘一位数",
			  "同分母分数加法","同分母分数减法","一减去几分之几"};
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
	    view = inflater.inflate(R.layout.grade_3_top, container,
	        false);
	    init();
	    ListenEvent();
	    return view;
	  }

	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_3_top_11);
		  
		  
		  tv2=(TextView)view.findViewById(R.id.grade_3_top_21);
		  
		  
		  tv3=(TextView)view.findViewById(R.id.grade_3_top_31);
		  
		  tv4=(TextView)view.findViewById(R.id.grade_3_top_41);
		  tv5=(TextView)view.findViewById(R.id.grade_3_top_42);
		  tv6=(TextView)view.findViewById(R.id.grade_3_top_43);
		  tv7=(TextView)view.findViewById(R.id.grade_3_top_44);
		  
		  
		  tv8=(TextView)view.findViewById(R.id.grade_3_top_51);
		  tv9=(TextView)view.findViewById(R.id.grade_3_top_52);
		  tv10=(TextView)view.findViewById(R.id.grade_3_top_53);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],ADDANDSUB);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],NULANDSUB);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],SMALLBRACKET);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],CANDIVALL);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],MULANDDIV);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],DIVSPACE);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],SEVENDIV);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],DIVWAY);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],MULDIV);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],MULANDADD);     
				}
			});
		 
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_3_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
	  }

	  
	  
