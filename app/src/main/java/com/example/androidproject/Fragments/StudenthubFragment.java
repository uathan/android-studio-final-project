package com.example.androidproject.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudenthubFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudenthubFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StudenthubFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudenthubFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudenthubFragment newInstance(String param1, String param2) {
        StudenthubFragment fragment = new StudenthubFragment();
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
        View view = inflater.inflate(R.layout.fragment_studenthub, container, false);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean largeText = preferences.getBoolean("largeText", false);

        String[] emails = {"nathanjamrog@customCollege.ca"};
        String name = "Nathan Jamrog";
        String phone = "226 340 2839";
        Button emailButton = view.findViewById(R.id.emailCollegeAgain);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                i.putExtra(Intent.EXTRA_SUBJECT, "I have a question about applying for a course");
                startActivity(i);
            }
        });

        TextView title = view.findViewById(R.id.studentHubTitle);
        TextView title2 = view.findViewById(R.id.studentHubDescription);
        TextView title3 = view.findViewById(R.id.textView45);

        Button card = view.findViewById(R.id.studentCardButton);
        Button books = view.findViewById(R.id.bookstoreButton);
        Button elective = view.findViewById(R.id.chooseElective);
        Button operationHours = view.findViewById(R.id.hoursOfOperation);
        Button campusMap = view.findViewById(R.id.campusFloorMaps);
        Button parkingPass = view.findViewById(R.id.parkingPass);
        Button contactIT = view.findViewById(R.id.contactIT);
        Button widthdrawRequest = view.findViewById(R.id.requestToWidthdraw);
        Button policies = view.findViewById(R.id.policies);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/studentcard"));
                startActivity(i);
            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/library/books/order"));
                startActivity(i);
            }
        });
        elective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/classes/electives"));
                startActivity(i);
            }
        });
        operationHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/hours"));
                startActivity(i);
            }
        });
        campusMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/campuses/maps"));
                startActivity(i);
            }
        });
        parkingPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/parking"));
                startActivity(i);
            }
        });
        contactIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/it/contact"));
                startActivity(i);
            }
        });
        widthdrawRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/forms/request-withdraw"));
                startActivity(i);
            }
        });
        policies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/forms/programs/policies"));
                startActivity(i);
            }
        });


        if (largeText) {
            title.setTextSize(30);
            title2.setTextSize(20);
            title3.setTextSize(20);
            card.setTextSize(20);
            books.setTextSize(20);
            elective.setTextSize(20);
            operationHours.setTextSize(20);
            campusMap.setTextSize(20);
            parkingPass.setTextSize(20);
            contactIT.setTextSize(20);
            widthdrawRequest.setTextSize(20);
            policies.setTextSize(20);
            emailButton.setTextSize(20);
        }


        return view;
    }
}