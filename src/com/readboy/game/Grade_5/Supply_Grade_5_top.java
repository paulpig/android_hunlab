package com.readboy.game.Grade_5;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.renderscript.Program;

public class Supply_Grade_5_top implements Runnable{
		Handler handler_program;
		Object Alock;
		int count=0;
		int count_float=0;
		int type; //��������
		boolean is_float=false;  //�б��Ǹ�������������
		ArrayList<String> problem;
		ArrayList<Integer> answer;
		ArrayList<Float> answer2;
		
		
		  final private int MULANDDIV=1;  //ƽ���ı��ε�������㹫ʽ
		  final private int CANDIVALL=2;	//�������������ؼ���
		  final private int SEVENDIV=3;  //���ε�������㹫ʽ��Ӧ��
		  
		  
		  final private int DIVSPACE=4;		//����ax+ab=c�ķ��̵Ľⷨ����Ӧ��
		  final private int DIVWAY=5;		//����ax+b=c�ķ��̵Ľⷨ����Ӧ��
		  final private int MULDIV=6;		//����ax=b�ķ��̵Ľⷨ
		  final private int  MULANDADD=7;		//����ax��bx=c�ķ��̵Ľⷨ	
		  final private int NULANDSUB=8;		//����ax-b=c�ķ��̵Ľⷨ����Ӧ��
		  final private int ADDANDSUB=9;		//����x��a=b�ķ��̵Ľⷨ
		  
		  
		  final private int SMALLBRACKET=10;		//С���������ļ��㷽��
		  final private int UNKOWNNUM=11;		//С�����������������㷽��
		  final private int ADDTHENSUB=12;		//С�����˵�����˳��
		  
		  
		  final private int SUBTHENADD=13;		//���������������ֲ������ļ��㷽��
		  final private int ADDFOREIGHT=14;		//����������ĩβ����������С���ļ��㷽��
		  final private int TENADD=15;				//С�����������ļ��㷽��
		
		public Supply_Grade_5_top(Handler handler_program,Object Alock,int type) {
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
			int ele_five=-1;
			int denominator=1;
			int choose=Math.random()>0.5?1:0;   //ѡ��Ӽ�
			int choose_num=Math.random()>0.5?1:0;//ѡ������
			switch (type) {
			case MULANDDIV://ƽ���ı��ε�������㹫ʽ
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(1+Math.random()*99);
				ele_three=(int)(1+Math.random()*98);
				problem.add((float)(ele_two+ele_one/100)+"*"+ele_three+"=");
				answer2.add((float)((float)(ele_two+ele_one/100)*ele_three));
				break;
			case CANDIVALL://�������������ؼ���
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(1+Math.random()*99);
				ele_three=(int)(1+Math.random()*98);
				problem.add((float)(ele_two+ele_one/100)+"*"+ele_three+"�� 2"+"=");
				answer2.add((float)((float)(ele_two+ele_one/100)*ele_three/2));
				break;
			case SEVENDIV://���ε�������㹫ʽ��Ӧ��
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(1+Math.random()*99);
				ele_three=(int)(1+Math.random()*98);
				ele_four=(int)(11+Math.random()*88);
				ele_five=(int)(1+Math.random()*99);
				problem.add("("+(float)(ele_two+ele_one/100)+"+"+(float)(ele_five+ele_four/100)+")"+"*"+ele_three+"�� 2"+"=");
				answer2.add((float)(((float)(ele_two+ele_one/100)+(float)(ele_five+ele_four/100))*ele_three/2));
				break;
			case DIVSPACE://����ax+ab=c�ķ��̵Ľⷨ����Ӧ��
				ele_one=(int)(1+Math.random()*8);;
				ele_two=(int)(1+Math.random()*8);
				ele_three=(int)(ele_one*ele_two+20+Math.random()*79);
				ele_four=IntFactor(ele_three-ele_one*ele_two);
				problem.add(ele_four+"x"+"+"+ele_one+"*"+ele_two+"="+ele_three+";"+"x=");
				answer.add((ele_three-ele_one*ele_two)/ele_four);
				break;
			case DIVWAY://����ax+b=c�ķ��̵Ľⷨ����Ӧ��
				if(choose==1){
					ele_one=(int)(1+Math.random()*49);
					//ele_two=(int)(1+Math.random()*8);
					ele_three=(int)(ele_one+20+Math.random()*79);
					ele_four=IntFactor(ele_three-ele_one);
					problem.add(ele_four+"x"+"+"+ele_one+"="+ele_three+";"+"x=");
					answer.add((ele_three-ele_one)/ele_four);
				}
				else{
					is_float=true;
					ele_one=(int)(1000+Math.random()*5999);
					//ele_two=(int)(1+Math.random()*8);
					ele_three=(int)(ele_one+200+Math.random()*10000);
					ele_four=(int)(100+Math.random()*899);
					problem.add(ele_four*00.1+"x"+"+"+ele_one*0.01+"="+ele_three*0.01+";"+"x=");
					answer2.add((float)((ele_three*0.01-ele_one*0.01)/(ele_four*0.01)));
				}
				break;
			
			case MULDIV://����ax=b�ķ��̵Ľⷨ
				if(choose==1){
					ele_one=(int)(10+Math.random()*89);
					//ele_two=(int)(1+Math.random()*8);
					ele_four=IntFactor(ele_one);
					problem.add(ele_four+"x"+"="+ele_one+";"+"x=");
					answer.add(ele_one/ele_four);
				}
				else{
					is_float=true;
					ele_one=(int)(1000+Math.random()*5999);
					//ele_two=(int)(1+Math.random()*8);
					ele_three=(int)(ele_one+200+Math.random()*10000);
					problem.add(ele_one*00.1+"x"+"="+ele_three*0.01+";"+"x=");
					answer2.add((float)(ele_three/ele_one));
				}
				break;
				
			case MULANDADD://����ax��bx=c�ķ��̵Ľⷨ
				if(choose==1){
					ele_one=(int)(10+Math.random()*89);
					ele_two=IntFactor(ele_one);
					ele_three=(int)(1+Math.random()*(ele_two-1));
					ele_four=ele_two-ele_three;
					problem.add(ele_three+"*x"+"+"+ele_four+"*x"+"="+ele_one+";"+"x=");
					answer.add(ele_one/ele_two);
				}
				else{
					ele_one=(int)(10+Math.random()*89);
					ele_two=IntFactor(ele_one);
					ele_three=(int)(1+Math.random()*8);
					ele_four=ele_two+ele_three;
					problem.add(ele_four+"*x"+"-"+ele_three+"*x"+"="+ele_one+";"+"x=");
					answer.add(ele_one/ele_two);
				}
				break;
				
				
			case NULANDSUB://����ax-b=c�ķ��̵Ľⷨ����Ӧ��
				if(choose==1){
					ele_one=(int)(10+Math.random()*89);
					ele_three=(int)(10+Math.random()*89);
					ele_four=IntFactor(ele_three+ele_one);
					problem.add(ele_four+"x"+"-"+ele_one+"="+ele_three+";"+"x=");
					answer.add((ele_three+ele_one)/ele_four);
				}
				else{
					is_float=true;
					ele_one=(int)(100+Math.random()*5999);
					//ele_two=(int)(1+Math.random()*8);
					ele_three=(int)(1000+Math.random()*8999);
					ele_four=(int)(1000+Math.random()*8999);
					problem.add(ele_four*00.1+"x"+"-"+ele_one*0.01+"="+ele_three*0.01+";"+"x=");
					answer2.add((float)((ele_three*0.01+ele_one*0.01)/(ele_four*0.01)));
				}
				break;
				
			case ADDANDSUB://����x��a=b�ķ��̵Ľⷨ
				if(choose==1){
					ele_one=(int)(10+Math.random()*89);
					ele_three=(int)(ele_one+10+Math.random()*79);
					ele_four=ele_three-ele_one;
					problem.add("x"+"+"+ele_one+"="+ele_three+";"+"x=");
					answer.add(ele_four);
				}
				else{
					ele_one=(int)(10+Math.random()*89);
					ele_three=(int)(10+Math.random()*89);
					ele_four=ele_three+ele_one;
					problem.add("x"+"-"+ele_one+"="+ele_three+";"+"x=");
					answer.add(ele_four);
				}
				break;
				
			case SMALLBRACKET://С���������ļ��㷽��
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(11+Math.random()*88);
				ele_three=(int)(10+Math.random()*89);
				problem.add(ele_one+ele_two*0.01+"*"+ele_three+"=");
				answer2.add((float)((ele_one+ele_two*0.01)*ele_three));
				break;
				
			case UNKOWNNUM: //С����С�����������㷽��
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(11+Math.random()*88);
				ele_three=(int)(10+Math.random()*89);
				ele_four=(int)(11+Math.random()*88);
				problem.add(ele_one+ele_two*0.01+"*"+ele_three+ele_four*0.01+"=");
				answer2.add((float)((ele_one+ele_two*0.01)*(ele_three+ele_four*0.01)));
				break;
				
				
			case ADDTHENSUB: //С�����˵�����˳��
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(11+Math.random()*88);
				ele_three=(int)(10+Math.random()*89);
				ele_four=(int)(11+Math.random()*88);
				ele_five=(int)(1001+Math.random()*8888);
				problem.add(ele_one+ele_two*0.01+"*"+ele_three+ele_four*0.01+"*"+ele_five*0.01+"=");
				answer2.add((float)((ele_one+ele_two*0.01)*(ele_three+ele_four*0.01)*(ele_five*0.01)));
				break;
			case SUBTHENADD: //���������������ֲ������ļ��㷽��
				is_float=true;
				ele_one=(int)(20+Math.random()*89);
				ele_two=(int)(10+Math.random()*(ele_one-20));
				ele_three=(int)(11+Math.random()*88);
				problem.add(ele_two+ele_three*0.01+"��"+ele_one+"=");
				answer2.add((float)((ele_two+ele_three*0.01)/ele_one));
				break;
			case ADDFOREIGHT:     //����������ĩβ����������С���ļ��㷽��
				is_float=true;
				ele_one=(int)(20+Math.random()*89);
				ele_two=(int)(10+Math.random()*(ele_one-20));
				ele_three=(int)(11+Math.random()*88);
				problem.add(ele_two+ele_three*0.01+"��"+ele_one+"=");
				answer2.add((float)((ele_two+ele_three*0.01)/ele_one));
				break;
			case TENADD:  		//С�����������ļ��㷽��
				is_float=true;
				ele_one=(int)(20+Math.random()*89);
				ele_two=(int)(10+Math.random()*89);
				ele_three=(int)(11+Math.random()*88);
				problem.add(ele_two+ele_three*0.01+"��"+ele_one+"=");
				answer2.add((float)((ele_two+ele_three*0.01)/ele_one));
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
		
		
		public void AddAndSubMethodFloat(float num1,float num2,int choose){
			if(choose==1){
				problem.add(num1+"+"+num2);
				answer2.add(num1+num2);
			}
			else{
				float ele_sum=num1+num2;
				problem.add(ele_sum+"-"+num1);
				answer2.add(num2);
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

