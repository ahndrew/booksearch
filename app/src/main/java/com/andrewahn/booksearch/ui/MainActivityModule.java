package com.andrewahn.booksearch.ui;

import android.app.Application;

import com.andrewahn.booksearch.models.books.BooksDataRepository;
import com.andrewahn.booksearch.ui.viewmodels.BookSearchViewModelFactory;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by andrewahn on 12/13/17.
 */
@Module
public abstract class MainActivityModule {

    @Provides
    static BookSearchViewModelFactory
    provideBookSearchViewModelFactory(Application app, BooksDataRepository booksDataRepository) {
        return new BookSearchViewModelFactory(app, booksDataRepository);
    }

}
