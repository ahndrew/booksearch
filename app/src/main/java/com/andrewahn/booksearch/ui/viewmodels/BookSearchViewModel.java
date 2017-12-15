package com.andrewahn.booksearch.ui.viewmodels;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.andrewahn.booksearch.api.responses.BookResponse;
import com.andrewahn.booksearch.models.books.BooksDataRepository;
import com.andrewahn.booksearch.ui.adapters.BaseRecyclerViewAdapter;
import com.andrewahn.booksearch.ui.adapters.BooksAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by andrewahn on 12/2/17.
 */

public class BookSearchViewModel extends RecyclerViewViewModel {

    private CompositeDisposable mCompositeDisposable;

    private final ObservableField<String> bookCount = new ObservableField<>();
    private final ObservableField<String> query = new ObservableField<>("");
    private final ObservableArrayList<BookResponse> bookList = new ObservableArrayList<>();

    private final BooksDataRepository booksDataRepository;

    private final BooksAdapter booksAdapter;

    private final Context context;

    BookSearchViewModel(Context context, BooksDataRepository booksDataRepository) {
        this.booksDataRepository = booksDataRepository;
        this.mCompositeDisposable = new CompositeDisposable();
        this.booksAdapter = new BooksAdapter();
        this.context = context;
    }

    public void fetchBooks(String query) {
        mCompositeDisposable.add(
            booksDataRepository.findBooks(query)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<List<BookResponse>>() {
                        @Override
                        public void accept(List<BookResponse> bookResponses) throws Exception {
                            if (bookResponses != null) {
                                bookList.addAll(bookResponses);
                                booksAdapter.setItems(bookList);
                                bookCount.set(String.valueOf(bookResponses.size()));
                            }
                        }
                    })
        );
    }

    public void onSearchClick(View v) {
        fetchBooks(query.get());
    }

    public ObservableField<String> getBookCount() {
        return bookCount;
    }

    public ObservableField<String> getQuery() {
        return query;
    }

    public ObservableArrayList<BookResponse> getBookList() {
        return bookList;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    @Override
    protected BaseRecyclerViewAdapter getAdapter() {
        return booksAdapter;
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        return new LinearLayoutManager(context);
    }
}
