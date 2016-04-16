package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_top;
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

public class MyFragment_Grade_2_top extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
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
	  private TextView tv16;
	  private TextView tv17;
	  private TextView tv18;
	  private TextView tv19;
	  View view;
	  private String []intent_content={"不进位加法","进位加法","不退位减法",
			  							"退位减法","连加","连减",
			  							"加减混合",
			  							"乘法是相同的数相加的简便算法","5的乘法口诀","2的乘法口诀",
			  							"3的乘法口诀","4的乘法口诀","乘加、乘减"
			  							,"6的乘法口诀",
			  							"7的乘法口诀","求一个数的几倍是多少的问题的计算方法","8的乘法口诀"
			  							,"9的乘法口诀","乘法口诀表"};
	  
	  final private int NOINADD=1;  //100以内不进位加法
	  final private int NOINSUB=2;	//100以内不退位减法
	  final private int ADDANDSUB=3;  //加减混合
	  final private int INADD=4;		//进位加法
	  final private int ADDADD=5;		//连加
	  final private int SUBSUB=6;		//连减
	  final private int  INSUB=7;		//退位减法
	  
	  
	  final private int MULFORSEVEN=8;		//7的乘法口诀
	  final private int MULFOREIGHT=9;		//8的乘法口诀
	  final private int MULFORNINE=10;		//9的乘法口诀
	  final private int MULTABLE=11;				//乘法口诀表
	  final private int NUMDOUBLE=12;			//求一个数的几倍是多少的问题的计算方法
	  
	  
	  final private int MULFORTWO=13;		//2的乘法口诀
	  final private int MULFORTHREE=14;		//3的乘法口诀
	  final private int MULFORFOUR=15;		//4的乘法口诀
	  final private int MULFORFIVE=16;		//5的乘法口诀
	  final private int MULFORSIX=17;		//6的乘法口诀
	  final private int MULISADD=18;				//乘法是相同的数相加的简便运算
	  final private int NULLADDSUB=19;			//乘加乘减
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
	    view = inflater.inflate(R.layout.grade_2_top, container,
	        false);
	    init();
	    ListenEvent();
	    return view;
	  }
	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_2_top_11);
		  tv2=(TextView)view.findViewById(R.id.grade_2_top_12);
		  tv3=(TextView)view.findViewById(R.id.grade_2_top_13);
		  tv4=(TextView)view.findViewById(R.id.grade_2_top_14);
		  tv5=(TextView)view.findViewById(R.id.grade_2_top_15);
		  tv6=(TextView)view.findViewById(R.id.grade_2_top_16);
		  tv7=(TextView)view.findViewById(R.id.grade_2_top_17);
		  
		  
		  tv8=(TextView)view.findViewById(R.id.grade_2_top_21);
		  tv9=(TextView)view.findViewById(R.id.grade_2_top_22);
		  tv10=(TextView)view.findViewById(R.id.grade_2_top_23);
		  tv11=(TextView)view.findViewById(R.id.grade_2_top_24);
		  tv12=(TextView)view.findViewById(R.id.grade_2_top_25);
		  tv13=(TextView)view.findViewById(R.id.grade_2_top_26);
		  tv14=(TextView)view.findViewById(R.id.grade_2_top_27);
		  
		  tv15=(TextView)view.findViewById(R.id.grade_2_top_31);
		  tv16=(TextView)view.findViewById(R.id.grade_2_top_32);
		  tv17=(TextView)view.findViewById(R.id.grade_2_top_33);
		  tv18=(TextView)view.findViewById(R.id.grade_2_top_34);
		  tv19=(TextView)view.findViewById(R.id.grade_2_top_35);
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],NOINADD);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],INADD);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],NOINSUB);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],INSUB);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],ADDADD);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],SUBSUB);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],ADDANDSUB);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],MULISADD);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],MULFORFIVE);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],MULFORTWO);     
				}
			});
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],MULFORTHREE);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],MULFORFOUR);    
				}
			});
		  tv13.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[12],NULLADDSUB);     
				}
			});
		  tv14.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[13],MULFORSIX);     
				}
			});
		  tv15.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[14],MULFORSEVEN);    
				}
			});
		  tv16.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[15],NUMDOUBLE);     
				}
			});
		  tv17.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[16],MULFOREIGHT);     
				}
			});
		  tv18.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[17],MULFORNINE);     
				}
			});
		  tv19.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[18],MULTABLE);    
				}
			});
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_2_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }

	  }

	  
	  
