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

public class MyFragment_Grade_1_top extends Fragment {
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
	  private TextView tv20;
	  private String []intent_content={"�ӷ��ļ��㷽��","�����ļ��㷽��","0�ļ���(1)-ͬ�����","0�ļ��㣨2��-һ�����ӡ���0"
			  							,"6��7�ļӼ����ļ��㷽��","һͼ��ʽ��8�ļӼ���","9�ļӼ���","9���ڼӼ�����Ӧ��","10�ļӼ���","��δ֪����","����","����","�ȼӺ���Ļ������","�ȼ���ӵĻ������",
			  							"ʮ�Ӽ�","ʮ���Ӽ�����Ӧ�ļ���","�Ӽ�����ʽ�ĸ���������",
			  							"9�Ӽ��ļ��㷽��","876�Ӽ��ļ��㷽��","5432�Ӽ��ļ��㷽��"};
	  
	  final private int ADDINFIVE=1;  //5���ڵļӷ�
	  final private int SUBINFIVE=2;	//5���ڵļ���
	  final private int ZEROONE=3;		//0�ļ���1
	  final private int ZERTWO=4;		//0�ļ���2
	  
	  
	  
	  final private int ADDINFIVEANDSIX=5;  //6��7�ļӼ���
	  final private int ADDFORNINE=6;		//9�ļӼ���
	  final private int ADDINNINE=7;		//9���ڵļӼ���
	  final private int ADDFORTEN=8;		//10�ļӼ���
	  final private int  CONTINUEADD=9;		//����
	  final private int CONTINUESUD=10;		//����
	  final private int UNKOWNNUM=11;		//��δ֪��
	  final private int ADDTHENSUB=12;		//�ȼӺ��
	  final private int SUBTHENADD=13;		//�ȼ����
	  final private int ADDFOREIGHT=14;		//һͼ��ʽ��8�ļӼ���
	  
	  
	  
	  final private int TENADD=15;				//ʮ�Ӽ�
	  final private int ADDNAME=16;			//�Ӽ�����ʽ�ĸ���������
	  final private int ADDFORTWI=17;			//ʮ���Ӽ�����Ӧ�ļ���
	  
	  final private int NINEADDWHAT=18;		//9�Ӽ��ļ��㷽��
	  final private int SEVENEIGHT=19;			//876�Ӽ��ļ��㷽��
	  final private int FIVETOTWO=20;			//5432�Ӽ��ļ��㷽��
	  
	  View view; 
	  /**
	   * ��activity����ΪFragmentActivity
	   */
	  @Override
	  public void onAttach(Activity activity) {
	    // TODO Auto-generated method stub
	    super.onAttach(activity);
	  }

	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    //���ò���
	    view= inflater.inflate(R.layout.grade_1_top, container,
	        false);
	    init();
	    ListenEvent();
	    return view;
	  }

	  
	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_1_top_11);
		  tv2=(TextView)view.findViewById(R.id.grade_1_top_12);
		  tv3=(TextView)view.findViewById(R.id.grade_1_top_13);
		  tv4=(TextView)view.findViewById(R.id.grade_1_top_14);
		  
		  tv5=(TextView)view.findViewById(R.id.grade_1_top_21);
		  tv6=(TextView)view.findViewById(R.id.grade_1_top_22);
		  tv7=(TextView)view.findViewById(R.id.grade_1_top_23);
		  tv8=(TextView)view.findViewById(R.id.grade_1_top_24);
		  tv9=(TextView)view.findViewById(R.id.grade_1_top_25);
		  tv10=(TextView)view.findViewById(R.id.grade_1_top_26);
		  tv11=(TextView)view.findViewById(R.id.grade_1_top_27);
		  tv12=(TextView)view.findViewById(R.id.grade_1_top_28);
		  tv13=(TextView)view.findViewById(R.id.grade_1_top_29);
		  tv14=(TextView)view.findViewById(R.id.grade_1_top_210);
		  
		  tv15=(TextView)view.findViewById(R.id.grade_1_top_31);
		  tv16=(TextView)view.findViewById(R.id.grade_1_top_32);
		  tv17=(TextView)view.findViewById(R.id.grade_1_top_33);
		  tv18=(TextView)view.findViewById(R.id.grade_1_top_41);
		  tv19=(TextView)view.findViewById(R.id.grade_1_top_42);
		  tv20=(TextView)view.findViewById(R.id.grade_1_top_43);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],ADDINFIVE);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],SUBINFIVE);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],ZEROONE);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],ZERTWO);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],ADDINFIVEANDSIX);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],ADDFOREIGHT);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],ADDFORNINE);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],ADDINNINE);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],ADDFORTEN);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],UNKOWNNUM);     
				}
			});
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],CONTINUEADD);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],CONTINUESUD);    
				}
			});
		  tv13.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[12],ADDTHENSUB);     
				}
			});
		  tv14.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[13],SUBTHENADD);     
				}
			});
		  tv15.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[14],TENADD);    
				}
			});
		  tv16.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[15],ADDFORTWI);     
				}
			});
		  tv17.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[16],ADDNAME);     
				}
			});
		  tv18.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[17],NINEADDWHAT);     
				}
			});
		  tv19.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[18],SEVENEIGHT);    
				}
			});
		  tv20.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[19],FIVETOTWO);     
				}
			});
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_1_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
	  }

	  
	  
