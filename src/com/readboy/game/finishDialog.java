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
    public finishDialog(Context context,int office,int grade,String intent_type) {
        // TODO Auto-generated constructor stub
        this.context=context;
        ad=new android.app.AlertDialog.Builder(context).create();
        ad.show();
        //�ؼ������������,ʹ��window.setContentView,�滻�����Ի��򴰿ڵĲ���
        Window window = ad.getWindow();
        window.setContentView(R.layout.enter_dialog);
        current_office=(TextView)window.findViewById(R.id.current_office);
        current_grade=(TextView)window.findViewById(R.id.current_grade);
        top_office=(TextView)window.findViewById(R.id.top_office);
        top_grade=(TextView)window.findViewById(R.id.top_grade);
        continue_bt=(TextView)window.findViewById(R.id.continue_game);
        quit_bt=(TextView)window.findViewById(R.id.quit_game);
        
        //setClickContinueEvent(final View.OnClickListener listener);
        //setClickQuitEvent();
        //���õ���հ״�
        ad.setCancelable(false);
        
        setCurrentData(office,grade);
        
    }
    
    /*���õ�ǰ�����ͷ���*/
    public void setCurrentData(int office ,int grade){
    	current_office.setText(office+"");
    	current_grade.setText(grade+"");
    }
    
    
    
    /*������ߵľֺͷ���*/
    public void setTopData(String intent_type){
    	String name="test";
	  	SharedPreferences sharedPreferences=context.getSharedPreferences(name, 
	  				Activity.MODE_PRIVATE); 
	  				// ʹ��getString�������value��ע���2��������value��Ĭ��ֵ 
	  	int topOffice=sharedPreferences.getInt("fist_grade"+intent_type, 0); 
    }
    
    /*���������ť*/
    public void setClickContinueEvent(final View.OnClickListener listener){
    	continue_bt.setOnClickListener(listener);
    }
    
    
    /*����˳���ť*/
    public void setClickQuitEvent(final View.OnClickListener listener){
    	quit_bt.setOnClickListener(listener);
    }
    
   /*������ť*/
    public void dismiss() {
        ad.dismiss();
    } 
}
