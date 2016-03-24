package com.readboy.game.Grade_2;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Supply_Grade_2_down implements Runnable  {
	Handler handler_program;
	Object Alock;
	int count=0;
	int type; //出题类型
	ArrayList<String> problem;
	ArrayList<Integer> answer;
	
	
	  final private int MULANDDIV=1;  //乘除混合运算的顺序
	  final private int CANDIVALL=2;	//求一个数是另一个数几倍的解题方法
	  final private int SEVENDIV=3;  //用789的乘法口诀求商
	  
	  
	  final private int DIVSPACE=4;		//除法算式各部分的名称
	  final private int DIVWAY=5;		//求商的方法
	  final private int MULDIV=6;		//用乘法和除法两步计算解决问题
	  
	  
	  final private int  MULANDADD=7;		//用乘法和加法两步计算解决问题
	  final private int NULANDSUB=8;		//用乘法和减法两步计算解决问题
	  final private int ADDANDSUB=9;		//用加法和减法两步计算解决问题
	  final private int SMALLBRACKET=10;		//用小括号列综合算式解决问题
	  
	  
	  
	  final private int BIGADD=11;				//几百几十加几百几十的计算方法
	  final private int BIGDIV=12;			//几百几十减几百几十的计算方法
	  final private int MIDADD=13;				//两位数加两位数口算方法
	  final private int MIDDIV=14;			//两位数减两位数的口算方法
	
	public Supply_Grade_2_down(Handler handler_program,Object Alock,int type) {
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
		int choose=Math.random()>0.5?1:0;   //选择加减
		int choose_num=Math.random()>0.5?1:0;//选择数字
		switch (type) {
		case MULANDDIV://乘除混合运算的顺序
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			ele_three=IntFactor(ele_one*ele_two);
			problem.add(ele_one+"*"+ele_two+"÷"+ele_three);
			answer.add(ele_one*ele_two/ele_three);
			break;
		case CANDIVALL://求一个数是另一个数几倍的解题方法
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			MulAndDivMethod(ele_one,ele_two,0);
			break;
		case SEVENDIV://用789的乘法口诀求商
			ele_one=(int)(1+Math.random()*8);
			if(choose==1&&choose_num==1){
				ele_two=7;
			}
			else if(choose==1&&choose_num==0){
				ele_two=8;
			}
			else {
				ele_two=9;
			}
			MulAndDivMethod(ele_two,ele_one,0);
			break;
		case DIVSPACE://除法算式各部分的名称
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			MulAndDivMethod(ele_one,ele_two,0);
			break;
		case DIVWAY://求商的方法
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			MulAndDivMethod(ele_one,ele_two,0);
			break;
		
		case MULDIV://用乘法和除法两步计算解决问题
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			ele_three=IntFactor(ele_one*ele_two);
			problem.add(ele_one+"*"+ele_two+"÷"+ele_three);
			answer.add(ele_one*ele_two/ele_three);
			break;
			
		case MULANDADD://用乘法和加法两步计算解决问题
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			ele_three=(int)(1+Math.random()*8);
			problem.add(ele_one+"*"+ele_two+"+"+ele_three);
			answer.add(ele_one*ele_two+ele_three);
			break;
			
			
		case NULANDSUB://用乘法和减法两步计算解决问题
			ele_one=(int)(1+Math.random()*8);
			ele_two=(int)(1+Math.random()*8);
			ele_three=(int)(1+Math.random()*(ele_one*ele_two-1));
			problem.add(ele_one+"*"+ele_two+"-"+ele_three);
			answer.add(ele_one*ele_two-ele_three);
			break;
			
		case ADDANDSUB://用加法和减法两步计算解决问题
			ele_one=(int)(10+Math.random()*79);
			ele_two=(int)(10+Math.random()*79);
			while(ele_one+ele_two>100){
				ele_two=(int)(10+Math.random()*79);
			}
			ele_three=(int)(10+Math.random()*(ele_one+ele_two-10));
			problem.add(ele_one+"+"+ele_two+"-"+ele_three);
			answer.add(ele_one+ele_two-ele_three);
			break;
			
		case SMALLBRACKET://用小括号列综合算式解决问题
			ele_one=(int)(10+Math.random()*79);
			ele_two=(int)(10+Math.random()*79);
			ele_three=(int)(10+Math.random()*79);
			if(choose==1){
				problem.add(ele_one+"+ ("+ele_two+"+"+ele_three+")");
				answer.add(ele_one+ele_two+ele_three);
			}
			else{
				ele_three=(int)(Math.random()*(ele_two-10));
				problem.add(ele_one+"+ ("+ele_two+"-"+ele_three+")");
				answer.add(ele_one+(ele_two-ele_three));
			}
			break;
			
			
		case BIGADD: //几百几十加几百几十的计算方法
			ele_one=(int)(10+Math.random()*89)*10;
			ele_two=(int)(10+Math.random()*89)*10;
			AddAndSubMethod(ele_one,ele_two,1);
			break;
			
			
		case BIGDIV: //几百几十减几百几十的计算方法
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(10+Math.random()*(ele_one-10));
			AddAndSubMethod(ele_one*10,ele_two*10,0);
			break;
			
		case MIDADD: //两位数加两位数口算方法
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(10+Math.random()*89);
			AddAndSubMethod(ele_one,ele_two,1);
			break;
			
			
		case MIDDIV: //两位数减两位数的口算方法
			ele_one=(int)(10+Math.random()*89);
			ele_two=(int)(10+Math.random()*(ele_one-10));
			AddAndSubMethod(ele_one,ele_two,0);
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
			CreateSubject();
			Message message = new Message(); 
			Bundle bundle=new Bundle();
			bundle.putString("problem",problem.get(count));
			bundle.putInt("answer", answer.get(count));
			message.setData(bundle);
			handler_program.sendMessage(message);
			count++;
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
