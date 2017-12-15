package com.andrewahn.booksearch.ui.adapters;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.andrewahn.booksearch.ui.viewmodels.RecyclerItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewahn on 12/7/17.
 */

public abstract class BaseRecyclerViewAdapter<ITEM_T, VIEW_MODEL_T extends RecyclerItemViewModel<ITEM_T>>
        extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ItemViewHolder<ITEM_T, VIEW_MODEL_T>> {

    protected final List<ITEM_T> items;

    public BaseRecyclerViewAdapter() {
        items = new ArrayList<>();
    }

    @Override
    public final void onBindViewHolder(ItemViewHolder<ITEM_T, VIEW_MODEL_T> holder, int position) {
        holder.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemViewHolder<T, VT extends RecyclerItemViewModel<T>>
            extends RecyclerView.ViewHolder {

        protected final VT viewModel;
        private final ViewDataBinding binding;

        public ItemViewHolder(View itemView, ViewDataBinding binding, VT viewModel) {
            super(itemView);
            this.binding = binding;
            this.viewModel = viewModel;
        }

        void setItem(T item) {
            viewModel.setItem(item);
            binding.executePendingBindings();
        }
    }
}