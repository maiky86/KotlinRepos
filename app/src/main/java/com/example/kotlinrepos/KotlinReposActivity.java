package com.example.kotlinrepos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.kotlinrepos.list_repos.RepoClickedListener;
import com.example.kotlinrepos.list_repos.ReposListFragment;
import com.example.kotlinrepos.model.User;
import com.example.kotlinrepos.owner_detail.OwnerDetailsFragment;

public class KotlinReposActivity extends AppCompatActivity{

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModelFactory factory = new MainViewModelFactory(this);
        viewModel = new ViewModelProvider(this,factory).get(MainViewModel.class);

        viewModel.getSelected().observe(this, user -> loadOwnerDetail(user.getLogin()));

        loadListFragment();
    }

    private void loadListFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentHolder, ReposListFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    private void loadOwnerDetail(String login){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentHolder, OwnerDetailsFragment.newInstance(login))
                .addToBackStack(null)
                .commit();
    }

}
