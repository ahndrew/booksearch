package com.andrewahn.booksearch.api;

import com.andrewahn.booksearch.api.responses.BookSearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by andrewahn on 12/1/17.
 */

public interface BooksService {

    @GET("/books/v1/volumes")
    Observable<BookSearchResponse> listBooks(
        @Query("q") String search
    );
}
