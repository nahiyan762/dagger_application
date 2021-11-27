package com.example.daggerapplication.di.component;

import android.app.Activity;

import com.example.daggerapplication.di.PerActivity;
import com.example.daggerapplication.di.module.ActivityModule;
import com.example.daggerapplication.ui.MainActivity;
import com.example.daggerapplication.ui.MainActivity2;


import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(MainActivity2 mainActivity);
}
