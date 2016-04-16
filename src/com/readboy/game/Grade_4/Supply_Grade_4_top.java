package com.readboy.game.Grade_4;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.renderscript.Program;

public class Supply_Grade_4_top implements Runnable{
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
		
		
		  final private int MULANDDIV=1;  //���ټ�ʮ������ʮ���Ŀ���
		  final private int CANDIVALL=2;	//��ʮ��������ʮ���Ŀ���
		  final private int SEVENDIV=3;  //���ټ�ʮ��һλ���Ŀ��㷽��
		  final private int DIVSPACE=4;		//��λ����һλ���Ŀ��㷽��
		  
		  
		
		public Supply_Grade_4_top(Handler handler_program,Object Alock,int type) {
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
			switch (type) {
			case MULANDDIV://���ټ�ʮ������ʮ���Ŀ���
				ele_one=(int)(1+Math.random()*8);
				ele_two=(int)((int)(10/ele_one)+1+Math.random()*8);
				MulAndDivMethod(ele_one*10,ele_two,0);
				break;
			case CANDIVALL://��ʮ��������ʮ���Ŀ���
				ele_one=(int)(1+Math.random()*4);
				if(10%ele_one==0){
					ele_two=1+(int)((int)(10/ele_one-2)*Math.random());
				}
				else{
					ele_two=1+(int)((int)(10/ele_one-1)*Math.random());
				}
				MulAndDivMethod(ele_one*10,ele_two,0);
				break;
			case SEVENDIV://���ټ�ʮ��һλ���Ŀ��㷽��
				ele_one=(int)(1+Math.random()*8);
				ele_two=(int)(1+Math.random()*8)*100+(int)(1+Math.random()*8)*10;
				MulAndDivMethod(ele_two,ele_one,1);
				break;
			case DIVSPACE://��λ����һλ���Ŀ��㷽��
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*8);
				MulAndDivMethod(ele_one,ele_two,1);
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
				problem.add(num1+"*"+num2+"=");
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
		
		/*������Ŀ���*/
		public void addStrElement(int d,int e){
			String str = String.valueOf((d*1.0/(e*1.0)));
			int index=str.indexOf(".");
			if(d%e!=0){
				problem1.add(d+"��"+e+"=");
				if(index==1 && str.length()==3)
					answer1.add(str.substring(0, 3));
				else if(index==1 && str.length()>=4){
					answer1.add(str.substring(0, 4));
				}
				else if(index ==2 && str.length()==4)
					answer1.add(str.substring(0, 4));
				else if(index ==2 && str.length()>=5)
					answer1.add(str.substring(0, 5));
				else if(index==3 && str.length()==5)
					answer1.add(str.substring(0,5));
				else if(index==3 && str.length()>=6)
					answer1.add(str.substring(0,6));
			}
			else{
				answer.add((int)d/(int)e);
				problem.add(d+"��"+e+"=");
				is_float=false;
			}
		}
		
		
		public void run() {
			//problem=new ArrayList<String>();
			//answer=new ArrayList<Integer>();
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

