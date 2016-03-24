package com.readboy.game.Grade_3;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Supply_Grade_3_down implements Runnable{
		Handler handler_program;
		Object Alock;
		int count=0;
		int count_float=0;
		int type; //��������
		boolean is_float=false;
		ArrayList<String> problem;
		ArrayList<Integer> answer;
		ArrayList<Float> answer2;
		
		  final private int MULANDDIV=1;  //��ĩβ��0�ĳ����ļ��㷽����������������
		  final private int CANDIVALL=2;	//��ĩβ��0�ĳ������㷽������û��������
		  final private int SEVENDIV=3;  //���м���0�ĳ����ļ��㷽�������Ĺ�����������
		  final private int DIVSPACE=4;		//���м���0�ĳ����ļ��㷽�������Ĺ�����û��������
		  final private int DIVWAY=5;		//һλ������λ��������������λ�϶��ܱ��������ļ��㷽��
		  final private int MULDIV=6;		//��һλ����������ʮ�����١���ǧ�Ŀ��㷽��
		  final private int  MULANDADD=7;		//�й�0�ĳ���
		  
		  
		  
		  final private int NULANDSUB=8;		//�ó˷���������������
		  
		  
		  final private int ADDANDSUB=9;		//��λ������λ��������λ���ı��㷽��
		  
		  
		  final private int SMALLBRACKET=10;		//ƽ�����ĺ��弰��ƽ�����ķ���
		  
		  
		  
		  final private int BIGADD=11;				//С���ӷ��ļ��㷽��
		  final private int BIGDIV=12;				//С�������ļ��㷽��
		
		public Supply_Grade_3_down(Handler handler_program,Object Alock,int type) {
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
			int ele_four=-1;
			int choose=Math.random()>0.5?1:0;   //ѡ��Ӽ�
			int choose_num=Math.random()>0.5?1:0;//ѡ������
			switch (type) {
			case MULANDDIV://��ĩβ��0�ĳ����ļ��㷽����������������
				is_float=true;
				ele_one=(int)(1+Math.random()*98)*10;
				ele_two=(int)(2+Math.random()*7);
				ele_three=(int)(1+Math.random()*(ele_two-2));
				problem.add(ele_one*ele_two+ele_three+"��"+ele_two+"=");
				answer2.add((float)(ele_one*ele_two+ele_three)/ele_two);
				break;
			case CANDIVALL://��ĩβ��0�ĳ������㷽������û��������
				ele_one=(int)(1+Math.random()*98)*10;
				ele_two=(int)(1+Math.random()*8);
				problem.add(ele_one*ele_two+"��"+ele_two+"=");
				answer.add((ele_one*ele_two)/ele_two);
				break;
			case SEVENDIV://���м���0�ĳ����ļ��㷽�������Ĺ�����������
				is_float=true;
				ele_one=(int)(1+Math.random()*8)*100;
				ele_two=(int)(1+Math.random()*8)+ele_one;
				ele_three=(int)(2+Math.random()*7);
				ele_four=(int)(1+Math.random()*(ele_three-2));
				problem.add(ele_three*ele_two+ele_four+"��"+ele_three+"=");
				answer2.add((float)(ele_three*ele_two+ele_four)/ele_three);
				break;
			case DIVSPACE://���м���0�ĳ����ļ��㷽�������Ĺ�����û��������
				ele_one=(int)(1+Math.random()*8)*100;
				ele_two=(int)(1+Math.random()*8)+ele_one;
				ele_three=(int)(1+Math.random()*8);
				problem.add(ele_three*ele_two+"��"+ele_three+"=");
				answer.add((ele_three*ele_two)/ele_three);
				break;
			case DIVWAY://һλ������λ��������������λ�϶��ܱ��������ļ��㷽��
				ele_one=(int)(1+Math.random()*8);
				ele_two=ele_one*(int)(Math.random()*(int)(10/ele_one));
				ele_three=ele_one*(int)(1+Math.random()*((int)(10/ele_one)-1));
				while(ele_two==10 || ele_three==10){
					ele_two=ele_one*(int)(Math.random()*(int)(10/ele_one));
					ele_three=ele_one*(int)(1+Math.random()*((int)(10/ele_one)-1));
				}
				problem.add(ele_three*10+ele_two+"��"+ele_one+"=");
				answer.add((ele_three*10+ele_two)/ele_one);
				break;
			
			case MULDIV://��һλ����������ʮ�����١���ǧ�Ŀ��㷽��
				ele_one=(int)(1+Math.random()*8);			//����
				if(choose==1&&choose_num==1){
					ele_two=(int)(1+Math.random()*8)*10;
				}
				else if(choose==1&&choose_num==0){
					ele_two=(int)(10+Math.random()*89)*10;
				}
				else{
					ele_two=(int)(100+Math.random()*899)*10;
				}
				problem.add(ele_one*ele_two+"��"+ele_one);
				answer.add((ele_one*ele_two)/ele_one);
				break;
				
			case MULANDADD://�й�0�ĳ���
				ele_one=0;
				ele_two=(int)(1+Math.random()*8);
				problem.add(ele_one+"��"+ele_two);
				answer.add(ele_one/ele_two);
				break;
				
				
			case NULANDSUB://�ó˷���������������
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*8);
				ele_three=(int)(1+Math.random()*8);;
				problem.add(ele_one+"*"+ele_two+"*"+ele_three+"=");
				answer.add(ele_one*ele_two*ele_three);
				break;
				
			case ADDANDSUB://��λ������λ��������λ���ı��㷽��
				ele_one=(int)(Math.random()*9);
				ele_two=(int)(Math.random()*(int)(10/ele_one));
				ele_three=(int)(1+Math.random()*8);
				ele_four=(int)(1+Math.random()*((int)(10/ele_one)-1));
				while(ele_two==10 || ele_four==10){
					ele_two=(int)(Math.random()*(int)(10/ele_one));
					ele_four=(int)(1+Math.random()*((int)(10/ele_one)-1));
				}
				problem.add(ele_one+ele_three*10+"*"+ele_two+ele_four*10+"=");
				answer.add((ele_one+ele_three*10)*(ele_two+ele_four*10));
				break;
				
			case SMALLBRACKET://ƽ�����ĺ��弰��ƽ�����ķ���
				ele_one=(int)(10+Math.random()*989);
				ele_two=(int)(10+Math.random()*989);
				ele_three=(int)(10+Math.random()*989);
				ele_four=(int)(10+Math.random()*989);
				int num_this=(int)(1+Math.random()*3);
				problem.add("("+ele_one+"+"+ele_three+"+"+ele_two+"+"+ele_four+")"+"��"+num_this+"=");
				answer2.add((float)((ele_one+ele_two+ele_three+ele_four)/num_this));
				break;
				
				
			case BIGADD://С���ӷ��ļ��㷽��
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*8);
				ele_three=(int)(10+Math.random()*89);
				ele_four=(int)(1+Math.random()*8);
				problem.add(ele_one+"."+ele_two+"+"+ele_three+"."+ele_four+"=");
				answer2.add((float)(ele_one+ele_two*0.1)+(float)(ele_three+ele_four*0.1));
				break;
				
				
			case BIGDIV: //С�������ļ��㷽��
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(1+Math.random()*8);
				ele_three=(int)(10+Math.random()*(ele_one-11));
				ele_four=(int)(1+Math.random()*8);
				problem.add(ele_one+"."+ele_two+"-"+ele_three+"."+ele_four+"=");
				answer2.add((float)(ele_one+ele_two*0.1)-(float)(ele_three+ele_four*0.1));
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
				is_float=false;
				CreateSubject();
				Message message = new Message(); 
				Bundle bundle=new Bundle();
				bundle.putString("problem",problem.get(count));
				if(!is_float){
					bundle.putInt("answer", answer.get(count));
					bundle.putBoolean("is_float",false);
					message.setData(bundle);
					handler_program.sendMessage(message);
					count++;
				}
				else{
					bundle.putFloat("answer", answer2.get(count_float));
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

