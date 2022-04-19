package com.example.assignmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.languagelibrary.ChangeLanguage;
import com.example.themechanger.ThemeChanger;

public class SettingActivity extends AppCompatActivity {

    Spinner spn_language;
    Switch sw_dark;
    MyPreference preference;
    String[] test=new String[]{"Select Language","English","Hindi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        preference = MyPreference.getInstance(SettingActivity.this);
        spn_language = findViewById(R.id.spn_language);
        sw_dark = findViewById(R.id.sw_dark);
        if (preference.getDarkMode()){
            sw_dark.setChecked(true);
        }else {
            sw_dark.setChecked(false);
        }
        sw_dark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    preference.setDarkMode(true);
                    startActivity(new Intent(SettingActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }else{
                    preference.setDarkMode(false);
                    startActivity(new Intent(SettingActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }
            }
        });
        ArrayAdapter<String> language= new ArrayAdapter<String>(SettingActivity.this,android.R.layout.simple_spinner_item, test);
        language.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_language.setAdapter(language);
        spn_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i!=0) {
                    if (i == 1) {
                        ChangeLanguage.setLocale(SettingActivity.this, "en");
                        preference.setLanguage("en");
                        startActivity(new Intent(SettingActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    } else if (i == 2) {
                        ChangeLanguage.setLocale(SettingActivity.this, "hi");
                        preference.setLanguage("hi");
                        startActivity(new Intent(SettingActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}