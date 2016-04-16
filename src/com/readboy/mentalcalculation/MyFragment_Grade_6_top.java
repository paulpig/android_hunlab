package com.readboy.mentalcalculation;

import com.readboy.game.Grade_5.Grade_5_top;
import com.readboy.game.Grade_6.Grade_6_top;

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

public class MyFragment_Grade_6_top extends Fragment{
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
	  final private int MULANDDIV=1;  //�����˷����ļ��㷽��
	  final private int CANDIVALL=2;	//�����˷����ļ������
	  final private int SEVENDIV=3;  //�����������ļ��㷽��
	  final private int DIVSPACE=4;		//������һ�����ļ���֮���Ƕ��ٵ�����Ľⷨ
	  
	  
	  final private int DIVWAY=5;		//�������������ļ��㷽��
	  final private int MULDIV=6;		//�����δ֪��ķ���
	  final private int  MULANDADD=7;		//һ�������Է����ļ��㷽��
	  
	  
	  final private int NULANDSUB=8;		//Բ��������㹫ʽ��Ӧ��
	  final private int ADDANDSUB=9;		//Բ���ܳ����㹫ʽ
	  final String []intent_content={"�����������ļ��㷽��","�����˷����ļ��㷽��","�����˷����ļ������",
			  						"������һ�����ļ���֮���Ƕ��ٵ�����Ľⷨ","�������������ļ��㷽��","һ�������Է����ļ��㷽��","�����δ֪��ķ���",
			  						"Բ���ܳ����㹫ʽ","Բ��������㹫ʽ��Ӧ��"};
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
		  view = inflater.inflate(R.layout.grade_6_top, container,
	        false);
		 init();
		 ListenEvent();
	    return view;
	  }
	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_6_top_11);
		  tv2=(TextView)view.findViewById(R.id.grade_6_top_12);
		  tv3=(TextView)view.findViewById(R.id.grade_6_top_13);
		  tv4=(TextView)view.findViewById(R.id.grade_6_top_14);
		  
		  tv5=(TextView)view.findViewById(R.id.grade_6_top_21);
		  tv6=(TextView)view.findViewById(R.id.grade_6_top_22);
		  tv7=(TextView)view.findViewById(R.id.grade_6_top_23);
		  
		  
		  tv8=(TextView)view.findViewById(R.id.grade_6_top_31);
		  tv9=(TextView)view.findViewById(R.id.grade_6_top_32);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],SEVENDIV);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],MULANDDIV);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],CANDIVALL);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],DIVSPACE);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],DIVWAY);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],MULANDADD);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],MULDIV);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],ADDANDSUB);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],NULANDSUB);     
				}
			});
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_6_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
}
