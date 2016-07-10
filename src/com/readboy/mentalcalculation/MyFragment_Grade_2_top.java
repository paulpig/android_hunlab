package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_top;
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

public class MyFragment_Grade_2_top extends Fragment {
	  private FragmentActivity activity;
	  private int show_num=-1;
	  private view tv;
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
	  View view;
	  private String []intent_content={"不进位加法","进位加法","不退位减法",
			  							"退位减法","连加","连减",
			  							"加减混合",
			  							"乘法是相同的数相加的简便算法","5的乘法口诀","2的乘法口诀",
			  							"3的乘法口诀","4的乘法口诀","乘加、乘减"
			  							,"6的乘法口诀",
			  							"7的乘法口诀","求一个数的几倍是多少的问题的计算方法","8的乘法口诀"
			  							,"9的乘法口诀","乘法口诀表"};
	  
	  final private int NOINADD=1;  //100以内不进位加法
	  final private int NOINSUB=2;	//100以内不退位减法
	  final private int ADDANDSUB=3;  //加减混合
	  final private int INADD=4;		//进位加法
	  final private int ADDADD=5;		//连加
	  final private int SUBSUB=6;		//连减
	  final private int  INSUB=7;		//退位减法
	  
	  
	  final private int MULFORSEVEN=8;		//7的乘法口诀
	  final private int MULFOREIGHT=9;		//8的乘法口诀
	  final private int MULFORNINE=10;		//9的乘法口诀
	  final private int MULTABLE=11;				//乘法口诀表
	  final private int NUMDOUBLE=12;			//求一个数的几倍是多少的问题的计算方法
	  
	  
	  final private int MULFORTWO=13;		//2的乘法口诀
	  final private int MULFORTHREE=14;		//3的乘法口诀
	  final private int MULFORFOUR=15;		//4的乘法口诀
	  final private int MULFORFIVE=16;		//5的乘法口诀
	  final private int MULFORSIX=17;		//6的乘法口诀
	  final private int MULISADD=18;				//乘法是相同的数相加的简便运算
	  final private int NULLADDSUB=19;			//乘加乘减
	  /**
	   * 把activity造型为FragmentActivity
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
	    //设置布局
	    view = inflater.inflate(R.layout.grade_2_top, container,
	        false);
	    init();
	    ListenEvent();
	    refreshData();
	    //得到关于实现粉色的数据
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
		  tv1=(view)view.findViewById(R.id.grade_2_top_11);
		  tv2=(view)view.findViewById(R.id.grade_2_top_12);
		  tv3=(view)view.findViewById(R.id.grade_2_top_13);
		  tv4=(view)view.findViewById(R.id.grade_2_top_14);
		  tv5=(view)view.findViewById(R.id.grade_2_top_15);
		  tv6=(view)view.findViewById(R.id.grade_2_top_16);
		  tv7=(view)view.findViewById(R.id.grade_2_top_17);
		  
		  
		  tv8=(view)view.findViewById(R.id.grade_2_top_21);
		  tv9=(view)view.findViewById(R.id.grade_2_top_22);
		  tv10=(view)view.findViewById(R.id.grade_2_top_23);
		  tv11=(view)view.findViewById(R.id.grade_2_top_24);
		  tv12=(view)view.findViewById(R.id.grade_2_top_25);
		  tv13=(view)view.findViewById(R.id.grade_2_top_26);
		  tv14=(view)view.findViewById(R.id.grade_2_top_27);
		  
		  tv15=(view)view.findViewById(R.id.grade_2_top_31);
		  tv16=(view)view.findViewById(R.id.grade_2_top_32);
		  tv17=(view)view.findViewById(R.id.grade_2_top_33);
		  tv18=(view)view.findViewById(R.id.grade_2_top_34);
		  tv19=(view)view.findViewById(R.id.grade_2_top_35);
		  
		  
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
		  tv16.setText(intent_content[15]);
		  tv17.setText(intent_content[16]);
		  tv18.setText(intent_content[17]);
		  tv19.setText(intent_content[18]);
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
		  setAllBlue();
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_2_top.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }

	  
	  /*重新从文件中读取最大值*/
	  public void setGrade(view tv,int type){
		String name="test";
		String intent_type="20"+type;   //不同年级的修改
	  	SharedPreferences sharedPreferences= getActivity().getSharedPreferences(name, 
	  				Activity.MODE_PRIVATE); 
	  	int top_grade=sharedPreferences.getInt("first_grade"+intent_type, 0); 
	  	judgeGrade(top_grade,tv);
	  }
	  
	  
	  
	  //设置星星的个数
	  public void judgeGrade(int topGrade,view tv){
		  if(topGrade/20 <6)
			  tv.setStarNum((int)(topGrade/20));
		  else{
			  tv.setStarNum(5);
		  }
	  }
	  
	  
	  /*接受下一个界面返回的值*/
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
			Log.i("lalala", "onActivity()");
			
			setData(requestCode);
			
			
			switch(requestCode){
				case NOINADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv1,NOINADD);
					tv1.setColor(true);
					break;
				case INADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv2,INADD);
					tv2.setColor(true);
					break;
				case NOINSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv3,NOINSUB);
					tv3.setColor(true);
					break;
				case INSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv4,INSUB);
					tv4.setColor(true);
					break;
				case ADDADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv5,ADDADD);
					tv5.setColor(true);
					break;
				case SUBSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv6,SUBSUB);
					tv6.setColor(true);
					break;
				case ADDANDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv7,ADDANDSUB);
					tv7.setColor(true);
					break;
				case MULISADD:
					Log.i("lalala", "onActivity().in");
					setGrade(tv8,MULISADD);
					tv8.setColor(true);
					break;
				case MULFORFIVE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv9,MULFORFIVE);
					tv9.setColor(true);
					break;
				case MULFORTWO:
					Log.i("lalala", "onActivity().in");
					setGrade(tv10,MULFORTWO);
					tv10.setColor(true);
					break;
				case MULFORTHREE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv11,MULFORTHREE);
					tv11.setColor(true);
					break;
				case MULFORFOUR:
					Log.i("lalala", "onActivity().in");
					setGrade(tv12,MULFORFOUR);
					tv12.setColor(true);
					break;
				case NULLADDSUB:
					Log.i("lalala", "onActivity().in");
					setGrade(tv13,NULLADDSUB);
					tv13.setColor(true);
					break;
				case MULFORSIX:
					Log.i("lalala", "onActivity().in");
					setGrade(tv14,MULFORSIX);
					tv14.setColor(true);
					break;
				case MULFORSEVEN:
					Log.i("lalala", "onActivity().in");
					setGrade(tv15,MULFORSEVEN);
					tv15.setColor(true);
					break;
				case NUMDOUBLE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv16,NUMDOUBLE);
					tv16.setColor(true);
					break;
				case MULFOREIGHT:
					Log.i("lalala", "onActivity().in");
					setGrade(tv17,MULFOREIGHT);
					tv17.setColor(true);
					break;
				case MULFORNINE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv18,MULFORNINE);
					tv18.setColor(true);
					break;
				case MULTABLE:
					Log.i("lalala", "onActivity().in");
					setGrade(tv19,MULTABLE);
					tv19.setColor(true);
					break;
			
			}
		}
		  
		 //进入界面之后的更新星星的个数
		 public  void refreshData(){
			 setGrade(tv1,NOINADD);
			 setGrade(tv2,INADD);
			 setGrade(tv3,NOINSUB);
			 setGrade(tv4,INSUB);
			 setGrade(tv5,ADDADD);
			 setGrade(tv6,SUBSUB);
			 setGrade(tv7,ADDANDSUB);
			 setGrade(tv8,MULISADD);
			 setGrade(tv9,MULFORFIVE);
			 setGrade(tv10,MULFORTWO);
			 setGrade(tv11,MULFORTHREE);
			 setGrade(tv12,MULFORFOUR);
			 setGrade(tv13,NULLADDSUB);
			 setGrade(tv14,MULFORSIX);
			 setGrade(tv15,MULFORSEVEN);
			 setGrade(tv16,NUMDOUBLE);
			 setGrade(tv17,MULFOREIGHT);
			 setGrade(tv18,MULFORNINE);
			 setGrade(tv19,MULTABLE);
		  }
		 
		 
		 /*全部清空为蓝色*/
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
		 }
		 
		 
		 /*显示开始的图片颜色*/
		 public void setStartColor(int num){
			 switch(num){
			 case NOINADD:
				
					tv1.setColor(true);
					break;
				case INADD:
					
					tv2.setColor(true);
					break;
				case NOINSUB:
				
					tv3.setColor(true);
					break;
				case INSUB:
			
					tv4.setColor(true);
					break;
				case ADDADD:
					
					tv5.setColor(true);
					break;
				case SUBSUB:
				
					tv6.setColor(true);
					break;
				case ADDANDSUB:
					
					tv7.setColor(true);
					break;
				case MULISADD:
					
					tv8.setColor(true);
					break;
				case MULFORFIVE:
					
					tv9.setColor(true);
					break;
				case MULFORTWO:
					
					tv10.setColor(true);
					break;
				case MULFORTHREE:
					
					tv11.setColor(true);
					break;
				case MULFORFOUR:
					
					tv12.setColor(true);
					break;
				case NULLADDSUB:
					
					tv13.setColor(true);
					break;
				case MULFORSIX:
					
					tv14.setColor(true);
					break;
				case MULFORSEVEN:
					
					tv15.setColor(true);
					break;
				case NUMDOUBLE:
					
					tv16.setColor(true);
					break;
				case MULFOREIGHT:
					
					tv17.setColor(true);
					break;
				case MULFORNINE:
					
					tv18.setColor(true);
					break;
				case MULTABLE:
					tv19.setColor(true);
					break;
			
		 }
		 }

	//设置文件中数据
		public void setData(int requestCode){
			String name="test";
	  		SharedPreferences mySharedPreferences= getActivity().getSharedPreferences(name, 
	  		Activity.MODE_PRIVATE); 
	  		//实例化SharedPreferences.Editor对象（第二步） 
	  		SharedPreferences.Editor editor = mySharedPreferences.edit(); 
	  		//用putString的方法保存数据 
	  		editor.putInt("grade_1_top", -1); 
	  		editor.putInt("grade_1_down",-1);
	  		editor.putInt("grade_2_top",requestCode);
	  		editor.putInt("grade_2_down",-1);
	  		editor.putInt("grade_3_top",-1);
	  		editor.putInt("grade_3_down",-1);
	  		editor.putInt("grade_4_top",-1);
	  		editor.putInt("grade_4_down",-1);
	  		editor.putInt("grade_5_top",-1);
	  		editor.putInt("grade_5_down",-1);
	  		editor.putInt("grade_6_top",-1);
	  		//提交当前数据 
	  		editor.commit(); 
			}
		
		//获取文件中的是否为粉色的数据
		public void getData(){
			String name="test";
	  		SharedPreferences mySharedPreferences= getActivity().getSharedPreferences(name, 
	  		Activity.MODE_PRIVATE); 
	  		show_num =mySharedPreferences.getInt("grade_2_top", -1); 
		}
	  
	  }

	  
	  
