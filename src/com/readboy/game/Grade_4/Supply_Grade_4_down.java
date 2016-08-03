package com.readboy.game.Grade_4;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Supply_Grade_4_down implements Runnable{
		Handler handler_program;
		Object Alock;
		int count=0;
		int count_float=0;
		int type; //��������
		boolean is_float=false;
		private ArrayList<String> problem=new ArrayList<String>();
		private ArrayList<Integer> answer=new ArrayList<Integer>();
		private ArrayList<String> answer1=new ArrayList<String>();
		private ArrayList<String> problem1=new ArrayList<String>();
		boolean stopThread;
		
		  final private int MULANDDIV=1;  //�й�0������
		  
		  
		  final private int CANDIVALL=2;	//�˷������
		  final private int SEVENDIV=3;  //�ӷ������ɡ��ӷ�����ɵ�����
		  final private int DIVSPACE=4;		//�ӷ������
		  final private int DIVWAY=5;		//�����ļ������
		
		public Supply_Grade_4_down(Handler handler_program,Object Alock,int type) {
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
			int ele_four=-1;
			int choose=Math.random()>0.5?1:0;   //ѡ��Ӽ�
			switch (type) {
			case MULANDDIV://�й�0������
				ele_one=0;
				if(choose==1){
					ele_two=(int)(10+Math.random()*898);
					MulAndDivMethod(ele_one,ele_two,1);
				}
				else{
					ele_two=(int)(10+Math.random()*898);
					MulAndDivMethod(ele_two,ele_one,0);
				}
				break;
			case CANDIVALL://�˷������
				ele_one= (int)(10+Math.random()*89)*10;
				ele_two=IntFactor(ele_one);
				ele_three=ele_one/ele_two;
				ele_four=(int)(10+Math.random()*89);
				problem.add(ele_four+"��"+ele_two+"��"+ele_three+"=");
				answer.add(ele_four*ele_two*ele_three);
				break;
			case SEVENDIV://�ӷ������ɡ��ӷ�����ɵ�����
				ele_one= (int)(10+Math.random()*89)*10;
				ele_two=(int)(10+Math.random()*(ele_one-10));
				ele_three=ele_one-ele_two;
				ele_four=(int)(10+Math.random()*989);
				if(choose==1){
					problem.add(ele_four+"+"+ele_two+"+"+ele_three+"=");
					answer.add(ele_four+ele_two+ele_three);
				}
				else{
					problem.add(ele_two+"+"+ele_four+"+"+ele_three+"=");
					answer.add(ele_four+ele_two+ele_three);
				}
				break;
			case DIVSPACE://�ӷ������
				ele_one= (int)(10+Math.random()*89)*10;
				ele_two=(int)(10+Math.random()*(ele_one-10));
				ele_three=ele_one-ele_two;
				ele_four=(int)(10+Math.random()*989);
				problem.add(ele_four+"+"+ele_two+"+"+ele_three+"=");
				answer.add(ele_four+ele_two+ele_three);
				break;
			case DIVWAY://�����ļ������
				ele_one=(int)(10+Math.random()*89)*10;
				ele_two=(int)(10+Math.random()*(ele_one-10));
				ele_three=ele_one-ele_two;
				ele_four=(int)(ele_one+Math.random()*(1000-ele_one));
				problem.add(ele_four+"-"+ele_two+"-"+ele_three+"=");
				answer.add(ele_four-ele_two-ele_three);
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
		
		
		/*����˳�*/
		public void MulAndDivMethod(int num1,int num2,int choose){
			if(choose==1){
				problem.add(num1+"��"+num2+"=");
				answer.add(num1*num2);
			}
			else{
				int ele_sum=num1*num2;
				problem.add(ele_sum+"��"+num1+"=");
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
			while(!stopThread){
				is_float=false;
				CreateSubject();
				Message message = new Message(); 
				Bundle bundle=new Bundle();
				if(!is_float){
					bundle.putString("problem",problem.get(count));
					bundle.putInt("answer", answer.get(count));
					bundle.putBoolean("is_float",false);
					message.setData(bundle);
					handler_program.sendMessage(message);
					count++;
				}
				else{
					bundle.putString("problem",problem1.get(count_float));
					bundle.putString("answer", answer1.get(count_float));
					bundle.putBoolean("is_float",true);
					message.setData(bundle);
					handler_program.sendMessage(message);
					count_float++;
				}
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

