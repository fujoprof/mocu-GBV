package com.mocu.mocu_gbv.one_time_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.mocu.mocu_gbv.MainActivity;
import com.mocu.mocu_gbv.R;

public class OneTimeRegistratiom extends AppCompatActivity {

    //Variable declarations
    ImageView Language_Selection;
    RadioButton Radio_Button_English, Radio_Button_Kiswahili;
    Button Button_Continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_registratiom);

        //Variable references
        Language_Selection = findViewById(R.id.language_selection_img);
        Radio_Button_English = findViewById(R.id.selected_english_langiage);
        Radio_Button_Kiswahili = findViewById(R.id.selected_kiswahili_langiage);
        Button_Continue = findViewById(R.id.continue_button);

        // Define translations
        final float translationX1 = 100f;
        final float translationY1 = -100f;
        final float translationX2 = -100f;
        final float translationY2 = 100f;

        // Start the first translation animation
        Language_Selection.animate().translationXBy(translationX1)
                .translationYBy(translationY1)
                .setDuration(2000)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        Language_Selection.animate().translationXBy(translationX2)
                                .translationYBy(translationY2)
                                .setDuration(2000);
                    }
                });

        //Restrict radio button selection
        Radio_Button_English.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Radio_Button_Kiswahili.setChecked(false);
                }
            }
        });

        Radio_Button_Kiswahili.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Radio_Button_English.setChecked(false);
                }
            }
        });

        //creating action for continue button
        Button_Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OneTimeRegistratiom.this, TermsAndConditionsActivity.class));
            }
        });

    }
}