package com.readboy.mentalcalculation;

import com.readboy.game.Grade_1.Grade_1_top;
import com.readboy.game.Grade_5.Grade_5_top;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class MyFragment_Grade_5_top extends Fragment{
	 private FragmentActivity activity;
	 private int show_num=-1;
	  view tv;
	  View view;
	  private view tv1;
	  private view tv2;
	  private view tv3;
	  private view tv4;
	  private view tv5;
	  private view tv6;
	  private view tv7;
	  private view tv8;
	  private view tv9;
	  private view tv10;
	  private view tv11;
	  private view tv12;
	  private view tv13;
	  private view tv14;
	  private view tv15;
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
	    refreshData();
	  //�õ�����ʵ�ַ�ɫ������
		   getData();
		   if(show_num==-1)
			   setAllBlue();
		   else{
			   setAllBlue();
			   setStartColor(show_num);
		   }
	    return view;
	  }
	  public void init(){
		  tv1=(view)view.findViewById(R.id.grade_5_top_11);
		  tv2=(view)view.findViewById(R.id.grade_5_top_12);
		  tv3=(view)view.findViewById(R.id.grade_5_top_13);
		  
		  
		  tv4=(view)view.findViewById(R.id.grade_5_top_21);
		  tv5=(view)view.findViewById(R.id.grade_5_top_22);
		  tv6=(view)view.findViewById(R.id.grade_5_top_23);
		  
		  tv7=(view)view.findViewById(R.id.grade_5_top_31);
		  tv8=(view)view.findViewById(R.id.grade_5_top_32);
		  tv9=(view)view.findViewById(R.id.grade_5_top_33);
		  tv10=(view)view.findViewById(R.id.grade_5_top_34); 
		  tv11=(view)view.findViewById(R.id.grade_5_top_35);
		  tv12=(view)view.findViewById(R.id.grade_5_top_36);
		  
		  
		  tv13=(view)view.findViewById(R.id.grade_5_top_41);
		  tv14=(view)view.findViewById(R.id.grade_5_top_42);
		  tv15=(view)view.findViewById(R.id.grade_5_top_43);
		  
		  
		  tv1.setText(intent_content[0]);
		  tv2.setText(intent_content[1]);
		  tv3.setText(intent_content[2]);
		  tv4.setText(intent_content[3]);
		  
		  tv5.setText(intent_content[4]);
		  tv6.setText(intent_content[5]);
		  tv7.setText(intent_content[6]);
		  tv8.setText(intent_content[7]);
		  tv9.setText(intent_content[8]);
		  tv10.setText(intent_content[9]);
		  tv11.setText(intent_content[10]);
		  tv12.setText(intent_content[11]);
		  tv13.setText(intent_content[12]);
		  tv14.setText(intent_content[13]);
		  
		  tv15.setText(intent_content[14]);
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
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_5_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
	  /*���´��ļ��ж�ȡ���ֵ*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="50"+type;   //��ͬ�꼶���޸�
	  	SharedPreferences sharedPreferences= getActivity().getSharedPreferences(name, 
	  				Activity.MODE_PRIVATE); 
	  	int top_grade=sharedPreferences.getInt("first_grade"+intent_type, 0); 
	  	judgeGrade(top_grade,tv);
	  }
	  
	  
	  
	  //�������ǵĸ���
	  public void judgeGrade(int topGrade,view tv){
		  if(topGrade/20 <6)
			  tv.setStarNum((int)(topGrade/20));
		  else{
			  tv.setStarNum(5);
		  }
	  }
	  
	  
	  /*������һ�����淵�ص�ֵ*/
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
			Log.i("lalala", "onActivity()");
			
			
			setData(requestCode);
			
			
			switch(requestCode){
				case SMALLBRACKET:
					Log.i("lalala", "onActivity().in");
					setGrade(tv1,SMALLBRACKET);
					tv1.setColor(true);
					break;
				case UNKOWNNUM:
					Log.i("lalala", "onActivity().in");
					setGrade(tv2,UNKOWNNUM);
					tv2.setColor(true);
					break;
				case ADDTHENSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv3,ADDTHENSUB);
					tv3.setColor(true);
					break;
				case TENADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv4,TENADD);
					tv4.setColor(true);
					break;
				case SUBTHENADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv5,SUBTHENADD);
					tv5.setColor(true);
					break;
				case ADDFOREIGHT:
					Log.i("lalala", "onActivity().in");
					setGrade(tv6,ADDFOREIGHT);
					tv6.setColor(true);
					break;
				case ADDANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv7,ADDANDSUB);
					tv7.setColor(true);
					break;
				case MULDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv8,MULDIV);
					tv8.setColor(true);
					break;
				case DIVWAY:
					Log.i("lalala", "onActivity().in");
					setGrade(tv9,DIVWAY);
					tv9.setColor(true);
					break;
				case NULANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv10,NULANDSUB);
					tv10.setColor(true);
					break;
				case DIVSPACE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv11,DIVSPACE);
					tv11.setColor(true);
					break;
				case MULANDADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv12,MULANDADD);
					tv12.setColor(true);
					break;
				case MULANDDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv13,MULANDDIV);
					tv13.setColor(true);
					break;
				case CANDIVALL:
					Log.i("lalala", "onActivity().in");
					setGrade(tv14,CANDIVALL);
					tv14.setColor(true);
					break;
				case SEVENDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv15,SEVENDIV);
					tv15.setColor(true);
					break;
			}
		}
		  
		 //�������֮��ĸ������ǵĸ���
		 public  void refreshData(){
			 setGrade(tv1,SMALLBRACKET);
			 setGrade(tv2,UNKOWNNUM);
			 setGrade(tv3,ADDTHENSUB);
			 setGrade(tv4,TENADD);
			 setGrade(tv5,SUBTHENADD);
			 setGrade(tv6,ADDFOREIGHT);
			 setGrade(tv7,ADDANDSUB);
			 setGrade(tv8,MULDIV);
			 setGrade(tv9,DIVWAY);
			 setGrade(tv10,NULANDSUB);
			 setGrade(tv11,DIVSPACE);
			 setGrade(tv12,MULANDADD);
			 setGrade(tv13,MULANDDIV);
			 setGrade(tv14,CANDIVALL);
			 setGrade(tv15,SEVENDIV);
		  }
		 
		 
		 /*ȫ�����Ϊ��ɫ*/
		 public void setAllBlue(){
			 tv1.setColor(false);
			 tv2.setColor(false);
			 tv3.setColor(false);
			 tv4.setColor(false);
			 tv5.setColor(false);
			 tv6.setColor(false);
			 tv7.setColor(false);
			 tv8.setColor(false);
			 tv9.setColor(false);
			 tv10.setColor(false);
			 tv11.setColor(false);
			 tv12.setColor(false);
			 tv13.setColor(false);
			 tv14.setColor(false);
			 tv15.setColor(false);
		 }
		 
		 /*��ʾ��ʼ��ͼƬ��ɫ*/
		 public void setStartColor(int num){
			 switch(num){
			 case SMALLBRACKET:
					
					tv1.setColor(true);
					break;
				case UNKOWNNUM:
					
					tv2.setColor(true);
					break;
				case ADDTHENSUB:
					
					tv3.setColor(true);
					break;
				case TENADD:
					
					tv4.setColor(true);
					break;
				case SUBTHENADD:
					
					tv5.setColor(true);
					break;
				case ADDFOREIGHT:
					
					tv6.setColor(true);
					break;
				case ADDANDSUB:
					
					tv7.setColor(true);
					break;
				case MULDIV:
					
					tv8.setColor(true);
					break;
				case DIVWAY:
					
					tv9.setColor(true);
					break;
				case NULANDSUB:
					
					tv10.setColor(true);
					break;
				case DIVSPACE:
					
					tv11.setColor(true);
					break;
				case MULANDADD:
					
					tv12.setColor(true);
					break;
				case MULANDDIV:
					
					tv13.setColor(true);
					break;
				case CANDIVALL:
					
					tv14.setColor(true);
					break;
				case SEVENDIV:
				
					tv15.setColor(true);
					break;
		 }
		 }

	//�����ļ�������
		public void setData(int requestCode){
			String name="test";
	  		SharedPreferences mySharedPreferences= getActivity().getSharedPreferences(name, 
	  		Activity.MODE_PRIVATE); 
	  		//ʵ����SharedPreferences.Editor���󣨵ڶ����� 
	  		SharedPreferences.Editor editor = mySharedPreferences.edit(); 
	  		//��putString�ķ����������� 
	  		editor.putInt("grade_1_top", -1); 
	  		editor.putInt("grade_1_down",-1);
	  		editor.putInt("grade_2_top",-1);
	  		editor.putInt("grade_2_down",-1);
	  		editor.putInt("grade_3_top",-1);
	  		editor.putInt("grade_3_down",-1);
	  		editor.putInt("grade_4_top",-1);
	  		editor.putInt("grade_4_down",-1);
	  		editor.putInt("grade_5_top",requestCode);
	  		editor.putInt("grade_5_down",-1);
	  		editor.putInt("grade_6_top",-1);
	  		//�ύ��ǰ���� 
	  		editor.commit(); 
			}
		
		//��ȡ�ļ��е��Ƿ�Ϊ��ɫ������
		public void getData(){
			String name="test";
	  		SharedPreferences mySharedPreferences= getActivity().getSharedPreferences(name, 
	  		Activity.MODE_PRIVATE); 
	  		show_num =mySharedPreferences.getInt("grade_5_top", -1); 
		}
	  
}
