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
		private ArrayList<String> problem=new ArrayList<String>();
		private ArrayList<Integer> answer=new ArrayList<Integer>();
		private ArrayList<String> answer1=new ArrayList<String>();
		private ArrayList<String> problem1=new ArrayList<String>();
		boolean stopThread;
		
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
			int choose_num=Math.random()>0.5?1:0;//ѡ������
			switch (type) {
			case MULANDDIV://��ĩβ��0�ĳ����ļ��㷽����������������
				is_float=true;
				ele_one=(int)(11+Math.random()*88)*10;
				ele_two=(int)(2+Math.random()*7);
				ele_three=(int)(1+Math.random()*(ele_two-2));
				addStrElement((ele_one*ele_two+ele_three),ele_two);
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
				addStrElement((ele_three*ele_two+ele_four),ele_three);
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
				problem.add(ele_one*ele_two+"��"+ele_one+"=");
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
				ele_one=(int)(2+Math.random()*7);
				ele_two=(int)(Math.random()*(int)(10/ele_one));
				ele_three=(int)(2+Math.random()*7);
				ele_four=(int)(1+Math.random()*((int)(10/ele_three)-1));
				int temp=ele_two+ele_four*10;
				problem.add(ele_one+ele_three*10+"*"+temp+"=");
				answer.add((ele_one+ele_three*10)*(ele_two+ele_four*10));
				break;
				
			case SMALLBRACKET://ƽ�����ĺ��弰��ƽ�����ķ���
				is_float=true;
				ele_one=(int)(10+Math.random()*989);
				ele_two=(int)(10+Math.random()*989);
				ele_three=(int)(10+Math.random()*989);
				ele_four=(int)(10+Math.random()*989);
				int num_this=(int)(1+Math.random()*3);
				int temp1=ele_one+ele_two+ele_three+ele_four;
				String str = String.valueOf((float)(temp1*1.0/num_this));
				int index=str.indexOf(".");
				if(temp1%num_this!=0){
					problem1.add("("+ele_one+"+"+ele_three+"+"+ele_two+"+"+ele_four+")"+"��"+num_this+"=");
					if(index==1 && str.length()==3)
						answer1.add(str.substring(0, 3));
					else if(index==1 && str.length()>=4){
						answer1.add(str.substring(0, 4));
					}
					else if(index ==2 && str.length()==4)
						answer1.add(str.substring(0, 4));
					else if(index ==2 && str.length()>=5)
						answer1.add(str.substring(0, 5));
					else if(index ==3 && str.length()==5)
						answer1.add(str.substring(0, 5));
					else if(index ==3 && str.length()>=6)
						answer1.add(str.substring(0, 6));
					else if(index ==4 && str.length()==6)
						answer1.add(str.substring(0, 6));
					else if(index ==4 && str.length()>=7)
						answer1.add(str.substring(0, 7));
				}
				else{
					answer.add((temp1)/num_this);
					problem.add("("+ele_one+"+"+ele_three+"+"+ele_two+"+"+ele_four+")"+"��"+num_this+"=");
					is_float=false;
				}
				break;
				
				
			case BIGADD://С���ӷ��ļ��㷽��
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*8);
				ele_three=(int)(10+Math.random()*89);
				ele_four=(int)(1+Math.random()*8);
				double temp2=ele_one+ele_two*0.1+ele_three+ele_four*0.1;
				String str1 = String.valueOf(temp2);
				int index1=str1.indexOf(".");
				if(str1.charAt(index1+1)!='0'){
					problem1.add(ele_one+"."+ele_two+"+"+ele_three+"."+ele_four+"=");
					if(index1==2)
						answer1.add(str1.substring(0, 4));
					else if(index1==3){
						answer1.add(str1.substring(0, 5));
					}
				}
				else{
					problem.add(ele_one+"."+ele_two+"+"+ele_three+"."+ele_four+"=");
					answer.add((int)(temp2));
					is_float=false;
				}
				break;
				
				
			case BIGDIV: //С�������ļ��㷽��
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(1+Math.random()*8);
				ele_three=(int)(10+Math.random()*(ele_one-11));
				ele_four=(int)(1+Math.random()*8);
				double temp3=ele_one+ele_two*0.1-(ele_three+ele_four*0.1);
				String str3 = String.valueOf(temp3);
				int index3=str3.indexOf(".");
				if(str3.charAt(index3+1)!='0'){
					problem1.add(ele_one+"."+ele_two+"-"+ele_three+"."+ele_four+"=");
					if(index3==2)
						answer1.add(str3.substring(0, 4));
					else if(index3==3){
						answer1.add(str3.substring(0, 5));
					}
					else if(index3==1){
						answer1.add(str3.substring(0, 3));
					}
				}
				else{
					problem.add(ele_one+"."+ele_two+"-"+ele_three+"."+ele_four+"=");
					answer.add((int)(temp3));
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

