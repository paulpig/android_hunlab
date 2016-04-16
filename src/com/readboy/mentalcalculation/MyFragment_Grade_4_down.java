package com.readboy.mentalcalculation;

import com.readboy.game.Grade_4.Grade_4_down;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MyFragment_Grade_4_down extends Fragment {
	 private FragmentActivity activity;
	  TextView tv;
	  View view ;
	  private TextView tv1;
	  private TextView tv2;
	  private TextView tv3;
	  private TextView tv4;
	  private TextView tv5;
	  final private int MULANDDIV=1;  //�й�0������
	  
	  
	  final private int CANDIVALL=2;	//�˷������
	  final private int SEVENDIV=3;  //�ӷ������ɡ��ӷ�����ɵ�Ӧ��
	  final private int DIVSPACE=4;		//�ӷ������
	  final private int DIVWAY=5;		//�����ļ������
	  private final String []intent_content={"�й�0������","�ӷ������","�ӷ������ɡ��ӷ�����ɵ�Ӧ��","�˷������","�����ļ������"};
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
	    view = inflater.inflate(R.layout.grade_4_down, container,
	        false);
	    init();
	    ListenEvent();
	    return view;
	  }

	  public void init(){
		  tv1=(TextView)view.findViewById(R.id.grade_4_down_11);
		  
		  
		  tv2=(TextView)view.findViewById(R.id.grade_4_down_21);
		  
		  
		  tv3=(TextView)view.findViewById(R.id.grade_4_down_22);
		  
		  tv4=(TextView)view.findViewById(R.id.grade_4_down_23);
		  
		  tv5=(TextView)view.findViewById(R.id.grade_4_down_24);
		  
	  }
	  
	  public void ListenEvent(){
		  tv1.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[0],MULANDDIV);     
				}
			});
		  tv2.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[1],DIVSPACE);     
				}
			});
		  tv3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[2],SEVENDIV);     
				}
			});
		  tv4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[3],CANDIVALL);    
				}
			});  
		  
		  tv5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					intentToGame(intent_content[4],DIVWAY);    
				}
			});  
	  }
	  
	  public void intentToGame(String content_intent,int type){
		  Intent intent = new Intent();  
          intent.setClass(getActivity(), Grade_4_down.class);  
          intent.putExtra("content",content_intent);
          intent.putExtra("type", type);
          startActivity(intent);    
	  }
}
