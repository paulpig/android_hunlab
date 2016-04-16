package com.readboy.mentalcalculation;

import com.readboy.game.Grade_1.Grade_1_top;
import com.readboy.game.Grade_5.Grade_5_top;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MyFragment_Grade_5_top extends Fragment{
	 private FragmentActivity activity;
	  TextView tv;
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
	  final private int UNKOWNNUM=11;		//С����С�����������㷽��
	  final private int ADDTHENSUB=12;		//С�����˵�����˳��
	  
	  
	  final private int SUBTHENADD=13;		//���������������ֲ������ļ��㷽��
	  final private int ADDFOREIGHT=14;		//����������ĩβ����������С���ļ��㷽��
	  final private int TENADD=15;				//С�����������ļ��㷽��
	  final private String []intent_content={"С���������ļ��㷽��","С����С�����������㷽��","С�����˵�����˳��",
			  									"С�����������ļ��㷽��","���������������ֲ������ļ��㷽��","����������ĩβ����������С���ļ��㷽��",
			  									"����x��a=b�ķ��̵Ľⷨ","����ax=b�ķ��̵Ľⷨ","����ax+b=c�ķ��̵Ľⷨ����Ӧ��",
			  									"����ax-b=c�ķ��̵Ľⷨ����Ӧ��","����ax+ab=c�ķ��̵Ľⷨ����Ӧ��","����ax��bx=c�ķ��̵Ľⷨ",
			  									"ƽ���ı��ε�������㹫ʽ","�������������ؼ���","���ε�������㹫ʽ��Ӧ��"};
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
	   view = inflater.inflate(R.layout.grade_5_top, container,
	        false);
	    init();
	    ListenEvent();
	    
	    return view;
	  }
	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_5_top_11);
		  tv2=(TextView)view.findViewById(R.id.grade_5_top_12);
		  tv3=(TextView)view.findViewById(R.id.grade_5_top_13);
		  
		  
		  tv4=(TextView)view.findViewById(R.id.grade_5_top_21);
		  tv5=(TextView)view.findViewById(R.id.grade_5_top_22);
		  tv6=(TextView)view.findViewById(R.id.grade_5_top_23);
		  
		  tv7=(TextView)view.findViewById(R.id.grade_5_top_31);
		  tv8=(TextView)view.findViewById(R.id.grade_5_top_32);
		  tv9=(TextView)view.findViewById(R.id.grade_5_top_33);
		  tv10=(TextView)view.findViewById(R.id.grade_5_top_34); 
		  tv11=(TextView)view.findViewById(R.id.grade_5_top_35);
		  tv12=(TextView)view.findViewById(R.id.grade_5_top_36);
		  
		  
		  tv13=(TextView)view.findViewById(R.id.grade_5_top_41);
		  tv14=(TextView)view.findViewById(R.id.grade_5_top_42);
		  tv15=(TextView)view.findViewById(R.id.grade_5_top_43);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],SMALLBRACKET);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],UNKOWNNUM);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],ADDTHENSUB);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],TENADD);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],SUBTHENADD);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],ADDFOREIGHT);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],ADDANDSUB);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],MULDIV);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],DIVWAY);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],NULANDSUB);     
				}
			});
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],DIVSPACE);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],MULANDADD);    
				}
			});
		  tv13.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[12],MULANDDIV);     
				}
			});
		  tv14.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[13],CANDIVALL);     
				}
			});
		  tv15.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[14],SEVENDIV);    
				}
			});
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_5_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
}
