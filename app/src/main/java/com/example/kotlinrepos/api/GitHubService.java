package com.example.kotlinrepos.api;

import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.model.User;
import com.example.kotlinrepos.repository.GitHubRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubService implements GitHubRepository {

    private static GitHubService instance;

    private GitHubApi gitHubApi;

    private static final String kotlinReposQuery = "language:kotlin";

    private GitHubService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubApi = retrofit.create(GitHubApi.class);
    }

    public static GitHubService getInstance(){

        if (instance == null) {

            instance = new GitHubService();
        }

        return instance;
    }

    @Override
    public List<GHRepo> getGHRepos() {

        gitHubApi.getKotlinRepos(kotlinReposQuery).enqueue(new Callback<List<GHRepo>>() {
            @Override
            public void onResponse(Call<List<GHRepo>> call, Response<List<GHRepo>> response) {
                if (response.isSuccessful()) {


                }
            }

            @Override
            public void onFailure(Call<List<GHRepo>> call, Throwable t) {

            }
        });

        return null;
    }

    @Override
    public User getUser(String login) {

        gitHubApi.getUser(login).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        return null;
    }
}
