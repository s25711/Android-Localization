package com.developer.localization_android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class CommonClas {
    public static Resources getLocaleStringResource(Locale requestedLocale, Context context) {
        Resources resources = context.getResources();
        Configuration conf = resources.getConfiguration();
        Locale savedLocale = conf.locale;
        conf.locale = requestedLocale;
        resources.updateConfiguration(conf, null);

        return resources;
    }

}
