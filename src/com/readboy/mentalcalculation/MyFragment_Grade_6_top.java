package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_6_top extends Fragment{
	 private FragmentActivity activity;
	  TextView tv;
	  final private int MULANDDIV=1;  //�����˷����ļ��㷽��
	  final private int CANDIVALL=2;	//�����˷����ļ������
	  final private int SEVENDIV=3;  //�����������ļ��㷽��
	  final private int DIVSPACE=4;		//������һ�����ļ���֮���Ƕ��ٵ�����Ľⷨ
	  
	  
	  final private int DIVWAY=5;		//�������������ļ��㷽��
	  final private int MULDIV=6;		//�����δ֪��ķ���
	  final private int  MULANDADD=7;		//һ�������Է����ļ��㷽��
	  
	  
	  final private int NULANDSUB=8;		//Բ��������㹫ʽ��Ӧ��
	  final private int ADDANDSUB=9;		//Բ���ܳ����㹫ʽ
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
	    View view = inflater.inflate(R.layout.grade_6_top, container,
	        false);
	    
	    //���ҿؼ������õ���¼�
	   
	      
	    //���ҿؼ������õ���¼�
	    
	    return view;
	  }

}
