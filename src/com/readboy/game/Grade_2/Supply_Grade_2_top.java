package com.readboy.game.Grade_2;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.renderscript.Program;

public class Supply_Grade_2_top implements Runnable{
	Handler handler_program;
	Object Alock;
	int count=0;
	int type; //��������
	ArrayList<String> problem;
	ArrayList<Integer> answer;
	
	
	  final private int NOINADD=1;  //100���ڲ���λ�ӷ�
	  final private int NOINSUB=2;	//100���ڲ���λ����
	  final private int ADDANDSUB=3;  //�Ӽ����
	  final private int INADD=4;		//��λ�ӷ�
	  final private int ADDADD=5;		//����
	  final private int SUBSUB=6;		//����
	  final private int  INSUB=7;		//��λ����
	  
	  
	  final private int MULFORSEVEN=8;		//7�ĳ˷��ھ�
	  final private int MULFOREIGHT=9;		//8�ĳ˷��ھ�
	  final private int MULFORNINE=10;		//9�ĳ˷��ھ�
	  final private int MULTABLE=11;				//�˷��ھ���
	  final private int NUMDOUBLE=12;			//��һ�����ļ����Ƕ��ٵ�����ļ��㷽��
	  
	  
	  final private int MULFORTWO=13;		//2�ĳ˷��ھ�
	  final private int MULFORTHREE=14;		//3�ĳ˷��ھ�
	  final private int MULFORFOUR=15;		//4�ĳ˷��ھ�
	  final private int MULFORFIVE=16;		//5�ĳ˷��ھ�
	  final private int MULFORSIX=17;		//6�ĳ˷��ھ�
	  final private int MULISADD=18;				//�˷�����ͬ������ӵļ������
	  final private int NULLADDSUB=19;			//�˼ӳ˼�
	
	public Supply_Grade_2_top(Handler handler_program,Object Alock,int type) {
		// TODO Auto-generated constructor stub
		this.handler_program=handler_program;
		this.Alock=Alock;
		this.type=type;
	}
	
	/*������Ŀ*/
	
	public  void CreateSubject(){
		int ele_one=-1;
		int ele_two=-1;
		int ele_three=-1;
		int choose=Math.random()>0.5?1:0;   //ѡ��Ӽ�
		int choose_num=Math.random()>0.5?1:0;//ѡ������
		switch (type) {
		case NOINADD://100���ڲ���λ�ӷ�
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(10+Math.random()*(90-ele_one));
			while(ele_one%10+ele_two%10>=10){
				ele_two=(int)(Math.random()*(100-ele_one));
			}
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		case NOINSUB://100���ڲ���λ����
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(Math.random()*ele_one);
			while(ele_one%10<ele_two%10){
				ele_two=(int)(Math.random()*ele_one);
			}
			AddAndSubMethod(ele_one,ele_two,0);
			break;
		case ADDANDSUB:////�Ӽ����
			ele_one=(int)(10+Math.random()*79);
			ele_two=(int)(10+Math.random()*79);
			while(ele_one+ele_two>100){
				ele_two=(int)(10+Math.random()*79);
			}
			ele_three=(int)(10+Math.random()*(ele_one+ele_two-10));
			problem.add(ele_one+"+"+ele_two+"-"+ele_three);
			answer.add(ele_one+ele_two-ele_three);
			break;
		case INADD://��λ�ӷ�
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(10+Math.random()*(90-ele_one));
			while(ele_one%10+ele_two%10<10){
				ele_two=(int)(10+Math.random()*(90-ele_one));
			}
			AddAndSubMethod(ele_one,ele_two,1);
			break;
		case ADDADD://����
			ele_one=(int)(10+Math.random()*69);
			ele_two=(int)(10+Math.random()*(80-ele_one));
			ele_three=(int)(10+Math.random()*(90-ele_one-ele_two));
			problem.add(ele_one+"+"+ele_two+"+"+ele_three);
			answer.add(ele_one+ele_two+ele_three);
			break;
		
		case SUBSUB://����
			ele_one=(int)(30+Math.random()*70);
			ele_two=(int)(10+Math.random()*(ele_one-30));
			ele_three=(int)(10+Math.random()*(ele_one-ele_two-10));
			problem.add(ele_one+"-"+ele_two+"-"+ele_three);
			answer.add(ele_one-ele_two-ele_three);
			break;
			
			
		case INSUB://��λ����
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(10+Math.random()*(ele_one-10));
			while(ele_one%10>=ele_two){
				ele_two=(int)(10+Math.random()*(ele_one-10));
			}
			AddAndSubMethod(ele_one,ele_two,0);
			break;
			
			
		case MULFORSEVEN://7�ĳ˷��ھ�
			ele_one=7;
			ele_two=(int)(1+Math.random()*8);
			if(ele_two<ele_one){
				MulAndDivMethod(ele_two,ele_one,1);
			}
			else{
				MulAndDivMethod(ele_one,ele_two,1);
			}
			break;
			
		case MULFOREIGHT://8�ĳ˷��ھ�
			ele_one=8;
			ele_two=(int)(1+Math.random()*8);
			if(ele_two<ele_one){
				MulAndDivMethod(ele_two,ele_one,1);
			}
			else{
				MulAndDivMethod(ele_one,ele_two,1);
			}
			break;
			
		case MULFORNINE://9�ĳ˷��ھ�
			ele_one=9;
			ele_two=(int)(1+Math.random()*8);
			MulAndDivMethod(ele_two,ele_one,1);
			break;
			
			
		case MULTABLE: //�˷��ھ���
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			if(ele_two<ele_one){
				MulAndDivMethod(ele_two,ele_one,1);
			}
			else{
				MulAndDivMethod(ele_one,ele_two,1);
			}
			break;
			
			
		case NUMDOUBLE: //��һ�����ļ����Ƕ��ٵ�����ļ��㷽��
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			if(ele_two<ele_one){
				MulAndDivMethod(ele_two,ele_one,1);
			}
			else{
				MulAndDivMethod(ele_one,ele_two,1);
			}
			break;
			
			
		case MULFORTWO://2�ĳ˷��ھ�
			ele_one=2;
			ele_two=(int)(1+Math.random()*8);
			if(ele_two<ele_one){
				MulAndDivMethod(ele_two,ele_one,1);
			}
			else{
				MulAndDivMethod(ele_one,ele_two,1);
			}
			break;
			
		case MULFORTHREE://3�ĳ˷��ھ�
			ele_one=3;
			ele_two=(int)(1+Math.random()*8);
			if(ele_two<ele_one){
				MulAndDivMethod(ele_two,ele_one,1);
			}
			else{
				MulAndDivMethod(ele_one,ele_two,1);
			}
			break;
			
		case MULFORFOUR://4�ĳ˷��ھ�
			ele_one=4;
			ele_two=(int)(1+Math.random()*8);
			if(ele_two<ele_one){
				MulAndDivMethod(ele_two,ele_one,1);
			}
			else{
				MulAndDivMethod(ele_one,ele_two,1);
			}
			break;
		case MULFORFIVE://5�ĳ˷��ھ�
			ele_one=5;
			ele_two=(int)(1+Math.random()*8);
			if(ele_two<ele_one){
				MulAndDivMethod(ele_two,ele_one,1);
			}
			else{
				MulAndDivMethod(ele_one,ele_two,1);
			}
			break;
			
		case MULFORSIX://6�ĳ˷��ھ�
			ele_one=6;
			ele_two=(int)(1+Math.random()*8);
			if(ele_two<ele_one){
				MulAndDivMethod(ele_two,ele_one,1);
			}
			else{
				MulAndDivMethod(ele_one,ele_two,1);
			}
			break;
			
		case MULISADD://�˷�����ͬ������ӵļ������
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			MulAndDivMethod(ele_two,ele_one,1);
			break;
			
		case NULLADDSUB://�˼ӳ˼�
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			ele_three=(int)(Math.random()*9);
			if(choose==1){
				problem.add(ele_one+"*"+ele_two+"+"+ele_three);
				answer.add(ele_one*ele_two+ele_three);
			}
			else{
				ele_three=(int)(Math.random()*(ele_one*ele_two));
				problem.add(ele_one+"*"+ele_two+"-"+ele_three);
				answer.add(ele_one*ele_two-ele_three);
			}
			break;
		default:
			break;
		}
	}

	
	
	/*����Ӽ���*/
	public void AddAndSubMethod(int num1,int num2,int choose){
		if(choose==1){
			problem.add(num1+"+"+num2);
			answer.add(num1+num2);
		}
		else{
			int ele_sum=num1+num2;
			problem.add(ele_sum+"-"+num1);
			answer.add(num2);
		}
	}
	
	
	
	/*����˳�*/
	public void MulAndDivMethod(int num1,int num2,int choose){
		if(choose==1){
			problem.add(num1+"*"+num2);
			answer.add(num1*num2);
		}
		else{
			int ele_sum=num1*num2;
			problem.add(ele_sum+"��"+num1);
			answer.add(num2);
		}
	}
	
	public void run() {
		problem=new ArrayList<String>();
		answer=new ArrayList<Integer>();
		while(true){
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
