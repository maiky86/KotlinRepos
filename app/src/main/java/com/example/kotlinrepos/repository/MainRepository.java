package com.example.kotlinrepos.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kotlinrepos.api.GitHubApi;
import com.example.kotlinrepos.api.GitHubService;
import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.model.SearchResponse;
import com.example.kotlinrepos.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository implements GitHubRepository{

    private MutableLiveData<List<GHRepo>> _liveRepos = new MutableLiveData<List<GHRepo>>();
    public LiveData<List<GHRepo>> liveRepos = _liveRepos;

    private MutableLiveData<User> _liveUser = new MutableLiveData<User>();
    public LiveData<User> liveUser = _liveUser;

    private GitHubService gitHubService;

    public MainRepository() {
        this.gitHubService = GitHubService.getInstance();
    }

    @Override
    public LiveData<List<GHRepo>> getGHRepos() {

        gitHubService.kotlinRepos().enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        _liveRepos.setValue(response.body().getItems());
                    }
                } else {
                    // Handle response codes 300+
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                // Handle network call failure
            }
        });


        return liveRepos;
    }

    @Override
    public LiveData<User> getUser(String login) {

        gitHubService.getUser(login).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        _liveUser.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return liveUser;
    }
}
