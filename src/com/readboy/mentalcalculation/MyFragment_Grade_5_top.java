package com.readboy.mentalcalculation;

import com.readboy.game.Grade_1.Grade_1_top;
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

public class MyFragment_Grade_5_top extends Fragment{
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
	  private TextView tv14;
	  private TextView tv15;
	  final private int MULANDDIV=1;  //平行四边形的面积计算公式
	  final private int CANDIVALL=2;	//三角形面积的相关计算
	  final private int SEVENDIV=3;  //梯形的面积计算公式的应用
	  
	  
	  final private int DIVSPACE=4;		//形如ax+ab=c的方程的解法及其应用
	  final private int DIVWAY=5;		//形如ax+b=c的方程的解法及其应用
	  final private int MULDIV=6;		//形如ax=b的方程的解法
	  final private int  MULANDADD=7;		//形如ax±bx=c的方程的解法	
	  final private int NULANDSUB=8;		//形如ax-b=c的方程的解法及其应用
	  final private int ADDANDSUB=9;		//形如x±a=b的方程的解法
	  
	  
	  final private int SMALLBRACKET=10;		//小数乘整数的计算方法
	  final private int UNKOWNNUM=11;		//小数乘小数的算理及计算方法
	  final private int ADDTHENSUB=12;		//小数连乘的运算顺序
	  
	  
	  final private int SUBTHENADD=13;		//被除数的整数部分不够除的计算方法
	  final private int ADDFOREIGHT=14;		//除到被除数末尾仍有余数的小数的计算方法
	  final private int TENADD=15;				//小数除以整数的计算方法
	  final private String []intent_content={"小数乘整数的计算方法","小数乘小数的算理及计算方法","小数连乘的运算顺序",
			  									"小数除以整数的计算方法","被除数的整数部分不够除的计算方法","除到被除数末尾仍有余数的小数的计算方法",
			  									"形如x±a=b的方程的解法","形如ax=b的方程的解法","形如ax+b=c的方程的解法及其应用",
			  									"形如ax-b=c的方程的解法及其应用","形如ax+ab=c的方程的解法及其应用","形如ax±bx=c的方程的解法",
			  									"平行四边形的面积计算公式","三角形面积的相关计算","梯形的面积计算公式的应用"};
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
	   view = inflater.inflate(R.layout.grade_5_top, container,
	        false);
	    init();
	    ListenEvent();
	    
	    return view;
	  }
	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_5_top_11);
		  tv2=(TextView)view.findViewById(R.id.grade_5_top_12);
		  tv3=(TextView)view.findViewById(R.id.grade_5_top_13);
		  
		  
		  tv4=(TextView)view.findViewById(R.id.grade_5_top_21);
		  tv5=(TextView)view.findViewById(R.id.grade_5_top_22);
		  tv6=(TextView)view.findViewById(R.id.grade_5_top_23);
		  
		  tv7=(TextView)view.findViewById(R.id.grade_5_top_31);
		  tv8=(TextView)view.findViewById(R.id.grade_5_top_32);
		  tv9=(TextView)view.findViewById(R.id.grade_5_top_33);
		  tv10=(TextView)view.findViewById(R.id.grade_5_top_34); 
		  tv11=(TextView)view.findViewById(R.id.grade_5_top_35);
		  tv12=(TextView)view.findViewById(R.id.grade_5_top_36);
		  
		  
		  tv13=(TextView)view.findViewById(R.id.grade_5_top_41);
		  tv14=(TextView)view.findViewById(R.id.grade_5_top_42);
		  tv15=(TextView)view.findViewById(R.id.grade_5_top_43);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],SMALLBRACKET);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],UNKOWNNUM);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],ADDTHENSUB);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],TENADD);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],SUBTHENADD);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],ADDFOREIGHT);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],ADDANDSUB);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],MULDIV);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],DIVWAY);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],NULANDSUB);     
				}
			});
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],DIVSPACE);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],MULANDADD);    
				}
			});
		  tv13.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[12],MULANDDIV);     
				}
			});
		  tv14.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[13],CANDIVALL);     
				}
			});
		  tv15.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[14],SEVENDIV);    
				}
			});
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_5_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
}
