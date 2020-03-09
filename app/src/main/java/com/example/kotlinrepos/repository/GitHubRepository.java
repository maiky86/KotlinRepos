package com.example.kotlinrepos.repository;

import androidx.lifecycle.LiveData;

import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.model.User;

import java.util.List;

public interface GitHubRepository {

    LiveData<List<GHRepo>> getGHRepos();

    LiveData<User> getUser(String login);

}
