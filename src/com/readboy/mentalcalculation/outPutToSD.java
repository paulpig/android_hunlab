package com.readboy.mentalcalculation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * @author wbc
 *
 */
public class outPutToSD implements Runnable{

	
	Context context;
	Handler handler;
	
	
	public outPutToSD(Context context,Handler handler) {
		super();
		this.context = context;
		this.handler=handler;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//���ݿ�ʼ����֮ǰ���Ż�ֵ110��������
		Message message_start = new Message(); 
		message_start.arg1=110;
		handler.sendMessage(message_start);
		String path = null ;
		path = getInerSDcard();
		path+="/Aiwrite.dat";   //·�����ļ���·����outputStream���Լ������ġ�
		
		
		try {
			copyBigDataToSD(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("mentalcalculation", "outputtoSdWrong");
		}
		
		//�����������֮�󣬾ͷ���101ֵ��������
		Message message = new Message(); 
		message.arg1=101;
		handler.sendMessage(message);
	}
	
	
	/**
     * ��asset�е������ڵ�һ�����е�ʱ��copy����Ŀ¼�У��߳�ʵ�֣�
     * @param strOutFileName  ���ļ������λ��
     * @throws IOException
     */
    private void copyBigDataToSD(String strOutFileName) throws IOException   
    {  
        InputStream myInput;    
        OutputStream myOutput = new FileOutputStream(strOutFileName);  
        myInput = context.getAssets().open("Aiwrite.dat");    
        byte[] buffer = new byte[1024];    
        int length = myInput.read(buffer);  
        while(length > 0)  
        {  
            myOutput.write(buffer, 0, length);   
            length = myInput.read(buffer);  
            Log.i("mentalcalculation", "length");
        }  
          
        myOutput.flush();    
        myInput.close();    
        myOutput.close();          
    }  

    
    /**
     * ��ȡ������sd����·��
     * @return ��������sd����·��
     */
    private String getInerSDcard(){
    	return Environment.getExternalStorageDirectory().getPath();
    }
}
