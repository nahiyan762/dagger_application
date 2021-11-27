package com.example.daggerapplication.di.component;

import android.content.SharedPreferences;

import com.example.daggerapplication.MyApp;
import com.example.daggerapplication.data.ApiRepository;
import com.example.daggerapplication.data.ProductDataSource;
import com.example.daggerapplication.di.module.ApplicationModule;
import com.example.daggerapplication.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ApplicationModule.class})
public interface AppComponent {

    void inject(MyApp myApp);

    ApiRepository getApiRepository();
}
