package com.readboy.game;

import com.readboy.HandWrite.DraftView;
import com.readboy.HandWrite.DrawView;
import com.readboy.HandWrite.HandWrite;
import com.readboy.mentalcalculation.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class draftActivity extends Activity{
	protected DraftView dv; 
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
		dv = (DraftView) findViewById(R.id.draft_layout);
		dv.paint.setColor(Color.RED);
		dv.paint.setStrokeWidth(5);
	}
	
	protected void listenerEvent(){
		//完成按钮
		end_button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						draftActivity.this.finish();
					}
				});
		//清除按钮
		clear_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dv.clearScreen();
			}
		});
		
		
		//移动按钮
		move_button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						dv.paint.setColor(Color.RED);
						dv.paint.setStrokeWidth(5);
					}
				});
		//擦除按钮
		earse_button.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						//dv.paint.setColor(Color.WHITE);
						//dv.paint.setStrokeWidth(20);
						dv. erasePaint();
					}
				});
		//练习按钮
		write_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dv.paint.setColor(Color.RED);
				dv.paint.setStrokeWidth(5);
				dv.invalidate();
			}
		});
	}
   
}
