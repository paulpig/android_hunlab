package com.readboy.mentalcalculation;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_6_down extends Fragment{
	 private FragmentActivity activity;
	  TextView tv;
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
	    View view = inflater.inflate(R.layout.grade_6_down, container,
	        false);
	    
	    new  AlertDialog.Builder(getActivity())    
	  
	                    .setTitle("速算练习---六年级下册" )  
	     
	                    .setMessage("对不起，暂时没有相关数据" )  
	      
	                    .setPositiveButton("确定" ,  null )  
	      
	                    .show();  
	    
	    return view;
	  }

}
