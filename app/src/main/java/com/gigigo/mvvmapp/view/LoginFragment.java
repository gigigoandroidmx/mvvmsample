package com.gigigo.mvvmapp.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigigo.mvvmapp.R;
import com.gigigo.mvvmapp.databinding.FragmentLoginBinding;
import com.gigigo.mvvmapp.viewmodel.LoginViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        viewModel = new LoginViewModel(getContext());

        viewModel.setEmail("peter@klaven");
        viewModel.setPassword("cityslicka");

        binding.setLoginViewModel(viewModel);

        View root = binding.getRoot();
        initialize();
        return root;
    }


    private void initialize() {

    }

}
