package com.example.vakulenko.notebook.sp;

import android.content.SharedPreferences;
import android.graphics.Color;
import com.example.vakulenko.notebook.contract.CustomContext;

public class Configuration {

    public static String getValue(ConfigurationName name) {
        return CustomContext.getSP().getString(name.name(), name.getDefaultValue());
    }

    public static void setValue(ConfigurationName name, String value) {
        SharedPreferences.Editor editor = CustomContext.getSP().edit();
        editor.putString(name.name(), value);
        editor.apply();
    }

    public enum ConfigurationName {
        TEXT_SIZE("18"),
        TEXT_COLOR("#FFFFFF");

        private String defaultValue;

        ConfigurationName(String defaultValue) {
            this.defaultValue = String.valueOf(defaultValue);
        }

        public String getDefaultValue() {
            return defaultValue;
        }
    }
}
