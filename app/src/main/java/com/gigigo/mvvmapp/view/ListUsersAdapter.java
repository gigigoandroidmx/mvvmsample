package com.gigigo.mvvmapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigigo.mvvmapp.R;
import com.gigigo.mvvmapp.databinding.ItemUserBinding;
import com.gigigo.mvvmapp.model.ListUsers;
import com.gigigo.mvvmapp.model.User;

import java.util.List;

/**
 * @author Juan Godínez Vera - 6/23/2017.
 */
public class ListUsersAdapter
        extends RecyclerView.Adapter<ListUsersViewHolder> {

    private List<User> itemsSource;

    @Override
    public ListUsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ItemUserBinding userBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_user, parent, false);

        return new ListUsersViewHolder(userBinding);
    }

    @Override
    public void onBindViewHolder(ListUsersViewHolder holder, int position) {
        if(getItemCount() == 0) return;

        holder.onBindIntem(itemsSource.get(position));
    }

    @Override
    public int getItemCount() {
        return this.itemsSource != null
                ? this.itemsSource.size() : 0;
    }

    public void setItemsSource(List<User> itemsSource) {
        this.itemsSource = itemsSource;
        notifyDataSetChanged();
    }
}
