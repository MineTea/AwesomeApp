package com.example.awesomeapp.fragments_subjects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.awesomeapp.R;
import com.example.awesomeapp.VideoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minetea on 2017/10/6.
 */

public class Fragment_History extends Fragment
	{
	
	private ListView listview1;
	private Bundle bundle;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
		
		View view = inflater.inflate(R.layout.fragment_subjects,container,false);
		
		//获取 listview
		this.listview1 = (ListView) view.findViewById(R.id.listview1);
		//声明信息对象的队列,添加消息对象
		List<String> stringList = new ArrayList<String>();
		stringList.add("video1");
		stringList.add("video2");
		//声明适配器，绑定到listview
		ArrayAdapter<String> adapterSubject = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,stringList);
		listview1.setAdapter(adapterSubject);
		
		//生成 intent 对象，用于和 VideoActivity 中间通信
		final Intent intent = new Intent(getActivity(), VideoActivity.class);
		//定义 list 点击事件，进入 VideoActivity
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener()
			{
			@Override
			public void onItemClick(AdapterView<?> av, View view, int position, long p4)
				{
				switch(position)
					{
					case 0:
						//设置要加入到 intent 的bundle 用于传输视频 url
						bundle = new Bundle();
						bundle.putString("url","http://flashmedia.eastday.com/newdate/news/2016-11/shznews1125-19.mp4");
						intent.putExtras(bundle);
						startActivity(intent);
						break;
					case 1:
						//设置要加入到 intent 的bundle 用于传输视频 url
						bundle = new Bundle();
						bundle.putString("url","rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov");
						intent.putExtras(bundle);
						startActivity(intent);
						break;
					}
				}
			});
		
		return view;
		}
	}
