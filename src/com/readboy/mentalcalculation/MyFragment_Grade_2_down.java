package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_top;
import com.readboy.game.Grade_2.Grade_2_down;
import com.readboy.game.Grade_2.Grade_2_top;

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

public class MyFragment_Grade_2_down extends Fragment {
	  private FragmentActivity activity;
	  private int show_num=-1;
	  private view tv;
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
	  private String []intent_content={"�üӷ��ͼ�����������������","��С�������ۺ���ʽ�������","�ó˷��ͼӷ���������������","�ó˷��ͼ�����������������",
			  							"������ʽ�����ֵ�����","���̵ķ���","�ó˷��ͳ�����������������",
			  							"��7��8��9�ĳ˷��ھ�����","��\"һ��������һ��������\"�Ľ��ⷽ��","�˳���������˳��",
			  							"��λ������λ�����㷽��","��λ������λ���Ŀ��㷽��","���ټ�ʮ�Ӽ��ټ�ʮ�ļ��㷽��","���ټ�ʮ�����ټ�ʮ�ļ��㷽��"};
	  
	  final private int MULANDDIV=1;  //�˳���������˳��
	  final private int CANDIVALL=2;	//��һ��������һ���������Ľ��ⷽ��
	  final private int SEVENDIV=3;  //��789�ĳ˷��ھ�����
	  
	  
	  final private int DIVSPACE=4;		//������ʽ�����ֵ�����
	  final private int DIVWAY=5;		//���̵ķ���
	  final private int MULDIV=6;		//�ó˷��ͳ�����������������
	  
	  
	  final private int  MULANDADD=7;		//�ó˷��ͼӷ���������������
	  final private int NULANDSUB=8;		//�ó˷��ͼ�����������������
	  final private int ADDANDSUB=9;		//�üӷ��ͼ�����������������
	  final private int SMALLBRACKET=10;		//��С�������ۺ���ʽ�������
	  
	  
	  
	  final private int BIGADD=11;				//���ټ�ʮ�Ӽ��ټ�ʮ�ļ��㷽��
	  final private int BIGDIV=12;			//���ټ�ʮ�����ټ�ʮ�ļ��㷽��
	  final private int MIDADD=13;				//��λ������λ�����㷽��
	  final private int MIDDIV=14;			//��λ������λ���Ŀ��㷽��
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
	    view = inflater.inflate(R.layout.grade_2_down, container,
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
		  tv1=(view)view.findViewById(R.id.grade_2_down_11);
		  tv2=(view)view.findViewById(R.id.grade_2_down_12);
		  tv3=(view)view.findViewById(R.id.grade_2_down_13);
		  tv4=(view)view.findViewById(R.id.grade_2_down_14);
		  
		  tv5=(view)view.findViewById(R.id.grade_2_down_21);
		  tv6=(view)view.findViewById(R.id.grade_2_down_22);
		  tv7=(view)view.findViewById(R.id.grade_2_down_23);
		  
		  
		  tv8=(view)view.findViewById(R.id.grade_2_down_31);
		  tv9=(view)view.findViewById(R.id.grade_2_down_32);
		  tv10=(view)view.findViewById(R.id.grade_2_down_33);
		  
		  tv11=(view)view.findViewById(R.id.grade_2_down_41);
		  tv12=(view)view.findViewById(R.id.grade_2_down_42);
		  tv13=(view)view.findViewById(R.id.grade_2_down_43);
		  tv14=(view)view.findViewById(R.id.grade_2_down_44);
		  
		  
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
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],ADDANDSUB);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],SMALLBRACKET);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],MULANDADD);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],NULANDSUB);    
				}
			});
		  
		  
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],DIVSPACE);     
				}
			});
		  tv6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[5],DIVWAY);     
				}
			});
		  tv7.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[6],MULDIV);     
				}
			});
		  
		  
		  
		  
		  
		  tv8.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[7],SEVENDIV);    
				}
			});
		  tv9.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[8],CANDIVALL);     
				}
			});
		  tv10.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[9],MULANDDIV);     
				}
			});
		  
		  
		  
		  
		  tv11.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[10],MIDADD);     
				}
			});
		  tv12.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[11],MIDDIV);    
				}
			});
		  
		  tv13.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[12],BIGADD);     
				}
			});
		  tv14.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[13],BIGDIV);     
				}
			});
		  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_2_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivityForResult(intent,type);   
	  }
	  
	  
	  /*���´��ļ��ж�ȡ���ֵ*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="21"+type;   //��ͬ�꼶���޸�
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
				case SMALLBRACKET:
					Log.i("lalala", "onActivity().in");
					setGrade(tv2,SMALLBRACKET);
					tv2.setColor(true);
					break;
				case MULANDADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv3,MULANDADD);
					tv3.setColor(true);
					break;
				case NULANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv4,NULANDSUB);
					tv4.setColor(true);
					break;
				case DIVSPACE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv5,DIVSPACE);
					tv5.setColor(true);
					break;
				case DIVWAY:
					Log.i("lalala", "onActivity().in");
					setGrade(tv6,DIVWAY);
					tv6.setColor(true);
					break;
				case MULDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv7,MULDIV);
					tv7.setColor(true);
					break;
				case SEVENDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv8,SEVENDIV);
					tv8.setColor(true);
					break;
				case CANDIVALL:
					Log.i("lalala", "onActivity().in");
					setGrade(tv9,CANDIVALL);
					tv9.setColor(true);
					break;
				case MULANDDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv10,MULANDDIV);
					tv10.setColor(true);
					break;
				case MIDADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv11,MIDADD);
					tv11.setColor(true);
					break;
				case MIDDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv12,MIDDIV);
					tv12.setColor(true);
					break;
				case BIGADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv13,BIGADD);
					tv13.setColor(true);
					break;
				case BIGDIV:
					Log.i("lalala", "onActivity().in");
					setGrade(tv14,BIGDIV);
					tv14.setColor(true);
					break;
			
			}
		}
		  
		 //�������֮��ĸ������ǵĸ���
		 public  void refreshData(){
			 setGrade(tv1,ADDANDSUB);
			 setGrade(tv2,SMALLBRACKET);
			 setGrade(tv3,MULANDADD);
			 setGrade(tv4,NULANDSUB);
			 setGrade(tv5,DIVSPACE);
			 setGrade(tv6,DIVWAY);
			 setGrade(tv7,MULDIV);
			 setGrade(tv8,SEVENDIV);
			 setGrade(tv9,CANDIVALL);
			 setGrade(tv10,MULANDDIV);
			 setGrade(tv11,MIDADD);
			 setGrade(tv12,MIDDIV);
			 setGrade(tv13,BIGADD);
			 setGrade(tv14,BIGDIV);
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
		 }
		 
		 
		 /*��ʾ��ʼ��ͼƬ��ɫ*/
		 public void setStartColor(int num){
			 switch(num){
			 case ADDANDSUB:
					
					tv1.setColor(true);
					break;
				case SMALLBRACKET:
					
					tv2.setColor(true);
					break;
				case MULANDADD:
					
					tv3.setColor(true);
					break;
				case NULANDSUB:
					
					tv4.setColor(true);
					break;
				case DIVSPACE:
					
					tv5.setColor(true);
					break;
				case DIVWAY:
					
					tv6.setColor(true);
					break;
				case MULDIV:
					
					tv7.setColor(true);
					break;
				case SEVENDIV:
					
					tv8.setColor(true);
					break;
				case CANDIVALL:
					
					tv9.setColor(true);
					break;
				case MULANDDIV:
					
					tv10.setColor(true);
					break;
				case MIDADD:
					
					tv11.setColor(true);
					break;
				case MIDDIV:
					
					tv12.setColor(true);
					break;
				case BIGADD:
					
					tv13.setColor(true);
					break;
				case BIGDIV:
					
					tv14.setColor(true);
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
	  		editor.putInt("grade_2_down",requestCode);
	  		editor.putInt("grade_3_top",-1);
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
	  		show_num =mySharedPreferences.getInt("grade_2_down", -1); 
		}
		
	  
	  }

	  
	  
