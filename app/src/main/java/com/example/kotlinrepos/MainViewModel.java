package com.example.kotlinrepos;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.model.User;
import com.example.kotlinrepos.repository.GitHubRepository;
import com.example.kotlinrepos.repository.MainRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    private GitHubRepository repository;

    private MutableLiveData<GHRepo> _repoOwner = new MutableLiveData<GHRepo>();
    private LiveData<User> repoOwner = Transformations.switchMap(_repoOwner, input -> repository.getUser(input.getOwner().getLogin()));

    public MainViewModel(Context context) {
        repository = new MainRepository();
    }

    public LiveData<List<GHRepo>> getRepos() {

        return repository.getGHRepos();
    }

    public LiveData<User> getSelected() {

        return repoOwner;
    }

    public void repoSelected(GHRepo repo){

        _repoOwner.setValue(repo);
    }


}
