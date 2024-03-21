package com.mocu.mocu_gbv.one_time_registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.mocu.mocu_gbv.R;

public class TermsAndConditionsActivity extends AppCompatActivity {

    ViewPager one_time_registation_steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        one_time_registation_steps = findViewById(R.id.one_time_registration_steps);

        OneTimeRegistrationAdapter oneTimeRegistrationAdapter = new OneTimeRegistrationAdapter(getSupportFragmentManager());

        one_time_registation_steps.setAdapter(oneTimeRegistrationAdapter);
    }
}