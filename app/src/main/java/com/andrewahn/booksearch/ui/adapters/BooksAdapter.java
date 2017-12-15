package com.andrewahn.booksearch.ui.adapters;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewahn.booksearch.R;
import com.andrewahn.booksearch.api.responses.BookResponse;
import com.andrewahn.booksearch.databinding.BookListRowBinding;
import com.andrewahn.booksearch.ui.viewmodels.BookViewModel;

import java.util.List;

/**
 * Created by andrewahn on 12/1/17.
 */

public class BooksAdapter extends BaseRecyclerViewAdapter<BookResponse, BookViewModel> {

    @Override
    public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_row, parent, false);

        BookViewModel viewModel = new BookViewModel();

        BookListRowBinding binding = BookListRowBinding.bind(itemView);
        binding.setVm(viewModel);

        return new BooksViewHolder(itemView, binding, viewModel);
    }

    public void setItems(List<BookResponse> newBooks) {
        items.clear();
        items.addAll(newBooks);
        notifyDataSetChanged();
    }

    public List<BookResponse> getItems() {
        return items;
    }

    public class BooksViewHolder extends ItemViewHolder<BookResponse, BookViewModel> {

        public BooksViewHolder(View itemView, ViewDataBinding binding, BookViewModel viewModel) {
            super(itemView, binding, viewModel);
        }
    }
}
