package com.readboy.game.Grade_1;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public  class Supply_Grade_1_top implements Runnable  {

	Handler handler_program;
	Object Alock;
	int count=0;
	int type; //��������
	boolean stopThread;
	ArrayList<String> problem;
	ArrayList<Integer> answer;
	
	
	final private int ADDINFIVE=1;			//5���ڵļӷ�
	final private int SUBINFIVE=2;			//5���ڵļ���
	final private int ZEROONE=3;			//0�ļ���1
	final private int ZERTWO=4;				//0�ļ���2
	
	
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
	
	public Supply_Grade_1_top(Handler handler_program,Object Alock,int type) {
		// TODO Auto-generated constructor stub
		this.handler_program=handler_program;
		this.Alock=Alock;
		this.type=type;
		stopThread=false;
	}
	
	public void setTag(boolean stopThread){
		this.stopThread=stopThread;
	}
	
	/*������Ŀ*/
	
	public  void CreateSubject(){
		int ele_one=-1;
		int ele_two=-1;
		int ele_three=-1;
		int choose=Math.random()>0.5?1:0;   //ѡ��Ӽ�
		int choose_num=Math.random()>0.5?1:0;//ѡ������
		switch (type) {
		case ADDINFIVE://5���ڵļӷ�
			ele_one=(int)(Math.random()*5);
			ele_two=(int)(Math.random()*5);
			while(ele_two+ele_one>5){
				ele_two=(int)(Math.random()*5);
			}
			problem.add(ele_one+"+"+ele_two+"=");
			answer.add(ele_one+ele_two);
			break;
		case SUBINFIVE://5���ڵļ���
			ele_one=(int)(Math.random()*5);
			ele_two=(int)(Math.random()*ele_one);
			problem.add(ele_one+"-"+ele_two);
			answer.add(ele_one-ele_two);
			break;
		case ZEROONE://0�ļ���1
			ele_one=(int)(Math.random()*5);
			ele_two=ele_one;
			problem.add(ele_one+"-"+ele_two);
			answer.add(ele_one-ele_two);
			break;
		case ZERTWO://0�ļ���2
			ele_one=(int)(Math.random()*5);
			if(choose==0){
				problem.add(ele_one+"-"+0+"=");
			}
			else{
				problem.add(ele_one+"+"+0+"=");
			}
			answer.add(ele_one);
			break;
		case ADDINFIVEANDSIX://6��7�ļӼ���
			ele_one=(int)(Math.random()*7);
			ele_two=(int)(Math.random()*7);
			while(ele_two+ele_one!=6||ele_two+ele_one!=7){
				ele_two=(int)(Math.random()*7);
			}
			AddAndSubMethod(ele_one,ele_two,choose);
			break;
		
		case ADDFORNINE://9�ļӼ���
			ele_one=(int)(Math.random()*9);
			ele_two=(int)(Math.random()*9);
			while(ele_two+ele_one!=9){
				ele_two=(int)(Math.random()*9);
			}
			
			AddAndSubMethod(ele_one,ele_two,choose);
			break;
			
			
		case ADDINNINE://9���ڵļӼ���
			ele_one=(int)(Math.random()*9);
			ele_two=(int)(Math.random()*9);
			while(ele_two+ele_one>9){
				ele_two=(int)(Math.random()*9);
			}
			AddAndSubMethod(ele_one,ele_two,choose);
			break;
			
			
		case ADDFORTEN://10�ļӼ���
			ele_one=(int)(Math.random()*10);
			ele_two=(int)(Math.random()*10);
			while(ele_two+ele_one!=10){
				ele_two=(int)(Math.random()*10);
			}
			AddAndSubMethod(ele_one,ele_two,choose);
			break;
			
		case CONTINUEADD://����
			ele_one=(int)(Math.random()*10);
			ele_two=(int)(Math.random()*10);
			ele_three=(int)(Math.random()*10);
			while(ele_two+ele_one+ele_three>10){
				ele_two=(int)(Math.random()*10);
				ele_three=(int)(Math.random()*10);
			}
			problem.add(ele_one+"+"+ele_two+"+"+ele_three+"=");
			answer.add(ele_one+ele_two+ele_three);
			break;
			
		case CONTINUESUD://����
			ele_one=(int)(Math.random()*10);
			ele_two=(int)(Math.random()*ele_one);
			ele_three=(int)(Math.random()*ele_two);
			problem.add(ele_one+"-"+ele_two+"-"+ele_three);
			answer.add(ele_one-ele_two-ele_three);
			break;
			
			
		case UNKOWNNUM: //δ֪���ļӼ�
			int xposition=Math.random()>0.5?1:0;
			ele_one=(int)(Math.random()*10);
			ele_two=(int)(Math.random()*ele_one);
			if(choose==0 && xposition==0){
				problem.add("x"+"+"+ele_two+"="+ele_one+"  x=");
			}
			else if(choose==0 && xposition==1){
				problem.add(ele_two+"+"+"x"+"="+ele_one+"   x=");
			}
			else if(choose==1 && xposition==0){
				problem.add(ele_one+"-"+"x"+"="+ele_two+"    x=");
			}
			else{
				problem.add(ele_one+"-"+"x"+"="+ele_two+"    x=");
			}
			answer.add(ele_one-ele_two);
			break;
			
			
		case ADDTHENSUB: //�ȼӺ��
			ele_one=(int)(Math.random()*10);
			ele_two=(int)(Math.random()*10);
			ele_three=(int)(Math.random()*10);
			while(ele_one+ele_two>10 || ele_one+ele_two-ele_three<0){
				ele_two=(int)(Math.random()*10);
				ele_three=(int)(Math.random()*10);
			}
			problem.add(ele_one+"+"+ele_two+"-"+ele_three+"=");
			answer.add(ele_one+ele_two-ele_three);
			break;
			
			
		case SUBTHENADD: //�ȼ����
			ele_one=(int)(Math.random()*10);
			ele_two=(int)(Math.random()*ele_one);
			ele_three=(int)(Math.random()*10);
			while(ele_one-ele_two+ele_three>10){
				ele_two=(int)(Math.random()*10);
				ele_three=(int)(Math.random()*10);
			}
			problem.add(ele_one+"-"+ele_two+"+"+ele_three+"=");
			answer.add(ele_one-ele_two+ele_three);
			break;
		case ADDFOREIGHT:     //һͼ��ʽ��8�ļӼ���
			ele_one=(int)(Math.random()*8);
			ele_two=(int)(Math.random()*8);
			while(ele_two+ele_one!=8){
				ele_two=(int)(Math.random()*8);
			}
			AddAndSubMethod(ele_one,ele_two,choose);
			break;
			
			
		case TENADD:  		//ʮ�Ӽ�
			ele_one=10;
			ele_two=(int)(Math.random()*10);
			while(ele_two+ele_one>20){
				ele_two=(int)(Math.random()*10);
			}
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		case ADDNAME:		//�Ӽ����ĸ���������
			ele_one=(int)(Math.random()*20);
			ele_two=(int)(Math.random()*ele_one);
			while(ele_two+ele_one>20){
				ele_two=(int)(Math.random()*ele_one);
			}
			AddAndSubMethod(ele_one,ele_two,choose);
			break;
		case ADDFORTWI: 	//ʮ���Ӽ�����Ӧ�ļ�
			ele_one=(int)(10+Math.random()*9);
			ele_two=(int)(Math.random()*9);
			while(ele_two+ele_one>20){
				ele_two=(int)(Math.random()*9);
			}
			AddAndSubMethod(ele_one,ele_two,choose);
			
			break;
		case NINEADDWHAT:		//�żӼ���Ӧ�ļ���
			ele_one=9;
			ele_two=(int)(Math.random()*10);
			while(ele_two+ele_one>20){
				ele_two=(int)(Math.random()*10);
			}
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		case SEVENEIGHT:		//876�Ӽ��ļ��㷽��
			if(choose==1&&choose_num==1){
				ele_one=8;
			}
			else if(choose==0&&choose_num==1){
				ele_one=7;
			}
			else if(choose==1&&choose_num==0){
				ele_one=6;
			}
			else{
				ele_one=6;
			}
			ele_two=(int)(Math.random()*20);
			while(ele_two+ele_one>20){
				ele_two=(int)(Math.random()*20);
			}
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		case FIVETOTWO:			//5432�Ӽ��ļ��㷽��
			if(choose==1&&choose_num==1){
				ele_one=5;
			}
			else if(choose==0&&choose_num==1){
				ele_one=4;
			}
			else if(choose==1&&choose_num==0){
				ele_one=3;
			}
			else{
				ele_one=2;
			}
			ele_two=(int)(Math.random()*20);
			while(ele_two+ele_one>20){
				ele_two=(int)(Math.random()*20);
			}
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		default:
			break;
		}
	}

	
	
	/*����Ӽ���*/
	public void AddAndSubMethod(int num1,int num2,int choose){
		if(choose==1){
			problem.add(num1+"+"+num2+"=");
			answer.add(num1+num2);
		}
		else{
			int ele_sum=num1+num2;
			problem.add(ele_sum+"-"+num1+"=");
			answer.add(num2);
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
