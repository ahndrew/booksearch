package com.andrewahn.booksearch.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.andrewahn.booksearch.BR;
import com.andrewahn.booksearch.BookSearchApp;
import com.andrewahn.booksearch.R;
import com.andrewahn.booksearch.ui.adapters.BooksAdapter;
import com.andrewahn.booksearch.ui.viewmodels.BookSearchViewModel;
import com.andrewahn.booksearch.ui.viewmodels.BookSearchViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    private BookSearchViewModel mBookSearchViewModel;
    private ViewDataBinding mViewDataBinding;

    @Inject
    BookSearchViewModelFactory bookSearchViewModelFactory;

    private RecyclerView recyclerView;
    private BooksAdapter booksAdapter;
    private Button searchButton;
    private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);

        setupDataBinding();
    }

    BookSearchViewModel createViewModel() {
        return ViewModelProviders.of(this, bookSearchViewModelFactory)
                .get(BookSearchViewModel.class);
    }

    private void setupDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBookSearchViewModel = mBookSearchViewModel == null ? createViewModel() : mBookSearchViewModel;
        mViewDataBinding.setVariable(BR.vm, mBookSearchViewModel);
        mViewDataBinding.executePendingBindings();
    }

    /*
    private void setupViews() {
        recyclerView = findViewById(R.id.recycler_view);

        booksAdapter = new BooksAdapter(new ArrayList<>());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(booksAdapter);

        searchButton = findViewById(R.id.search_button);

        searchText = findViewById(R.id.input_search);

        searchButton.setOnClickListener((View v) -> {
            String query = searchText.getText().toString();
            mBookSearchViewModel.fetchBooks(query);
        });


    }*/
}
