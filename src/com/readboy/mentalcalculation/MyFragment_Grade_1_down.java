package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_down;
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

public class MyFragment_Grade_1_down extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
	  private String []intent_content={"�ӷ��ļ��㷽��"};
	  
	  final private int TENSUBNINE=1;  //ʮ����9 �ļ��㷽��
	  final private int TENSUBWHAT=2;	//ʮ�������ļ��㷽��
	  
	  
	  final private int NOTWOADDONE=3;  //��λ����һλ��������λ���ļ��㷽��
	  final private int TWOADDONE=4;		//��λ����һλ������λ���ļ��㷽��
	  final private int TWOADDTEN=5;		//��λ������ʮ���ļ��㷽��
	  final private int NOTWOSUBONE=6;		//��λ����һλ��������λ���ļ��㷽��
	  final private int  TWOSUBONE=7;		//��λ����һλ������λ���ļ��㷽��
	  final private int TWOSUBTEN=8;		//��λ������ʮ���ļ��㷽��
	  final private int TENADDTEN=9;		//��ʮ������ʮ���ļ��㷽��
	  final private int TENSUBTEN=10;		//��ʮ������ʮ���ļ��㷽��
	  
	  
	  
	  final private int TWOSUBTHIS=11;			//����ʮ����һλ����Ӧ�ļ������㷽��
	  final private int TENADDONE=12;			//��ʮ����һλ���ļ��㷽��
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
	    View view = inflater.inflate(R.layout.grade_1_down, container,
	        false);
	    
	    //ʮ����9 �ļ��㷽��
	   /* tv=(TextView)view.findViewById(R.id.item_1_textview3);
	    tv.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				 tv.setText("nihao");
				 Intent intent = new Intent();  
	             intent.setClass(getActivity(), Grade_1_down.class);  
	             intent.putExtra("content",intent_content[0] );
	             intent.putExtra("type", TENSUBNINE);
	             startActivity(intent);      
			}
		});*/
	      
	    
	    
	    
	    
	    return view;
	  }

	  }

	  
	  
