package com.example.androidproject.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

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

    public int bool = 3; // 0 == monthly 1 == yearly

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

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean largeText = preferences.getBoolean("largeText", false);

        RadioButton partTime = view.findViewById(R.id.partTimeButton);
        RadioButton fullTime = view.findViewById(R.id.fullTimeButton);
        Button caluclate = view.findViewById(R.id.calculateButton);
        Button reset = view.findViewById(R.id.reset);

        TextView tuitionText = view.findViewById(R.id.tuitionTextView);
        TextView registrationText = view.findViewById(R.id.registrationTextView);
        TextView textbookText = view.findViewById(R.id.textbookcostTextView);
        TextView suppliesText = view.findViewById(R.id.suppliescostTextView);
        TextView housingText = view.findViewById(R.id.housingTextView);
        TextView mealsText = view.findViewById(R.id.mealsTextView);
        TextView transportationText = view.findViewById(R.id.transportationTextView);
        TextView miscText = view.findViewById(R.id.miscTextView);
        TextView schoolfees = view.findViewById(R.id.schoolfeesTextView);
        TextView textbooksuppliesfees = view.findViewById(R.id.TextbooksSuppliesTextView);
        TextView livingExpenses = view.findViewById(R.id.LivingExpensesTextView);
        TextView misc2 = view.findViewById(R.id.miscTextView2);
        TextView title = view.findViewById(R.id.billingCycleTitle);

        EditText tuitionInput = view.findViewById(R.id.tuitionTextInput);
        EditText registrationInput = view.findViewById(R.id.registrationTextInput);
        EditText textbookInput = view.findViewById(R.id.textbookTextInput);
        EditText suppliesInput = view.findViewById(R.id.suppliesTextInput);
        EditText housingInput = view.findViewById(R.id.housingTextInput);
        EditText mealsInput = view.findViewById(R.id.mealsTextInput);
        EditText transportationInput = view.findViewById(R.id.transportationTextInput);
        EditText miscInput = view.findViewById(R.id.miscTextInput);

        RadioButton check1 = view.findViewById(R.id.partTimeButton);
        RadioButton check2 = view.findViewById(R.id.fullTimeButton);


        LinearLayout parttimeLayout = view.findViewById(R.id.PartTime);
        LinearLayout resultlayout = view.findViewById(R.id.resultLayout);


        TextView resultText = view.findViewById(R.id.resulttext);
        TextView resultnum = view.findViewById(R.id.result);





        if (largeText) {
            check1.setTextSize(20);
            check2.setTextSize(20);
            title.setTextSize(20);
            schoolfees.setTextSize(20);
            textbooksuppliesfees.setTextSize(20);
            livingExpenses.setTextSize(20);
            misc2.setTextSize(20);
            tuitionText.setTextSize(20);
            tuitionInput.setTextSize(20);
            registrationText.setTextSize(20);
            registrationInput.setTextSize(20);
            textbookText.setTextSize(20);
            textbookInput.setTextSize(20);
            suppliesText.setTextSize(20);
            suppliesInput.setTextSize(20);
            housingText.setTextSize(20);
            housingInput.setTextSize(20);
            mealsText.setTextSize(20);
            mealsInput.setTextSize(20);
            transportationText.setTextSize(20);
            transportationInput.setTextSize(20);
            miscText.setTextSize(20);
            miscInput.setTextSize(20);
            caluclate.setTextSize(20);
            reset.setTextSize(20);
            resultText.setTextSize(20);
            resultnum.setTextSize(20);

        }

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
                tuitionInput.setText("0");
                registrationInput.setText("0");
                textbookInput.setText("0");
                suppliesInput.setText("0");
                housingInput.setText("0");
                housingInput.setText("0");
                mealsInput.setText("0");
                transportationInput.setText("0");
                miscInput.setText("0");
                resultText.setText("");
                resultnum.setText("");
                resultlayout.setVisibility(View.INVISIBLE);

            }
        });

        caluclate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int tuition = Integer.parseInt(tuitionInput.getText().toString());
                    int registration = Integer.parseInt(registrationInput.getText().toString());
                    int textbook = Integer.parseInt(textbookInput.getText().toString());
                    int supplies = Integer.parseInt(suppliesInput.getText().toString());
                    int housing = Integer.parseInt(housingInput.getText().toString());
                    int meals = Integer.parseInt(mealsInput.getText().toString());
                    int transportation = Integer.parseInt(transportationInput.getText().toString());
                    int misc = Integer.parseInt(miscInput.getText().toString());

                    System.out.println("Calculate clicked");

                    if (bool == 1) { // if yearly is clicked
                        int total = tuition + registration + textbook + supplies + housing + meals + transportation + misc;
                        int monthly = total / 12;
                        resultText.setText("Your monthly payment will be: ");
                        resultnum.setText("$" + String.valueOf(monthly));
                        resultlayout.setVisibility(View.VISIBLE);
                    } else if (bool == 0) { // if monthly is clicked
                        int total = tuition + registration + textbook + supplies + housing + meals + transportation + misc;
                        resultText.setText("Your yearly payment will be: ");
                        resultnum.setText("$" + String.valueOf(total));
                        resultlayout.setVisibility(View.VISIBLE);
                    } else {
                        resultText.setText("Please select a billing cycle");
                        resultnum.setText("");
                        resultlayout.setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    resultText.setText("Please enter values into all fields.\nIf you don't apply, leave as 0.");
                    resultnum.setText("");
                    resultlayout.setVisibility(View.VISIBLE);
                }


            }
        });



        return view;
    }
}