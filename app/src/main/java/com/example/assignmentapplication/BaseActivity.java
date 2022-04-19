package com.example.assignmentapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.languagelibrary.ChangeLanguage;
import com.example.themechanger.ThemeChanger;

public class BaseActivity extends AppCompatActivity {
    public Context context;
    public MyPreference preference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        context = BaseActivity.this;
        preference = MyPreference.getInstance(context);
        changeLanguage();
        checkDarkMode();
    }
    private void checkDarkMode() {
        if (preference.getDarkMode()){
            preference.setDarkMode(true);
            ThemeChanger.setTheme(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            preference.setDarkMode(false);
            ThemeChanger.setTheme(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void changeLanguage() {
      ChangeLanguage.setLocale(BaseActivity.this, preference.getLanguage());
    }
}
