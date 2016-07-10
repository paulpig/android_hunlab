package com.readboy.mentalcalculation;

import com.readboy.game.Grade_4.Grade_4_down;

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

public class MyFragment_Grade_4_down extends Fragment {
	 private FragmentActivity activity;
	 private int show_num=-1;
	  view tv;
	  View view ;
	  private view tv1;
	  private view tv2;
	  private view tv3;
	  private view tv4;
	  private view tv5;
	  final private int MULANDDIV=1;  //�й�0������
	  
	  
	  final private int CANDIVALL=2;	//�˷������
	  final private int SEVENDIV=3;  //�ӷ������ɡ��ӷ�����ɵ�Ӧ��
	  final private int DIVSPACE=4;		//�ӷ������
	  final private int DIVWAY=5;		//�����ļ������
	  private final String []intent_content={"�й�0������","�ӷ������","�ӷ������ɡ��ӷ�����ɵ�Ӧ��","�˷������","�����ļ������"};
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
	    view = inflater.inflate(R.layout.grade_4_down, container,
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
		  tv1=(view)view.findViewById(R.id.grade_4_down_11);
		  
		  
		  tv2=(view)view.findViewById(R.id.grade_4_down_21);
		  
		  
		  tv3=(view)view.findViewById(R.id.grade_4_down_22);
		  
		  tv4=(view)view.findViewById(R.id.grade_4_down_23);
		  
		  tv5=(view)view.findViewById(R.id.grade_4_down_24);
		  
		  tv1.setText(intent_content[0]);
		  tv2.setText(intent_content[1]);
		  tv3.setText(intent_content[2]);
		  tv4.setText(intent_content[3]);
		  
		  tv5.setText(intent_content[4]);
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],MULANDDIV);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],DIVSPACE);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],SEVENDIV);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],CANDIVALL);    
				}
			});  
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],DIVWAY);    
				}
			});  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_4_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
	  
	  /*���´��ļ��ж�ȡ���ֵ*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="41"+type;   //��ͬ�꼶���޸�
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
			
			//�����ļ�������
			setData(requestCode);
			
			
			switch(requestCode){
				case MULANDDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv1,MULANDDIV);
					tv1.setColor(true);
					break;
				case DIVSPACE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv2,DIVSPACE);
					tv2.setColor(true);
					break;
				case SEVENDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv3,SEVENDIV);
					tv3.setColor(true);
					break;
				case CANDIVALL:
					Log.i("lalala", "onActivity().in");
					setGrade(tv4,CANDIVALL);
					tv4.setColor(true);
					break;
				case DIVWAY:
					Log.i("lalala", "onActivity().in");
					setGrade(tv5,DIVWAY);
					tv5.setColor(true);
					break;
			}
		}
		  
		 //�������֮��ĸ������ǵĸ���
		 public  void refreshData(){
			 setGrade(tv1,MULANDDIV);
			 setGrade(tv2,DIVSPACE);
			 setGrade(tv3,SEVENDIV);
			 setGrade(tv4,CANDIVALL);
			 setGrade(tv5,DIVWAY);
		  }
		 
		 
		 /*ȫ�����Ϊ��ɫ*/
		 public void setAllBlue(){
			 tv1.setColor(false);
			 tv2.setColor(false);
			 tv3.setColor(false);
			 tv4.setColor(false);
			 tv5.setColor(false);
		 }
		 
		 
		 /*��ʾ��ʼ��ͼƬ��ɫ*/
		 public void setStartColor(int num){
			 switch(num){
			 case MULANDDIV:
					
					tv1.setColor(true);
					break;
				case DIVSPACE:
					
					tv2.setColor(true);
					break;
				case SEVENDIV:
					
					tv3.setColor(true);
					break;
				case CANDIVALL:


					tv4.setColor(true);
					break;
				case DIVWAY:
					tv5.setColor(true);
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
	  		editor.putInt("grade_4_down",requestCode);
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
	  		show_num =mySharedPreferences.getInt("grade_4_down", -1); 
		}
		
		
	  
}
