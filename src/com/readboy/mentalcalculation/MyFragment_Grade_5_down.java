package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_5_down extends Fragment{
	 private FragmentActivity activity;
	  TextView tv;
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
	    View view = inflater.inflate(R.layout.grade_5_down, container,
	        false);
	    
	    //查找控件并设置点击事件
	   
	      
	    //查找控件并设置点击事件
	    
	    return view;
	  }

}
