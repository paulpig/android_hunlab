package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_5_top extends Fragment{
	 private FragmentActivity activity;
	  TextView tv;
	  final private int MULANDDIV=1;  //ƽ���ı��ε�������㹫ʽ
	  final private int CANDIVALL=2;	//�������������ؼ���
	  final private int SEVENDIV=3;  //���ε�������㹫ʽ��Ӧ��
	  
	  
	  final private int DIVSPACE=4;		//����ax+ab=c�ķ��̵Ľⷨ����Ӧ��
	  final private int DIVWAY=5;		//����ax+b=c�ķ��̵Ľⷨ����Ӧ��
	  final private int MULDIV=6;		//����ax=b�ķ��̵Ľⷨ
	  final private int  MULANDADD=7;		//����ax��bx=c�ķ��̵Ľⷨ	
	  final private int NULANDSUB=8;		//����ax-b=c�ķ��̵Ľⷨ����Ӧ��
	  final private int ADDANDSUB=9;		//����x��a=b�ķ��̵Ľⷨ
	  
	  
	  final private int SMALLBRACKET=10;		//С���������ļ��㷽��
	  final private int UNKOWNNUM=11;		//С�����������������㷽��
	  final private int ADDTHENSUB=12;		//С�����˵�����˳��
	  
	  
	  final private int SUBTHENADD=13;		//���������������ֲ������ļ��㷽��
	  final private int ADDFOREIGHT=14;		//����������ĩβ����������С���ļ��㷽��
	  final private int TENADD=15;				//С�����������ļ��㷽��
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
	    View view = inflater.inflate(R.layout.grade_5_top, container,
	        false);
	    
	    //���ҿؼ������õ���¼�
	   
	      
	    //���ҿؼ������õ���¼�
	    
	    return view;
	  }

}
