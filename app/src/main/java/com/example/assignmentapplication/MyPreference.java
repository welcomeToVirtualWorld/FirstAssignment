package com.example.assignmentapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPreference
{
    private static MyPreference instance;
    private static SharedPreferences pref;

    public MyPreference(Context context)
    {
        if (context != null)
        {
            pref = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public static MyPreference getInstance(Context context)
    {
        if (instance == null || pref == null)
        {
            instance = new MyPreference(context);
        }
        return instance;
    }


    public String getLanguage()
    {
        return pref.getString("appLanguage", "en");
    }

    public void setLanguage(String b)
    {
        pref.edit().putString("appLanguage", b).apply();
    }
    public boolean getDarkMode(){
        return pref.getBoolean("dark",false);
    }
    public void setDarkMode(boolean b){
        pref.edit().putBoolean("dark",b).apply();
    }
}
