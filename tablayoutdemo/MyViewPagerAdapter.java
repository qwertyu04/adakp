package com.example.tablayoutdemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tablayoutdemo.fragments.HomeFragment;
import com.example.tablayoutdemo.fragments.MessageFragment;
import com.example.tablayoutdemo.fragments.SettingFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new MessageFragment();
            case 2:
                return new SettingFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
