package com.example.androidproject.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import com.example.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JavaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean largeText = preferences.getBoolean("largeText", false);
        TextView mainDescription = view.findViewById(R.id.mainDesc);
        TextView coursesText = view.findViewById(R.id.coursesText);
        TextView counsellingText = view.findViewById(R.id.counsellingText);
        TextView currentStudentsText = view.findViewById(R.id.currentStudentsText);
        TextView futureStudentsText = view.findViewById(R.id.futureStudentsText);

        if (largeText) {
            coursesText.setTextSize(20);
            mainDescription.setTextSize(20);
            counsellingText.setTextSize(20);
            currentStudentsText.setTextSize(20);
            futureStudentsText.setTextSize(20);
        }

//        ImageView courses = view.findViewById(R.id.coursesPicture);
//        ImageView counselling = view.findViewById(R.id.counsellingPicture);
//        ImageView future = view.findViewById(R.id.futureStudentsPicture);
//        ImageView current = view.findViewById(R.id.currentStudentsPicture);
//        ImageView alumni = view.findViewById(R.id.alumniPicture);


        ImageButton dataTypeButton = view.findViewById(R.id.dataType);
        dataTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view)
                        .navigate(R.id.coursesFragment);
            }
        });
        ImageButton counselling = view.findViewById(R.id.counselling);
        counselling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.counsellingFragment);
            }
        });
        ImageButton studentInfo = view.findViewById(R.id.futureStudents);
        studentInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.studentinfoFragment);
            }
        });
        ImageButton currentStudents = view.findViewById(R.id.currentStudents);
        currentStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.studenthubFragment);
            }
        });
        Button alumni = view.findViewById(R.id.alumni);
        alumni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.alumniFragment);
            }
        });

        return view;
    }
}