package com.readboy.mentalcalculation;

import com.readboy.game.Grade_3.Grade_3_down;
import com.readboy.game.Grade_3.Grade_3_top;

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

public class MyFragment_Grade_3_down extends Fragment {
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
	  private view tv11;
	  private view tv12;
	  
	  
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
			  "һλ������λ��(����������λ�϶��ܱ�����)","�й�0�ĳ���","���м���0�ĳ��������Ĺ�����û��������"
			  ,"��ĩβ��0�ĳ�������û��������","���м���0�ĳ��������Ĺ�����������","��ĩβ��0�ĳ�����������������",
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
	   refreshData();
	 //�õ�����ʵ�ַ�ɫ������
	   getData();
	   if(show_num==-1)
		   setAllBlue();
	   else{
		   setAllBlue();
		   setStartColor(show_num);
	   }
	    //���ҿؼ������õ���¼�
	    
	    return view;
	  }

	  public void init(){
		  tv1=(view)view.findViewById(R.id.grade_3_down_11);
		  tv2=(view)view.findViewById(R.id.grade_3_down_12);
		  tv3=(view)view.findViewById(R.id.grade_3_down_13);
		  tv4=(view)view.findViewById(R.id.grade_3_down_14);
		  tv5=(view)view.findViewById(R.id.grade_3_down_15);
		  tv6=(view)view.findViewById(R.id.grade_3_down_16);
		  tv7=(view)view.findViewById(R.id.grade_3_down_17);
		  
		  
		  tv8=(view)view.findViewById(R.id.grade_3_down_21);
		  
		  tv9=(view)view.findViewById(R.id.grade_3_down_31);
		  
		  tv10=(view)view.findViewById(R.id.grade_3_down_41);
		  tv11=(view)view.findViewById(R.id.grade_3_down_42);
		  
		  tv12=(view)view.findViewById(R.id.grade_3_down_51);
		  
		  
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
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_3_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivityForResult(intent,type);    
	  }
	  
	  
	  /*���´��ļ��ж�ȡ���ֵ*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="31"+type;   //��ͬ�꼶���޸�
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
				case MULDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv1,MULDIV);
					tv1.setColor(true);
					break;
				case DIVWAY:
					Log.i("lalala", "onActivity().in");
					setGrade(tv2,DIVWAY);
					tv2.setColor(true);
					break;
				case MULANDADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv3,MULANDADD);
					tv3.setColor(true);
					break;
				case DIVSPACE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv4,DIVSPACE);
					tv4.setColor(true);
					break;
				case CANDIVALL:
					Log.i("lalala", "onActivity().in");
					setGrade(tv5,CANDIVALL);
					tv5.setColor(true);
					break;
				case SEVENDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv6,SEVENDIV);
					tv6.setColor(true);
					break;
				case MULANDDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv7,MULANDDIV);
					tv7.setColor(true);
					break;
				case SMALLBRACKET:
					Log.i("lalala", "onActivity().in");
					setGrade(tv8,SMALLBRACKET);
					tv8.setColor(true);
					break;
				case ADDANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv9,ADDANDSUB);
					tv9.setColor(true);
					break;
				case BIGADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv10,BIGADD);
					tv10.setColor(true);
					break;
				case BIGDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv11,BIGDIV);
					tv11.setColor(true);
					break;
				case NULANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv12,NULANDSUB);
					tv12.setColor(true);
					break;
			
			}
		}
		  
		 //�������֮��ĸ������ǵĸ���
		 public  void refreshData(){
			 setGrade(tv1,MULDIV);
			 setGrade(tv2,DIVWAY);
			 setGrade(tv3,MULANDADD);
			 setGrade(tv4,DIVSPACE);
			 setGrade(tv5,CANDIVALL);
			 setGrade(tv6,SEVENDIV);
			 setGrade(tv7,MULANDDIV);
			 setGrade(tv8,SMALLBRACKET);
			 setGrade(tv9,ADDANDSUB);
			 setGrade(tv10,BIGADD);
			 setGrade(tv11,BIGDIV);
			 setGrade(tv12,NULANDSUB);
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
		 }
		 
		 /*��ʾ��ʼ��ͼƬ��ɫ*/
		 public void setStartColor(int num){
			 switch(num){
			 case MULDIV:
					
					tv1.setColor(true);
					break;
				case DIVWAY:
					
					tv2.setColor(true);
					break;
				case MULANDADD:
					
					tv3.setColor(true);
					break;
				case DIVSPACE:
					
					tv4.setColor(true);
					break;
				case CANDIVALL:
					
					tv5.setColor(true);
					break;
				case SEVENDIV:
					
					tv6.setColor(true);
					break;
				case MULANDDIV:
					
					tv7.setColor(true);
					break;
				case SMALLBRACKET:
					
					tv8.setColor(true);
					break;
				case ADDANDSUB:
					
					tv9.setColor(true);
					break;
				case BIGADD:
					
					tv10.setColor(true);
					break;
				case BIGDIV:
					
					tv11.setColor(true);
					break;
				case NULANDSUB:
					
					tv12.setColor(true);
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
	  		editor.putInt("grade_3_down",requestCode);
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
	  		show_num =mySharedPreferences.getInt("grade_3_down", -1); 
		}
}
