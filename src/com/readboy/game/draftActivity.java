package com.readboy.game;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.readboy.HandWrite.DraftView;
import com.readboy.HandWrite.startThread;
import com.readboy.mentalcalculation.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class draftActivity extends Activity{
	protected DraftView d_v; 
	private Button write_button;
	private Button earse_button;
	private Button move_button;
	private Button clear_button;
	private Button end_button;
	private Button delete_button;
	private Button left_button;
	private Button right_button;
	private TextView draft_current;
	private TextView draft_all;
	private int currentState;
	
	final private int WRITE=1;// д״̬
	final private int ERASE=2;//��Ƥ��״̬
	final private int MOVE=3;//�ƶ�״̬
	final private int ADD=4;
	final private int LEFT=5;
	final private int RIGHT=6;
	final private int NONE=7;
	
	
	private int temp_left=0;
	private int temp_add=0;
	private int temp_right=0;
	private int temp_move=0;
	private int state=-1;
	
	private Timer timer = new Timer();
	
	private boolean is_ok=false;
	
	private startThread startthread;
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.draft_layout);
        
        init();
        listenerEvent();
        
    }
	
	
	protected void onDestroy(){
		Log.i("mentalwubingchao", "on destorys");
		
		//��ձ����ļ��д�ŵ�bitmap
		Thread thread = new Thread(new Runnable() {
			String path = Environment.getExternalStorageDirectory().getPath() +"/BitMapCacheFiles/"; 
			File file = new File(path);
			@Override
			public void run() {
				// TODO Auto-generated method stub
				delete(file);
			}
		});
		thread.start();
		
		//��յ�ǰ���ڵ�currentBitmap
		d_v.clearCurrentBitMap();
		super.onDestroy();
	}
	
	protected void init(){
		
		write_button=(Button) findViewById(R.id.draft_write_button);
		earse_button=(Button) findViewById(R.id.draft_erase_button);
		move_button=(Button) findViewById(R.id.draft_move_button);
		clear_button=(Button) findViewById(R.id.draft_clean_button);
		end_button=(Button) findViewById(R.id.draft_finished_button);
		d_v = (DraftView) findViewById(R.id.draft_screen);
		delete_button=(Button) findViewById(R.id.draft_remove_button);
		left_button=(Button) findViewById(R.id.draft_left_button);
		right_button=(Button) findViewById(R.id.draft_right_button);
		draft_current=(TextView) findViewById(R.id.draft_current);
		draft_all=(TextView) findViewById(R.id.draft_all);
		whichButtonShow(0);
		
		//��ձ����ļ��д�ŵ�bitmap
				Thread thread = new Thread(new Runnable() {
					String path = Environment.getExternalStorageDirectory().getPath() +"/BitMapCacheFiles/"; 
					File file = new File(path);
					@Override
					public void run() {
						// TODO Auto-generated method stub
						delete(file);
					}
				});
				thread.start();
	}
	
	/**
	 * ����ť��Ӽ����¼�
	 */
	protected void listenerEvent(){
		//��ɰ�ť
		end_button.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						draftActivity.this.finish();
					}
				});
		//�����ť
		clear_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				d_v.reSetPath();
				//Log.i("onclickis", "yes");
			}
		});	
		
		//�ƶ���ť
		move_button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						whichButtonShow(2);
						d_v.move();
						currentState=MOVE;
					}
				});
		//������ť
		earse_button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						whichButtonShow(1);
						d_v.erase();
						currentState=ERASE;
					}
				});
		//��ϰ��ť
		write_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				whichButtonShow(0);
				d_v.write();
				currentState=WRITE;  
				
			}
		});
		
		//ɾ���ݸ�ֽ
		delete_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int current_num=Integer.parseInt(draft_current.getText().toString());
				int all_num=Integer.parseInt(draft_all.getText().toString());
				if(all_num>=2 && current_num!=1){
					if(d_v.deleteButton(LEFT)){
						draft_current.setText(current_num-1+"");
						draft_all.setText(all_num-1+"");
					}
				}
				
				if(all_num>=2 && current_num==1){
					if(d_v.deleteButton(RIGHT)){
						draft_current.setText("1");
						draft_all.setText(all_num-1+"");
					}
				}
				
				
			
			}
		});
		
		//�鿴left�ݸ�ֽ
		left_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				
				/*����Ļ�ļ����ı䣬������ʱ����ʾbitmap������*/
				int current_num=Integer.parseInt(draft_current.getText().toString())-1;
				if(current_num!=0){
					saveThreadJudge();
				}
				if(current_num>=1){
					draft_current.setText(current_num+"");
					temp_left++;   //���������ƶ��˶���λ��
				}
				else{
					draft_current.setText("1");
					return;
				}
				
				
				showScreenContent();
				
	    		
				//���浱ǰ״̬
				currentState(currentState);
			}
		});
		
		//�鿴right�ݸ�ֽ
		right_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int current_num=Integer.parseInt(draft_current.getText().toString())+1;
				
				int all_num=Integer.parseInt(draft_all.getText().toString());
				
				//û�����ӣ�ֻ�Ǽ򵥵��л����ұߵ�bitmap
				if(current_num<=all_num){
					saveThreadJudge();
					/*����Ļ�ļ����ı䣬������ʱ����ʾbitmap������*/
					draft_current.setText(current_num+"");
					temp_right++;   //���������ƶ��˶���λ��
					
					showScreenContent();
					
					
				//������һ���ݸ�ֽ
				}else{ 
					//����һ�ε����ʱ�򱣴浱ǰͼƬ
					saveThreadJudge();
					
					/*�жϵ��˵ڼ���ͼƬ��*/
					temp_add++;
					
					int add_all_num=Integer.parseInt(draft_all.getText().toString())+1;
					draft_current.setText(current_num+"");
					draft_all.setText(add_all_num+"");
					
					
					showScreenContent();
				}
				
				
				//���浱ǰ״̬
				currentState(currentState);
			}
		});
	}
	
	public void saveThreadJudge(){
		/*��һ�ΰ�����ʱ�򣬴洢ͼƬ*/
		if(temp_left==0 && temp_right==0 && temp_add==0){
			d_v.savaThread();
		}
		
	}
	
	/**
	 * ���յ�����or�����̵߳ķ������
	 */
	final Handler handler=new Handler(){
		 public void handleMessage(Message msg) {
			Bundle b = msg.getData();
			int time = b.getInt("type");
			d_v.setVisibility(View.VISIBLE);
			switch (time) {
			case ADD:
				Log.i("", "handler add in");
				try {
					if(d_v.addButton(temp_move)){
						temp_add=0;
						temp_right=0;
						temp_left=0;
						temp_move=0;
						Log.i("mentalwubingchao", "handler add success");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.i("mentalwubingchao", "ADD ����ʧ�� ");
				}
				break;
			case LEFT:
				if(d_v.leftButton(-temp_move)){
					temp_add=0;
					temp_right=0;
					temp_left=0;
					temp_move=0;
					Log.i("mentalwubingchao", "handler leftmove success");
				}
				else{
					Log.i("mentalwubingchao", "leftbutton��ȡ����");
				}
				break;
				
			case RIGHT:
				d_v.max_bitmap_index=Integer.parseInt(draft_all.getText().toString());
				if(d_v.rightButton(temp_move)){
					temp_add=0;
					temp_right=0;
					temp_left=0;
					temp_move=0;
					Log.i("mentalwubingchao", "handler rightmove success");
				}
				else{
					Log.i("mentalwubingchao", "rightbutton��ȡ����");
				}
				break;
				
			case NONE:
				if(d_v.moveToCurrentPosition()==true){
					temp_add=0;
					temp_right=0;
					temp_left=0;
					temp_move=0;
					Log.i("mentalwubingchao", "handler moveCurrent success");
				}
				break;
			default:
				break;
			}
		 }
	};
	
	/**��ָ�뿪һ��ʱ�����Ļ�д�sd���м�������
	 * state_temp:1�������ң�2��������
	 */
	public void showScreenContent(){
		/*����ָ�ͷ�һ���ӵ�ʱ����ʾbitmap������*/
		int current_num=Integer.parseInt(draft_current.getText().toString());
		int all_num=Integer.parseInt(draft_all.getText().toString());
		//d_v.setClickable(false);
		d_v.setVisibility(View.INVISIBLE);
		if(current_num==all_num){
			state=2;
		}
		else{
			state=1;
		}
		timer.cancel();
		timer = new Timer(); 
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				//d_v.setClickable(true);
				Log.i("mentalwubingchao", "run is start");
				temp_move=temp_right+temp_add-temp_left;//���ڵ���0��ʾ�����ƶ�
				Log.i("mentalwubingchao", "really move "+temp_move+" steps");
				if(temp_move==0){
					//do nothing 
					startthread=new startThread(NONE,handler);
					new Thread(startthread).start();
				}
				else if(temp_move<0){
					startthread=new startThread(LEFT,handler);
					new Thread(startthread).start();
					Log.i("mentalwubingchao", "step into leftmove");
				}
				else {
					if(state==1){
						startthread=new startThread(RIGHT,handler);
						new Thread(startthread).start();
						Log.i("mentalwubingchao", "step into rightmove");
					}
					else if(state==2){
						startthread=new startThread(ADD,handler);
						new Thread(startthread).start();
						Log.i("mentalwubingchao", "step into addmove");
					}
				}
			}
		}, 1000);
	}
	
	 /**
	  * ��ղݸ屾
	 * @param file
	 */
	public static void delete(File file) {
	        if (file.isFile()) {  
	            file.delete();  
	            return;  
	        }  
	          if(file.isDirectory()){  
	            File[] childFiles = file.listFiles();  
	            if (childFiles == null || childFiles.length == 0) {  
	                file.delete();  
	                return;  
	            }        
	            for (int i = 0; i < childFiles.length; i++) {  
	            	delete(childFiles[i]);  
	            }  
	            file.delete();  
	        }  
	    } 
	/*��ʾ��ǰ��ť״̬*/
	@SuppressWarnings("deprecation")
	public void whichButtonShow(int type){
		Resources resources=getBaseContext().getResources();
		Drawable bWrite1 = resources.getDrawable(R.drawable.write2);
		Drawable bErase1 = resources.getDrawable(R.drawable.erase2);
		Drawable bMove1= resources.getDrawable(R.drawable.hand2);
		Drawable bWrite2 = resources.getDrawable(R.drawable.write1);
		Drawable bErase2 = resources.getDrawable(R.drawable.erase1);
		Drawable bMove2= resources.getDrawable(R.drawable.hand1);
		switch(type){
		case 0:
			write_button.setBackgroundDrawable(bWrite2);
			earse_button.setBackgroundDrawable(bErase1);
			move_button.setBackgroundDrawable(bMove1);
			break;
		case 1:
			write_button.setBackgroundDrawable(bWrite1);
			earse_button.setBackgroundDrawable(bErase2);
			move_button.setBackgroundDrawable(bMove1);
			break;
		case 2:
			write_button.setBackgroundDrawable(bWrite1);
			earse_button.setBackgroundDrawable(bErase1);
			move_button.setBackgroundDrawable(bMove2);
			break;
		}
	}
	
	
	/**
	 * �жϵ�ǰ״̬
	 */
	
	public void currentState(int state){
		switch (state) {
		case WRITE:
			whichButtonShow(0);
			d_v.write();
			break;
		case ERASE:
			whichButtonShow(1);
			d_v.erase();
			break;
			
		case MOVE:
			whichButtonShow(2);
			d_v.move();
			break;
		default:
			break;
		}
	}
   
}
