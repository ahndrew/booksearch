package com.andrewahn.booksearch.ui.viewmodels;

import android.arch.lifecycle.ViewModel;

/**
 * Created by andrewahn on 12/7/17.
 */

public abstract class RecyclerItemViewModel<ITEM_T> extends ViewModel {

    public RecyclerItemViewModel() {
        super();
    }

    public abstract void setItem(ITEM_T item);

}
