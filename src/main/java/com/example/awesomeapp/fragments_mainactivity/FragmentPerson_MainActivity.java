package com.example.awesomeapp.fragments_mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.awesomeapp.LoginActivity;
import com.example.awesomeapp.R;
import com.example.awesomeapp.SubjectActivity;

/**
 * Created by minetea on 2017/10/4.
 */

public class FragmentPerson_MainActivity extends Fragment
	{
	private ImageView imageView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
		View view = inflater.inflate(R.layout.fragment_person,container,false);
		return view;
		
		
		}
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
		{
		super.onActivityCreated(savedInstanceState);
		
		//获取imageview控件
		this.imageView = (ImageView)getActivity().findViewById(R.id.imageView);
		//定义imageview的点击事件
		imageView.setOnClickListener(new View.OnClickListener()
			{
			@Override
			public void onClick(View view)
				{
				final Intent intent = new Intent();
				intent.setClass(getActivity().getApplicationContext(),LoginActivity.class);
				startActivity(intent);
				}
			});
		}
		
		
	}
