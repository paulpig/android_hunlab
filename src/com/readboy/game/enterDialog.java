package com.readboy.game;
import com.readboy.mentalcalculation.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class enterDialog {
	Context context;
    android.app.AlertDialog ad;

    TextView remind_next_time;
    TextView click_back;
    TextView click_ok;
    boolean is_show_next_time=true;

    TextView titleView;
    TextView messageView;
    LinearLayout buttonLayout;
    public enterDialog(Context context) {
        // TODO Auto-generated constructor stub
        this.context=context;
        ad=new android.app.AlertDialog.Builder(context).create();
        ad.show();
        //关键在下面的两行,使用window.setContentView,替换整个对话框窗口的布局
        Window window = ad.getWindow();
        window.setContentView(R.layout.enter_dialog);
        remind_next_time=(TextView)window.findViewById(R.id.remind_next_time);
        click_back=(TextView)window.findViewById(R.id.click_back);
        click_ok=(TextView)window.findViewById(R.id.click_ok);
        is_show_next_time=true;
        setClickBackListenEvent();
        setClickOkListenEvent();
        //设置点击空白处
        ad.setCancelable(false);
    }
    /**
     * 点击下一次发生的事件
     * @param text
     * @param listener
     */
    public void setRemind_next_timeListenEvent(final View.OnClickListener listener)
    {
    	remind_next_time.setOnClickListener(listener);
    	//dismiss();
    } 

    
    
    
    
    /**
     * 点击clickback按钮发生事件
     */
    
    public void setClickBackListenEvent(){
    	//is_show_next_time=true;
    	click_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				is_show_next_time=false;
				click_ok.setVisibility(0);
			}
		});
    }
    
    
    /*点击click_ok按钮发生事件*/
    
    public void setClickOkListenEvent(){
    	click_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				is_show_next_time=true;
				click_ok.setVisibility(4);
			}
		});
    	
    }
    
    /*保存是否进入下一次变量在文件中*/
    public void keepIsShow(){
    	String name="test";
  		SharedPreferences mySharedPreferences= context.getSharedPreferences(name, 
  		Activity.MODE_PRIVATE); 
  		//实例化SharedPreferences.Editor对象（第二步） 
  		SharedPreferences.Editor editor = mySharedPreferences.edit(); 
  		//用putString的方法保存数据 
  		editor.putBoolean("is_show", is_show_next_time); 
  		editor.commit(); 
    	}
  
   /*消除按钮*/
    public void dismiss() {
        ad.dismiss();
        keepIsShow();
    } 
    
     public void setbackKey(){
    	 ad.setOnKeyListener(new OnKeyListener() {
             
             @Override
             public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                 // TODO Auto-generated method stub
                 if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0)
                 {
                     dialog.dismiss();
                 }
                 return false;
             }
         });
    		 
     }
}
