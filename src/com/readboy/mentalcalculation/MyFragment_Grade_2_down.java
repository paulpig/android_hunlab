package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
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

public class MyFragment_Grade_2_down extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
	  private String []intent_content={"�ӷ��ļ��㷽��"};
	  
	  final private int MULANDDIV=1;  //�˳���������˳��
	  final private int CANDIVALL=2;	//��һ��������һ���������Ľ��ⷽ��
	  final private int SEVENDIV=3;  //��789�ĳ˷��ھ�����
	  
	  
	  final private int DIVSPACE=4;		//������ʽ�����ֵ�����
	  final private int DIVWAY=5;		//���̵ķ���
	  final private int MULDIV=6;		//�ó˷��ͳ�����������������
	  
	  
	  final private int  MULANDADD=7;		//�ó˷��ͼӷ���������������
	  final private int NULANDSUB=8;		//�ó˷��ͼ�����������������
	  final private int ADDANDSUB=9;		//�üӷ��ͼ�����������������
	  final private int SMALLBRACKET=10;		//��С�������ۺ���ʽ�������
	  
	  
	  
	  final private int BIGADD=11;				//���ټ�ʮ�Ӽ��ټ�ʮ�ļ��㷽��
	  final private int BIGDIV=12;			//���ټ�ʮ�����ټ�ʮ�ļ��㷽��
	  final private int MIDADD=13;				//��λ������λ�����㷽��
	  final private int MIDDIV=14;			//��λ������λ���Ŀ��㷽��
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
	    View view = inflater.inflate(R.layout.grade_2_down, container,
	        false);
	    
	    //�����ڵļӷ�
	   /* tv=(TextView)view.findViewById(R.id.item_1_textview3);
	    tv.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				 tv.setText("nihao");
				 Intent intent = new Intent();  
	             intent.setClass(getActivity(), Grade_1_top.class);  
	             intent.putExtra("content",intent_content[0] );
	             intent.putExtra("type", SEVENDIV);
	             startActivity(intent);      
			}
		});*/
	      
	    //�����ڵļ���
	    
	    
	    
	    
	    //0�ļ��㣨1��
	    
	    
	    
	    
	    //0�ļ��㣨2��
	    
	    
	    
	    return view;
	  }

	  }

	  
	  
