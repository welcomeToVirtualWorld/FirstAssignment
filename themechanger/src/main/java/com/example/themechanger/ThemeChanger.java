package com.example.themechanger;

import android.content.Context;
import android.content.res.Resources;

import androidx.appcompat.app.AppCompatDelegate;

public class ThemeChanger {
    public static void setTheme(int theme)
    {
        AppCompatDelegate.setDefaultNightMode(theme);
    }

}
