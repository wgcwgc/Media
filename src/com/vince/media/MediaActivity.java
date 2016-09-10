package com.vince.media;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MediaActivity extends Activity
{
	private Button btnSrc , btnSys , btnNet , btnLocal , btnRecorder;

	@Override
	public void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btnSrc = (Button) findViewById(R.id.button1_src);
		btnSys = (Button) findViewById(R.id.button2_sys);
		btnNet = (Button) findViewById(R.id.button3_net);
		btnLocal = (Button) findViewById(R.id.button4_local);
		btnRecorder = (Button) findViewById(R.id.button5_Recorder);

		btnRecorder.setOnClickListener(new OnClickListener()
		{

			public void onClick(View v )
			{
				getAudioRecorder();
			}

		});

		btnSrc.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v )
			{
				playFromSrc();
			}
		});

		btnSys.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v )
			{
				playFromSys();
			}
		});

		btnNet.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v )
			{
				playFromNet();
			}
		});

		btnLocal.setOnClickListener(new OnClickListener()
		{

			public void onClick(View v )
			{
				playFromLocal();
			}

		});

//		String str = Environment.getExternalStorageDirectory().toString();
//		System.out.println(str);// /storage/sdcard

	}

	protected void getAudioRecorder()
	{
		startActivity(new Intent(this , Recorder.class));
	}

	// 从本地扫描并播放
	protected void playFromLocal()
	{
		startActivity(new Intent(this , MediaPlayerActivity.class));
	}

	// 从网络中播放
	protected void playFromNet()
	{
		MediaPlayer mp = new MediaPlayer();
		String uriString = "http://bd.kuwo.cn/yinyue/599182?from=baidu";
		// String urlString =
		// "http://zhangmenshiting2.baidu.com/data2/music/9138619/9138619.mp3?xcode=dd0d0d0df7218eb9a79c7fd72cefb648&mid=0.18926789458694";
		// mp.reset();
		// try
		// {
		// mp.setDataSource(this ,Uri.parse(urlString));
		// mp.prepareAsync();// 异步预处理
		//
		// // 监听异步预处理完成的事件
		// Toast.makeText(this ,"网络连接异常1。。。" ,Toast.LENGTH_LONG).show();
		// mp.setOnPreparedListener(new OnPreparedListener()
		// {
		// public void onPrepared(MediaPlayer mp )
		// {
		// Toast.makeText(MediaActivity.this ,"网络连接异常2。。。"
		// ,Toast.LENGTH_LONG).show();
		// mp.start();
		// }
		// });
		// }
		// catch(IOException e)
		// {
		// Toast.makeText(this ,"网络连接异常3。。。" ,Toast.LENGTH_LONG).show();
		// }

		try
		{
			// mediaPlayer = new MediaPlayer();
			// 通过Uri解析一个网络地址

			Uri uri = Uri.parse(uriString);
			mp.setDataSource(this ,Uri.parse(uriString));
			// mp.prepareAsync();// 异步预处理
			// mp.prepare();
			// 也可以直接通过这种方式装载网络上的音频文件
			mp = MediaPlayer.create(this ,uri);
			mp.start();
		}
		catch(Exception e)
		{
			Toast.makeText(this ,"网络连接异常3。。。" ,Toast.LENGTH_LONG).show();
		}

	}

	// 从系统文件中播放
	@SuppressLint("SdCardPath")
	protected void playFromSys()
	{
		// MediaPlayer mp = MediaPlayer.create(this,
		// Uri.parse("/sdcard/a1.mp3"));
		// 创建播放器对象
		MediaPlayer mp = new MediaPlayer();
		try
		{
			// 设置数据源
			// String str =
			// Environment.getExternalStorageDirectory().toString();
			// System.out.println(str);// /storage/sdcard
			// System.out.println("111111111111111111111111111111111111111111111111111");
			// String str1 = Environment.getExternalStorageState();
			// System.out.println(str1);// mounted
			// System.out.println("222222222222222222222222222222222222222222222222222");
			// String str2 = Environment.getDataDirectory().toString();
			// System.out.println(str2);// /data
			// System.out.println("333333333333333333333333333333333333333333333333333");
			// String str3 = Environment.getDownloadCacheDirectory().toString();
			// System.out.println(str3);// /cache
			// System.out.println("444444444444444444444444444444444444444444444444444");
			// Log.d("LOG" ,"ceshi");
			// String str4 = Environment.getRootDirectory().toString();
			// System.out.println(str4);// /system
			// System.out.println("555555555555555555555555555555555555555555555555555");
			// String str5 =
			// Environment.getExternalStoragePublicDirectory(".mp3").toString();
			// System.out.println(str5);// /storage/sdcard/.mp3
			// System.out.println("666666666666666666666666666666666666666666666666666");
			// System.out.println(getFilesDir());//
			// /data/data/com.vince.media/files
			// System.out.println("777777777777777777777777777777777777777777777777777");
			// System.out.println(getFileStreamPath(".mp3"));//
			// /data/data/com.vince.media/files/.mp3
			// System.out.println("888888888888888888888888888888888888888888888888888");
			// System.out.println(getExternalCacheDir());//
			// /storage/sdcard/Android/data/com.vince.media/cache
			// System.out.println("9999999999999999999999999999999999999999999999999999");
			// System.out.println(getExternalFilesDir(".mp3"));//
			// /storage/sdcard/Android/data/com.vince.media/files/.mp3
			// System.out.println("0000000000000000000000000000000000000000000000000000");
			// System.out.println(getCacheDir());//
			// /data/data/com.vince.media/cache
			// System.out.println("111111111111111111111111111111111111111111111111111");
			// System.out.println(getLastNonConfigurationInstance());// null
			// System.out.println("222222222222222222222222222222222222222222222222222");

			// mp.setDataSource(str);

			mp.setDataSource("/sdcard/a1.mp3");
			mp.prepare();// 预处理
			mp.start();

		}
		catch(IOException e)
		{
			Toast.makeText(this ,"找不到文件。。。" ,Toast.LENGTH_LONG).show();
		}

	}

	// 从源文件中播放
	protected void playFromSrc()
	{
		// 创建播放器对象，并绑定音频文件
		MediaPlayer mp = MediaPlayer.create(this ,R.raw.honor);
		mp.start();
	}

}
