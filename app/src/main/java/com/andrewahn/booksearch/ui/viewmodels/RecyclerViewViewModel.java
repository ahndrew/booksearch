package com.andrewahn.booksearch.ui.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;

import com.andrewahn.booksearch.ui.adapters.BaseRecyclerViewAdapter;

/**
 * Created by andrewahn on 12/7/17.
 */

public abstract class RecyclerViewViewModel extends ViewModel {

    RecyclerView.LayoutManager layoutManager;

    protected abstract BaseRecyclerViewAdapter getAdapter();
    protected abstract RecyclerView.LayoutManager createLayoutManager();

    public final void setupRecyclerView(RecyclerView recyclerView) {
        layoutManager = createLayoutManager();
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(layoutManager);
    }

}
