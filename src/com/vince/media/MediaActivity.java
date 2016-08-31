package com.vince.media;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MediaActivity extends Activity
{
	private Button btnSrc , btnSys , btnNet , btnLocal;

	@Override
	public void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btnSrc = (Button) findViewById(R.id.button1_src);
		btnSys = (Button) findViewById(R.id.button2_sys);
		btnNet = (Button) findViewById(R.id.button3_net);
		btnLocal = (Button) findViewById(R.id.button4_local);

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
	}

	// �ӱ���ɨ�貢����
	protected void playFromLocal()
	{
		startActivity(new Intent(this , MediaPlayerActivity.class));
	}

	// �������в���
	protected void playFromNet()
	{
		MediaPlayer mp = new MediaPlayer();
		// mp.reset()
		try
		{
			mp.setDataSource(this ,Uri.parse("http://2.2.2.44:8080/a1.mp3"));
			mp.prepareAsync();// �첽Ԥ����

			// �����첽Ԥ������ɵ��¼�
			Toast.makeText(this ,"���������쳣1������" ,Toast.LENGTH_LONG).show();
			mp.setOnPreparedListener(new OnPreparedListener()
			{
				public void onPrepared(MediaPlayer mp )
				{
					Toast.makeText(MediaActivity.this ,"���������쳣2������" ,Toast.LENGTH_LONG).show();
					mp.start();
				}
			});
		}
		catch(IOException e)
		{
			Toast.makeText(this ,"���������쳣3������" ,Toast.LENGTH_LONG).show();
		}
	}

	// ��ϵͳ�ļ��в���
	@SuppressLint("SdCardPath")
	protected void playFromSys()
	{
		// MediaPlayer mp = MediaPlayer.create(this,
		// Uri.parse("/sdcard/a1.mp3"));
		// ��������������
		MediaPlayer mp = new MediaPlayer();
		try
		{
			// ��������Դ
			String str = Environment.getExternalStorageDirectory().toString();
			System.out.println(str);//  /storage/sdcard
			System.out.println("111111111111111111111111111111111111111111111111111");
			String str1 = Environment.getExternalStorageState();
			System.out.println(str1);// mounted
			System.out.println("222222222222222222222222222222222222222222222222222");
			String str2 = Environment.getDataDirectory().toString();
			System.out.println(str2);// /data
			System.out.println("333333333333333333333333333333333333333333333333333");
			String str3 = Environment.getDownloadCacheDirectory().toString();
			System.out.println(str3);//  /cache
			System.out.println("444444444444444444444444444444444444444444444444444");
			String str4 = Environment.getRootDirectory().toString();
			System.out.println(str4);//  /system
			System.out.println("555555555555555555555555555555555555555555555555555");
			String str5 = Environment.getExternalStoragePublicDirectory(".mp3").toString();
			System.out.println(str5);// /storage/sdcard/.mp3
			System.out.println("666666666666666666666666666666666666666666666666666");
			System.out.println(getFilesDir());//  /data/data/com.vince.media/files
			System.out.println("777777777777777777777777777777777777777777777777777");
			System.out.println(getFileStreamPath(".mp3"));//  /data/data/com.vince.media/files/.mp3
			System.out.println("888888888888888888888888888888888888888888888888888");
			System.out.println(getExternalCacheDir());// /storage/sdcard/Android/data/com.vince.media/cache
			System.out.println("9999999999999999999999999999999999999999999999999999");
			System.out.println(getExternalFilesDir(".mp3"));// /storage/sdcard/Android/data/com.vince.media/files/.mp3
			System.out.println("0000000000000000000000000000000000000000000000000000");
			System.out.println(getCacheDir());//  /data/data/com.vince.media/cache
			System.out.println("111111111111111111111111111111111111111111111111111");
			System.out.println(getLastNonConfigurationInstance());//  null
			System.out.println("222222222222222222222222222222222222222222222222222");

			// mp.setDataSource(str);

			mp.setDataSource("/sdcard/a1.mp3");
			mp.prepare();// Ԥ����
			mp.start();

		}
		catch(IOException e)
		{
			Toast.makeText(this ,"�Ҳ����ļ�������" ,Toast.LENGTH_LONG).show();
		}

	}

	// ��Դ�ļ��в���
	protected void playFromSrc()
	{
		// �������������󣬲�����Ƶ�ļ�
		MediaPlayer mp = MediaPlayer.create(this ,R.raw.honor);
		mp.start();
	}

}