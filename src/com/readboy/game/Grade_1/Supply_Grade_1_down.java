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
	int type; //��������
	ArrayList<String> problem;
	ArrayList<Integer> answer;
	boolean stopThread;
	
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
	  
	  
	  
	  final private int TWOSUBTHIS=11;				//����ʮ����һλ����Ӧ�ļ������㷽��
	  final private int TENADDONE=12;			//��ʮ����һλ���ļ��㷽��
	
	public Supply_Grade_1_down(Handler handler_program,Object Alock,int type) {
		// TODO Auto-generated constructor stub
		this.handler_program=handler_program;
		this.Alock=Alock;
		this.type=type;
		stopThread=false;
	}
	
	/*������Ŀ*/
	
	public  void CreateSubject(){
		int ele_one=-1;
		int ele_two=-1;
		int ele_three=-1;
		int choose=Math.random()>0.5?1:0;   //ѡ��Ӽ�
		int choose_num=Math.random()>0.5?1:0;//ѡ������
		switch (type) {
		case TENSUBNINE://ʮ����9 �ļ��㷽��
			ele_one=10+(int)(Math.random()*9);
			ele_two=9;
			AddAndSubMethod(ele_one,ele_two,0);
			break;
		case TENSUBWHAT://ʮ�������ļ��㷽��
			ele_one=(int)(10+Math.random()*9);
			ele_two=(int)(Math.random()*9);
			AddAndSubMethod(ele_one,ele_two,0);
			break;
		case NOTWOADDONE://��λ����һλ��������λ���ļ��㷽��
			ele_one=(int)(10+Math.random()*89);
			int judge_num1=ele_one%10;
			ele_two=(int)(Math.random()*(9-judge_num1));
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		case TWOADDONE://��λ����һλ������λ���ļ��㷽��
			ele_one=(int)(10+Math.random()*89);
			int judge_num2=ele_one%10;
			while(judge_num2==0){
				ele_one=(int)(10+Math.random()*89);
				judge_num2=ele_one%10;
			}
			ele_two=10-judge_num2+(int)(Math.random()*(judge_num2-1));
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		case TWOADDTEN://��λ������ʮ���ļ��㷽��
			
			ele_two=(int)(Math.random()*8)*10+10;
			ele_one=(int)(10+Math.random()*(90-ele_two));
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		
		case NOTWOSUBONE://��λ����һλ��������λ���ļ��㷽��
			ele_one=(int)(10+Math.random()*89);
			int judge_num3=ele_one%10;
			ele_two=(int)(Math.random()*(judge_num3));
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
			
		case TWOSUBONE://��λ����һλ������λ���ļ��㷽��
			ele_one=(int)(10+Math.random()*89);
			int judge_num4=ele_one%10;
			while(judge_num4==9){
				ele_one=(int)(10+Math.random()*89);
				judge_num4=ele_one%10;
			}
			ele_two=judge_num4+1+(int)(Math.random()*(8-judge_num4));
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
			
		case TWOSUBTEN://��λ������ʮ���ļ��㷽��
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(Math.random()*(ele_one/10-1))*10+10;
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
		case TENADDTEN://��ʮ������ʮ���ļ��㷽��
			ele_one=(int)(Math.random()*8)*10+10;
			ele_two=(int)(Math.random()*(9-ele_one/10))*10+10;
			AddAndSubMethod(ele_one,ele_two,1);
			break;
			
		case TENSUBTEN://��ʮ������ʮ���ļ��㷽��
			ele_one=(int)(Math.random()*8)*10+10;
			ele_two=(int)(Math.random()*(ele_one/10-1))*10+10;
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
			
		case TWOSUBTHIS: //����ʮ����һλ����Ӧ�ļ������㷽��
			ele_two=(int)(Math.random()*9);
			ele_one=(int)(Math.random()*8)*10+10+ele_two;
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
			
		case TENADDONE: //��ʮ����һλ���ļ��㷽��
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
	
	/*����Ӽ���*/
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

