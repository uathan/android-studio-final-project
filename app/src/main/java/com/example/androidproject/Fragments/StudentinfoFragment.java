package com.example.androidproject.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentinfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentinfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StudentinfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentinfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentinfoFragment newInstance(String param1, String param2) {
        StudentinfoFragment fragment = new StudentinfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_studentinfo, container, false);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean largeText = preferences.getBoolean("largeText", false);
        Button contact = view.findViewById(R.id.contactCollegeButton);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_contact);
            }
        });

        TextView text2 = view.findViewById(R.id.textView27);
        TextView text3 = view.findViewById(R.id.textView29);
        TextView text4 = view.findViewById(R.id.textView31);
        TextView text5 = view.findViewById(R.id.textView32);
        TextView text6 = view.findViewById(R.id.textView33);
        TextView text7 = view.findViewById(R.id.textView34);
        TextView text8 = view.findViewById(R.id.textView35);
        TextView text9 = view.findViewById(R.id.textView36);
        TextView text10 = view.findViewById(R.id.textView37);
        TextView text11 = view.findViewById(R.id.textView38);
        TextView text12 = view.findViewById(R.id.textView39);
        TextView text13 = view.findViewById(R.id.textView40);
        TextView text14 = view.findViewById(R.id.textView41);
        TextView text15 = view.findViewById(R.id.textView42);
        TextView text16 = view.findViewById(R.id.textView43);

        if (largeText) {
            text2.setTextSize(20);
            text3.setTextSize(20);
            text4.setTextSize(20);
            text5.setTextSize(20);
            text6.setTextSize(20);
            text7.setTextSize(20);
            text8.setTextSize(20);
            text9.setTextSize(20);
            text10.setTextSize(20);
            text11.setTextSize(20);
            text12.setTextSize(20);
            text13.setTextSize(20);
            text14.setTextSize(20);
            text15.setTextSize(20);
            text16.setTextSize(20);
        }




        return view;
    }
}