package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomViewPagerAdapter  extends FragmentStateAdapter {


    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       // position = position % 5;
        switch (position){
            case 0: return FactFragment.newInstance("Find an organizational system that works for you");
            case 1: return FactFragment.newInstance("Connect with our colleges social media platforms");
            case 2: return FactFragment.newInstance("Locate our colleges tutoring center, get help when you need it most!");
            case 3: return FactFragment.newInstance("Be careful when applying through early decision programs");
            case 4: return FactFragment.newInstance("Don't limit yourself by numbers");
            default: return FactFragment.newInstance("Keep your finances in mind");
        }
    }

    @Override
    public int getItemCount() {
      //  return Integer.MAX_VALUE;
        return 5;
    }
}
