package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_5_down extends Fragment{
	 private FragmentActivity activity;
	  TextView tv;
	  final private int MULANDDIV=1;  //�����ӷ��ĺ����ͬ��ĸ�����ӷ��ļ��㷽��
	  final private int CANDIVALL=2;	//�����ӷ��ļ���
	  final private int SEVENDIV=3;  //�����Ӽ�������������˳��
	  final private int DIVSPACE=4;		//���������ĺ����ͬ��ĸ���������ļ��㷽��
	  final private int DIVWAY=5;		//ͬ��ĸ�������ӡ������ļ��㷽��
	  final private int MULDIV=6;		//���ĸ�����ӡ������ļ��㷽��
	  
	  
	  final private int  MULANDADD=7;		//��������С���ķ���
	  final private int NULANDSUB=8;		//����������������ķ���
	  final private int ADDANDSUB=9;		//����������С�������ķ���
	  
	  
	  final private int SMALLBRACKET=10;		//�����������ļ��㷽��
	  final private int UNKOWNNUM=11;		//�����������ļ��㹫ʽ
	  final private int ADDTHENSUB=12;		//�����������ļ��㷽��
	  final private int SUBTHENADD=13;		//������������ʽ
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
	    View view = inflater.inflate(R.layout.grade_5_down, container,
	        false);
	    
	    //���ҿؼ������õ���¼�
	   
	      
	    //���ҿؼ������õ���¼�
	    
	    return view;
	  }

}
