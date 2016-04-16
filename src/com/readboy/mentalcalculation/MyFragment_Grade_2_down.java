package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_top;
import com.readboy.game.Grade_2.Grade_2_down;
import com.readboy.game.Grade_2.Grade_2_top;

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
	  View view;
	  private TextView tv1;
	  private TextView tv2;
	  private TextView tv3;
	  private TextView tv4;
	  private TextView tv5;
	  private TextView tv6;
	  private TextView tv7;
	  private TextView tv8;
	  private TextView tv9;
	  private TextView tv10;
	  private TextView tv11;
	  private TextView tv12;
	  private TextView tv13;
	  private TextView tv14;
	  private TextView tv15;
	  private String []intent_content={"�üӷ��ͼ�����������������","��С�������ۺ���ʽ�������","�ó˷��ͼӷ���������������","�ó˷��ͼ�����������������",
			  							"������ʽ�����ֵ�����","���̵ķ���","�ó˷��ͳ�����������������",
			  							"��7��8��9�ĳ˷��ھ�����","��\"һ��������һ��������\"�Ľ��ⷽ��","�˳���������˳��",
			  							"��λ������λ�����㷽��","��λ������λ���Ŀ��㷽��","���ټ�ʮ�Ӽ��ټ�ʮ�ļ��㷽��","���ټ�ʮ�����ټ�ʮ�ļ��㷽��"};
	  
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
	    view = inflater.inflate(R.layout.grade_2_down, container,
	        false);
	    init();
	    ListenEvent();
	    return view;
	  }

	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_2_down_11);
		  tv2=(TextView)view.findViewById(R.id.grade_2_down_12);
		  tv3=(TextView)view.findViewById(R.id.grade_2_down_13);
		  tv4=(TextView)view.findViewById(R.id.grade_2_down_14);
		  
		  tv5=(TextView)view.findViewById(R.id.grade_2_down_21);
		  tv6=(TextView)view.findViewById(R.id.grade_2_down_22);
		  tv7=(TextView)view.findViewById(R.id.grade_2_down_23);
		  
		  
		  tv8=(TextView)view.findViewById(R.id.grade_2_down_31);
		  tv9=(TextView)view.findViewById(R.id.grade_2_down_32);
		  tv10=(TextView)view.findViewById(R.id.grade_2_down_33);
		  
		  tv11=(TextView)view.findViewById(R.id.grade_2_down_41);
		  tv12=(TextView)view.findViewById(R.id.grade_2_down_42);
		  tv13=(TextView)view.findViewById(R.id.grade_2_down_43);
		  tv14=(TextView)view.findViewById(R.id.grade_2_down_44);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],ADDANDSUB);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],SMALLBRACKET);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],MULANDADD);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],NULANDSUB);    
				}
			});
		  
		  
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],DIVSPACE);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],DIVWAY);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],MULDIV);     
				}
			});
		  
		  
		  
		  
		  
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],SEVENDIV);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],CANDIVALL);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],MULANDDIV);     
				}
			});
		  
		  
		  
		  
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],MIDADD);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],MIDDIV);    
				}
			});
		  
		  tv13.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[12],BIGADD);     
				}
			});
		  tv14.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[13],BIGDIV);     
				}
			});
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_2_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
	  }

	  
	  
