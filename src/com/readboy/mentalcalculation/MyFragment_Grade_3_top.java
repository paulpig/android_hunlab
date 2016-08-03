package com.readboy.mentalcalculation;

import com.readboy.game.Grade_1.Grade_1_top;
import com.readboy.game.Grade_3.Grade_3_top;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MyFragment_Grade_3_top extends Fragment {
	  private FragmentActivity activity;
	  private int show_num=-1;
	  view tv;
	  View view ;
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
		  tv1=(view)view.findViewById(R.id.grade_3_top_11);
		  
		  
		  tv2=(view)view.findViewById(R.id.grade_3_top_21);
		  
		  
		  tv3=(view)view.findViewById(R.id.grade_3_top_31);
		  
		  tv4=(view)view.findViewById(R.id.grade_3_top_41);
		  tv5=(view)view.findViewById(R.id.grade_3_top_42);
		  tv6=(view)view.findViewById(R.id.grade_3_top_43);
		  tv7=(view)view.findViewById(R.id.grade_3_top_44);
		  
		  
		  tv8=(view)view.findViewById(R.id.grade_3_top_51);
		  tv9=(view)view.findViewById(R.id.grade_3_top_52);
		  tv10=(view)view.findViewById(R.id.grade_3_top_53);
		  
		  
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
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_3_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivityForResult(intent,type);   
	  }
	  
	  
	  
	  /*���´��ļ��ж�ȡ���ֵ*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="30"+type;   //��ͬ�꼶���޸�
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
				case ADDANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv1,ADDANDSUB);
					tv1.setColor(true);
					break;
				case NULANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv2,NULANDSUB);
					tv2.setColor(true);
					break;
				case SMALLBRACKET:
					Log.i("lalala", "onActivity().in");
					setGrade(tv3,SMALLBRACKET);
					tv3.setColor(true);
					break;
				case CANDIVALL:
					Log.i("lalala", "onActivity().in");
					setGrade(tv4,CANDIVALL);
					tv4.setColor(true);
					break;
				case MULANDDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv5,MULANDDIV);
					tv5.setColor(true);
					break;
				case DIVSPACE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv6,DIVSPACE);
					tv6.setColor(true);
					break;
				case SEVENDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv7,SEVENDIV);
					tv7.setColor(true);
					break;
				case DIVWAY:
					Log.i("lalala", "onActivity().in");
					setGrade(tv8,DIVWAY);
					tv8.setColor(true);
					break;
				case MULDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv9,MULDIV);
					tv9.setColor(true);
					break;
				case MULANDADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv10,MULANDADD);
					tv10.setColor(true);
					break;
			
			}
		}
		  
		 //�������֮��ĸ������ǵĸ���
		 public  void refreshData(){
			 setGrade(tv1,ADDANDSUB);
			 setGrade(tv2,NULANDSUB);
			 setGrade(tv3,SMALLBRACKET);
			 setGrade(tv4,CANDIVALL);
			 setGrade(tv5,MULANDDIV);
			 setGrade(tv6,DIVSPACE);
			 setGrade(tv7,SEVENDIV);
			 setGrade(tv8,DIVWAY);
			 setGrade(tv9,MULDIV);
			 setGrade(tv10,MULANDADD);
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
		 }
	  
		 
		 /*��ʾ��ʼ��ͼƬ��ɫ*/
		 public void setStartColor(int num){
			 switch(num){
			 case ADDANDSUB:
					
					tv1.setColor(true);
					break;
				case NULANDSUB:
					
					tv2.setColor(true);
					break;
				case SMALLBRACKET:
					
					tv3.setColor(true);
					break;
				case CANDIVALL:
					
					tv4.setColor(true);
					break;
				case MULANDDIV:
					
					tv5.setColor(true);
					break;
				case DIVSPACE:
					
					tv6.setColor(true);
					break;
				case SEVENDIV:
				
					tv7.setColor(true);
					break;
				case DIVWAY:
					
					tv8.setColor(true);
					break;
				case MULDIV:
					
					tv9.setColor(true);
					break;
				case MULANDADD:
					
					tv10.setColor(true);
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
	  		editor.putInt("grade_3_top",requestCode);
	  		editor.putInt("grade_3_down",-1);
	  		editor.putInt("grade_4_top",-1);
	  		editor.putInt("grade_4_down",-1);
	  		editor.putInt("grade_5_top",-1);
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
	  		show_num =mySharedPreferences.getInt("grade_3_top", -1); 
		}
		
	  }

	  
	  
