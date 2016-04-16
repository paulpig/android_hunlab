package com.readboy.game.Grade_3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.renderscript.Program;

public class Supply_Grade_3_top implements Runnable{
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
		
		
		  final private int MULANDDIV=1;  //������λ����һλ����������λ�ı���˷�
		  final private int CANDIVALL=2;	//��λ����һλ������λ�ı���˷�
		  final private int SEVENDIV=3;  //ĩβ��0����λ����һλ��
		  final private int DIVSPACE=4;		//�м��0 ����λ����һλ��
		  
		  
		  final private int DIVWAY=5;		//ͬ��ĸ�����ӷ�
		  final private int MULDIV=6;		//ͬ��ĸ��������
		  final private int  MULANDADD=7;		//һ��ȥ����֮��
		  
		  
		  final private int NULANDSUB=8;		//�����ε��ܳ�
		  
		  
		  final private int ADDANDSUB=9;		//��λ������λ����������λ�ӷ�
		  
		  
		  final private int SMALLBRACKET=10;		//�����ͳ����Ĺ�ϵ
		
		public Supply_Grade_3_top(Handler handler_program,Object Alock,int type) {
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
			int denominator=1;
			int choose=Math.random()>0.5?1:0;   //ѡ��Ӽ�
			int choose_num=Math.random()>0.5?1:0;//ѡ������
			int maxdivide;//���Լ��
			switch (type) {
			case MULANDDIV://������λ����һλ����������λ�ı���˷�
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(100+Math.random()*899);
				if(choose==1){
					ele_three=(int)(1+Math.random()*((int)(10/(ele_one%10))-1));
					MulAndDivMethod(ele_one,ele_three,1);
				}
				else{
					ele_three=(int)(1+Math.random()*((int)(10/(ele_one%10))-1));
					MulAndDivMethod(ele_two,ele_three,1);
				}
				break;
			case CANDIVALL://��λ����һλ������λ�ı���˷�
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*((int)(10/(ele_one%10))-1));
				MulAndDivMethod(ele_one,ele_two,1);
				break;
			case SEVENDIV://ĩβ��0����λ����һλ��
				ele_one=(int)(10+Math.random()*89)*10;
				ele_two=(int)(1+Math.random()*8);
				MulAndDivMethod(ele_one,ele_two,1);
				break;
			case DIVSPACE://�м��0 ����λ����һλ��
				ele_one=(int)(1+Math.random()*8)*100+(int)(1+Math.random()*8);
				ele_two=(int)(1+Math.random()*8);
				MulAndDivMethod(ele_one,ele_two,1);
				break;
			case DIVWAY://ͬ��ĸ�����ӷ�
				is_float=true;
				denominator=(int)(10+Math.random()*89);
				ele_one=(int)(1+Math.random()*(denominator-1));
				ele_two=(int)(1+Math.random()*(denominator-1));
				ele_three=(int)(1+Math.random()*(denominator-1));
				maxdivide=greatestCommonDivisor(ele_one+ele_two+ele_three,denominator);
				problem1.add(ele_one+"/"+denominator+"+"+ele_two+"/"+denominator+"+"+ele_three+"/"+denominator+"=");
				answer1.add((ele_one+ele_two+ele_three)/maxdivide+"/"+denominator/maxdivide);
				break;
			
			case MULDIV://ͬ��ĸ��������
				is_float=true;
				denominator=(int)(10+Math.random()*89);
				ele_one=(int)(10+Math.random()*(denominator-1));
				ele_two=(int)(1+Math.random()*(ele_one-1));
				ele_three=(int)(1+Math.random()*(ele_one-ele_two-1));
				maxdivide=greatestCommonDivisor(ele_one-ele_two-ele_three,denominator);
				problem1.add(ele_one+"/"+denominator+"-"+ele_two+"/"+denominator+"-"+ele_three+"/"+denominator+"=");
				answer1.add((ele_one+ele_two+ele_three)/maxdivide+"/"+denominator/maxdivide);
				break;
				
			case MULANDADD://һ��ȥ����֮��
				is_float=true;
				denominator=(int)(10+Math.random()*89);
				ele_one=1;
				ele_two=(int)(1+Math.random()*(denominator-1));
				ele_three=(int)(1+Math.random()*(denominator-ele_two-1));
				maxdivide=greatestCommonDivisor(denominator-ele_two-ele_three,denominator);
				problem1.add("1"+"-"+ele_two+"/"+denominator+"-"+ele_three+"/"+denominator+"=");
				answer1.add((denominator-ele_two-ele_three)/maxdivide+"/"+denominator/maxdivide);
				break;
				
				
			case NULANDSUB://�����ε��ܳ�
				ele_one=(int)(100+Math.random()*899);
				ele_two=(int)(100+Math.random()*899);
				if(choose==1){
					problem.add(ele_one+"*2"+ele_two+"*2"+"=");
					answer.add(ele_one*2+ele_two*2);
				}
				else{
					problem.add("("+ele_one+"+"+ele_two+")*2"+"=");
					answer.add(ele_one*2+ele_two*2);
				}
				break;
				
			case ADDANDSUB://��λ������λ����������λ�ӷ�
				ele_one=(int)(11+Math.random()*89);
				int remainder=ele_one%10;
				while(remainder==0){
					ele_one=(int)(11+Math.random()*89);
					remainder=ele_one%10;
				}
				int div=ele_one/10;
				ele_two=10-remainder+(int)(Math.random()*(remainder-1))+(9-div+(int)(Math.random()*div))*10;
				AddAndSubMethod(ele_one,ele_two,1);
				break;
				
			case SMALLBRACKET://�����ͳ����Ĺ�ϵ
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(1+Math.random()*8);
				//ele_one=97;
				//ele_two=7;
				String str = String.valueOf((float)(ele_one*1.0/ele_two));
				int index=str.indexOf(".");
				if(ele_one%ele_two!=0){
					problem1.add(ele_one+"��"+ele_two+"=");
					if(index==1 && str.length()==3)
						answer1.add(str.substring(0, 3));
					else if(index==1 && str.length()>=4){
						answer1.add(str.substring(0, 4));
					}
					else if(index ==2 && str.length()==4)
						answer1.add(str.substring(0, 4));
					else if(index ==2 && str.length()>=5)
						answer1.add(str.substring(0, 5));
				}
				else{
					answer.add(ele_one/ele_two);
					problem.add(ele_one+"��"+ele_two+"=");
					is_float=false;
				}
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
		
		
		
		/*���Լ��*/
		public int greatestCommonDivisor(int a,int b){
			 int c = a%b;
		        while(c!=0){
		                a = b;
		                b = c;
		                c = a % b;
		        }
		        return b;
		}
		
		
		public void run() {
			problem=new ArrayList<String>();
			answer=new ArrayList<Integer>();
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

