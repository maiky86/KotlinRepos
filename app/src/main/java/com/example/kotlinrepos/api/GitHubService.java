package com.example.kotlinrepos.api;

import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.model.SearchResponse;
import com.example.kotlinrepos.model.User;
import com.example.kotlinrepos.repository.GitHubRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubService implements GitHubApi{

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

    public Call<SearchResponse> kotlinRepos() {
        return getKotlinRepos(kotlinReposQuery);
    }

    @Override
    public Call<SearchResponse> getKotlinRepos(String mainQuery) {
        return gitHubApi.getKotlinRepos(mainQuery);
    }

    @Override
    public Call<User> getOrganization(String orgainzation) {
        return gitHubApi.getOrganization(orgainzation);
    }

    @Override
    public Call<User> getUser(String user) {
        return gitHubApi.getUser(user);
    }
}
