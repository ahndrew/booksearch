package com.andrewahn.booksearch.models.books;

import com.andrewahn.booksearch.api.BooksService;
import com.andrewahn.booksearch.api.responses.BookResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andrewahn on 12/1/17.
 */

public class BooksDataRepository {

    private final BooksService booksService;

    public BooksDataRepository(BooksService booksService) {
        this.booksService = booksService;
    }

    public Observable<List<BookResponse>> findBooks(String searchQuery) {
        return booksService.listBooks(searchQuery)
                        .subscribeOn(Schedulers.newThread())
                        .map(booksResponse -> booksResponse.books);
    }
}
