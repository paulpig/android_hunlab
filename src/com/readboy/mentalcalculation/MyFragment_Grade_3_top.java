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

public class MyFragment_Grade_3_top extends Fragment {
	  private FragmentActivity activity;
	  TextView tv;

	  final private int MULANDDIV=1;  //������λ����һλ����������λ�ı���˷�
	  final private int CANDIVALL=2;	//��λ����һλ������λ�ı���˷�
	  final private int SEVENDIV=3;  //ĩβ��0����λ����һλ��
	  final private int DIVSPACE=4;		//�м��0 ����λ����һλ��
	  
	  
	  final private int DIVWAY=5;		//ͬ��ĸ�����ӷ�
	  final private int MULDIV=6;		//ͬ��ĸ��������
	  final private int  MULANDADD=7;		//һ��ȥ����֮��
	  
	  
	  final private int NULANDSUB=8;		//�����ε��ܳ�
	  
	  
	  final private int ADDANDSUB=9;		//��λ������λ����������λ�ӷ�
	  
	  
	  final private int SMALLBRACKET=10;		//�����ͳ����Ĺ�ϵ
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
	    View view = inflater.inflate(R.layout.grade_3_top, container,
	        false);
	    
	    //���ҿؼ������õ���¼�
	   
	      
	    //���ҿؼ������õ���¼�
	    
	    return view;
	  }

	  }

	  
	  
