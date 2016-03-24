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

public class MyFragment_Grade_2_down extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
	  private String []intent_content={"加法的计算方法"};
	  
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
	    View view = inflater.inflate(R.layout.grade_2_down, container,
	        false);
	    
	    //五以内的加法
	   /* tv=(TextView)view.findViewById(R.id.item_1_textview3);
	    tv.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				 tv.setText("nihao");
				 Intent intent = new Intent();  
	             intent.setClass(getActivity(), Grade_1_top.class);  
	             intent.putExtra("content",intent_content[0] );
	             intent.putExtra("type", SEVENDIV);
	             startActivity(intent);      
			}
		});*/
	      
	    //五以内的减法
	    
	    
	    
	    
	    //0的计算（1）
	    
	    
	    
	    
	    //0的计算（2）
	    
	    
	    
	    return view;
	  }

	  }

	  
	  
