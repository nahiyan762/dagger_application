package com.example.daggerapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.daggerapplication.MyApp;
import com.example.daggerapplication.R;
import com.example.daggerapplication.data.ApiRepository;
import com.example.daggerapplication.di.component.ActivityComponent;
import com.example.daggerapplication.di.component.DaggerActivityComponent;
import com.example.daggerapplication.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity2 extends AppCompatActivity {

    @Inject
    ApiRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActivityComponent activityComponent = DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((MyApp) getApplication()).getComponent())
                .build();

        activityComponent.inject(this);

        Log.d("DAGGER_2", "MainActivity2"+ repository.toString());
    }
}