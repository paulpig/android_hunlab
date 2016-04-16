package com.readboy.game.Grade_1;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public  class Supply_Grade_1_down implements Runnable  {

	Handler handler_program;
	Object Alock;
	int count=0;
	int type; //出题类型
	ArrayList<String> problem;
	ArrayList<Integer> answer;
	boolean stopThread;
	
	  final private int TENSUBNINE=1;  //十几减9 的计算方法
	  final private int TENSUBWHAT=2;	//十几减几的计算方法
	  
	  
	  final private int NOTWOADDONE=3;  //两位数加一位数（不进位）的计算方法
	  final private int TWOADDONE=4;		//两位数加一位数（进位）的计算方法
	  final private int TWOADDTEN=5;		//两位数加整十数的计算方法
	  final private int NOTWOSUBONE=6;		//两位数减一位数（不退位）的计算方法
	  final private int  TWOSUBONE=7;		//两位数减一位数（退位）的计算方法
	  final private int TWOSUBTEN=8;		//两位数减整十数的计算方法
	  final private int TENADDTEN=9;		//整十数加整十数的计算方法
	  final private int TENSUBTEN=10;		//整十数减整十数的计算方法
	  
	  
	  
	  final private int TWOSUBTHIS=11;				//与整十数加一位数对应的减法计算方法
	  final private int TENADDONE=12;			//整十数加一位数的计算方法
	
	public Supply_Grade_1_down(Handler handler_program,Object Alock,int type) {
		// TODO Auto-generated constructor stub
		this.handler_program=handler_program;
		this.Alock=Alock;
		this.type=type;
		stopThread=false;
	}
	
	/*产生题目*/
	
	public  void CreateSubject(){
		int ele_one=-1;
		int ele_two=-1;
		int ele_three=-1;
		int choose=Math.random()>0.5?1:0;   //选择加减
		int choose_num=Math.random()>0.5?1:0;//选择数字
		switch (type) {
		case TENSUBNINE://十几减9 的计算方法
			ele_one=10+(int)(Math.random()*9);
			ele_two=9;
			AddAndSubMethod(ele_one,ele_two,0);
			break;
		case TENSUBWHAT://十几减几的计算方法
			ele_one=(int)(10+Math.random()*9);
			ele_two=(int)(Math.random()*9);
			AddAndSubMethod(ele_one,ele_two,0);
			break;
		case NOTWOADDONE://两位数加一位数（不进位）的计算方法
			ele_one=(int)(10+Math.random()*89);
			int judge_num1=ele_one%10;
			ele_two=(int)(Math.random()*(9-judge_num1));
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		case TWOADDONE://两位数加一位数（进位）的计算方法
			ele_one=(int)(10+Math.random()*89);
			int judge_num2=ele_one%10;
			while(judge_num2==0){
				ele_one=(int)(10+Math.random()*89);
				judge_num2=ele_one%10;
			}
			ele_two=10-judge_num2+(int)(Math.random()*(judge_num2-1));
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		case TWOADDTEN://两位数加整十数的计算方法
			
			ele_two=(int)(Math.random()*8)*10+10;
			ele_one=(int)(10+Math.random()*(90-ele_two));
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		
		case NOTWOSUBONE://两位数减一位数（不退位）的计算方法
			ele_one=(int)(10+Math.random()*89);
			int judge_num3=ele_one%10;
			ele_two=(int)(Math.random()*(judge_num3));
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
			
		case TWOSUBONE://两位数减一位数（退位）的计算方法
			ele_one=(int)(10+Math.random()*89);
			int judge_num4=ele_one%10;
			while(judge_num4==9){
				ele_one=(int)(10+Math.random()*89);
				judge_num4=ele_one%10;
			}
			ele_two=judge_num4+1+(int)(Math.random()*(8-judge_num4));
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
			
		case TWOSUBTEN://两位数减整十数的计算方法
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(Math.random()*(ele_one/10-1))*10+10;
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
		case TENADDTEN://整十数加整十数的计算方法
			ele_one=(int)(Math.random()*8)*10+10;
			ele_two=(int)(Math.random()*(9-ele_one/10))*10+10;
			AddAndSubMethod(ele_one,ele_two,1);
			break;
			
		case TENSUBTEN://整十数减整十数的计算方法
			ele_one=(int)(Math.random()*8)*10+10;
			ele_two=(int)(Math.random()*(ele_one/10-1))*10+10;
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
			
		case TWOSUBTHIS: //与整十数加一位数对应的减法计算方法
			ele_two=(int)(Math.random()*9);
			ele_one=(int)(Math.random()*8)*10+10+ele_two;
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
			
		case TENADDONE: //整十数加一位数的计算方法
			ele_one=(int)(Math.random()*8)*10+10;
			ele_two=(int)(Math.random()*9);
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		default:
			break;
		}
	}

	public void setTag(boolean stopThread){
		this.stopThread=stopThread;
	}
	
	/*计算加减法*/
	public void AddAndSubMethod(int num1,int num2,int choose){
		if(choose==1){
			problem.add(num1+"+"+num2+"=");
			answer.add(num1+num2);
		}
		else{
			//int ele_sum=num1+num2;
			problem.add(num1+"-"+num2+"=");
			answer.add(num1-num2);
		}
	}
	
	
	public void run() {
		problem=new ArrayList<String>();
		answer=new ArrayList<Integer>();
		while(!stopThread){
			CreateSubject();
			Message message = new Message(); 
			Bundle bundle=new Bundle();
			bundle.putString("problem",problem.get(count));
			bundle.putInt("answer", answer.get(count));
			message.setData(bundle);
			handler_program.sendMessage(message);
			count++;
			synchronized(Alock) {
				try {
					Alock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
		}
	}

}

