package com.readboy.game;
import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.readboy.mentalcalculation.R;

public class finishDialog {
	Context context;
    android.app.AlertDialog ad;
    TextView current_office;
    TextView current_grade;
    TextView top_office;
    TextView top_grade;
    TextView continue_bt;
    TextView quit_bt;
    
    int topOffice;
    int topGrade;
    int currentOffice;
    int currentGrade;
    public finishDialog(Context context,int office,int grade,String intent_type) {
        // TODO Auto-generated constructor stub
        this.context=context;
        ad=new android.app.AlertDialog.Builder(context).create();
        ad.show();
        //关键在下面的两行,使用window.setContentView,替换整个对话框窗口的布局
        Window window = ad.getWindow();
        window.setContentView(R.layout.finish_dialog);
        current_office=(TextView)window.findViewById(R.id.current_office);
        current_grade=(TextView)window.findViewById(R.id.current_grade);
        top_office=(TextView)window.findViewById(R.id.top_office);
        top_grade=(TextView)window.findViewById(R.id.top_grade);
        continue_bt=(TextView)window.findViewById(R.id.continue_game);
        quit_bt=(TextView)window.findViewById(R.id.quit_game);
        
        //setClickContinueEvent(final View.OnClickListener listener);
        //setClickQuitEvent();
        //设置点击空白处不可退出
        ad.setCancelable(false);
        currentOffice=office;
        currentGrade=grade;
        
        
        setCurrentData(office,grade);
        setTopData(intent_type);
    }
    
    /*设置当前局数和分数*/
    public void setCurrentData(int office ,int grade){
    	current_office.setText(office+"");
    	current_grade.setText(grade+"");
    }
    
    
    
    /*设置最高的局和分数*/
    public void setTopData(String intent_type){
    	String name="test";
	  	SharedPreferences sharedPreferences=context.getSharedPreferences(name, 
	  				Activity.MODE_PRIVATE); 
	  				// 使用getString方法获得value，注意第2个参数是value的默认值 
	  	topGrade=sharedPreferences.getInt("first_grade"+intent_type, 0); 
	  	topOffice=sharedPreferences.getInt("office_grade"+intent_type, 1);
	  	
	  	updateGradeContent();
	  	
	  	updateGrade(topGrade,topOffice ,intent_type);
	  	
	  	top_office.setText(topOffice+"");
	  	top_grade.setText(topGrade+"");
    }
    
    /*点击继续按钮*/
    public void setClickContinueEvent(final View.OnClickListener listener){
    	continue_bt.setOnClickListener(listener);
    	
    }
    
    
    /*点击退出按钮*/
    public void setClickQuitEvent(final View.OnClickListener listener){
    	quit_bt.setOnClickListener(listener);
    	
    }
    
   /*消除按钮*/
    public void dismiss() {
        ad.dismiss();
    } 
    
    
    public void hide(){
    	ad.hide();
    }
	
  	public void show(){
  		ad.show();
  	}
  	/**
  	 * 更新名次
  	 */
  	public void updateGradeContent(){
  		if(currentOffice>=topOffice){
  			topOffice=currentOffice;
  		}
  		if(currentGrade>=topGrade){
  			topGrade=currentGrade;
  		}
  	}
  	/*
  	 * 设置保存的数据 排名
  	 * @param fist_grade 第一名分数
  	 * @param second_grade 第二名分数
  	 * @param third_grade 第三名分数
  	 */
  	public void updateGrade(int fist_grade,int office,String intent_type){
  		//实例化SharedPreferences对象（第一步） 
  		String name="test";
  		SharedPreferences mySharedPreferences= context.getSharedPreferences(name, 
  		Activity.MODE_PRIVATE); 
  		//实例化SharedPreferences.Editor对象（第二步） 
  		SharedPreferences.Editor editor = mySharedPreferences.edit(); 
  		//用putString的方法保存数据 
  		editor.putInt("first_grade"+intent_type, topGrade); 
  		editor.putInt("office_grade"+intent_type, topOffice);
  		//提交当前数据 
  		editor.commit(); 
  	}
  	


}
