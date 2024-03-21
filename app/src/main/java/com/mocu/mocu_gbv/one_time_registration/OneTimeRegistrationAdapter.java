package com.mocu.mocu_gbv.one_time_registration;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class OneTimeRegistrationAdapter extends FragmentPagerAdapter {

    private static final int STEPS = 3;

    public OneTimeRegistrationAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new TermsandConditionsFragment();
            case 1:
                return  new SafeandSecureFragment();
            case 2:
                return new LetsGetStartedFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return STEPS;
    }
}
