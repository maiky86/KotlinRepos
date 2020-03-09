package com.example.kotlinrepos.list_repos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kotlinrepos.KotlinReposActivity;
import com.example.kotlinrepos.MainViewModel;
import com.example.kotlinrepos.MainViewModelFactory;
import com.example.kotlinrepos.R;
import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.repository.FakeRepository;

import java.util.List;

public class ReposListFragment extends Fragment {

    public static final String TAG = "ReposListFragment";

    private RecyclerView recyclerView;

    private MainViewModel viewModel;

    public ReposListFragment() {
        // Required empty public constructor
    }

    public static ReposListFragment newInstance() {
        return new ReposListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_repos_list, container, false);

        MainViewModelFactory factory = new MainViewModelFactory(requireActivity());
        viewModel = new ViewModelProvider(requireActivity(),factory).get(MainViewModel.class);

        final ReposListAdapter adapter = new ReposListAdapter(viewModel, getContext());

        recyclerView = v.findViewById(R.id.reposList);
        recyclerView.setAdapter(adapter);

        viewModel.getRepos().observe(getViewLifecycleOwner(), ghRepos -> adapter.addRepos(ghRepos));

        return v;
    }



    @Override
    public void onDetach() {

        recyclerView.setAdapter(null);
        super.onDetach();
    }
}
