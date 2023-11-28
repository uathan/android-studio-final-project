package com.example.androidproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TuitionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TuitionFragment extends Fragment {

    public int bool = 0; // 0 == monthly 1 == yearly

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TuitionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TuitionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TuitionFragment newInstance(String param1, String param2) {
        TuitionFragment fragment = new TuitionFragment();
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
        View view = inflater.inflate(R.layout.fragment_tuition, container, false);
        RadioButton partTime = view.findViewById(R.id.partTimeButton);
        RadioButton fullTime = view.findViewById(R.id.fullTimeButton);
        Button caluclate = view.findViewById(R.id.calculateButton);
        Button reset = view.findViewById(R.id.reset);

        EditText tuitionInput = view.findViewById(R.id.tuitionTextInput);
        EditText registrationInput = view.findViewById(R.id.registrationTextInput);
        EditText otherInput = view.findViewById(R.id.otherfeesTextInput);
        EditText textbookInput = view.findViewById(R.id.textbookTextInput);
        EditText suppliesInput = view.findViewById(R.id.suppliesTextInput);
        EditText housingInput = view.findViewById(R.id.housingTextInput);
        EditText mealsInput = view.findViewById(R.id.mealsTextInput);
        EditText transportationInput = view.findViewById(R.id.transportationTextInput);


        LinearLayout parttimeLayout = view.findViewById(R.id.PartTime);
        LinearLayout resultlayout = view.findViewById(R.id.resultLayout);


        TextView resultText = view.findViewById(R.id.resulttext);
        TextView resultnum = view.findViewById(R.id.result);



        partTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bool = 1;
//                fulltimeLayout.setVisibility(View.GONE);
//                parttimeLayout.setVisibility(View.VISIBLE);
            }
        });

        fullTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bool = 0;
//                parttimeLayout.setVisibility(View.GONE);
//                fulltimeLayout.setVisibility(View.VISIBLE);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tuitionInput.setText("");
                registrationInput.setText("");
                otherInput.setText("");
                textbookInput.setText("");
                suppliesInput.setText("");
                housingInput.setText("");
                housingInput.setText("");
                mealsInput.setText("");
                transportationInput.setText("");
                resultlayout.setVisibility(View.INVISIBLE);

            }
        });

        caluclate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int tuition = Integer.parseInt(tuitionInput.getText().toString());
                    int registration = Integer.parseInt(registrationInput.getText().toString());
                    int other = Integer.parseInt(otherInput.getText().toString());
                    int textbook = Integer.parseInt(textbookInput.getText().toString());
                    int supplies = Integer.parseInt(suppliesInput.getText().toString());
                    int housing = Integer.parseInt(housingInput.getText().toString());
                    int meals = Integer.parseInt(mealsInput.getText().toString());
                    int transportation = Integer.parseInt(transportationInput.getText().toString());
                    if (bool == 1) { // if yearly is clicked
                        int total = tuition + registration + other + textbook + supplies + housing + meals + transportation;
                        int monthly = total / 12;
                        resultText.setText("Your monthly payment will be: ");
                        resultnum.setText("$" + String.valueOf(monthly));
                        resultlayout.setVisibility(View.VISIBLE);
                    } else { // if monthly is clicked
                        int total = tuition + registration + other + textbook + supplies + housing + meals + transportation;
                        resultText.setText("Your yearly payment will be: ");
                        resultnum.setText("$" + String.valueOf(total));
                        resultlayout.setVisibility(View.VISIBLE);
                    }
                }
        });



        return view;
    }
}