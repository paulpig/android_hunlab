package com.readboy.mentalcalculation;

import com.readboy.game.Grade_5.Grade_5_top;
import com.readboy.game.Grade_6.Grade_6_top;

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

public class MyFragment_Grade_6_top extends Fragment{
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
		  tv1=(view)view.findViewById(R.id.grade_6_top_11);
		  tv2=(view)view.findViewById(R.id.grade_6_top_12);
		  tv3=(view)view.findViewById(R.id.grade_6_top_13);
		  tv4=(view)view.findViewById(R.id.grade_6_top_14);
		  
		  tv5=(view)view.findViewById(R.id.grade_6_top_21);
		  tv6=(view)view.findViewById(R.id.grade_6_top_22);
		  tv7=(view)view.findViewById(R.id.grade_6_top_23);
		  
		  
		  tv8=(view)view.findViewById(R.id.grade_6_top_31);
		  tv9=(view)view.findViewById(R.id.grade_6_top_32);
		  
		  tv1.setText(intent_content[0]);
		  tv2.setText(intent_content[1]);
		  tv3.setText(intent_content[2]);
		  tv4.setText(intent_content[3]);
		  
		  tv5.setText(intent_content[4]);
		  tv6.setText(intent_content[5]);
		  tv7.setText(intent_content[6]);
		  tv8.setText(intent_content[7]);
		  tv9.setText(intent_content[8]);
		  
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
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_6_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
	  
	  
	  /*���´��ļ��ж�ȡ���ֵ*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="60"+type;   //��ͬ�꼶���޸�
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
				case SEVENDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv1,SEVENDIV);
					tv1.setColor(true);
					break;
				case MULANDDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv2,MULANDDIV);
					tv2.setColor(true);
					break;
				case CANDIVALL:
					Log.i("lalala", "onActivity().in");
					setGrade(tv3,CANDIVALL);
					tv3.setColor(true);
					break;
				case DIVSPACE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv4,DIVSPACE);
					tv4.setColor(true);
					break;
				case DIVWAY:
					Log.i("lalala", "onActivity().in");
					setGrade(tv5,DIVWAY);
					tv5.setColor(true);
					break;
				case MULANDADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv6,MULANDADD);
					tv6.setColor(true);
					break;
				case MULDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv7,MULDIV);
					tv7.setColor(true);
					break;
				case ADDANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv8,ADDANDSUB);
					tv8.setColor(true);
					break;
				case NULANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv9,NULANDSUB);
					tv9.setColor(true);
					break;
			}
		}
		  
		 //�������֮��ĸ������ǵĸ���
		 public  void refreshData(){
			 setGrade(tv1,SEVENDIV);
			 setGrade(tv2,MULANDDIV);
			 setGrade(tv3,CANDIVALL);
			 setGrade(tv4,DIVSPACE);
			 setGrade(tv5,DIVWAY);
			 setGrade(tv6,MULANDADD);
			 setGrade(tv7,MULDIV);
			 setGrade(tv8,ADDANDSUB);
			 setGrade(tv9,NULANDSUB);
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
		 }
		 
		 
		 /*��ʾ��ʼ��ͼƬ��ɫ*/
		 public void setStartColor(int num){
			 switch(num){
			 case SEVENDIV:
					
					tv1.setColor(true);
					break;
				case MULANDDIV:
					
					tv2.setColor(true);
					break;
				case CANDIVALL:
					
					tv3.setColor(true);
					break;
				case DIVSPACE:
					
					tv4.setColor(true);
					break;
				case DIVWAY:
					
					tv5.setColor(true);
					break;
				case MULANDADD:
					
					tv6.setColor(true);
					break;
				case MULDIV:
					
					tv7.setColor(true);
					break;
				case ADDANDSUB:
					
					tv8.setColor(true);
					break;
				case NULANDSUB:
					
					tv9.setColor(true);
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
	  		editor.putInt("grade_5_top",-1);
	  		editor.putInt("grade_5_down",-1);
	  		editor.putInt("grade_6_top",requestCode);
	  		//�ύ��ǰ���� 
	  		editor.commit(); 
			}
		
		//��ȡ�ļ��е��Ƿ�Ϊ��ɫ������
		public void getData(){
			String name="test";
	  		SharedPreferences mySharedPreferences= getActivity().getSharedPreferences(name, 
	  		Activity.MODE_PRIVATE); 
	  		show_num =mySharedPreferences.getInt("grade_6_top", -1); 
		}
		
}
