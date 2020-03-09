package com.example.kotlinrepos.api;

import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.model.SearchResponse;
import com.example.kotlinrepos.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubApi {

    @GET("/search/repositories")
    Call<SearchResponse> getKotlinRepos(
            @Query("q") String mainQuery);

    @GET("/orgs/{organization}")
    Call<User> getOrganization(
            @Path("organization") String orgainzation);

    @GET("/users/{user}")
    Call<User> getUser(
            @Path("user") String user);
}
