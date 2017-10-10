package com.example.awesomeapp.fragments_subjects;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.awesomeapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minetea on 2017/10/6.
 */

public class Fragment_Geography extends Fragment
	{
	
	private ListView listview1;
	
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
		
		return view;
		}
	}
