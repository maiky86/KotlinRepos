package com.example.kotlinrepos.list_repos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kotlinrepos.KotlinReposActivity;
import com.example.kotlinrepos.MainViewModel;
import com.example.kotlinrepos.MainViewModelFactory;
import com.example.kotlinrepos.R;
import com.example.kotlinrepos.databinding.FragmentReposListBinding;
import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.repository.FakeRepository;

import java.util.List;

public class ReposListFragment extends Fragment {

    public static final String TAG = "ReposListFragment";

    private FragmentReposListBinding binding;

    private MainViewModel viewModel;

    public ReposListFragment() {
    }

    public static ReposListFragment newInstance() {
        return new ReposListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentReposListBinding.inflate(inflater);

        MainViewModelFactory factory = new MainViewModelFactory(requireActivity());
        viewModel = new ViewModelProvider(requireActivity(),factory).get(MainViewModel.class);

        final ReposListAdapter adapter = new ReposListAdapter(viewModel, getContext());

        binding.reposList.setAdapter(adapter);

        viewModel.getRepos().observe(getViewLifecycleOwner(), adapter::addRepos);

        return binding.getRoot();
    }



    @Override
    public void onDetach() {

        binding.reposList.setAdapter(null);
        super.onDetach();
    }
}
