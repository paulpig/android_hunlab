package com.readboy.game.Grade_6;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.renderscript.Program;

public class Supply_Grade_6_top implements Runnable{
		Handler handler_program;
		Object Alock;
		int count=0;
		int count_float=0;
		int type; //出题类型
		boolean is_float=false;  //判别是浮点数还是整数
		private ArrayList<String> problem=new ArrayList<String>();
		private ArrayList<Integer> answer=new ArrayList<Integer>();
		private ArrayList<String> answer1=new ArrayList<String>();
		private ArrayList<String> problem1=new ArrayList<String>();
		boolean stopThread;
		
		
		  final private int MULANDDIV=1;  //分数乘分数的计算方法
		  final private int CANDIVALL=2;	//分数乘分数的简便运算
		  final private int SEVENDIV=3;  //分数乘整数的计算方法
		  final private int DIVSPACE=4;		//连续求一个数的几分之几是多少的问题的解法
		  
		  
		  final private int DIVWAY=5;		//分数除以整数的计算方法
		  final private int MULDIV=6;		//求比中未知项的方法
		  final private int  MULANDADD=7;		//一个数除以分数的计算方法
		  
		  
		  final private int NULANDSUB=8;		//圆的面积计算公式的应用
		  final private int ADDANDSUB=9;		//圆的周长计算公式
		  
		
		public Supply_Grade_6_top(Handler handler_program,Object Alock,int type) {
			// TODO Auto-generated constructor stub
			this.handler_program=handler_program;
			this.Alock=Alock;
			this.type=type;
			stopThread=false;
		}
		public void setTag(boolean stopThread){
			this.stopThread=stopThread;
		}
		
		/*产生题目*/
		
		public  void CreateSubject(){
			int ele_one=-1;
			int ele_two=-1;
			int ele_three=-1;
			int ele_four=-1;
			int ele_five=-1;
			int denominator=1;
			int divmax;
			int choose=Math.random()>0.5?1:0;   //选择加减
			int choose_num=Math.random()>0.5?1:0;//选择数字
			switch (type) {
			case MULANDDIV://分数乘分数的计算方法
				is_float=true;
				ele_one=(int)(11+Math.random()*38);
				ele_two=(int)(1+Math.random()*49);
				ele_three=(int)(1+Math.random()*48);
				ele_four=(int)(11+Math.random()*38);
				divmax=greatestCommonDivisor(ele_two*ele_three,ele_one*ele_four);
				problem1.add(ele_two+"/"+ele_one+"×"+ele_three+"/"+ele_four+"=");
				answer1.add((ele_two*ele_three)/divmax+"/"+ele_one*ele_four/divmax);
				//problem.add(ele_two+"/"+ele_one+"×"+ele_three+"/"+ele_four+"=");
				//answer2.add((float)(ele_two/ele_one+ele_three/ele_four));
				break;
			case CANDIVALL://分数乘分数的简便运算
				is_float=true;
				ele_one=(int)(11+Math.random()*38);
				ele_two=(int)(1+Math.random()*49);
				ele_three=(int)(1+Math.random()*48);
				ele_four=(int)(11+Math.random()*38);
				divmax=greatestCommonDivisor(ele_two*ele_three,ele_one);
				problem1.add(ele_two+"/"+ele_one+"×"+ele_three+"/"+ele_four+"×"+ele_four+"=");
				answer1.add((ele_two*ele_three)/divmax+"/"+ele_one/divmax);
				//problem.add(ele_two+"/"+ele_one+"×"+ele_three+"/"+ele_four+"×"+ele_four+"=");
				//answer2.add((float)(ele_two/ele_one*ele_three));
				break;
			case SEVENDIV://分数乘整数的计算方法
				is_float=true;
				ele_one=(int)(11+Math.random()*38);
				ele_two=(int)(1+Math.random()*49);
				ele_three=(int)(1+Math.random()*48);
				divmax=greatestCommonDivisor(ele_two*ele_three,ele_one);
				problem1.add(ele_two+"/"+ele_one+"×"+ele_three+"=");
				answer1.add((ele_two*ele_three)/divmax+"/"+ele_one/divmax);
				//problem.add(ele_two+"/"+ele_one+"×"+ele_three+"=");
				//answer2.add((float)(ele_two/ele_one*ele_three));
				break;
			case DIVSPACE://连续求一个数的几分之几是多少的问题的解法
				is_float=true;
				ele_one=(int)(11+Math.random()*38);
				ele_two=(int)(1+Math.random()*49);
				ele_three=(int)(1+Math.random()*48);
				ele_four=(int)(11+Math.random()*38);
				ele_five=(int)(1+Math.random()*48);
				divmax=greatestCommonDivisor(ele_five*ele_two*ele_three,ele_one*ele_four);
				problem1.add(ele_five+"×"+ele_two+"/"+ele_one+"×"+ele_three+"/"+ele_four+"=");
				answer1.add((ele_five*ele_two*ele_three)/divmax+"/"+ele_one*ele_four/divmax);
				//problem.add(ele_five+"×"+ele_two+"/"+ele_one+"×"+ele_three+"/"+ele_four+"=");
				//answer2.add((float)(ele_two/ele_one*ele_three/ele_four*ele_five));
				break;
			case DIVWAY://分数除以整数的计算方法
				is_float=true;
				ele_one=(int)(11+Math.random()*38);
				ele_two=(int)(1+Math.random()*49);
				ele_three=(int)(1+Math.random()*48);
				divmax=greatestCommonDivisor(ele_two,ele_one*ele_three);
				problem1.add(ele_two+"/"+ele_one+"÷"+ele_three+"=");
				answer1.add((ele_two)/divmax+"/"+ele_one*ele_three/divmax);
				//problem.add(ele_two+"/"+ele_one+"÷"+ele_three+"=");
				//answer2.add((float)(ele_two/ele_one/ele_three));
				break;
			
			case MULDIV://求比中未知项的方法
				is_float=true;
				ele_one=(int)(101+Math.random()*498);
				ele_two=(int)(10+Math.random()*49);
				ele_three=(int)(10+Math.random()*49);
				boolean whichChoose=addStrElement(ele_one*ele_two*1.0,ele_three*1.0,true);
				if(whichChoose==true)
					problem1.add(ele_one+"×"+ele_two+"÷"+ele_three+"=");
				else 
					problem.add(ele_one+"×"+ele_two+"÷"+ele_three+"=");
				//problem.add(ele_one+"×"+ele_two+"÷"+ele_three+"=");
				//answer2.add((float)(ele_one*ele_two/ele_three));
				break;
			case MULANDADD://一个数除以分数的计算方法
				is_float=true;
				ele_one=(int)(11+Math.random()*38);
				ele_two=(int)(1+Math.random()*49);
				ele_three=(int)(1+Math.random()*48);
				divmax=greatestCommonDivisor(ele_one*ele_three,ele_two);
				problem1.add(ele_three+"÷"+ele_two+"/"+ele_one+"=");
				answer1.add((ele_one*ele_three)/divmax+"/"+ele_two/divmax);
				//problem.add(ele_three+"÷"+ele_two+"/"+ele_one+"=");
				//answer2.add((float)(ele_three/(ele_two/ele_one)));
				break;
			case NULANDSUB://圆的面积计算公式的应用
				is_float=true;
				ele_two=(int)(1+Math.random()*49);
				boolean whichChoose1=addStrElement(3.14*1.0,ele_two*ele_two*1.0,false);
				if(whichChoose1==true)
					problem1.add("π "+"×"+ele_two+"²"+"=");
				else 
					problem.add("π "+"×"+ele_two+"²"+"=");
				//problem.add("π "+"×"+ele_two+"²"+"=");
				//answer2.add((float)(Math.PI*ele_two*ele_two));
				break;
			case ADDANDSUB://圆的周长计算公式
				is_float=true;
				ele_two=(int)(1+Math.random()*49);
				boolean whichChoose2=addStrElement(3.14*1.0,ele_two*2*1.0,false);
				if(whichChoose2==true)
					problem1.add("2 × π "+"×"+ele_two+"=");
				else 
					problem.add("2 × π "+"×"+ele_two+"=");
				//problem.add("2 × π "+"×"+ele_two+"=");
				//answer2.add((float)(Math.PI*ele_two*2));
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
		
		
//		public void AddAndSubMethodFloat(float num1,float num2,int choose){
//			if(choose==1){
//				problem.add(num1+"+"+num2);
//				answer2.add(num1+num2);
//			}
//			else{
//				float ele_sum=num1+num2;
//				problem.add(ele_sum+"-"+num1);
//				answer2.add(num2);
//			}
//		}
		
		/*计算乘除*/
		public void MulAndDivMethod(int num1,int num2,int choose){
			if(choose==1){
				problem.add(num1+"×"+num2);
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
		/*最大公约数*/
		public int greatestCommonDivisor(int a,int b){
			 int c = a%b;
		        while(c!=0){
		                a = b;
		                b = c;
		                c = a % b;
		        }
		        return b;
		}
		
		/*具体题目添加*/
		public boolean addStrElement(double d,double e,boolean mul_or_div){
			String str=null;
			if(mul_or_div==true){
				str = String.valueOf((d*1.0/(e*1.0)));
			}
			else{
				str = String.valueOf((d*1.0*(e*1.0)));
			}
			int index=str.indexOf(".");
			if(d%e!=0){
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
				else if(index==4 && str.length()==6)
					answer1.add(str.substring(0,6));
				else if(index==4 && str.length()>=7)
					answer1.add(str.substring(0,7));
				return true;
			}
			else{
				answer.add((int)d/(int)e);
				is_float=false;
				return false;
			}
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

