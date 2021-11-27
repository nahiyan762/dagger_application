package com.example.daggerapplication;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.daggerapplication.data.ApiRepository;
import com.example.daggerapplication.data.AppDatabase;
import com.example.daggerapplication.data.AppPreferences;
import com.example.daggerapplication.data.ProductDataSource;
import com.example.daggerapplication.di.component.AppComponent;

import com.example.daggerapplication.di.component.DaggerAppComponent;
import com.example.daggerapplication.di.module.ApplicationModule;
import com.example.daggerapplication.di.module.NetworkModule;

import javax.inject.Inject;


public class MyApp extends Application {

    @Inject
    ApiRepository repository;

    @Inject
    AppPreferences preferences;

    @Inject
    AppDatabase appDatabase;

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule("https://api.tvmaze.com/"))
                .build();

        appComponent.inject(this);

        Log.d("DAGGER_2", repository.toString());
        Log.d("DAGGER_2", preferences.toString());
        Log.d("DAGGER_2", appDatabase.toString());

    }

    public AppComponent getComponent(){
        return appComponent;
    }
}