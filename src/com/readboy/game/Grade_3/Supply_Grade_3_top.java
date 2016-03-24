package com.readboy.game.Grade_3;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.renderscript.Program;

public class Supply_Grade_3_top implements Runnable{
		Handler handler_program;
		Object Alock;
		int count=0;
		int count_float=0;
		int type; //出题类型
		boolean is_float=false;
		ArrayList<String> problem;
		ArrayList<Integer> answer;
		ArrayList<Float> answer2;
		
		
		  final private int MULANDDIV=1;  //两、三位数乘一位数不连续进位的笔算乘法
		  final private int CANDIVALL=2;	//两位数乘一位数不进位的笔算乘法
		  final private int SEVENDIV=3;  //末尾带0的三位数乘一位数
		  final private int DIVSPACE=4;		//中间带0 的三位数乘一位数
		  
		  
		  final private int DIVWAY=5;		//同分母分数加法
		  final private int MULDIV=6;		//同分母分数减法
		  final private int  MULANDADD=7;		//一减去几分之几
		  
		  
		  final private int NULANDSUB=8;		//长方形的周长
		  
		  
		  final private int ADDANDSUB=9;		//两位数加两位数的连续进位加法
		  
		  
		  final private int SMALLBRACKET=10;		//余数和除数的关系
		
		public Supply_Grade_3_top(Handler handler_program,Object Alock,int type) {
			// TODO Auto-generated constructor stub
			this.handler_program=handler_program;
			this.Alock=Alock;
			this.type=type;
		}
		
		/*产生题目*/
		
		public  void CreateSubject(){
			int ele_one=-1;
			int ele_two=-1;
			int ele_three=-1;
			int denominator=1;
			int choose=Math.random()>0.5?1:0;   //选择加减
			int choose_num=Math.random()>0.5?1:0;//选择数字
			switch (type) {
			case MULANDDIV://两、三位数乘一位数不连续进位的笔算乘法
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
			case CANDIVALL://两位数乘一位数不进位的笔算乘法
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*((int)(10/(ele_one%10))-1));
				MulAndDivMethod(ele_one,ele_two,1);
				break;
			case SEVENDIV://末尾带0的三位数乘一位数
				ele_one=(int)(10+Math.random()*89)*10;
				ele_two=(int)(1+Math.random()*8);
				MulAndDivMethod(ele_one,ele_two,1);
				break;
			case DIVSPACE://中间带0 的三位数乘一位数
				ele_one=(int)(1+Math.random()*8)*100+(int)(1+Math.random()*8);
				ele_two=(int)(1+Math.random()*8);
				MulAndDivMethod(ele_one,ele_two,1);
				break;
			case DIVWAY://同分母分数加法
				is_float=true;
				denominator=(int)(10+Math.random()*89);
				ele_one=(int)(1+Math.random()*(denominator-1));
				ele_two=(int)(1+Math.random()*(denominator-1));
				ele_three=(int)(1+Math.random()*(denominator-1));
				problem.add(ele_one+"/"+denominator+"+"+ele_two+"/"+denominator+"+"+ele_three+"/"+denominator);
				answer2.add((float)(ele_one/denominator)+(float)(ele_two/denominator)+(float)(ele_three/denominator));
				break;
			
			case MULDIV://同分母分数减法
				is_float=true;
				denominator=(int)(10+Math.random()*89);
				ele_one=(int)(10+Math.random()*(denominator-1));
				ele_two=(int)(1+Math.random()*(ele_one-1));
				ele_three=(int)(1+Math.random()*(ele_one-ele_two-1));
				problem.add(ele_one+"/"+denominator+"-"+ele_two+"/"+denominator+"-"+ele_three+"/"+denominator);
				answer2.add((float)(ele_one/denominator)-(float)(ele_two/denominator)-(float)(ele_three/denominator));
				break;
				
			case MULANDADD://一减去几分之几
				is_float=true;
				denominator=(int)(10+Math.random()*89);
				ele_one=1;
				ele_two=(int)(1+Math.random()*(denominator-1));
				ele_three=(int)(1+Math.random()*(denominator-ele_two-1));
				problem.add("1"+"-"+ele_two+"/"+denominator+"-"+ele_three+"/"+denominator);
				answer2.add((float)(1)-(float)(ele_two/denominator)-(float)(ele_three/denominator));
				break;
				
				
			case NULANDSUB://长方形的周长
				ele_one=(int)(100+Math.random()*899);
				ele_two=(int)(100+Math.random()*899);
				if(choose==1){
					problem.add(ele_one+"*2"+ele_two+"*2"+"=");
					answer.add(ele_one*2+ele_two*2);
				}
				else{
					problem.add("("+ele_one+"+"+ele_two+")*2");
					answer.add(ele_one*2+ele_two*2);
				}
				break;
				
			case ADDANDSUB://两位数加两位数的连续进位加法
				ele_one=(int)(11+Math.random()*89);
				ele_two=(int)(10+Math.random()*89);
				while(ele_one%10+ele_two%10<10 || ele_one%10==0 || ele_two%10==0){
					ele_one=(int)(11+Math.random()*89);
					ele_two=(int)(10+Math.random()*89);
				}
				AddAndSubMethod(ele_one,ele_two,1);
				break;
				
			case SMALLBRACKET://余数和除数的关系
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(1+Math.random()*8);
				problem.add(ele_one+"÷"+ele_two+"=");
				answer2.add((float)(ele_one/ele_two));
				break;
			default:
				break;
			}
		}

		
		
		/*计算加减法*/
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
		
		/*计算乘除*/
		public void MulAndDivMethod(int num1,int num2,int choose){
			if(choose==1){
				problem.add(num1+"*"+num2);
				answer.add(num1*num2);
			}
			else{
				int ele_sum=num1*num2;
				problem.add(ele_sum+"÷"+num1);
				answer.add(num2);
			}
		}
		
		/*整数因式分解*/
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

