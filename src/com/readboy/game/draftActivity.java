package com.readboy.game;

import com.readboy.HandWrite.DraftView;
import com.readboy.HandWrite.DrawView;
import com.readboy.HandWrite.HandWrite;
import com.readboy.mentalcalculation.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class draftActivity extends Activity{
	protected DraftView d_v; 
	private Button write_button;
	private Button earse_button;
	private Button move_button;
	private Button clear_button;
	private Button end_button;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.draft_layout);
        init();
        listenerEvent();
    }
	
	
	protected void init(){
		write_button=(Button) findViewById(R.id.draft_write_button);
		earse_button=(Button) findViewById(R.id.draft_erase_button);
		move_button=(Button) findViewById(R.id.draft_move_button);
		clear_button=(Button) findViewById(R.id.draft_clean_button);
		end_button=(Button) findViewById(R.id.draft_finished_button);
		d_v = (DraftView) findViewById(R.id.draft_screen);
		//d_v.paint.setColor(Color.RED);
		//d_v.paint.setStrokeWidth(5);
	}
	
	protected void listenerEvent(){
		//完成按钮
		end_button.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						draftActivity.this.finish();
					}
				});
		//清除按钮
		clear_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				d_v.reSetPath();
				//Log.i("onclickis", "yes");
			}
		});	
		
		//移动按钮
		move_button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						whichButtonShow(2);
						
					}
				});
		//擦除按钮
		earse_button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						whichButtonShow(1);
						d_v.erase();
					}
				});
		//练习按钮
		write_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				whichButtonShow(0);
				
			}
		});
	}
	
	
	/*显示当前按钮状态*/
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
   
}
