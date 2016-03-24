package com.readboy.game.Grade_2;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Supply_Grade_2_down implements Runnable  {
	Handler handler_program;
	Object Alock;
	int count=0;
	int type; //��������
	ArrayList<String> problem;
	ArrayList<Integer> answer;
	
	
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
	
	public Supply_Grade_2_down(Handler handler_program,Object Alock,int type) {
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
		case MULANDDIV://�˳���������˳��
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			ele_three=IntFactor(ele_one*ele_two);
			problem.add(ele_one+"*"+ele_two+"��"+ele_three);
			answer.add(ele_one*ele_two/ele_three);
			break;
		case CANDIVALL://��һ��������һ���������Ľ��ⷽ��
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			MulAndDivMethod(ele_one,ele_two,0);
			break;
		case SEVENDIV://��789�ĳ˷��ھ�����
			ele_one=(int)(1+Math.random()*8);
			if(choose==1&&choose_num==1){
				ele_two=7;
			}
			else if(choose==1&&choose_num==0){
				ele_two=8;
			}
			else {
				ele_two=9;
			}
			MulAndDivMethod(ele_two,ele_one,0);
			break;
		case DIVSPACE://������ʽ�����ֵ�����
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			MulAndDivMethod(ele_one,ele_two,0);
			break;
		case DIVWAY://���̵ķ���
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			MulAndDivMethod(ele_one,ele_two,0);
			break;
		
		case MULDIV://�ó˷��ͳ�����������������
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			ele_three=IntFactor(ele_one*ele_two);
			problem.add(ele_one+"*"+ele_two+"��"+ele_three);
			answer.add(ele_one*ele_two/ele_three);
			break;
			
		case MULANDADD://�ó˷��ͼӷ���������������
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			ele_three=(int)(1+Math.random()*8);
			problem.add(ele_one+"*"+ele_two+"+"+ele_three);
			answer.add(ele_one*ele_two+ele_three);
			break;
			
			
		case NULANDSUB://�ó˷��ͼ�����������������
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			ele_three=(int)(1+Math.random()*(ele_one*ele_two-1));
			problem.add(ele_one+"*"+ele_two+"-"+ele_three);
			answer.add(ele_one*ele_two-ele_three);
			break;
			
		case ADDANDSUB://�üӷ��ͼ�����������������
			ele_one=(int)(10+Math.random()*79);
			ele_two=(int)(10+Math.random()*79);
			while(ele_one+ele_two>100){
				ele_two=(int)(10+Math.random()*79);
			}
			ele_three=(int)(10+Math.random()*(ele_one+ele_two-10));
			problem.add(ele_one+"+"+ele_two+"-"+ele_three);
			answer.add(ele_one+ele_two-ele_three);
			break;
			
		case SMALLBRACKET://��С�������ۺ���ʽ�������
			ele_one=(int)(10+Math.random()*79);
			ele_two=(int)(10+Math.random()*79);
			ele_three=(int)(10+Math.random()*79);
			if(choose==1){
				problem.add(ele_one+"+ ("+ele_two+"+"+ele_three+")");
				answer.add(ele_one+ele_two+ele_three);
			}
			else{
				ele_three=(int)(Math.random()*(ele_two-10));
				problem.add(ele_one+"+ ("+ele_two+"-"+ele_three+")");
				answer.add(ele_one+(ele_two-ele_three));
			}
			break;
			
			
		case BIGADD: //���ټ�ʮ�Ӽ��ټ�ʮ�ļ��㷽��
			ele_one=(int)(10+Math.random()*89)*10;
			ele_two=(int)(10+Math.random()*89)*10;
			AddAndSubMethod(ele_one,ele_two,1);
			break;
			
			
		case BIGDIV: //���ټ�ʮ�����ټ�ʮ�ļ��㷽��
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(10+Math.random()*(ele_one-10));
			AddAndSubMethod(ele_one*10,ele_two*10,0);
			break;
			
		case MIDADD: //��λ������λ�����㷽��
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(10+Math.random()*89);
			AddAndSubMethod(ele_one,ele_two,1);
			break;
			
			
		case MIDDIV: //��λ������λ���Ŀ��㷽��
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(10+Math.random()*(ele_one-10));
			AddAndSubMethod(ele_one,ele_two,0);
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
	
	/*������ʽ�ֽ�*/
	public int IntFactor(int num){
		int []result=new int[num];
		int factor_num=0;
		int choose_which=0;
		for(int i=1;i<=num;i++){
			if(num%i==0){
				result[factor_num]=i;
				factor_num++;
			}
		}
		choose_which=(int)(Math.random()*(factor_num-1));
		return result[choose_which];
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
