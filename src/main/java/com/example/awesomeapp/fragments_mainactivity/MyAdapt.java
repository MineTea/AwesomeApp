package com.example.awesomeapp.fragments_mainactivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by minetea on 2017/10/4.
 */

public class MyAdapt extends FragmentStatePagerAdapter
	{
	
	private List<Fragment> mFragments;
	
	public MyAdapt(FragmentManager fm,List<Fragment> mFragments)
		{
		
		super(fm);
		this.mFragments = mFragments;
		
		}
	
	@Override
	public Fragment getItem(int position)
		{
		return mFragments.get(position);
		}
	
	public int getCount()
		{
		return mFragments.size();
		}
	
	}
