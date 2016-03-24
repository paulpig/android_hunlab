package com.readboy.mentalcalculation;

import android.app.Activity;
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

	  final private int MULANDDIV=1;  //两、三位数乘一位数不连续进位的笔算乘法
	  final private int CANDIVALL=2;	//两位数乘一位数不进位的笔算乘法
	  final private int SEVENDIV=3;  //末尾带0的三位数乘一位数
	  final private int DIVSPACE=4;		//中间带0 的三位数乘一位数
	  
	  
	  final private int DIVWAY=5;		//同分母分数加法
	  final private int MULDIV=6;		//同分母分数减法
	  final private int  MULANDADD=7;		//一减去几分之几
	  
	  
	  final private int NULANDSUB=8;		//长方形的周长
	  
	  
	  final private int ADDANDSUB=9;		//两位数加两位数的连续进位加法
	  
	  
	  final private int SMALLBRACKET=10;		//余数和除数的关系
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
	    View view = inflater.inflate(R.layout.grade_3_top, container,
	        false);
	    
	    //查找控件并设置点击事件
	   
	      
	    //查找控件并设置点击事件
	    
	    return view;
	  }

	  }

	  
	  
