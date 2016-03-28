package com.readboy.game;

import com.readboy.HandWrite.DraftView;
import com.readboy.mentalcalculation.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
	private Button add_button;
	private Button left_button;
	private Button right_button;
	private TextView draft_current;
	private TextView draft_all;
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
		delete_button=(Button) findViewById(R.id.draft_remove_button);
		add_button=(Button) findViewById(R.id.draft_add_button);
		left_button=(Button) findViewById(R.id.draft_left_button);
		right_button=(Button) findViewById(R.id.draft_right_button);
		draft_current=(TextView) findViewById(R.id.draft_current);
		draft_all=(TextView) findViewById(R.id.draft_all);
		//d_v.paint.setColor(Color.RED);
		//d_v.paint.setStrokeWidth(5);
		whichButtonShow(0);
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
						d_v.move();
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
				d_v.write();
				
			}
		});
		
		//删除草稿纸
		delete_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int current_num=Integer.parseInt(draft_current.getText().toString());
				int all_num=Integer.parseInt(draft_all.getText().toString());
				if(all_num>=2){
					draft_current.setText(1+"");
					draft_all.setText(all_num-1+"");
					d_v.deleteButton(current_num-1);
					//whichButtonShow(0);
				}
				
			
			}
		});
		
		//增加草稿纸
		add_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int current_num=Integer.parseInt(draft_current.getText().toString())+1;
				int all_num=Integer.parseInt(draft_all.getText().toString())+1;
				draft_current.setText(current_num+"");
				draft_all.setText(all_num+"");
				d_v.addButton(current_num-1);
				//whichButtonShow(0);
			}
		});
		
		//查看left草稿纸
		left_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int current_num=Integer.parseInt(draft_current.getText().toString())-1;
				
				if(current_num>=1){
					draft_current.setText(current_num+"");
					d_v.leftButton(current_num-1);
					//whichButtonShow(0);
				}
				
			}
		});
		
		//查看right草稿纸
		right_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int current_num=Integer.parseInt(draft_current.getText().toString())+1;
				
				int all_num=Integer.parseInt(draft_all.getText().toString());
				if(current_num<=all_num){
					draft_current.setText(current_num+"");
					d_v.leftButton(current_num-1);
					//whichButtonShow(0);
				}
				
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
