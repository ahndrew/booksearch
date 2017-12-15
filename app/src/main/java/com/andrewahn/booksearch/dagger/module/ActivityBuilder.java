package com.andrewahn.booksearch.dagger.module;

import com.andrewahn.booksearch.ui.MainActivity;
import com.andrewahn.booksearch.ui.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by andrewahn on 12/13/17.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}
