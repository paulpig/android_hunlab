package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_top;
import com.readboy.game.Grade_2.Grade_2_down;
import com.readboy.game.Grade_2.Grade_2_top;

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

public class MyFragment_Grade_2_down extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
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
	  private TextView tv14;
	  private TextView tv15;
	  private String []intent_content={"用加法和减法两步计算解决问题","用小括号列综合算式解决问题","用乘法和加法两步计算解决问题","用乘法和减法两步计算解决问题",
			  							"除法算式各部分的名称","求商的方法","用乘法和除法两步计算解决问题",
			  							"用7、8、9的乘法口诀求商","求\"一个数是另一个数几倍\"的解题方法","乘除混合运算的顺序",
			  							"两位数加两位数口算方法","两位数减两位数的口算方法","几百几十加几百几十的计算方法","几百几十减几百几十的计算方法"};
	  
	  final private int MULANDDIV=1;  //乘除混合运算的顺序
	  final private int CANDIVALL=2;	//求一个数是另一个数几倍的解题方法
	  final private int SEVENDIV=3;  //用789的乘法口诀求商
	  
	  
	  final private int DIVSPACE=4;		//除法算式各部分的名称
	  final private int DIVWAY=5;		//求商的方法
	  final private int MULDIV=6;		//用乘法和除法两步计算解决问题
	  
	  
	  final private int  MULANDADD=7;		//用乘法和加法两步计算解决问题
	  final private int NULANDSUB=8;		//用乘法和减法两步计算解决问题
	  final private int ADDANDSUB=9;		//用加法和减法两步计算解决问题
	  final private int SMALLBRACKET=10;		//用小括号列综合算式解决问题
	  
	  
	  
	  final private int BIGADD=11;				//几百几十加几百几十的计算方法
	  final private int BIGDIV=12;			//几百几十减几百几十的计算方法
	  final private int MIDADD=13;				//两位数加两位数口算方法
	  final private int MIDDIV=14;			//两位数减两位数的口算方法
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
	    view = inflater.inflate(R.layout.grade_2_down, container,
	        false);
	    init();
	    ListenEvent();
	    return view;
	  }

	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_2_down_11);
		  tv2=(TextView)view.findViewById(R.id.grade_2_down_12);
		  tv3=(TextView)view.findViewById(R.id.grade_2_down_13);
		  tv4=(TextView)view.findViewById(R.id.grade_2_down_14);
		  
		  tv5=(TextView)view.findViewById(R.id.grade_2_down_21);
		  tv6=(TextView)view.findViewById(R.id.grade_2_down_22);
		  tv7=(TextView)view.findViewById(R.id.grade_2_down_23);
		  
		  
		  tv8=(TextView)view.findViewById(R.id.grade_2_down_31);
		  tv9=(TextView)view.findViewById(R.id.grade_2_down_32);
		  tv10=(TextView)view.findViewById(R.id.grade_2_down_33);
		  
		  tv11=(TextView)view.findViewById(R.id.grade_2_down_41);
		  tv12=(TextView)view.findViewById(R.id.grade_2_down_42);
		  tv13=(TextView)view.findViewById(R.id.grade_2_down_43);
		  tv14=(TextView)view.findViewById(R.id.grade_2_down_44);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],ADDANDSUB);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],SMALLBRACKET);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],MULANDADD);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],NULANDSUB);    
				}
			});
		  
		  
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],DIVSPACE);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],DIVWAY);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],MULDIV);     
				}
			});
		  
		  
		  
		  
		  
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],SEVENDIV);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],CANDIVALL);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],MULANDDIV);     
				}
			});
		  
		  
		  
		  
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],MIDADD);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],MIDDIV);    
				}
			});
		  
		  tv13.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[12],BIGADD);     
				}
			});
		  tv14.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[13],BIGDIV);     
				}
			});
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_2_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
	  }

	  
	  
