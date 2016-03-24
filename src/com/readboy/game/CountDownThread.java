package com.readboy.game;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class CountDownThread implements Runnable {

	int count_time;
	int start_time;
	Handler mHandler;
	boolean stopThread;
	public CountDownThread(int count_time,Handler time_hander) {
		// TODO Auto-generated constructor stub
		this.count_time=count_time;
		mHandler=time_hander;
		this.start_time=count_time;
		stopThread=false;
	}
	
	
	public void setTag(boolean stopThread){
		this.stopThread=stopThread;
	}
	@Override
	public void run() {
		while(!stopThread){
			while(count_time!=0){
			// TODO Auto-generated method stub
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			count_time--;
			 Message message = new Message(); 
			 Bundle bundle=new Bundle();
			 bundle.putInt("time",count_time);
			 message.setData(bundle);
			 mHandler.sendMessage(message);
			}
			count_time=start_time;
		}

}
}
