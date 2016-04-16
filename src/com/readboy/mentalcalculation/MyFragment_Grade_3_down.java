package com.readboy.mentalcalculation;

import com.readboy.game.Grade_3.Grade_3_down;
import com.readboy.game.Grade_3.Grade_3_top;

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

public class MyFragment_Grade_3_down extends Fragment {
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
	  private TextView tv11;
	  private TextView tv12;
	  
	  
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
	  
	  private String []intent_content={"��һλ����������ʮ�����١���ǧ�Ŀ��㷽��",
			  "һλ������λ��������������λ�϶��ܱ��������ļ��㷽��","�й�0�ĳ���","���м���0�ĳ����ļ��㷽�������Ĺ�����û��������"
			  ,"��ĩβ��0�ĳ������㷽������û��������","���м���0�ĳ����ļ��㷽�������Ĺ�����������","��ĩβ��0�ĳ����ļ��㷽����������������",
			  "ƽ�����ĺ��弰��ƽ�����ķ���",
			  "��λ������λ��������λ���ı��㷽��",
			  "С���ӷ��ļ��㷽��","С�������ļ��㷽��",
			  "�ó˷���������������"};
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
	    view = inflater.inflate(R.layout.grade_3_down, container,
	        false);
	    
	    //���ҿؼ������õ���¼�
	   init();
	   ListenEvent();
	    //���ҿؼ������õ���¼�
	    
	    return view;
	  }

	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_3_down_11);
		  tv2=(TextView)view.findViewById(R.id.grade_3_down_12);
		  tv3=(TextView)view.findViewById(R.id.grade_3_down_13);
		  tv4=(TextView)view.findViewById(R.id.grade_3_down_14);
		  tv5=(TextView)view.findViewById(R.id.grade_3_down_15);
		  tv6=(TextView)view.findViewById(R.id.grade_3_down_16);
		  tv7=(TextView)view.findViewById(R.id.grade_3_down_17);
		  
		  
		  tv8=(TextView)view.findViewById(R.id.grade_3_down_21);
		  
		  tv9=(TextView)view.findViewById(R.id.grade_3_down_31);
		  
		  tv10=(TextView)view.findViewById(R.id.grade_3_down_41);
		  tv11=(TextView)view.findViewById(R.id.grade_3_down_42);
		  
		  tv12=(TextView)view.findViewById(R.id.grade_3_down_51);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],MULDIV);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],DIVWAY);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],MULANDADD);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],DIVSPACE);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],CANDIVALL);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],SEVENDIV);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],MULANDDIV);   
				
				}
			});
		  
		  ///////////////////////////////////
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],SMALLBRACKET);    
				}
			});
		  //////////////////
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],ADDANDSUB);     
				}
			});
		  
		  //////////////////////////
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],BIGADD);     
				}
			});
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],BIGDIV);     
				}
			});
		  ////////////////
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],NULANDSUB);     
				}
			});
		 
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_3_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
}
