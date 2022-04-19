package com.example.languagelibrary;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

public class ChangeLanguage {
    public static void setLocale(Context context, String language) {
        applyLanguage(context,language);
    }

    public static void applyLanguage(Context context,String languageCode)
    {
        Configuration config = context.getResources().getConfiguration();

        if (!"".equals(languageCode) && !config.locale.getLanguage().equals(languageCode))
        {
            Locale locale = new Locale(languageCode);
            Locale.setDefault(locale);
            config.locale = locale;
            context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        }
    }

}
