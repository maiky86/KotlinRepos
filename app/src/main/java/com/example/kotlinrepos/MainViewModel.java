package com.example.kotlinrepos;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.model.User;
import com.example.kotlinrepos.repository.FakeRepository;
import com.example.kotlinrepos.repository.GitHubRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    private GitHubRepository repository;

    private MutableLiveData<List<GHRepo>> _repositories = new MutableLiveData<>();

    private MutableLiveData<User> _repoOwner = new MutableLiveData<>();

    public MainViewModel(Context context) {
        repository = new FakeRepository();
    }

    public LiveData<List<GHRepo>> getRepos() {

        _repositories.setValue(repository.getGHRepos());

        return _repositories;
    }

    public LiveData<User> getSelected() {

        return _repoOwner;
    }

    public void repoSelected(GHRepo repo){

        User user = repository.getUser(repo.getOwner().getLogin());
        _repoOwner.postValue(user);
    }


}
