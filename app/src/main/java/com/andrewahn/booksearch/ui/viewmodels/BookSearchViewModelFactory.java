package com.andrewahn.booksearch.ui.viewmodels;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.andrewahn.booksearch.models.books.BooksDataRepository;

import javax.inject.Inject;

/**
 * Created by andrewahn on 12/2/17.
 */

public class BookSearchViewModelFactory implements ViewModelProvider.Factory {

    private final BooksDataRepository booksDataRepository;

    private final Context appContext;

    @Inject
    public BookSearchViewModelFactory(Application app, BooksDataRepository booksDataRepository) {
        this.booksDataRepository = booksDataRepository;
        this.appContext = app.getApplicationContext();
    }

    @Override
    public BookSearchViewModel create(Class modelClass) {
        return new BookSearchViewModel(appContext, booksDataRepository);
    }
}