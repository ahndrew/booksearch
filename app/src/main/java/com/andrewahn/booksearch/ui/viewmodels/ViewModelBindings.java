package com.andrewahn.booksearch.ui.viewmodels;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * Created by andrewahn on 12/7/17.
 */

public class ViewModelBindings {

    @BindingAdapter("recyclerViewViewModel")
    public static void setRecyclerViewViewModel(RecyclerView recyclerView,
                                                RecyclerViewViewModel viewModel) {
        viewModel.setupRecyclerView(recyclerView);
    }
}