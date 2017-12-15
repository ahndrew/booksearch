package com.andrewahn.booksearch.ui.viewholders;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by andrewahn on 12/7/17.
 */

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public BaseRecyclerViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj) {
        binding.setVariable(BR.vm, obj);
        binding.executePendingBindings();
    }
}
