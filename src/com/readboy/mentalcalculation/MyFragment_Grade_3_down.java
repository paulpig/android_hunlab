package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_3_down extends Fragment {
	 private FragmentActivity activity;
	  TextView tv;
	  final private int MULANDDIV=1;  //商末尾有0的除法的计算方法（商中有余数）
	  final private int CANDIVALL=2;	//商末尾有0的除法计算方法（商没有余数）
	  final private int SEVENDIV=3;  //商中间有0的除法的计算方法（除的过程有余数）
	  final private int DIVSPACE=4;		//商中间有0的除法的计算方法（除的过程中没有余数）
	  final private int DIVWAY=5;		//一位数除两位数（被除数各数位上都能被整除）的计算方法
	  final private int MULDIV=6;		//用一位数除商是整十、整百、整千的口算方法
	  final private int  MULANDADD=7;		//有关0的除法
	  
	  
	  
	  final private int NULANDSUB=8;		//用乘法两步计算解决问题
	  
	  
	  final private int ADDANDSUB=9;		//两位数乘两位数（不进位）的笔算方法
	  
	  
	  final private int SMALLBRACKET=10;		//平均数的含义及求平均数的方法
	  
	  
	  
	  final private int BIGADD=11;				//小数加法的计算方法
	  final private int BIGDIV=12;				//小数减法的计算方法
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
	    View view = inflater.inflate(R.layout.grade_3_down, container,
	        false);
	    
	    //查找控件并设置点击事件
	   
	      
	    //查找控件并设置点击事件
	    
	    return view;
	  }

}
