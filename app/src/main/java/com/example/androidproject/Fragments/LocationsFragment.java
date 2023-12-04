package com.example.androidproject.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidproject.DataTypeItems;
import com.example.androidproject.R;
import com.example.androidproject.RecycleView.CustomRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LocationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LocationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LocationsFragment newInstance(String param1, String param2) {
        LocationsFragment fragment = new LocationsFragment();
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
        View view = inflater.inflate(R.layout.fragment_locations, container, false);

        ArrayList<DataTypeItems> dataTypeItems = new ArrayList<>();

        dataTypeItems.add(new DataTypeItems("Windsor Campus", "400 Dougall St"));
        dataTypeItems.add(new DataTypeItems("Downtown Windsor Campus", "540 Oulette"));
        dataTypeItems.add(new DataTypeItems("Chatham Campus", "183 Chatham Rd"));
        dataTypeItems.add(new DataTypeItems("Ottawa Campus", "500 Ottawa St"));
        dataTypeItems.add(new DataTypeItems("Toronto Campus", "901 Shelby Dr"));
        dataTypeItems.add(new DataTypeItems("Hamilton Campus", "940 Upper James St"));
        dataTypeItems.add(new DataTypeItems("Guelph Campus", "782 Oliver St"));
        dataTypeItems.add(new DataTypeItems("Cambridge Campus", "34 Pinebush Rd"));
        dataTypeItems.add(new DataTypeItems("London Campus", "26 York Rd"));

        RecyclerView recyclerView = view.findViewById(R.id.RecycleView);
        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(dataTypeItems);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));




        return view;
    }
}