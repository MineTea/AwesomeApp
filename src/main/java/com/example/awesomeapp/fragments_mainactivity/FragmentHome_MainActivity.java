package com.example.awesomeapp.fragments_mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.awesomeapp.MainActivity;
import com.example.awesomeapp.R;
import com.example.awesomeapp.SubjectActivity;

/**
 * Created by minetea on 2017/10/4.
 */

public class FragmentHome_MainActivity extends Fragment
	{
	
	//获取各个控件
	private Button button6;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
		
		View view = inflater.inflate(R.layout.fragment_home,container,false);
		return view;
		
		}
	
	public void onActivityCreated(Bundle savedInstanceState)
		{
		
		super.onActivityCreated(savedInstanceState);
		
		//生成 intent 对象，用于 activity 之间通信
		final Intent intent = new Intent();
		intent.setClass(getActivity().getApplicationContext(),SubjectActivity.class);
		
		//获取按钮
		Button button6 = (Button)getActivity().findViewById(R.id.button6);
		//按钮点击事件
		button6.setOnClickListener(new View.OnClickListener()
			{
			@Override
			public void onClick(View view)
				{
				startActivity(intent);
				}
			});
		}
	
	}
