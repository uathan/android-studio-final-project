package com.example.androidproject.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.androidproject.Fragments.FactFragment;

public class CustomViewPagerAdapter  extends FragmentStateAdapter {


    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       // position = position % 5;
        switch (position){
            case 0: return FactFragment.newInstance("Resident Assistants are in charge of a dormitory or residence hall, serving as a resource for students, organizing events, and promoting a positive living environment");
            case 1: return FactFragment.newInstance("Library Assistant works in the college library helping students with research, shelving books, and managing the library resources");
            case 2: return FactFragment.newInstance("Tutors assist fellow students in specific subjects, providing guidance and support through tutoring sessions");
            case 3: return FactFragment.newInstance("Student Ambassadors represent the college at events, give campus tours, and assist with helping outreach activities to prospective students");
            case 4: return FactFragment.newInstance("Campus Tour Guides lead prospective students and their families on tours, sharing insights about campus light, facilities, and academic progress");
            default: return FactFragment.newInstance("Student Research Assistants collaborate with faculty on research projects, gaining hands-on experience in the research process and contributes to academic advancements within their field of study");
        }
    }

    @Override
    public int getItemCount() {
      //  return Integer.MAX_VALUE;
        return 5;
    }
}
