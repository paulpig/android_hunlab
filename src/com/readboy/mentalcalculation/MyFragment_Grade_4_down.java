package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_4_down extends Fragment {
	 private FragmentActivity activity;
	  TextView tv;
	  final private int MULANDDIV=1;  //有关0的运算
	  
	  
	  final private int CANDIVALL=2;	//乘法结合律
	  final private int SEVENDIV=3;  //加法交换律、加法结合律的运用
	  final private int DIVSPACE=4;		//加法结合律
	  final private int DIVWAY=5;		//连减的简便运算
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
	    View view = inflater.inflate(R.layout.grade_4_down, container,
	        false);
	    
	    //查找控件并设置点击事件
	   
	      
	    //查找控件并设置点击事件
	    
	    return view;
	  }

}
