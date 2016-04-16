package com.readboy.mentalcalculation;

import com.readboy.game.Grade_4.Grade_4_top;

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

public class MyFragment_Grade_4_top extends Fragment {
	  private FragmentActivity activity;
	  TextView tv;
	  View view ;
	  private TextView tv1;
	  private TextView tv2;
	  private TextView tv3;
	  private TextView tv4;
	  final private int MULANDDIV=1;  //几百几十除以整十数的口算
	  final private int CANDIVALL=2;	//整十数除以整十数的口算
	  final private int SEVENDIV=3;  //几百几十乘一位数的口算方法
	  final private int DIVSPACE=4;		//两位数乘一位数的口算方法
	  private String []intent_content={"两位数乘一位数的口算方法","几百几十乘一位数的口算方法","整十数除以整十数的口算","几百几十除以整十数的口算"};
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
	   view = inflater.inflate(R.layout.grade_4_top, container,
	        false);
	   init();
	   ListenEvent();
	    return view;
	  }

	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_4_top_11);
		  
		  
		  tv2=(TextView)view.findViewById(R.id.grade_4_top_12);
		  
		  
		  tv3=(TextView)view.findViewById(R.id.grade_4_top_21);
		  
		  tv4=(TextView)view.findViewById(R.id.grade_4_top_22);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],DIVSPACE);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],SEVENDIV);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],CANDIVALL);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],MULANDDIV);    
				}
			});  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_4_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
	  }

	  
	  
