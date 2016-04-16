package com.readboy.mentalcalculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity{
	private TextView TextContext;
	private ImageView menuImg;
	private TextView first_grade;
	private TextView second_grade;
	private TextView third_grade;
	private TextView four_grade;
	private TextView five_grade;
	private TextView six_grade;
	private Button left_button;
	private Button right_button;
	private String[]grade={"一年级","二年级","三年级","四年级","五年级","六年级"};
	private FragmentManager manager;
	private Fragment mFragments1;
	private Fragment mFragments2;
	private int FragmentForButton[]={1,2};
	private DrawerLayout mDrawerLayout;
	private LinearLayout linerlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.activity_main);
        initView();
		initEvents();
        findViewButton();
        clickListener();
        
       // adapterListView();
        manager = getSupportFragmentManager();
		mFragments1 = manager.findFragmentById(R.id.MyFragment_Grade_1);  
		mFragments2=manager.findFragmentById(R.id.left_framgment);
    }
    
    public void findViewButton(){
    	first_grade = (TextView) findViewById(R.id.first_grade);
    	second_grade= (TextView) findViewById(R.id.second_grade);
    	third_grade= (TextView) findViewById(R.id.third_grade);
    	four_grade= (TextView) findViewById(R.id.four_grade);
    	five_grade= (TextView) findViewById(R.id.five_grade);
    	six_grade= (TextView) findViewById(R.id.six_grade);
    	Log.i("tagg", "lalalal");
    	TextContext=(TextView)findViewById(R.id.title_bar_name);
    	left_button=(Button)findViewById(R.id.first_volume);
    	right_button=(Button)findViewById(R.id.second_volume);
    	linerlayout=(LinearLayout) findViewById(R.id.layout_menu);
    }
    
    /*监听各个按钮*/
    public void clickListener(){
    	first_grade.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mDrawerLayout.closeDrawer(Gravity.LEFT);
				Resources resources=getBaseContext().getResources();
				Drawable right_b = resources.getDrawable(R.drawable.right_unpress);
				Drawable left_b = resources.getDrawable(R.drawable.left_press);
				left_button.setBackgroundDrawable(left_b);
				right_button.setBackgroundDrawable(right_b);
				clearChooseBack(first_grade);
				TextContext.setText(grade[0]);
				FragmentForButton[0]=1;
				FragmentForButton[1]=2;
				FragmentTransaction transaction1;
				transaction1 =manager.beginTransaction()  
		                .hide(mFragments1).hide(mFragments1);
			    transaction1.replace(R.id.relative,new MyFragment_Grade_1_top());
			    transaction1.commit();
			}
		});
    	second_grade.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mDrawerLayout.closeDrawer(Gravity.LEFT);
				Resources resources=getBaseContext().getResources();
				Drawable right_b = resources.getDrawable(R.drawable.right_unpress);
				Drawable left_b = resources.getDrawable(R.drawable.left_press);
				left_button.setBackgroundDrawable(left_b);
				right_button.setBackgroundDrawable(right_b);
				clearChooseBack(second_grade);
				TextContext.setText(grade[1]); 
				FragmentForButton[0]=3;
				FragmentForButton[1]=4;
				FragmentTransaction transaction1;
				transaction1 =manager.beginTransaction()  
		                .hide(mFragments1).hide(mFragments1);
			    transaction1.replace(R.id.relative,new MyFragment_Grade_2_top());
			    transaction1.commit();
				
			}
		});
    	third_grade.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mDrawerLayout.closeDrawer(Gravity.LEFT);
				Resources resources=getBaseContext().getResources();
				Drawable right_b = resources.getDrawable(R.drawable.right_unpress);
				Drawable left_b = resources.getDrawable(R.drawable.left_press);
				left_button.setBackgroundDrawable(left_b);
				right_button.setBackgroundDrawable(right_b);
				clearChooseBack(third_grade);
				TextContext.setText(grade[2]); 
				FragmentForButton[0]=5;
				FragmentForButton[1]=6;
				FragmentTransaction transaction1;
				transaction1 =manager.beginTransaction()  
		                .hide(mFragments1).hide(mFragments1);
			    transaction1.replace(R.id.relative,new MyFragment_Grade_3_top());
			    transaction1.commit();
			}
		});
    	four_grade.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mDrawerLayout.closeDrawer(Gravity.LEFT);
				Resources resources=getBaseContext().getResources();
				Drawable right_b = resources.getDrawable(R.drawable.right_unpress);
				Drawable left_b = resources.getDrawable(R.drawable.left_press);
				left_button.setBackgroundDrawable(left_b);
				right_button.setBackgroundDrawable(right_b);
				clearChooseBack(four_grade);
				TextContext.setText(grade[3]); 
				FragmentForButton[0]=7;
				FragmentForButton[1]=8;
				FragmentTransaction transaction1;
				transaction1 =manager.beginTransaction()  
		                .hide(mFragments1).hide(mFragments1);
			    transaction1.replace(R.id.relative,new MyFragment_Grade_4_top());
			    transaction1.commit();
			}
		});
    	five_grade.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mDrawerLayout.closeDrawer(Gravity.LEFT);
				Resources resources=getBaseContext().getResources();
				Drawable right_b = resources.getDrawable(R.drawable.right_unpress);
				Drawable left_b = resources.getDrawable(R.drawable.left_press);
				left_button.setBackgroundDrawable(left_b);
				right_button.setBackgroundDrawable(right_b);
				clearChooseBack(five_grade);
				TextContext.setText(grade[4]); 
				FragmentForButton[0]=9;
				FragmentForButton[1]=10;
				FragmentTransaction transaction1;
				transaction1 =manager.beginTransaction()  
		                .hide(mFragments1).hide(mFragments1);
			    transaction1.replace(R.id.relative,new MyFragment_Grade_5_top());
			    transaction1.commit();
			}
		});
    	six_grade.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mDrawerLayout.closeDrawer(Gravity.LEFT);
				Resources resources=getBaseContext().getResources();
				Drawable right_b = resources.getDrawable(R.drawable.right_unpress);
				Drawable left_b = resources.getDrawable(R.drawable.left_press);
				left_button.setBackgroundDrawable(left_b);
				right_button.setBackgroundDrawable(right_b);
				clearChooseBack(six_grade);
				TextContext.setText(grade[5]); 
				FragmentForButton[0]=11;
				FragmentForButton[1]=12;
				FragmentTransaction transaction1;
				transaction1 =manager.beginTransaction()  
		                .hide(mFragments1).hide(mFragments1);
			    transaction1.replace(R.id.relative,new MyFragment_Grade_6_top());
			    transaction1.commit();
			}
		});
    	
    	left_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Resources resources=getBaseContext().getResources();
				Drawable right_b = resources.getDrawable(R.drawable.right_unpress);
				Drawable left_b = resources.getDrawable(R.drawable.left_press);
				left_button.setBackgroundDrawable(left_b);
				right_button.setBackgroundDrawable(right_b);
				switch(FragmentForButton[0]){
					case 1:
						FragmentTransaction transaction1;
						transaction1 =manager.beginTransaction()  
				                .hide(mFragments1).hide(mFragments1);
					    transaction1.replace(R.id.relative,new MyFragment_Grade_1_top());
					    transaction1.commit();
						break;
					case 3:
						FragmentTransaction transaction2;
						transaction2 =manager.beginTransaction()  
				                .hide(mFragments1).hide(mFragments1);
					    transaction2.replace(R.id.relative,new MyFragment_Grade_2_top());
					    transaction2.commit();
						break;
					case 5:
						FragmentTransaction transaction3;
						transaction3 =manager.beginTransaction()  
				                .hide(mFragments1).hide(mFragments1);
					    transaction3.replace(R.id.relative,new MyFragment_Grade_3_top());
					    transaction3.commit();
						break;
					case 7:
						FragmentTransaction transaction4;
						transaction4 =manager.beginTransaction()  
				                .hide(mFragments1).hide(mFragments1);
					    transaction4.replace(R.id.relative,new MyFragment_Grade_4_top());
					    transaction4.commit();
						break;
					case 9:
						FragmentTransaction transaction5;
						transaction5 =manager.beginTransaction()  
				                .hide(mFragments1).hide(mFragments1);
					    transaction5.replace(R.id.relative,new MyFragment_Grade_5_top());
					    transaction5.commit();
						break;
					case 11:
						FragmentTransaction transaction6;
						transaction6 =manager.beginTransaction()  
				                .hide(mFragments1).hide(mFragments1);
					    transaction6.replace(R.id.relative,new MyFragment_Grade_6_top());
					    transaction6.commit();
						break;
					default:
						break;
				}
			}
		});
    	
    	
    	right_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Resources resources=getBaseContext().getResources();
				Drawable right_b = resources.getDrawable(R.drawable.right_press);
				Drawable left_b = resources.getDrawable(R.drawable.left_unpress);
				left_button.setBackgroundDrawable(left_b);
				right_button.setBackgroundDrawable(right_b);
				// TODO Auto-generated method stub
				switch(FragmentForButton[1]){
				case 2:
					FragmentTransaction transaction1;
					transaction1 =manager.beginTransaction()  
			                .hide(mFragments1).hide(mFragments1);
				    transaction1.replace(R.id.relative,new MyFragment_Grade_1_down());
				    transaction1.commit();
					break;
				case 4:
					FragmentTransaction transaction3;
					transaction3 =manager.beginTransaction()  
			                .hide(mFragments1).hide(mFragments1);
				    transaction3.replace(R.id.relative,new MyFragment_Grade_2_down());
				    transaction3.commit();
					break;
				case 6:
					FragmentTransaction transaction4;
					transaction4 =manager.beginTransaction()  
			                .hide(mFragments1).hide(mFragments1);
				    transaction4.replace(R.id.relative,new MyFragment_Grade_3_down());
				    transaction4.commit();
					break;
				case 8:
					FragmentTransaction transaction5;
					transaction5 =manager.beginTransaction()  
			                .hide(mFragments1).hide(mFragments1);
				    transaction5.replace(R.id.relative,new MyFragment_Grade_4_down());
				    transaction5.commit();
					break;
				case 10:
					FragmentTransaction transaction6;
					transaction6 =manager.beginTransaction()  
			                .hide(mFragments1).hide(mFragments1);
				    transaction6.replace(R.id.relative,new MyFragment_Grade_5_down());
				    transaction6.commit();
					break;
				case 12:
					FragmentTransaction transaction7;
					transaction7 =manager.beginTransaction()  
			                .hide(mFragments1).hide(mFragments1);
				    transaction7.replace(R.id.relative,new MyFragment_Grade_6_down());
				    transaction7.commit();
					break;
					
				default:
					break;
			}
			}
		});
    }
    

    
    
    
    public void OpenRightMenu(View view)
	{
		mDrawerLayout.openDrawer(Gravity.LEFT);
		mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,Gravity.LEFT);
		
	}
	


	private void initEvents()
	{
		mDrawerLayout.setDrawerListener(new DrawerListener()
		{
			@Override
			public void onDrawerStateChanged(int newState)
			{
			}

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset)
			{
				

			}

			@Override
			public void onDrawerOpened(View drawerView)
			{
				linerlayout.setClickable(true);
			}

			@Override
			public void onDrawerClosed(View drawerView)
			{
				mDrawerLayout.setDrawerLockMode(
						DrawerLayout.LOCK_MODE_LOCKED_CLOSED,Gravity.LEFT);
			}
		});
	}

	private void initView()
	{
		mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);
		mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
				Gravity.LEFT);
	}
	
	/*清除所有背景色，点击显示*/
	public void clearChooseBack(TextView tv){
		first_grade.setBackgroundDrawable(null);
		second_grade.setBackgroundDrawable(null);
		third_grade.setBackgroundDrawable(null);
		four_grade.setBackgroundDrawable(null);
		five_grade.setBackgroundDrawable(null);
		six_grade.setBackgroundDrawable(null);
		Resources resources=getBaseContext().getResources();
		Drawable m_choosing = resources.getDrawable(R.drawable.choosing);
		tv.setBackgroundDrawable(m_choosing);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
