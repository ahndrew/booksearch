package com.andrewahn.booksearch.dagger.component;

import android.app.Application;

import com.andrewahn.booksearch.BookSearchApp;
import com.andrewahn.booksearch.dagger.module.ActivityBuilder;
import com.andrewahn.booksearch.dagger.module.AppModule;
import com.andrewahn.booksearch.dagger.module.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by andrewahn on 12/13/17.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(BookSearchApp app);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}

