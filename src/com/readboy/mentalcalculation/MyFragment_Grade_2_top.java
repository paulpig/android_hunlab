package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_top;

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
	  private String []intent_content={"加法的计算方法"};
	  
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
	    View view = inflater.inflate(R.layout.grade_2_top, container,
	        false);
	    
	    //五以内的加法
	   /* tv=(TextView)view.findViewById(R.id.item_1_textview3);
	    tv.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				 tv.setText("nihao");
				 Intent intent = new Intent();  
	             intent.setClass(getActivity(), Grade_1_top.class);  
	             intent.putExtra("content",intent_content[0] );
	             intent.putExtra("type", ADDADD);
	             startActivity(intent);      
			}
		});*/
	      
	    //五以内的减法
	    
	    
	    
	    
	    //0的计算（1）
	    
	    
	    
	    
	    //0的计算（2）
	    
	    
	    
	    return view;
	  }

	  }

	  
	  
