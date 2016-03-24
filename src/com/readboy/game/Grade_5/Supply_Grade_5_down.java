package com.readboy.game.Grade_5;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.renderscript.Program;

public class Supply_Grade_5_down implements Runnable{
		Handler handler_program;
		Object Alock;
		int count=0;
		int count_float=0;
		int type; //出题类型
		boolean is_float=false;
		ArrayList<String> problem;
		ArrayList<Integer> answer;
		ArrayList<Float> answer2;
		
		
		  final private int MULANDDIV=1;  //分数加法的含义和同分母分数加法的计算方法
		  final private int CANDIVALL=2;	//分数加法的简算
		  final private int SEVENDIV=3;  //分数加减混合运算的运算顺序
		  final private int DIVSPACE=4;		//分数减法的含义和同分母分数减法的计算方法
		  final private int DIVWAY=5;		//同分母分数连加、连减的计算方法
		  final private int MULDIV=6;		//异分母分数加、减法的计算方法
		  
		  
		  final private int  MULANDADD=7;		//分数化成小数的方法
		  final private int NULANDSUB=8;		//求两个数最大公因数的方法
		  final private int ADDANDSUB=9;		//求两个数最小公倍数的方法
		  
		  
		  final private int SMALLBRACKET=10;		//长方体表面积的计算方法
		  final private int UNKOWNNUM=11;		//长方体的体积的计算公式
		  final private int ADDTHENSUB=12;		//正方体表面积的计算方法
		  final private int SUBTHENADD=13;		//正方体的体积公式
		
		public Supply_Grade_5_down(Handler handler_program,Object Alock,int type) {
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
			int ele_four=-1;
			int ele_five=-1;
			int denominator=1;
			int choose=Math.random()>0.5?1:0;   //选择加减
			int choose_num=Math.random()>0.5?1:0;//选择数字
			switch (type) {
			case MULANDDIV://分数加法的含义和同分母分数加法的计算方法
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(10+Math.random()*89);
				ele_three=(int)(10+Math.random()*89);
				problem.add(ele_one+"/"+ele_two+"+"+ele_three+"/"+ele_two+"=");
				answer2.add((float)(ele_one/ele_two+ele_three/ele_two));
				break;
			case CANDIVALL://分数加法的简算
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*99);
				ele_three=(int)(1+Math.random()*99);
				ele_four=(int)(10+Math.random()*89);
				ele_five=(int)(1+Math.random()*99);
				problem.add(ele_two+"/"+ele_one+"+"+ele_five+"/"+ele_four+ele_three+"/"+ele_one+"=");
				answer2.add((float)(ele_two/ele_one+ele_three/ele_one+ele_five/ele_four));
				break;
			case SEVENDIV://分数加减混合运算的运算顺序
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*99);
				ele_three=(int)(1+Math.random()*99);
				ele_four=(int)(10+Math.random()*89);
				ele_five=(int)(1+Math.random()*99);
				problem.add(ele_two+"/"+ele_one+"+"+ele_five+"/"+ele_four+ele_three+"/"+ele_one+"=");
				answer2.add((float)(ele_two/ele_one+ele_three/ele_one+ele_five/ele_four));
				break;
			case DIVSPACE://分数减法的含义和同分母分数减法的计算方法
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(10+Math.random()*89);
				ele_three=(int)(10+Math.random()*(ele_one-10));
				problem.add(ele_one+"/"+ele_two+"-"+ele_three+"/"+ele_two+"=");
				answer2.add((float)(ele_one/ele_two-ele_three/ele_two));
				break;
			case DIVWAY://同分母分数连加、连减的计算方法
				if(choose==1){
					is_float=true;
					ele_one=(int)(10+Math.random()*89);
					ele_two=(int)(1+Math.random()*99);
					ele_three=(int)(1+Math.random()*99);
					ele_four=(int)(11+Math.random()*89);
					problem.add(ele_two+"/"+ele_one+"+"+ele_three+"/"+ele_one+"+"+ele_four+"/"+ele_one+"=");
					answer2.add((float)(ele_two/ele_one+ele_three/ele_one+ele_four/ele_one));
				}
				else{
					is_float=true;
					ele_one=(int)(10+Math.random()*89);
					ele_two=(int)(8+Math.random()*99);
					ele_three=(int)(2+Math.random()*(ele_two-4));
					ele_four=(int)(1+Math.random()*(ele_two-ele_four-1));
					problem.add(ele_two+"/"+ele_one+"-"+ele_three+"/"+ele_one+"-"+ele_four+"/"+ele_one+"=");
					answer2.add((float)(ele_two/ele_one-ele_three/ele_one-ele_four/ele_one));
				}
				break;
			
			case MULDIV://异分母分数加、减法的计算方法
				if(choose==1){
					is_float=true;
					ele_one=(int)(10+Math.random()*89);
					ele_two=(int)(10+Math.random()*89);
					while(ele_one==ele_two){
						ele_one=(int)(10+Math.random()*89);
						ele_two=(int)(10+Math.random()*89);
					}
					ele_three=(int)(1+Math.random()*99);
					ele_four=(int)(1+Math.random()*99);
					problem.add(ele_three+"/"+ele_one+"+"+ele_four+"/"+ele_two+"=");
					answer2.add((float)(ele_four/ele_two+ele_three/ele_one));
				}
				else{
					ele_one=(int)(10+Math.random()*89);
					ele_two=(int)(10+Math.random()*89);
					ele_three=(int)(1+Math.random()*99);
					ele_four=(int)(1+Math.random()*99);
					while(ele_one==ele_two || ele_three*1.0/ele_one<ele_four*1.0/ele_two){
						ele_one=(int)(10+Math.random()*89);
						ele_two=(int)(10+Math.random()*89);
						ele_three=(int)(1+Math.random()*99);
						ele_four=(int)(1+Math.random()*99);
					}
					problem.add(ele_three+"/"+ele_one+"-"+ele_four+"/"+ele_two+"=");
					answer2.add((float)(ele_three/ele_one-ele_four/ele_two));
				}
				break;
				
			case MULANDADD://分数化成小数的方法
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(10+Math.random()*89);
				while(ele_one==ele_two){
					ele_one=(int)(10+Math.random()*89);
					ele_two=(int)(10+Math.random()*89);
				}
				problem.add(ele_one+"/"+ele_two+"=");
				answer2.add((float)(ele_one/ele_two));
				break;
				
				
			case NULANDSUB://求两个数最大公因数的方法
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(9+Math.random()*(ele_one-10));
				int a=ele_one;
				int b=ele_two;
				int c=0;
				while(b!=0)  /* 余数不为0，继续相除，直到余数为0 */   
				   { c=a%b; a=b;  b=c;}  
				problem.add(ele_one+"和"+ele_two+"的最大公约数是:");
				answer.add(a);
				break;
			case ADDANDSUB://求两个数最小公倍数的方法
				ele_one=(int)(11+Math.random()*89);
				ele_two=(int)(10+Math.random()*89);
				int ab=lowest_common_multiple(ele_one,ele_two);
				problem.add(ele_one+"和"+ele_two+"的最小公倍数是:");
				answer.add(ab);
				break;
				
			case SMALLBRACKET://长方体表面积的计算方法
				is_float=true;
				ele_one=(int)(100+Math.random()*9899);
				ele_two=(int)(100+Math.random()*9899);
				ele_three=(int)(100+Math.random()*9899);
				problem.add("("+ele_one*0.01+"*"+ele_two*0.01+"+"+ele_one*0.01+"*"+ele_three*0.01+"+"+ele_two*0.01+"*"+ele_three*0.01+")×2"+"=");
				answer2.add((float)((ele_one*0.01*ele_two*0.01+ele_one*0.01*ele_three*0.01+ele_two*0.01*ele_three*0.01)*2));
				break;
			case UNKOWNNUM:	//长方体的体积的计算公式
				is_float=true;
				ele_one=(int)(100+Math.random()*9899);
				ele_two=(int)(100+Math.random()*9899);
				ele_three=(int)(100+Math.random()*9899);
				problem.add(ele_one*0.01+"*"+ele_two*0.01+"*"+ele_three*0.01+"=");
				answer2.add((float)(ele_one*0.01*ele_two*0.01*ele_three*0.01));
				break;
			case ADDTHENSUB://正方体表面积的计算方法
				is_float=true;
				ele_one=(int)(100+Math.random()*9899);
				ele_two=(int)(100+Math.random()*9899);
				problem.add(ele_one*0.01+"×"+ele_two*0.01+"²"+"=");
				answer2.add((float)(ele_one*0.01*ele_two*0.01*ele_two*0.01));
				break;
			case SUBTHENADD://正方体的体积公式
				is_float=true;
				ele_one=(int)(100+Math.random()*9899);
				problem.add(ele_one*0.01+"³"+"=");
				answer2.add((float)(ele_one*0.01*ele_one*0.01*ele_one*0.01));
				break;
			default:
				break;
			}
		}
		/*最小公倍数*/
		public int lowest_common_multiple(int m,int n)
		{
		  int remainder,m1,n1;
		  m1=m;
		  n1=n;
		  while (n != 0) {
		    remainder = m % n;
		    m = n;
		    n = remainder;
		  }
		  return m1*n1/m;
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

