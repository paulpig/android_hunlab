package com.readboy.mentalcalculation;

import com.readboy.game.Grade_1.Grade_1_top;
import com.readboy.game.Grade_3.Grade_3_top;

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

public class MyFragment_Grade_3_top extends Fragment {
	  private FragmentActivity activity;
	  TextView tv;
	  View view ;
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
	  
	  final private int MULANDDIV=1;  //������λ����һλ����������λ�ı���˷�
	  final private int CANDIVALL=2;	//��λ����һλ��(����λ)�ı���˷�
	  final private int SEVENDIV=3;  //ĩβ��0����λ����һλ��
	  final private int DIVSPACE=4;		//�м��0 ����λ����һλ��
	  
	  
	  final private int DIVWAY=5;		//ͬ��ĸ�����ӷ�
	  final private int MULDIV=6;		//ͬ��ĸ��������
	  final private int  MULANDADD=7;		//һ��ȥ����֮��
	  
	  
	  final private int NULANDSUB=8;		//�����ε��ܳ�
	  
	  
	  final private int ADDANDSUB=9;		//��λ������λ����������λ�ӷ�
	  
	  
	  final private int SMALLBRACKET=10;		//�����ͳ����Ĺ�ϵ
	  
	  private String []intent_content={"��λ������λ����������λ�ӷ�","�����ε��ܳ�","�����ͳ����Ĺ�ϵ",
			  "��λ����һλ��(����λ)�ı���˷�","������λ����һλ����������λ�ı���˷�","�м��0 ����λ����һλ��","�м��0 ����λ����һλ��",
			  "ͬ��ĸ�����ӷ�","ͬ��ĸ��������","һ��ȥ����֮��"};
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
	    view = inflater.inflate(R.layout.grade_3_top, container,
	        false);
	    init();
	    ListenEvent();
	    return view;
	  }

	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_3_top_11);
		  
		  
		  tv2=(TextView)view.findViewById(R.id.grade_3_top_21);
		  
		  
		  tv3=(TextView)view.findViewById(R.id.grade_3_top_31);
		  
		  tv4=(TextView)view.findViewById(R.id.grade_3_top_41);
		  tv5=(TextView)view.findViewById(R.id.grade_3_top_42);
		  tv6=(TextView)view.findViewById(R.id.grade_3_top_43);
		  tv7=(TextView)view.findViewById(R.id.grade_3_top_44);
		  
		  
		  tv8=(TextView)view.findViewById(R.id.grade_3_top_51);
		  tv9=(TextView)view.findViewById(R.id.grade_3_top_52);
		  tv10=(TextView)view.findViewById(R.id.grade_3_top_53);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],ADDANDSUB);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],NULANDSUB);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],SMALLBRACKET);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],CANDIVALL);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],MULANDDIV);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],DIVSPACE);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],SEVENDIV);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],DIVWAY);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],MULDIV);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],MULANDADD);     
				}
			});
		 
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_3_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
	  }

	  
	  
