package com.example.kotlinrepos.repository;

import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.model.User;

import java.util.List;

public interface GitHubRepository {

    List<GHRepo> getGHRepos();

    User getUser(String login);
}
