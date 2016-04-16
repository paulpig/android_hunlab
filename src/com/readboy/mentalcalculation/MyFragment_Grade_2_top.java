package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_top;
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

public class MyFragment_Grade_2_top extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
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
	  private TextView tv16;
	  private TextView tv17;
	  private TextView tv18;
	  private TextView tv19;
	  View view;
	  private String []intent_content={"����λ�ӷ�","��λ�ӷ�","����λ����",
			  							"��λ����","����","����",
			  							"�Ӽ����",
			  							"�˷�����ͬ������ӵļ���㷨","5�ĳ˷��ھ�","2�ĳ˷��ھ�",
			  							"3�ĳ˷��ھ�","4�ĳ˷��ھ�","�˼ӡ��˼�"
			  							,"6�ĳ˷��ھ�",
			  							"7�ĳ˷��ھ�","��һ�����ļ����Ƕ��ٵ�����ļ��㷽��","8�ĳ˷��ھ�"
			  							,"9�ĳ˷��ھ�","�˷��ھ���"};
	  
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
	    view = inflater.inflate(R.layout.grade_2_top, container,
	        false);
	    init();
	    ListenEvent();
	    return view;
	  }
	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_2_top_11);
		  tv2=(TextView)view.findViewById(R.id.grade_2_top_12);
		  tv3=(TextView)view.findViewById(R.id.grade_2_top_13);
		  tv4=(TextView)view.findViewById(R.id.grade_2_top_14);
		  tv5=(TextView)view.findViewById(R.id.grade_2_top_15);
		  tv6=(TextView)view.findViewById(R.id.grade_2_top_16);
		  tv7=(TextView)view.findViewById(R.id.grade_2_top_17);
		  
		  
		  tv8=(TextView)view.findViewById(R.id.grade_2_top_21);
		  tv9=(TextView)view.findViewById(R.id.grade_2_top_22);
		  tv10=(TextView)view.findViewById(R.id.grade_2_top_23);
		  tv11=(TextView)view.findViewById(R.id.grade_2_top_24);
		  tv12=(TextView)view.findViewById(R.id.grade_2_top_25);
		  tv13=(TextView)view.findViewById(R.id.grade_2_top_26);
		  tv14=(TextView)view.findViewById(R.id.grade_2_top_27);
		  
		  tv15=(TextView)view.findViewById(R.id.grade_2_top_31);
		  tv16=(TextView)view.findViewById(R.id.grade_2_top_32);
		  tv17=(TextView)view.findViewById(R.id.grade_2_top_33);
		  tv18=(TextView)view.findViewById(R.id.grade_2_top_34);
		  tv19=(TextView)view.findViewById(R.id.grade_2_top_35);
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],NOINADD);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],INADD);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],NOINSUB);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],INSUB);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],ADDADD);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],SUBSUB);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],ADDANDSUB);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],MULISADD);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],MULFORFIVE);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],MULFORTWO);     
				}
			});
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],MULFORTHREE);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],MULFORFOUR);    
				}
			});
		  tv13.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[12],NULLADDSUB);     
				}
			});
		  tv14.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[13],MULFORSIX);     
				}
			});
		  tv15.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[14],MULFORSEVEN);    
				}
			});
		  tv16.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[15],NUMDOUBLE);     
				}
			});
		  tv17.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[16],MULFOREIGHT);     
				}
			});
		  tv18.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[17],MULFORNINE);     
				}
			});
		  tv19.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[18],MULTABLE);    
				}
			});
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_2_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }

	  }

	  
	  
