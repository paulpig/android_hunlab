package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_3_down extends Fragment {
	 private FragmentActivity activity;
	  TextView tv;
	  final private int MULANDDIV=1;  //��ĩβ��0�ĳ����ļ��㷽����������������
	  final private int CANDIVALL=2;	//��ĩβ��0�ĳ������㷽������û��������
	  final private int SEVENDIV=3;  //���м���0�ĳ����ļ��㷽�������Ĺ�����������
	  final private int DIVSPACE=4;		//���м���0�ĳ����ļ��㷽�������Ĺ�����û��������
	  final private int DIVWAY=5;		//һλ������λ��������������λ�϶��ܱ��������ļ��㷽��
	  final private int MULDIV=6;		//��һλ����������ʮ�����١���ǧ�Ŀ��㷽��
	  final private int  MULANDADD=7;		//�й�0�ĳ���
	  
	  
	  
	  final private int NULANDSUB=8;		//�ó˷���������������
	  
	  
	  final private int ADDANDSUB=9;		//��λ������λ��������λ���ı��㷽��
	  
	  
	  final private int SMALLBRACKET=10;		//ƽ�����ĺ��弰��ƽ�����ķ���
	  
	  
	  
	  final private int BIGADD=11;				//С���ӷ��ļ��㷽��
	  final private int BIGDIV=12;				//С�������ļ��㷽��
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
	    View view = inflater.inflate(R.layout.grade_3_down, container,
	        false);
	    
	    //���ҿؼ������õ���¼�
	   
	      
	    //���ҿؼ������õ���¼�
	    
	    return view;
	  }

}
