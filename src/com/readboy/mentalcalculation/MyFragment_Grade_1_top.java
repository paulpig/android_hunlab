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

public class MyFragment_Grade_1_top extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
	  private String []intent_content={"加法的计算方法"};
	  
	  final private int ADDINFIVE=1;  //5以内的加法
	  final private int SUBINFIVE=2;	//5以内的减法
	  final private int ZEROONE=3;		//0的计算1
	  final private int ZERTWO=4;		//0的计算2
	  
	  
	  
	  final private int ADDINFIVEANDSIX=5;  //6和7的加减法
	  final private int ADDFORNINE=6;		//9的加减法
	  final private int ADDINNINE=7;		//9以内的加减法
	  final private int ADDFORTEN=8;		//10的加减法
	  final private int  CONTINUEADD=9;		//连加
	  final private int CONTINUESUD=10;		//连减
	  final private int UNKOWNNUM=11;		//填未知数
	  final private int ADDTHENSUB=12;		//先加后减
	  final private int SUBTHENADD=13;		//先减后加
	  final private int ADDFOREIGHT=14;		//一图四式和8的加减法
	  
	  
	  
	  final private int TENADD=15;				//十加几
	  final private int ADDNAME=16;			//加减法算式的各部分名称
	  final private int ADDFORTWI=17;			//十几加几和相应的减法
	  
	  final private int NINEADDWHAT=18;		//9加几的计算方法
	  final private int SEVENEIGHT=19;			//876加几的计算方法
	  final private int FIVETOTWO=20;			//5432加几的计算方法
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
	    View view = inflater.inflate(R.layout.grade_1_top, container,
	        false);
	    
	    //五以内的加法
	    tv=(TextView)view.findViewById(R.id.grade_1_top_11);
	    tv.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				 Intent intent = new Intent();  
	             intent.setClass(getActivity(), Grade_1_top.class);  
	             intent.putExtra("content",intent_content[0]);
	             intent.putExtra("type", ADDINFIVE);
	             startActivity(intent);      
			}
		});
	      
	    //五以内的减法
	    
	    
	    
	    
	    //0的计算（1）
	    
	    
	    
	    
	    //0的计算（2）
	    
	    
	    
	    return view;
	  }

	  }

	  
	  
