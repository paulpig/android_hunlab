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

public class MyFragment_Grade_2_top extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
	  private String []intent_content={"�ӷ��ļ��㷽��"};
	  
	  final private int NOINADD=1;  //100���ڲ���λ�ӷ�
	  final private int NOINSUB=2;	//100���ڲ���λ����
	  final private int ADDANDSUB=3;  //�Ӽ����
	  final private int INADD=4;		//��λ�ӷ�
	  final private int ADDADD=5;		//����
	  final private int SUBSUB=6;		//����
	  final private int  INSUB=7;		//��λ����
	  
	  
	  final private int MULFORSEVEN=8;		//7�ĳ˷��ھ�
	  final private int MULFOREIGHT=9;		//8�ĳ˷��ھ�
	  final private int MULFORNINE=10;		//9�ĳ˷��ھ�
	  final private int MULTABLE=11;				//�˷��ھ���
	  final private int NUMDOUBLE=12;			//��һ�����ļ����Ƕ��ٵ�����ļ��㷽��
	  
	  
	  final private int MULFORTWO=13;		//2�ĳ˷��ھ�
	  final private int MULFORTHREE=14;		//3�ĳ˷��ھ�
	  final private int MULFORFOUR=15;		//4�ĳ˷��ھ�
	  final private int MULFORFIVE=16;		//5�ĳ˷��ھ�
	  final private int MULFORSIX=17;		//6�ĳ˷��ھ�
	  final private int MULISADD=18;				//�˷�����ͬ������ӵļ������
	  final private int NULLADDSUB=19;			//�˼ӳ˼�
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
	    View view = inflater.inflate(R.layout.grade_2_top, container,
	        false);
	    
	    //�����ڵļӷ�
	   /* tv=(TextView)view.findViewById(R.id.item_1_textview3);
	    tv.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				 tv.setText("nihao");
				 Intent intent = new Intent();  
	             intent.setClass(getActivity(), Grade_1_top.class);  
	             intent.putExtra("content",intent_content[0] );
	             intent.putExtra("type", ADDADD);
	             startActivity(intent);      
			}
		});*/
	      
	    //�����ڵļ���
	    
	    
	    
	    
	    //0�ļ��㣨1��
	    
	    
	    
	    
	    //0�ļ��㣨2��
	    
	    
	    
	    return view;
	  }

	  }

	  
	  
