package com.example.kotlinrepos.owner_detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.kotlinrepos.MainViewModel;
import com.example.kotlinrepos.MainViewModelFactory;
import com.example.kotlinrepos.databinding.FragmentOwnerDetailsBinding;
import com.example.kotlinrepos.model.User;

import java.util.Objects;

public class OwnerDetailsFragment extends Fragment {

    public static final String TAG = "OwnerDetailsFragment";

    private static final String LOGIN = "login";

    private MainViewModel viewModel;

    private FragmentOwnerDetailsBinding binding;

    public OwnerDetailsFragment() {
        // Required empty public constructor
    }

    public static OwnerDetailsFragment newInstance() {
        OwnerDetailsFragment fragment = new OwnerDetailsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOwnerDetailsBinding.inflate(inflater);

        MainViewModelFactory factory = new MainViewModelFactory(requireActivity());
        viewModel = new ViewModelProvider(requireActivity(),factory).get(MainViewModel.class);

        binding.ghPage.setOnClickListener(view -> {

            Uri uriUrl = Uri.parse(binding.ghPage.getText().toString());

            Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(intent);
        });

        viewModel.getSelected().observe(getViewLifecycleOwner(), this::bindUserToView);

        return binding.getRoot();
    }

    private void bindUserToView(User user) {

        binding.setUser(user);
        binding.executePendingBindings();
        Glide.with(Objects.requireNonNull(getContext()))
                .load(user.getAvatar())
                .circleCrop()
                .into(binding.ownerAvatar);
    }
}
