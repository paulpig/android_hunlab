package com.readboy.mentalcalculation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment_Grade_4_down extends Fragment {
	 private FragmentActivity activity;
	  TextView tv;
	  final private int MULANDDIV=1;  //�й�0������
	  
	  
	  final private int CANDIVALL=2;	//�˷������
	  final private int SEVENDIV=3;  //�ӷ������ɡ��ӷ�����ɵ�����
	  final private int DIVSPACE=4;		//�ӷ������
	  final private int DIVWAY=5;		//�����ļ������
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
	    View view = inflater.inflate(R.layout.grade_4_down, container,
	        false);
	    
	    //���ҿؼ������õ���¼�
	   
	      
	    //���ҿؼ������õ���¼�
	    
	    return view;
	  }

}
