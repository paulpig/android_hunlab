package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_down;
import com.readboy.game.Grade_1.Grade_1_top;

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
import android.widget.TextView;

public class MyFragment_Grade_1_top extends Fragment {
	  private int show_num=-1;
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
	  private view tv16;
	  private view tv17;
	  private view tv18;
	  private view tv19;
	  private view tv20;
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
		  tv1=(view)view.findViewById(R.id.grade_1_top_11);
		  tv1.setText(intent_content[0]);
		  tv2=(view)view.findViewById(R.id.grade_1_top_12);
		  tv2.setText(intent_content[1]);
		  tv3=(view)view.findViewById(R.id.grade_1_top_13);
		  tv3.setText(intent_content[2]);
		  tv4=(view)view.findViewById(R.id.grade_1_top_14);
		  tv4.setText(intent_content[3]);
		  
		  tv5=(view)view.findViewById(R.id.grade_1_top_21);
		  tv5.setText(intent_content[4]);
		  tv6=(view)view.findViewById(R.id.grade_1_top_22);
		  tv6.setText(intent_content[5]);
		  tv7=(view)view.findViewById(R.id.grade_1_top_23);
		  tv7.setText(intent_content[6]);
		  tv8=(view)view.findViewById(R.id.grade_1_top_24);
		  tv8.setText(intent_content[7]);
		  tv9=(view)view.findViewById(R.id.grade_1_top_25);
		  tv9.setText(intent_content[8]);
		  tv10=(view)view.findViewById(R.id.grade_1_top_26);
		  tv10.setText(intent_content[9]);
		  tv11=(view)view.findViewById(R.id.grade_1_top_27);
		  tv11.setText(intent_content[10]);
		  tv12=(view)view.findViewById(R.id.grade_1_top_28);
		  tv12.setText(intent_content[11]);
		  tv13=(view)view.findViewById(R.id.grade_1_top_29);
		  tv13.setText(intent_content[12]);
		  tv14=(view)view.findViewById(R.id.grade_1_top_210);
		  tv14.setText(intent_content[13]);
		  
		  tv15=(view)view.findViewById(R.id.grade_1_top_31);
		  tv15.setText(intent_content[14]);
		  tv16=(view)view.findViewById(R.id.grade_1_top_32);
		  tv16.setText(intent_content[15]);
		  tv17=(view)view.findViewById(R.id.grade_1_top_33);
		  tv17.setText(intent_content[16]);
		  tv18=(view)view.findViewById(R.id.grade_1_top_41);
		  tv18.setText(intent_content[17]);
		  tv19=(view)view.findViewById(R.id.grade_1_top_42);
		  tv19.setText(intent_content[18]);
		  tv20=(view)view.findViewById(R.id.grade_1_top_43);
		  tv20.setText(intent_content[19]);
		  
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
	  
	  
	  /*���´��ļ��ж�ȡ���ֵ*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="10"+type;   //��ͬ�꼶���޸�
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
	  
	  
	  
	  /*��ת����Ϸ����*/
	  public void intentToGame(String content_intent,int type){
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_1_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivityForResult(intent,type);    
	  }
	 
	  
	  
	  
	 /*������һ�����淵�ص�ֵ*/
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.i("lalala", "onActivity()");
		//show_num=requestCode; 
		//�����ļ�������
		
		
		setData(requestCode);
		
		
		
		switch(requestCode){
			case ADDINFIVE:
				Log.i("lalala", "onActivity().in");
				setGrade(tv1,ADDINFIVE);
				tv1.setColor(true);
				break;
			case SUBINFIVE:
				Log.i("lalala", "onActivity().in");
				setGrade(tv2,SUBINFIVE);
				tv2.setColor(true);
				break;
			case ZEROONE:
				Log.i("lalala", "onActivity().in");
				setGrade(tv3,ZEROONE);
				tv3.setColor(true);
				break;
			case ZERTWO:
				Log.i("lalala", "onActivity().in");
				setGrade(tv4,ZERTWO);
				tv4.setColor(true);
				break;
			case ADDINFIVEANDSIX:
				Log.i("lalala", "onActivity().in");
				setGrade(tv5,ADDINFIVEANDSIX);
				tv5.setColor(true);
				break;
			case ADDFOREIGHT:
				Log.i("lalala", "onActivity().in");
				setGrade(tv6,ADDFOREIGHT);
				tv6.setColor(true);
				break;
			case ADDFORNINE:
				Log.i("lalala", "onActivity().in");
				setGrade(tv7,ADDFORNINE);
				tv7.setColor(true);
				break;
			case ADDINNINE:
				Log.i("lalala", "onActivity().in");
				setGrade(tv8,ADDINNINE);
				tv8.setColor(true);
				break;
			case ADDFORTEN:
				Log.i("lalala", "onActivity().in");
				setGrade(tv9,ADDFORTEN);
				tv9.setColor(true);
				break;
			case UNKOWNNUM:
				Log.i("lalala", "onActivity().in");
				setGrade(tv10,UNKOWNNUM);
				tv10.setColor(true);
				break;
			case CONTINUEADD:
				Log.i("lalala", "onActivity().in");
				setGrade(tv11,CONTINUEADD);
				tv11.setColor(true);
				break;
			case CONTINUESUD:
				Log.i("lalala", "onActivity().in");
				setGrade(tv12,CONTINUESUD);
				tv12.setColor(true);
				break;
			case ADDTHENSUB:
				Log.i("lalala", "onActivity().in");
				setGrade(tv13,ADDTHENSUB);
				tv13.setColor(true);
				break;
			case SUBTHENADD:
				Log.i("lalala", "onActivity().in");
				setGrade(tv14,SUBTHENADD);
				tv14.setColor(true);
				break;
			case TENADD:
				Log.i("lalala", "onActivity().in");
				setGrade(tv15,TENADD);
				tv15.setColor(true);
				break;
			case ADDFORTWI:
				Log.i("lalala", "onActivity().in");
				setGrade(tv16,ADDFORTWI);
				tv16.setColor(true);
				break;
			case ADDNAME:
				Log.i("lalala", "onActivity().in");
				setGrade(tv17,ADDNAME);
				tv17.setColor(true);
				break;
			case NINEADDWHAT:
				Log.i("lalala", "onActivity().in");
				setGrade(tv18,NINEADDWHAT);
				tv18.setColor(true);
				break;
			case SEVENEIGHT:
				Log.i("lalala", "onActivity().in");
				setGrade(tv19,SEVENEIGHT);
				tv19.setColor(true);
				break;
			case FIVETOTWO:
				Log.i("lalala", "onActivity().in");
				setGrade(tv20,FIVETOTWO);
				tv20.setColor(true);
				break;
		
		}
	}
	  
	 //�������֮��ĸ������ǵĸ���
	 public  void refreshData(){
		 setGrade(tv1,ADDINFIVE);
		 setGrade(tv2,SUBINFIVE);
		 setGrade(tv3,ZEROONE);
		 setGrade(tv4,ZERTWO);
		 setGrade(tv5,ADDINFIVEANDSIX);
		 setGrade(tv6,ADDFOREIGHT);
		 setGrade(tv7,ADDFORNINE);
		 setGrade(tv8,ADDINNINE);
		 setGrade(tv9,ADDFORTEN);
		 setGrade(tv10,UNKOWNNUM);
		 setGrade(tv11,CONTINUEADD);
		 setGrade(tv12,CONTINUESUD);
		 setGrade(tv13,ADDTHENSUB);
		 setGrade(tv14,SUBTHENADD);
		 setGrade(tv15,TENADD);
		 setGrade(tv16,ADDFORTWI);
		 setGrade(tv17,ADDNAME);
		 setGrade(tv18,NINEADDWHAT);
		 setGrade(tv19,SEVENEIGHT);
		 setGrade(tv20,FIVETOTWO);
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
		 tv16.setColor(false);
		 tv17.setColor(false);
		 tv18.setColor(false);
		 tv19.setColor(false);
		 tv20.setColor(false);
	 }
	 
	 /*��ʾ��ʼ��ͼƬ��ɫ*/
	 public void setStartColor(int num){
		 switch(num){
			case ADDINFIVE:
				tv1.setColor(true);
				break;
			case SUBINFIVE:
				tv2.setColor(true);
				break;
			case ZEROONE:
				tv3.setColor(true);
				break;
			case ZERTWO:
				tv4.setColor(true);
				break;
			case ADDINFIVEANDSIX:
				tv5.setColor(true);
				break;
			case ADDFOREIGHT:
				tv6.setColor(true);
				break;
			case ADDFORNINE:
				tv7.setColor(true);
				break;
			case ADDINNINE:
				tv8.setColor(true);
				break;
			case ADDFORTEN:
				tv9.setColor(true);
				break;
			case UNKOWNNUM:
				tv10.setColor(true);
				break;
			case CONTINUEADD:
				tv11.setColor(true);
				break;
			case CONTINUESUD:
				tv12.setColor(true);
				break;
			case ADDTHENSUB:
				tv13.setColor(true);
				break;
			case SUBTHENADD:
				tv14.setColor(true);
				break;
			case TENADD:
				tv15.setColor(true);
				break;
			case ADDFORTWI:
				tv16.setColor(true);
				break;
			case ADDNAME:
				tv17.setColor(true);
				break;
			case NINEADDWHAT:
				tv18.setColor(true);
				break;
			case SEVENEIGHT:
				tv19.setColor(true);
				break;
			case FIVETOTWO:
				tv20.setColor(true);
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
  		editor.putInt("grade_1_top", requestCode); 
  		editor.putInt("grade_1_down",-1);
  		editor.putInt("grade_2_top",-1);
  		editor.putInt("grade_2_down",-1);
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
  		show_num =mySharedPreferences.getInt("grade_1_top", -1); 
	}
	
	
}

	  
	  
