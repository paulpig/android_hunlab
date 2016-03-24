package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_6_top extends Fragment{
	 private FragmentActivity activity;
	  TextView tv;
	  final private int MULANDDIV=1;  //分数乘分数的计算方法
	  final private int CANDIVALL=2;	//分数乘分数的简便运算
	  final private int SEVENDIV=3;  //分数乘整数的计算方法
	  final private int DIVSPACE=4;		//连续求一个数的几分之几是多少的问题的解法
	  
	  
	  final private int DIVWAY=5;		//分数除以整数的计算方法
	  final private int MULDIV=6;		//求比中未知项的方法
	  final private int  MULANDADD=7;		//一个数除以分数的计算方法
	  
	  
	  final private int NULANDSUB=8;		//圆的面积计算公式的应用
	  final private int ADDANDSUB=9;		//圆的周长计算公式
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
	    View view = inflater.inflate(R.layout.grade_6_top, container,
	        false);
	    
	    //查找控件并设置点击事件
	   
	      
	    //查找控件并设置点击事件
	    
	    return view;
	  }

}
