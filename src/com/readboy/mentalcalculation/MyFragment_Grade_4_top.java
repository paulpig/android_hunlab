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
	  final private int MULANDDIV=1;  //���ټ�ʮ������ʮ���Ŀ���
	  final private int CANDIVALL=2;	//��ʮ��������ʮ���Ŀ���
	  final private int SEVENDIV=3;  //���ټ�ʮ��һλ���Ŀ��㷽��
	  final private int DIVSPACE=4;		//��λ����һλ���Ŀ��㷽��
	  /**
	   * ��activity����ΪFragmentActivity
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
	    //���ò���
	    View view = inflater.inflate(R.layout.grade_4_top, container,
	        false);
	    
	    //���ҿؼ������õ���¼�
	   
	    //���ҿؼ������õ���¼�
	    
	    return view;
	  }

	  }

	  
	  
