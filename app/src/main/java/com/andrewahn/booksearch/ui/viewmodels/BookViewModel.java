package com.andrewahn.booksearch.ui.viewmodels;

import android.databinding.ObservableField;

import com.andrewahn.booksearch.api.responses.BookResponse;

/**
 * Created by andrewahn on 12/7/17.
 */

public class BookViewModel extends RecyclerItemViewModel<BookResponse> {

    private BookResponse book;

    private final ObservableField<String> title = new ObservableField<>();
    private final ObservableField<String> author = new ObservableField<>();
    private final ObservableField<String> description = new ObservableField<>();
    private final ObservableField<String> thumbnail = new ObservableField<>();
    private final ObservableField<String> smallThumbnail = new ObservableField<>();

    @Override
    public void setItem(BookResponse item) {
        book = item;
    }

    public String getTitle() {
        return book.volumeInfo.title;
    }

    public String getAuthor() {
        return book.volumeInfo.authors.get(0);
    }

    public String getDescription() {
        return book.volumeInfo.description;
    }

    public String getThumbnail() {
        return book.volumeInfo.imageLinks.thumbnail;
    }

    public String getSmallThumbnail() {
        return book.volumeInfo.imageLinks.smallThumbnail;
    }
}
