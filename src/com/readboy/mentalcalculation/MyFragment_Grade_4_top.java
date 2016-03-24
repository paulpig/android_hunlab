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

public class MyFragment_Grade_4_top extends Fragment {
	  private FragmentActivity activity;
	  TextView tv;
	  final private int MULANDDIV=1;  //几百几十除以整十数的口算
	  final private int CANDIVALL=2;	//整十数除以整十数的口算
	  final private int SEVENDIV=3;  //几百几十乘一位数的口算方法
	  final private int DIVSPACE=4;		//两位数乘一位数的口算方法
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
	    View view = inflater.inflate(R.layout.grade_4_top, container,
	        false);
	    
	    //查找控件并设置点击事件
	   
	    //查找控件并设置点击事件
	    
	    return view;
	  }

	  }

	  
	  
