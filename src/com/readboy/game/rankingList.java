package com.readboy.game;



import com.readboy.mentalcalculation.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class rankingList extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.ranking_list);
	}
}
