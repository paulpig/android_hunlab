package com.readboy.game;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

public class costomAnimation {
	    private static final int MSG_START = 0xf1;
	    private static final int MSG_STOP  = 0xf2;
	    private static final int STATE_STOP = 0xf3;
	    private static final int STATE_RUNNING = 0xf4;

	    /* ����״̬*/
	    private int mState = STATE_RUNNING;
	    private ImageView mImageView;
	    /* ͼƬ��ԴID�б�*/
	    private List<Integer> mResourceIdList = null;
	    /* ��ʱ����*/
	    private Timer mTimer = null;
	    private AnimTimerTask mTimeTask = null;
	    /* ��¼����λ��*/
	    private int mFrameIndex = 0;
	    /* ������ʽ*/
	    private boolean isLooping = false;

	    public costomAnimation( ){
	        mTimer = new Timer();
	    }

	    /**
	     * ���ö���������Դ
	     * 
	     * */
	    public void setAnimation( ImageView imageview, List<Integer> resourceIdList ){
	        mImageView = imageview;
	        mResourceIdList = resourceIdList;
	    }

	    /**
	     *  ��ʼ���Ŷ���
	     *  @param loop ʱ��ѭ������
	     *  @param duration ��������ʱ����
	     * */
	    public void start(boolean loop, int duration){
	        stop();
	        isLooping = loop;
	        mFrameIndex = 0;
	        mState = STATE_RUNNING;
	        mTimeTask = new AnimTimerTask( );
	        mTimer.schedule(mTimeTask, 0, duration);
	    }

	    /**
	     * ֹͣ��������
	     * 
	     * */
	    public void stop(){
	        if (mTimeTask != null) {
	            mFrameIndex = 0;
	            mState = STATE_STOP;
	            mTimer.purge();
	            mTimeTask.cancel();
	            mTimeTask = null;
	            mImageView.setBackgroundResource(0);
	        }
	    }

	    /**
	     * ��ʱ������
	     * 
	     * 
	     */
	    class AnimTimerTask extends TimerTask {
	        @Override
	        public void run() {
	            if(mFrameIndex < 0 || mState == STATE_STOP){
	                return;
	            }

	            if( mFrameIndex < mResourceIdList.size() ){
	                Message msg = AnimHanlder.obtainMessage(MSG_START,0,0,null);
	                msg.sendToTarget();
	            }else{
	                mFrameIndex = 0;
	                if(!isLooping){
	                    Message msg = AnimHanlder.obtainMessage(MSG_STOP,0,0,null);
	                    msg.sendToTarget();
	                }
	            }
	        }
	    }

	    private Handler AnimHanlder = new Handler(){
	         public void handleMessage(android.os.Message msg) {
	                switch (msg.what) {
	                case MSG_START:{
	                	Log.i("wubingchao",  mResourceIdList.size()+"");
	                    if(mFrameIndex >=0 && mFrameIndex < mResourceIdList.size() && mState == STATE_RUNNING){
	                        mImageView.setImageResource(mResourceIdList.get(mFrameIndex));
	                        mFrameIndex++;
	                    }
	                }
	                    break;
	                case MSG_STOP:{
	                    if (mTimeTask != null) {
	                        mFrameIndex = 0;
	                        mTimer.purge();
	                        mTimeTask.cancel();
	                        mState = STATE_STOP;
	                        mTimeTask = null;
	                        mImageView.setImageResource(0);
	                    }
	                }
	                    break;
	                default:
	                    break;
	                }
	         }
	    };
}
