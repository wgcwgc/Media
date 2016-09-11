package com.vince.media;

import java.io.IOException;
import java.util.Random;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Recorder extends Activity
{

	private MediaRecorder myAutoRecorder;
	private String outputFile = null;
	private Button start , stop , play;

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recorder);

		start = (Button) findViewById(R.id.button1);
		stop = (Button) findViewById(R.id.button2);
		play = (Button) findViewById(R.id.button3);

		stop.setEnabled(false);
		play.setEnabled(false);
		String name = new Random(57).toString().substring(17);
		outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myRecording_" + name + ".wav";

		System.out.println(outputFile.toString());

		myAutoRecorder = new MediaRecorder();
		// myAutoRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		// myAutoRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		// myAutoRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);

		// 从麦克风源进行录音
		myAutoRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
		// 设置输出格式
		myAutoRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
		// 设置编码格式
		myAutoRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

		myAutoRecorder.setOutputFile(outputFile);

	}

	public void stop(View view )
	{
		myAutoRecorder.stop();
		// Toast.makeText(this ,"测试1" ,Toast.LENGTH_LONG).show();
		myAutoRecorder.release();
		// Toast.makeText(this ,"测试2" ,Toast.LENGTH_LONG).show();
		myAutoRecorder = null;
		// Toast.makeText(this ,"测试3" ,Toast.LENGTH_LONG).show();
		stop.setEnabled(false);
		play.setEnabled(true);
		Toast.makeText(getApplicationContext() ,"Audio recorded successfully" ,Toast.LENGTH_LONG).show();
		// Toast.makeText(this ,"测试4" ,Toast.LENGTH_LONG).show();
	}

	public void start(View view )
	{
		try
		{
			myAutoRecorder.prepare();
			myAutoRecorder.start();
		}
		catch(Exception e)
		{
			Toast.makeText(this ,"亲：我是bug" ,Toast.LENGTH_LONG).show();
		}
		start.setEnabled(false);
		stop.setEnabled(true);
		Toast.makeText(getApplicationContext() ,"Recording started" ,Toast.LENGTH_LONG).show();
	}

	public void play(View view ) throws IllegalArgumentException , SecurityException , IllegalStateException , IOException
	{
		MediaPlayer m = new MediaPlayer();
		m.setDataSource(outputFile);
		m.prepare();
		m.start();
		Toast.makeText(getApplicationContext() ,"Playing audio" ,Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu )
	{
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item )
	{

		return super.onOptionsItemSelected(item);
	}

}
