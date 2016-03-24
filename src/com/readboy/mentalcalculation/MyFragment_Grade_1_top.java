package com.readboy.mentalcalculation;

import com.readboy.game.GameActivity;
import com.readboy.game.Grade_1.Grade_1_top;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyFragment_Grade_1_top extends Fragment {
	  private FragmentActivity activity;
	  private TextView tv;
	  private String []intent_content={"�ӷ��ļ��㷽��"};
	  
	  final private int ADDINFIVE=1;  //5���ڵļӷ�
	  final private int SUBINFIVE=2;	//5���ڵļ���
	  final private int ZEROONE=3;		//0�ļ���1
	  final private int ZERTWO=4;		//0�ļ���2
	  
	  
	  
	  final private int ADDINFIVEANDSIX=5;  //6��7�ļӼ���
	  final private int ADDFORNINE=6;		//9�ļӼ���
	  final private int ADDINNINE=7;		//9���ڵļӼ���
	  final private int ADDFORTEN=8;		//10�ļӼ���
	  final private int  CONTINUEADD=9;		//����
	  final private int CONTINUESUD=10;		//����
	  final private int UNKOWNNUM=11;		//��δ֪��
	  final private int ADDTHENSUB=12;		//�ȼӺ��
	  final private int SUBTHENADD=13;		//�ȼ����
	  final private int ADDFOREIGHT=14;		//һͼ��ʽ��8�ļӼ���
	  
	  
	  
	  final private int TENADD=15;				//ʮ�Ӽ�
	  final private int ADDNAME=16;			//�Ӽ�����ʽ�ĸ���������
	  final private int ADDFORTWI=17;			//ʮ���Ӽ�����Ӧ�ļ���
	  
	  final private int NINEADDWHAT=18;		//9�Ӽ��ļ��㷽��
	  final private int SEVENEIGHT=19;			//876�Ӽ��ļ��㷽��
	  final private int FIVETOTWO=20;			//5432�Ӽ��ļ��㷽��
	  /**
	   * ��activity����ΪFragmentActivity
	   */
	  @Override
	  public void onAttach(Activity activity) {
	    // TODO Auto-generated method stub
	    super.onAttach(activity);
	    this.activity = (FragmentActivity) activity;
	  }

	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    //���ò���
	    View view = inflater.inflate(R.layout.grade_1_top, container,
	        false);
	    
	    //�����ڵļӷ�
	    tv=(TextView)view.findViewById(R.id.grade_1_top_11);
	    tv.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				 Intent intent = new Intent();  
	             intent.setClass(getActivity(), Grade_1_top.class);  
	             intent.putExtra("content",intent_content[0]);
	             intent.putExtra("type", ADDINFIVE);
	             startActivity(intent);      
			}
		});
	      
	    //�����ڵļ���
	    
	    
	    
	    
	    //0�ļ��㣨1��
	    
	    
	    
	    
	    //0�ļ��㣨2��
	    
	    
	    
	    return view;
	  }

	  }

	  
	  
