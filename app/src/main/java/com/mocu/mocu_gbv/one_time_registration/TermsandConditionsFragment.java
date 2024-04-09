package com.mocu.mocu_gbv.one_time_registration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.mocu.mocu_gbv.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TermsandConditionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TermsandConditionsFragment extends Fragment {

    private RadioButton terms_condition_step1,terms_condition_step2,terms_condition_step3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TermsandConditionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TermsandConditionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TermsandConditionsFragment newInstance(String param1, String param2) {
        TermsandConditionsFragment fragment = new TermsandConditionsFragment();
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
        return inflater.inflate(R.layout.fragment_terms_and_conditions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        terms_condition_step1 = view.findViewById(R.id.terms_conditions_step1);
        terms_condition_step2 = view.findViewById(R.id.terms_conditions_step2);
        terms_condition_step3 = view.findViewById(R.id.terms_conditions_step3);

        terms_condition_step1.setChecked(true);

        terms_condition_step2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                terms_condition_step2.setChecked(false);
            }
        });

        terms_condition_step3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                terms_condition_step3.setChecked(false);
            }
        });
        
    }
}