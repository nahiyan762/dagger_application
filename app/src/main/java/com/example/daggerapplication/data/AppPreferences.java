package com.example.daggerapplication.data;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferences {

    private final SharedPreferences preferences;

    @Inject
    public AppPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public String getData() {
        return this.toString();
    }
}
