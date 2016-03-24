package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_5_top extends Fragment{
	 private FragmentActivity activity;
	  TextView tv;
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
	  final private int UNKOWNNUM=11;		//小数乘整数的算理及计算方法
	  final private int ADDTHENSUB=12;		//小数连乘的运算顺序
	  
	  
	  final private int SUBTHENADD=13;		//被除数的整数部分不够除的计算方法
	  final private int ADDFOREIGHT=14;		//除到被除数末尾仍有余数的小数的计算方法
	  final private int TENADD=15;				//小数除以整数的计算方法
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
	    View view = inflater.inflate(R.layout.grade_5_top, container,
	        false);
	    
	    //查找控件并设置点击事件
	   
	      
	    //查找控件并设置点击事件
	    
	    return view;
	  }

}
