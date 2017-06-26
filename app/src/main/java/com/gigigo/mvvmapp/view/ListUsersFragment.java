package com.gigigo.mvvmapp.view;


import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigigo.mvvmapp.R;
import com.gigigo.mvvmapp.databinding.FragmentListUsersBinding;
import com.gigigo.mvvmapp.view.ListUsersAdapter;
import com.gigigo.mvvmapp.viewmodel.ListUsersViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListUsersFragment extends Fragment {

    private FragmentListUsersBinding binding;
    private ListUsersViewModel viewModel;

    public ListUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_users, container, false);
        viewModel = new ListUsersViewModel(getContext());
        binding.setListUsersViewModel(viewModel);

        viewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(final Observable observable, int i) {
                if(observable instanceof  ListUsersViewModel) {

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ListUsersAdapter adapter = (ListUsersAdapter) binding.recyclerview.getAdapter();
                            ListUsersViewModel vm = (ListUsersViewModel) observable;
                            adapter.setItemsSource(vm.getUserList());
                        }
                    });

                }
            }
        });

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
