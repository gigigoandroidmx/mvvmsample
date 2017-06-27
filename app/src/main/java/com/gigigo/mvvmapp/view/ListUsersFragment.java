package com.gigigo.mvvmapp.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigigo.mvvmapp.R;
import com.gigigo.mvvmapp.databinding.FragmentListUsersBinding;
import com.gigigo.mvvmapp.viewmodel.ListUsersViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListUsersFragment
        extends Fragment {

    private FragmentListUsersBinding binding;
    private ListUsersViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_users, container, false);
        viewModel = new ListUsersViewModel(getContext());
        binding.setListUsersViewModel(viewModel);

        View root = binding.getRoot();
        initialize();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        viewModel.fetchUserList();
    }

    private void initialize() {
        RecyclerView recyclerView = binding.recyclerview;
        ListUsersAdapter adapter = new ListUsersAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,
                false));
    }

}
