package com.example.androidproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FactFragment extends Fragment {
    //FactFragment.newInstance("Comment often as possible")
    //Font.font();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1"; //FOOD_IMAGE, FOOD_DESC

    // TODO: Rename and change types of parameters
    private String mParam1; //"Comment often as possible"

    public FactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FactFragment newInstance(String param1) {
        FactFragment fragment = new FactFragment();
        Bundle args = new Bundle();//["param1"] = "Comment often as possible"
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) { //["param1"]
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fact, container, false);
        TextView  fact = view.findViewById(R.id.fact);
        if(mParam1 != null){ //"comment often as possible"
            fact.setText(mParam1);
        }
        return view;
    }
}