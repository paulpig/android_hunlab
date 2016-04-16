package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_down;
import com.readboy.game.Grade_1.Grade_1_top;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyFragment_Grade_1_down extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
	  View view;
	  String whichChoose;
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
	  private TextView sb1;
	  private TextView sb2;
	  private TextView sb3;
	  private TextView sb4;
	  private TextView sb5;
	  private TextView sb6;
	  private TextView sb7;
	  private TextView sb8;
	  private TextView sb9;
	  private TextView sb10;
	  private TextView sb11;
	  private TextView sb12;
	  private String []intent_content={"ʮ����9�ļ��㷽��","ʮ�������ļ��㷽��",
			  "��ʮ����һλ���ļ��㷽��","����ʮ����һλ����Ӧ�ļ������㷽��",
			  "����������ʮ���ļ��㷽��","��ʮ������ʮ���ļ��㷽��","��λ����һλ��������λ���ļ��㷽��",
			  "��λ������ʮ���ļ��㷽��","��λ����һλ������λ���ļ��㷽��","��λ����һλ��������λ���ļ��㷽��",
			  "��ʮ������ʮ���ļ��㷽��","��λ����һλ������λ���ļ��㷽��"};
	  
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
	    view = inflater.inflate(R.layout.grade_1_down, container,
	        false);
	    
	    init();
	    ListenEvent();
	    setGrade(sb3,TENADDONE);
	    return view;
	  }

	  
	  
	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_1_down_11);
		  tv2=(TextView)view.findViewById(R.id.grade_1_down_12);
		  
		  tv3=(TextView)view.findViewById(R.id.grade_1_down_21);
		  sb3=(TextView)view.findViewById(R.id.subject_1_down_21);
		  tv4=(TextView)view.findViewById(R.id.grade_1_down_22);
		  
		  tv5=(TextView)view.findViewById(R.id.grade_1_down_31);
		  tv6=(TextView)view.findViewById(R.id.grade_1_down_32);
		  tv7=(TextView)view.findViewById(R.id.grade_1_down_33);
		  tv8=(TextView)view.findViewById(R.id.grade_1_down_34);
		  tv9=(TextView)view.findViewById(R.id.grade_1_down_35);
		  tv10=(TextView)view.findViewById(R.id.grade_1_down_36);
		  tv11=(TextView)view.findViewById(R.id.grade_1_down_37);
		  tv12=(TextView)view.findViewById(R.id.grade_1_down_38);
		  
		  
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],TENSUBNINE);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],TENSUBWHAT);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],TENADDONE);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],TWOSUBTHIS);    
				}
			});
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],TENADDTEN);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],TENSUBTEN);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],NOTWOADDONE);     
				}
			});
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],TWOADDTEN);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],TWOADDONE);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],NOTWOSUBONE);     
				}
			});
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],TWOSUBTEN);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],TWOSUBONE);    
				}
			});
		  
		 
		  
	  }
	  
	  public void setGrade(TextView tv,int type){
		String name="test";
		String intent_type="11"+type;   //��ͬ�꼶���޸�
	  	SharedPreferences sharedPreferences= getActivity().getSharedPreferences(name, 
	  				Activity.MODE_PRIVATE); 
	  				// ʹ��getString�������value��ע���2��������value��Ĭ��ֵ 
	  	int top_grade=sharedPreferences.getInt("fist_grade"+intent_type, 0); 
	  	String outPutValue=top_grade+"����";
	  	tv.setText(outPutValue);
	  		//grade_all[1]=sharedPreferences.getInt("second_grade"+intent_type, 0); 
	  		//grade_all[2]=sharedPreferences.getInt("third_grade"+intent_type,0); 
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_1_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivityForResult(intent,1);    
	  }
	 
	  
	  @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode){
			case 1:
				setGrade(sb3,TENADDONE);
				break;
		
		}
	}
	  
	  
//	 public  void refreshData(){
//		 setGrade(sb1,TENSUBNINE);
//		 setGrade(sb2,TENSUBWHAT);
//		 setGrade(sb3,TENADDONE);
//		 setGrade(sb4,TWOSUBTHIS);
//		 setGrade(sb5,TENADDTEN);
//		 setGrade(sb6,TENSUBTEN);
//		 setGrade(sb7,NOTWOADDONE);
//		 setGrade(sb8,TWOADDTEN);
//		 setGrade(sb9,TWOADDONE);
//		 setGrade(sb10,NOTWOSUBONE);
//		 setGrade(sb11,TWOSUBTEN);
//		 setGrade(sb12,TWOSUBONE);
//	  }
	  }

	  
	  
