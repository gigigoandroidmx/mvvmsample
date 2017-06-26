package com.gigigo.mvvmapp.view;

import android.support.v7.widget.RecyclerView;

import com.gigigo.mvvmapp.databinding.ItemUserBinding;
import com.gigigo.mvvmapp.model.User;
import com.gigigo.mvvmapp.viewmodel.UserViewModel;

/**
 * @author Juan Godínez Vera - 6/23/2017.
 */
public class ListUsersViewHolder
        extends RecyclerView.ViewHolder {

    ItemUserBinding binding;

    public ListUsersViewHolder(ItemUserBinding binding) {
        super(binding.itemUser);
        this.binding = binding;
    }

    public void onBindIntem(User user) {
        if(binding.getUserViewModel() == null) {
            binding.setUserViewModel(new UserViewModel(itemView.getContext(), user));
        } else {
            binding.getUserViewModel().setUser(user);
        }
    }
}
