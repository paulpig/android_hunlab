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
		int type; //出题类型
		boolean is_float=false;
		ArrayList<String> problem;
		ArrayList<Integer> answer;
		ArrayList<Float> answer2;
		
		  final private int MULANDDIV=1;  //商末尾有0的除法的计算方法（商中有余数）
		  final private int CANDIVALL=2;	//商末尾有0的除法计算方法（商没有余数）
		  final private int SEVENDIV=3;  //商中间有0的除法的计算方法（除的过程有余数）
		  final private int DIVSPACE=4;		//商中间有0的除法的计算方法（除的过程中没有余数）
		  final private int DIVWAY=5;		//一位数除两位数（被除数各数位上都能被整除）的计算方法
		  final private int MULDIV=6;		//用一位数除商是整十、整百、整千的口算方法
		  final private int  MULANDADD=7;		//有关0的除法
		  
		  
		  
		  final private int NULANDSUB=8;		//用乘法两步计算解决问题
		  
		  
		  final private int ADDANDSUB=9;		//两位数乘两位数（不进位）的笔算方法
		  
		  
		  final private int SMALLBRACKET=10;		//平均数的含义及求平均数的方法
		  
		  
		  
		  final private int BIGADD=11;				//小数加法的计算方法
		  final private int BIGDIV=12;				//小数减法的计算方法
		
		public Supply_Grade_3_down(Handler handler_program,Object Alock,int type) {
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
			int choose=Math.random()>0.5?1:0;   //选择加减
			int choose_num=Math.random()>0.5?1:0;//选择数字
			switch (type) {
			case MULANDDIV://商末尾有0的除法的计算方法（商中有余数）
				is_float=true;
				ele_one=(int)(1+Math.random()*98)*10;
				ele_two=(int)(2+Math.random()*7);
				ele_three=(int)(1+Math.random()*(ele_two-2));
				problem.add(ele_one*ele_two+ele_three+"÷"+ele_two+"=");
				answer2.add((float)(ele_one*ele_two+ele_three)/ele_two);
				break;
			case CANDIVALL://商末尾有0的除法计算方法（商没有余数）
				ele_one=(int)(1+Math.random()*98)*10;
				ele_two=(int)(1+Math.random()*8);
				problem.add(ele_one*ele_two+"÷"+ele_two+"=");
				answer.add((ele_one*ele_two)/ele_two);
				break;
			case SEVENDIV://商中间有0的除法的计算方法（除的过程有余数）
				is_float=true;
				ele_one=(int)(1+Math.random()*8)*100;
				ele_two=(int)(1+Math.random()*8)+ele_one;
				ele_three=(int)(2+Math.random()*7);
				ele_four=(int)(1+Math.random()*(ele_three-2));
				problem.add(ele_three*ele_two+ele_four+"÷"+ele_three+"=");
				answer2.add((float)(ele_three*ele_two+ele_four)/ele_three);
				break;
			case DIVSPACE://商中间有0的除法的计算方法（除的过程中没有余数）
				ele_one=(int)(1+Math.random()*8)*100;
				ele_two=(int)(1+Math.random()*8)+ele_one;
				ele_three=(int)(1+Math.random()*8);
				problem.add(ele_three*ele_two+"÷"+ele_three+"=");
				answer.add((ele_three*ele_two)/ele_three);
				break;
			case DIVWAY://一位数除两位数（被除数各数位上都能被整除）的计算方法
				ele_one=(int)(1+Math.random()*8);
				ele_two=ele_one*(int)(Math.random()*(int)(10/ele_one));
				ele_three=ele_one*(int)(1+Math.random()*((int)(10/ele_one)-1));
				while(ele_two==10 || ele_three==10){
					ele_two=ele_one*(int)(Math.random()*(int)(10/ele_one));
					ele_three=ele_one*(int)(1+Math.random()*((int)(10/ele_one)-1));
				}
				problem.add(ele_three*10+ele_two+"÷"+ele_one+"=");
				answer.add((ele_three*10+ele_two)/ele_one);
				break;
			
			case MULDIV://用一位数除商是整十、整百、整千的口算方法
				ele_one=(int)(1+Math.random()*8);			//除数
				if(choose==1&&choose_num==1){
					ele_two=(int)(1+Math.random()*8)*10;
				}
				else if(choose==1&&choose_num==0){
					ele_two=(int)(10+Math.random()*89)*10;
				}
				else{
					ele_two=(int)(100+Math.random()*899)*10;
				}
				problem.add(ele_one*ele_two+"÷"+ele_one);
				answer.add((ele_one*ele_two)/ele_one);
				break;
				
			case MULANDADD://有关0的除法
				ele_one=0;
				ele_two=(int)(1+Math.random()*8);
				problem.add(ele_one+"÷"+ele_two);
				answer.add(ele_one/ele_two);
				break;
				
				
			case NULANDSUB://用乘法两步计算解决问题
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*8);
				ele_three=(int)(1+Math.random()*8);;
				problem.add(ele_one+"*"+ele_two+"*"+ele_three+"=");
				answer.add(ele_one*ele_two*ele_three);
				break;
				
			case ADDANDSUB://两位数乘两位数（不进位）的笔算方法
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
				
			case SMALLBRACKET://平均数的含义及求平均数的方法
				ele_one=(int)(10+Math.random()*989);
				ele_two=(int)(10+Math.random()*989);
				ele_three=(int)(10+Math.random()*989);
				ele_four=(int)(10+Math.random()*989);
				int num_this=(int)(1+Math.random()*3);
				problem.add("("+ele_one+"+"+ele_three+"+"+ele_two+"+"+ele_four+")"+"÷"+num_this+"=");
				answer2.add((float)((ele_one+ele_two+ele_three+ele_four)/num_this));
				break;
				
				
			case BIGADD://小数加法的计算方法
				is_float=true;
				ele_one=(int)(10+Math.random()*89);
				ele_two=(int)(1+Math.random()*8);
				ele_three=(int)(10+Math.random()*89);
				ele_four=(int)(1+Math.random()*8);
				problem.add(ele_one+"."+ele_two+"+"+ele_three+"."+ele_four+"=");
				answer2.add((float)(ele_one+ele_two*0.1)+(float)(ele_three+ele_four*0.1));
				break;
				
				
			case BIGDIV: //小数减法的计算方法
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

