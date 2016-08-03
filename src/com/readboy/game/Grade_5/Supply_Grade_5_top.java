package com.readboy.game.Grade_5;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.renderscript.Program;

public class Supply_Grade_5_top implements Runnable{
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
		
		  final private int MULANDDIV=1;  //平行四边形的面积计算公式
		  final private int CANDIVALL=2;	//三角形面积的相关计算
		  final private int SEVENDIV=3;  //梯形的面积计算公式的应用
		  
		  
		  final private int DIVSPACE=4;		//形如ax+ab=c的方程的解法及其应用
		  final private int DIVWAY=5;		//形如ax+b=c的方程的解法及其应用
		  final private int MULDIV=6;		//形如ax=b的方程的解法
		  final private int  MULANDADD=7;		//形如ax±bx=c的方程的解法	
		  final private int NULANDSUB=8;		//形如ax-b=c的方程的解法及其应用
		  final private int ADDANDSUB=9;		//形如x±a=b的方程的解法
		  
		  
		  final private int SMALLBRACKET=10;		//小数乘整数的计算方法
		  final private int UNKOWNNUM=11;		//小数乘整数的算理及计算方法
		  final private int ADDTHENSUB=12;		//小数连乘的运算顺序
		  
		  
		  final private int SUBTHENADD=13;		//被除数的整数部分不够除的计算方法
		  final private int ADDFOREIGHT=14;		//除到被除数末尾仍有余数的小数的计算方法
		  final private int TENADD=15;				//小数除以整数的计算方法
		
		public Supply_Grade_5_top(Handler handler_program,Object Alock,int type) {
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
			String str;
			double temp;
			int length=-1;
			boolean is_string;
			int choose=Math.random()>0.5?1:0;   //选择加减
			int choose_num=Math.random()>0.5?1:0;//选择数字
			DecimalFormat df = new DecimalFormat( "00.00 ");  
			switch (type) {
			case MULANDDIV://平行四边形的面积计算公式
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(10+Math.random()*89);
				ele_three=(int)(1+Math.random()*98);
				is_string=addStrElement((ele_two+ele_one*1.0/100),ele_three,false);
				if(is_string==true)
					problem1.add(df.format((ele_two+ele_one*1.0/100))+"×"+ele_three+"=");
				else
					problem.add(df.format((ele_two+ele_one*1.0/100))+"×"+ele_three+"=");
				//answer1.add(str.substring(0, length+1));
				//problem1.add(df.format((ele_two+ele_one*1.0/100))+"*"+ele_three+"=");
				break;
			case CANDIVALL://三角形面积的相关计算
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(10+Math.random()*89);
				ele_three=(int)(1+Math.random()*98);
				is_string=addStrElement((ele_two+ele_one*1.0/100)/2.0,ele_three,false);
				if(is_string==true)
					problem1.add(df.format((ele_two+ele_one*1.0/100))+"×"+ele_three+"÷ 2"+"=");
				else
					problem.add(df.format((ele_two+ele_one*1.0/100))+"×"+ele_three+"÷ 2"+"=");
				//answer1.add(str.substring(0, length+1));
				//problem1.add(df.format((ele_two+ele_one*1.0/100))+"*"+ele_three+"÷ 2"+"=");
				break;
			case SEVENDIV://梯形的面积计算公式的应用
				is_float=true;
				ele_one=(int)(11+Math.random()*88);
				ele_two=(int)(10+Math.random()*40);
				ele_three=(int)(10+Math.random()*40);
				ele_four=(int)(11+Math.random()*88);
				ele_five=(int)(10+Math.random()*40);
				temp=ele_five+ele_four*1.0/100;
				//str = String.valueOf((ele_two+ele_one*1.0/100+ele_five+ele_four*1.0/100)*(ele_three*2.0));
				is_string=addStrElement((ele_two+ele_one*1.0/100+ele_five+ele_four*1.0/100)/2.0,ele_three,false);
				if(is_string==true)
					problem1.add("("+df.format((ele_two+ele_one*1.0/100))+"+"+temp+")"+"×"+ele_three+"÷ 2"+"=");
				else
					problem.add("("+df.format(ele_two+ele_one*1.0/100)+"+"+temp+")"+"×"+ele_three+"÷ 2"+"=");
				break;
			case DIVSPACE://形如ax+ab=c的方程的解法及其应用
				ele_one=(int)(1+Math.random()*8);;
				ele_two=(int)(1+Math.random()*8);
				ele_three=(int)(ele_one*ele_two+20+Math.random()*79);
				ele_four=IntFactor(ele_three-ele_one*ele_two);
				problem.add(ele_four+"x"+"+"+ele_one+"×"+ele_two+"="+ele_three+";"+"x=");
				answer.add((ele_three-ele_one*ele_two)/ele_four);
				break;
			case DIVWAY://形如ax+b=c的方程的解法及其应用
					is_float=true;
					ele_one=(int)(1000+Math.random()*5999);
					ele_three=(int)(ele_one+200+Math.random()*10000);
					ele_four=(int)(2+Math.random()*18);
					is_string=addStrElement((ele_three*0.01-ele_one*0.01),ele_four*1.0,true);
					if(is_string==true)
						problem1.add(ele_four+"x"+"+"+df.format(ele_one*0.01)+"="+df.format(ele_three*0.01)+";"+"x=");
					else
						problem.add(ele_four+"x"+"+"+df.format(ele_one*0.01)+"="+df.format(ele_three*0.01)+";"+"x=");
					//answer1.add(str.substring(0, length));
					//problem1.add(ele_four*00.1+"x"+"+"+ele_one*0.01+"="+ele_three*0.01+";"+"x=");
					//answer2.add((float)((ele_three*0.01-ele_one*0.01)/(ele_four*0.01)));
				break;
			
			case MULDIV://形如ax=b的方程的解法
					is_float=true;
					ele_one=(int)(1000+Math.random()*5999);
					ele_three=(int)(ele_one+200+Math.random()*10000);
					is_string=addStrElement((ele_three*0.01),ele_one*0.01,true);
					if(is_string==true)
						problem1.add(df.format(ele_one*0.01)+"x"+"="+df.format(ele_three*0.01)+";"+"x=");
					else
						problem.add(df.format(ele_one*0.01)+"x"+"="+df.format(ele_three*0.01)+";"+"x=");
					//problem.add(ele_one*00.1+"x"+"="+ele_three*0.01+";"+"x=");
					//answer2.add((float)(ele_three/ele_one));
				break;
				
			case MULANDADD://形如ax±bx=c的方程的解法
				if(choose==1){
					ele_one=(int)(10+Math.random()*89);
					ele_two=IntFactor(ele_one);
					ele_three=(int)(1+Math.random()*(ele_two-1));
					ele_four=ele_two-ele_three;
					problem.add(ele_three+"× x"+"+"+ele_four+"× x"+"="+ele_one+";"+"x=");
					answer.add(ele_one/ele_two);
				}
				else{
					ele_one=(int)(10+Math.random()*89);
					ele_two=IntFactor(ele_one);
					ele_three=(int)(1+Math.random()*8);
					ele_four=ele_two+ele_three;
					problem.add(ele_four+"× x"+"-"+ele_three+"× x"+"="+ele_one+";"+"x=");
					answer.add(ele_one/ele_two);
				}
				break;
				
				
			case NULANDSUB://形如ax-b=c的方程的解法及其应用
					is_float=true;
					ele_one=(int)(100+Math.random()*5999);
					//ele_two=(int)(1+Math.random()*8);
					ele_three=(int)(1000+Math.random()*8999);
					ele_four=(int)(1000+Math.random()*8999);
					is_string=addStrElement((ele_three*0.01+ele_one*0.01),ele_four*0.01,true);
					if(is_string==true)
						problem1.add(df.format(ele_four*0.01)+"x"+"-"+df.format(ele_one*0.01)+"="+df.format(ele_three*0.01)+";"+"x=");
					else
						problem.add(df.format(ele_four*0.01)+"x"+"-"+df.format(ele_one*0.01)+"="+df.format(ele_three*0.01)+";"+"x=");
					//problem.add(ele_four*00.1+"x"+"-"+ele_one*0.01+"="+ele_three*0.01+";"+"x=");
					//answer2.add((float)((ele_three*0.01+ele_one*0.01)/(ele_four*0.01)));
				break;
				
			case ADDANDSUB://形如x±a=b的方程的解法
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
				
			case SMALLBRACKET://小数乘整数的计算方法
				is_float=true;
				ele_one=(int)(10+Math.random()*50);
				ele_two=(int)(11+Math.random()*88);
				ele_three=(int)(10+Math.random()*89);
				is_string=addStrElement((ele_one+ele_two*0.01),ele_three*1.0,false);
				if(is_string==true)
					problem1.add(ele_one+ele_two*0.01+"×"+ele_three+"=");
				else
					problem.add(ele_one+ele_two*0.01+"×"+ele_three+"=");
				//problem.add(ele_one+ele_two*0.01+"*"+ele_three+"=");
				//answer2.add((float)((ele_one+ele_two*0.01)*ele_three));
				break;
				
			case UNKOWNNUM: //小数乘小数的算理及计算方法
				is_float=true;
				ele_one=(int)(10+Math.random()*50);
				ele_two=(int)(11+Math.random()*88);
				ele_three=(int)(10+Math.random()*50);
				ele_four=(int)(11+Math.random()*88);
				temp=ele_three+ele_four*0.01;
				is_string=addStrElement((ele_one+ele_two*0.01),ele_three+ele_four*0.01,false);
				if(is_string==true)
					problem1.add(ele_one+ele_two*0.01+"×"+temp+"=");
				else
					problem.add(ele_one+ele_two*0.01+"×"+temp+"=");
				//problem.add(ele_one+ele_two*0.01+"*"+ele_three+ele_four*0.01+"=");
				//answer2.add((float)((ele_one+ele_two*0.01)*(ele_three+ele_four*0.01)));
				break;
				
				
			case ADDTHENSUB: //小数连乘的运算顺序
				is_float=true;
				ele_one=(int)(10+Math.random()*10);
				ele_two=(int)(11+Math.random()*88);
				ele_three=(int)(10+Math.random()*10);
				ele_four=(int)(11+Math.random()*88);
				double temp2=(int)(10+Math.random()*10)+(int)(11+Math.random()*88)*0.01;
				is_string=addStrElement((ele_one+ele_two*0.01)*(ele_three+ele_four*0.01),temp2,false);
				temp=ele_three*1.0+ele_four*0.01;
				if(is_string==true)
					problem1.add(ele_one+ele_two*0.01+"×"+temp+"×"+temp2+"=");
				else
					problem.add(ele_one+ele_two*0.01+"×"+temp+"×"+temp2+"=");
				break;
			case SUBTHENADD: //被除数的整数部分不够除的计算方法
				is_float=true;
				ele_one=(int)(20+Math.random()*79);
				ele_two=(int)(10+Math.random()*(ele_one-20));
				ele_three=(int)(11+Math.random()*88);
				is_string=addStrElement((ele_two+ele_three*0.01),ele_one*1.0,true);
				if(is_string==true)
					problem1.add(ele_two+ele_three*0.01+"÷"+ele_one+"=");
				else
					problem.add(ele_two+ele_three*0.01+"÷"+ele_one+"=");
				//problem.add(ele_two+ele_three*0.01+"÷"+ele_one+"=");
				//answer2.add((float)((ele_two+ele_three*0.01)/ele_one));
				break;
			case ADDFOREIGHT:     //除到被除数末尾仍有余数的小数的计算方法
				is_float=true;
				ele_one=(int)(20+Math.random()*89);
				ele_two=(int)(10+Math.random()*(ele_one-20));
				ele_three=(int)(11+Math.random()*88);
				is_string=addStrElement((ele_two+ele_three*0.01),ele_one*1.0,true);
				if(is_string==true)
					problem1.add(ele_two+ele_three*0.01+"÷"+ele_one+"=");
				else
					problem.add(ele_two+ele_three*0.01+"÷"+ele_one+"=");
				//problem.add(ele_two+ele_three*0.01+"÷"+ele_one+"=");
				//answer2.add((float)((ele_two+ele_three*0.01)/ele_one));
				break;
			case TENADD:  		//小数除以整数的计算方法
				is_float=true;
				ele_one=(int)(20+Math.random()*79);
				ele_two=(int)(10+Math.random()*89);
				ele_three=(int)(11+Math.random()*88);
				is_string=addStrElement((ele_two+ele_three*0.01),ele_one*1.0,true);
				if(is_string==true)
					problem1.add(ele_two+ele_three*0.01+"÷"+ele_one+"=");
				else
					problem.add(ele_two+ele_three*0.01+"÷"+ele_one+"=");
				//problem.add(ele_two+ele_three*0.01+"÷"+ele_one+"=");
				//answer2.add((float)((ele_two+ele_three*0.01)/ele_one));
				break;
			default:
				break;
			}
		}

		
		
		/*计算加减法*/
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
		
		
		
		
		/*计算乘除*/
		public void MulAndDivMethod(int num1,int num2,int choose){
			if(choose==1){
				problem.add(num1+"×"+num2+"=");
				answer.add(num1*num2);
			}
			else{
				int ele_sum=num1*num2;
				problem.add(ele_sum+"÷"+num1+"=");
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

