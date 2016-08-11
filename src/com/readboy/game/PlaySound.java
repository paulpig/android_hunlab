package com.readboy.game;

import java.net.ContentHandler;
import java.util.HashMap;

import com.readboy.mentalcalculation.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;

public class PlaySound {
	final int FAIL=2;
	final int SUCCESS=1;
	private Context content;
	private SoundPool mSoundPool = null;  
    private HashMap<Integer, Integer> soundID = new HashMap<Integer, Integer>();  

    
    
	public PlaySound(Context context) {
		super();
		// TODO Auto-generated constructor stub
		content=context;
	}

	private void initSP() throws Exception {   
        mSoundPool = new SoundPool(2, AudioManager.STREAM_SYSTEM, 5);  
        soundID.put(1, mSoundPool.load(content.getAssets().openFd("success.wav"), 1));
        soundID.put(2, mSoundPool.load(content.getAssets().openFd("fail.wav"), 1));  //需要捕获IO异常  
    }  
	
	
	
	
	/**
	 * 播放音效
	 * 
	 * @param num_sound：1代表成功的音效 2代表失败音效
	 */
	public void PlaySound(int num_sound){
		try {
			initSP();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("mentalcalculation", "sound init fail");
		}
		switch (num_sound){
		case SUCCESS:
			mSoundPool.play(soundID.get(1),1,1, 0, -1, 1);
			break;
		case FAIL:
			mSoundPool.play(soundID.get(2),1,1, 0, 0, 1);
			break;
		}
	}
}
