package com.example.daggerapplication.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import com.example.daggerapplication.data.AppDatabase;
import com.example.daggerapplication.data.AppPreferences;
import com.example.daggerapplication.data.Product;
import com.example.daggerapplication.data.ProductDao;
import com.example.daggerapplication.data.ProductDataSource;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    AppPreferences provideAppPreferences(SharedPreferences preferences) {
        return new AppPreferences(preferences);
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "demo-dagger.db").fallbackToDestructiveMigration().build();
    }

//    @Provides
//    @Singleton
//    ProductDao providesProductDao(AppDatabase appDatabase) {
//        return appDatabase.getProductDao();
//    }
//
//    @Provides
//    @Singleton
//    ProductDataSource providesUserInfoDataSource(ProductDao productDao) {
//        return new ProductDataSource(productDao);
//    }


}
