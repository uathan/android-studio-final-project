package com.example.androidproject.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import com.example.androidproject.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final int PERMISSION_SEND_SMS = 1;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
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
        View view =inflater.inflate(R.layout.fragment_contact, container, false);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean largeText = preferences.getBoolean("largeText", false);
        TextView emailText = view.findViewById(R.id.emailText);
        TextView phoneText = view.findViewById(R.id.phoneText);
        TextView webText = view.findViewById(R.id.webText);
        TextView locationText = view.findViewById(R.id.locationText);


        if (largeText) {
            emailText.setTextSize(20);
            phoneText.setTextSize(20);
            webText.setTextSize(20);
            locationText.setTextSize(20);
        }



        String[] emails = {"nathanjamrog@customCollege.ca"};
        String name = "Nathan Jamrog";
        String phone = "226 340 2839";
        Button emailButton = view.findViewById(R.id.contactCollege);
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
        Button webButton = view.findViewById(R.id.visitWebsite);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nathanscollege.com/"));
                startActivity(i);
            }
        });
        Button callButton = view.findViewById(R.id.phoneButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9999999999"));
                if(i.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(i);
                }
                else{
                    Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                            "No Installed Software To Complete Task", Snackbar.LENGTH_LONG);
                    snackbar.show();
                   // Toast.makeText(getActivity(), "No Installed Software", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button locationButton = view.findViewById(R.id.locationButton);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.locationsFragment);
            }
        });

        return view;
    }
}