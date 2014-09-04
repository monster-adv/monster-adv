package com.example.digitalsignage;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class AdvPlayer extends Activity{
	private VideoView videoView;
	private String path;
	private Intent intent, before_intent;
	private Flag flag;
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        
        videoView = (VideoView) findViewById(R.id.videoView1);
        flag = (Flag)getApplicationContext();
        flag.setFlag(false);
        intent = getIntent();
        path = intent.getExtras().getString("PATH");
        
        
        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);
        Uri uri = Uri.parse(path);
		videoView.setVideoURI(uri);
		videoView.requestFocus();
		
		videoView.start();
        videoView.setOnCompletionListener(new OnCompletionListener() {
        	public void onCompletion(MediaPlayer player){
        		flag.setFlag(true);
        		finish();
        	}
        });
	}
}
