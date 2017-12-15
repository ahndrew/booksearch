package com.andrewahn.booksearch;

import com.andrewahn.booksearch.dagger.component.AppComponent;
import com.andrewahn.booksearch.dagger.component.DaggerAppComponent;
//import com.andrewahn.booksearch.dagger.component.DaggerNetworkComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by andrewahn on 12/1/17.
 */

public class BookSearchApp extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

}
