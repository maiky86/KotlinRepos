package com.example.kotlinrepos.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kotlinrepos.model.GHRepo;
import com.example.kotlinrepos.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FakeRepository implements GitHubRepository {

    private static String listRepos = "[" +
            "{\"id\":51148780,\"node_id\":\"MDEwOlJlcG9zaXRvcnk1MTE0ODc4MA==\",\"name\":\"architecture-samples\",\"full_name\":\"android/architecture-samples\",\"private\":false,\"owner\":{\"login\":\"android\",\"id\":32689599,\"node_id\":\"MDEyOk9yZ2FuaXphdGlvbjMyNjg5NTk5\",\"avatar_url\":\"https://avatars3.githubusercontent.com/u/32689599?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/android\",\"html_url\":\"https://github.com/android\",\"followers_url\":\"https://api.github.com/users/android/followers\",\"following_url\":\"https://api.github.com/users/android/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/android/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/android/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/android/subscriptions\",\"organizations_url\":\"https://api.github.com/users/android/orgs\",\"repos_url\":\"https://api.github.com/users/android/repos\",\"events_url\":\"https://api.github.com/users/android/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/android/received_events\",\"type\":\"Organization\",\"site_admin\":false},\"html_url\":\"https://github.com/android/architecture-samples\",\"description\":\"A collection of samples to discuss and showcase different architectural tools and patterns for Android apps.\",\"fork\":false,\"url\":\"https://api.github.com/repos/android/architecture-samples\",\"forks_url\":\"https://api.github.com/repos/android/architecture-samples/forks\",\"keys_url\":\"https://api.github.com/repos/android/architecture-samples/keys{/key_id}\",\"collaborators_url\":\"https://api.github.com/repos/android/architecture-samples/collaborators{/collaborator}\",\"teams_url\":\"https://api.github.com/repos/android/architecture-samples/teams\",\"hooks_url\":\"https://api.github.com/repos/android/architecture-samples/hooks\",\"issue_events_url\":\"https://api.github.com/repos/android/architecture-samples/issues/events{/number}\",\"events_url\":\"https://api.github.com/repos/android/architecture-samples/events\",\"assignees_url\":\"https://api.github.com/repos/android/architecture-samples/assignees{/user}\",\"branches_url\":\"https://api.github.com/repos/android/architecture-samples/branches{/branch}\",\"tags_url\":\"https://api.github.com/repos/android/architecture-samples/tags\",\"blobs_url\":\"https://api.github.com/repos/android/architecture-samples/git/blobs{/sha}\",\"git_tags_url\":\"https://api.github.com/repos/android/architecture-samples/git/tags{/sha}\",\"git_refs_url\":\"https://api.github.com/repos/android/architecture-samples/git/refs{/sha}\",\"trees_url\":\"https://api.github.com/repos/android/architecture-samples/git/trees{/sha}\",\"statuses_url\":\"https://api.github.com/repos/android/architecture-samples/statuses/{sha}\",\"languages_url\":\"https://api.github.com/repos/android/architecture-samples/languages\",\"stargazers_url\":\"https://api.github.com/repos/android/architecture-samples/stargazers\",\"contributors_url\":\"https://api.github.com/repos/android/architecture-samples/contributors\",\"subscribers_url\":\"https://api.github.com/repos/android/architecture-samples/subscribers\",\"subscription_url\":\"https://api.github.com/repos/android/architecture-samples/subscription\",\"commits_url\":\"https://api.github.com/repos/android/architecture-samples/commits{/sha}\",\"git_commits_url\":\"https://api.github.com/repos/android/architecture-samples/git/commits{/sha}\",\"comments_url\":\"https://api.github.com/repos/android/architecture-samples/comments{/number}\",\"issue_comment_url\":\"https://api.github.com/repos/android/architecture-samples/issues/comments{/number}\",\"contents_url\":\"https://api.github.com/repos/android/architecture-samples/contents/{+path}\",\"compare_url\":\"https://api.github.com/repos/android/architecture-samples/compare/{base}...{head}\",\"merges_url\":\"https://api.github.com/repos/android/architecture-samples/merges\",\"archive_url\":\"https://api.github.com/repos/android/architecture-samples/{archive_format}{/ref}\",\"downloads_url\":\"https://api.github.com/repos/android/architecture-samples/downloads\",\"issues_url\":\"https://api.github.com/repos/android/architecture-samples/issues{/number}\",\"pulls_url\":\"https://api.github.com/repos/android/architecture-samples/pulls{/number}\",\"milestones_url\":\"https://api.github.com/repos/android/architecture-samples/milestones{/number}\",\"notifications_url\":\"https://api.github.com/repos/android/architecture-samples/notifications{?since,all,participating}\",\"labels_url\":\"https://api.github.com/repos/android/architecture-samples/labels{/name}\",\"releases_url\":\"https://api.github.com/repos/android/architecture-samples/releases{/id}\",\"deployments_url\":\"https://api.github.com/repos/android/architecture-samples/deployments\",\"created_at\":\"2016-02-05T13:42:07Z\",\"updated_at\":\"2020-03-08T18:01:31Z\",\"pushed_at\":\"2020-03-02T07:14:54Z\",\"git_url\":\"git://github.com/android/architecture-samples.git\",\"ssh_url\":\"git@github.com:android/architecture-samples.git\",\"clone_url\":\"https://github.com/android/architecture-samples.git\",\"svn_url\":\"https://github.com/android/architecture-samples\",\"homepage\":\"\",\"size\":12211,\"stargazers_count\":35659,\"watchers_count\":35659,\"language\":\"Kotlin\",\"has_issues\":true,\"has_projects\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"forks_count\":9947,\"mirror_url\":null,\"archived\":false,\"disabled\":false,\"open_issues_count\":142,\"license\":{\"key\":\"apache-2.0\",\"name\":\"Apache License 2.0\",\"spdx_id\":\"Apache-2.0\",\"url\":\"https://api.github.com/licenses/apache-2.0\",\"node_id\":\"MDc6TGljZW5zZTI=\"},\"forks\":9947,\"open_issues\":142,\"watchers\":35659,\"default_branch\":\"master\",\"score\":1.0}," +
            "{\"id\":51148780,\"node_id\":\"MDEwOlJlcG9zaXRvcnk1MTE0ODc4MA==\",\"name\":\"architecture-samples\",\"full_name\":\"android/architecture-samples\",\"private\":false,\"owner\":{\"login\":\"android\",\"id\":32689599,\"node_id\":\"MDEyOk9yZ2FuaXphdGlvbjMyNjg5NTk5\",\"avatar_url\":\"https://avatars3.githubusercontent.com/u/32689599?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/android\",\"html_url\":\"https://github.com/android\",\"followers_url\":\"https://api.github.com/users/android/followers\",\"following_url\":\"https://api.github.com/users/android/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/android/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/android/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/android/subscriptions\",\"organizations_url\":\"https://api.github.com/users/android/orgs\",\"repos_url\":\"https://api.github.com/users/android/repos\",\"events_url\":\"https://api.github.com/users/android/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/android/received_events\",\"type\":\"Organization\",\"site_admin\":false},\"html_url\":\"https://github.com/android/architecture-samples\",\"description\":\"A collection of samples to discuss and showcase different architectural tools and patterns for Android apps.\",\"fork\":false,\"url\":\"https://api.github.com/repos/android/architecture-samples\",\"forks_url\":\"https://api.github.com/repos/android/architecture-samples/forks\",\"keys_url\":\"https://api.github.com/repos/android/architecture-samples/keys{/key_id}\",\"collaborators_url\":\"https://api.github.com/repos/android/architecture-samples/collaborators{/collaborator}\",\"teams_url\":\"https://api.github.com/repos/android/architecture-samples/teams\",\"hooks_url\":\"https://api.github.com/repos/android/architecture-samples/hooks\",\"issue_events_url\":\"https://api.github.com/repos/android/architecture-samples/issues/events{/number}\",\"events_url\":\"https://api.github.com/repos/android/architecture-samples/events\",\"assignees_url\":\"https://api.github.com/repos/android/architecture-samples/assignees{/user}\",\"branches_url\":\"https://api.github.com/repos/android/architecture-samples/branches{/branch}\",\"tags_url\":\"https://api.github.com/repos/android/architecture-samples/tags\",\"blobs_url\":\"https://api.github.com/repos/android/architecture-samples/git/blobs{/sha}\",\"git_tags_url\":\"https://api.github.com/repos/android/architecture-samples/git/tags{/sha}\",\"git_refs_url\":\"https://api.github.com/repos/android/architecture-samples/git/refs{/sha}\",\"trees_url\":\"https://api.github.com/repos/android/architecture-samples/git/trees{/sha}\",\"statuses_url\":\"https://api.github.com/repos/android/architecture-samples/statuses/{sha}\",\"languages_url\":\"https://api.github.com/repos/android/architecture-samples/languages\",\"stargazers_url\":\"https://api.github.com/repos/android/architecture-samples/stargazers\",\"contributors_url\":\"https://api.github.com/repos/android/architecture-samples/contributors\",\"subscribers_url\":\"https://api.github.com/repos/android/architecture-samples/subscribers\",\"subscription_url\":\"https://api.github.com/repos/android/architecture-samples/subscription\",\"commits_url\":\"https://api.github.com/repos/android/architecture-samples/commits{/sha}\",\"git_commits_url\":\"https://api.github.com/repos/android/architecture-samples/git/commits{/sha}\",\"comments_url\":\"https://api.github.com/repos/android/architecture-samples/comments{/number}\",\"issue_comment_url\":\"https://api.github.com/repos/android/architecture-samples/issues/comments{/number}\",\"contents_url\":\"https://api.github.com/repos/android/architecture-samples/contents/{+path}\",\"compare_url\":\"https://api.github.com/repos/android/architecture-samples/compare/{base}...{head}\",\"merges_url\":\"https://api.github.com/repos/android/architecture-samples/merges\",\"archive_url\":\"https://api.github.com/repos/android/architecture-samples/{archive_format}{/ref}\",\"downloads_url\":\"https://api.github.com/repos/android/architecture-samples/downloads\",\"issues_url\":\"https://api.github.com/repos/android/architecture-samples/issues{/number}\",\"pulls_url\":\"https://api.github.com/repos/android/architecture-samples/pulls{/number}\",\"milestones_url\":\"https://api.github.com/repos/android/architecture-samples/milestones{/number}\",\"notifications_url\":\"https://api.github.com/repos/android/architecture-samples/notifications{?since,all,participating}\",\"labels_url\":\"https://api.github.com/repos/android/architecture-samples/labels{/name}\",\"releases_url\":\"https://api.github.com/repos/android/architecture-samples/releases{/id}\",\"deployments_url\":\"https://api.github.com/repos/android/architecture-samples/deployments\",\"created_at\":\"2016-02-05T13:42:07Z\",\"updated_at\":\"2020-03-08T18:01:31Z\",\"pushed_at\":\"2020-03-02T07:14:54Z\",\"git_url\":\"git://github.com/android/architecture-samples.git\",\"ssh_url\":\"git@github.com:android/architecture-samples.git\",\"clone_url\":\"https://github.com/android/architecture-samples.git\",\"svn_url\":\"https://github.com/android/architecture-samples\",\"homepage\":\"\",\"size\":12211,\"stargazers_count\":35659,\"watchers_count\":35659,\"language\":\"Kotlin\",\"has_issues\":true,\"has_projects\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"forks_count\":9947,\"mirror_url\":null,\"archived\":false,\"disabled\":false,\"open_issues_count\":142,\"license\":{\"key\":\"apache-2.0\",\"name\":\"Apache License 2.0\",\"spdx_id\":\"Apache-2.0\",\"url\":\"https://api.github.com/licenses/apache-2.0\",\"node_id\":\"MDc6TGljZW5zZTI=\"},\"forks\":9947,\"open_issues\":142,\"watchers\":35659,\"default_branch\":\"master\",\"score\":1.0}," +
            "{\"id\":51148780,\"node_id\":\"MDEwOlJlcG9zaXRvcnk1MTE0ODc4MA==\",\"name\":\"architecture-samples\",\"full_name\":\"android/architecture-samples\",\"private\":false,\"owner\":{\"login\":\"android\",\"id\":32689599,\"node_id\":\"MDEyOk9yZ2FuaXphdGlvbjMyNjg5NTk5\",\"avatar_url\":\"https://avatars3.githubusercontent.com/u/32689599?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/android\",\"html_url\":\"https://github.com/android\",\"followers_url\":\"https://api.github.com/users/android/followers\",\"following_url\":\"https://api.github.com/users/android/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/android/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/android/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/android/subscriptions\",\"organizations_url\":\"https://api.github.com/users/android/orgs\",\"repos_url\":\"https://api.github.com/users/android/repos\",\"events_url\":\"https://api.github.com/users/android/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/android/received_events\",\"type\":\"Organization\",\"site_admin\":false},\"html_url\":\"https://github.com/android/architecture-samples\",\"description\":\"A collection of samples to discuss and showcase different architectural tools and patterns for Android apps.\",\"fork\":false,\"url\":\"https://api.github.com/repos/android/architecture-samples\",\"forks_url\":\"https://api.github.com/repos/android/architecture-samples/forks\",\"keys_url\":\"https://api.github.com/repos/android/architecture-samples/keys{/key_id}\",\"collaborators_url\":\"https://api.github.com/repos/android/architecture-samples/collaborators{/collaborator}\",\"teams_url\":\"https://api.github.com/repos/android/architecture-samples/teams\",\"hooks_url\":\"https://api.github.com/repos/android/architecture-samples/hooks\",\"issue_events_url\":\"https://api.github.com/repos/android/architecture-samples/issues/events{/number}\",\"events_url\":\"https://api.github.com/repos/android/architecture-samples/events\",\"assignees_url\":\"https://api.github.com/repos/android/architecture-samples/assignees{/user}\",\"branches_url\":\"https://api.github.com/repos/android/architecture-samples/branches{/branch}\",\"tags_url\":\"https://api.github.com/repos/android/architecture-samples/tags\",\"blobs_url\":\"https://api.github.com/repos/android/architecture-samples/git/blobs{/sha}\",\"git_tags_url\":\"https://api.github.com/repos/android/architecture-samples/git/tags{/sha}\",\"git_refs_url\":\"https://api.github.com/repos/android/architecture-samples/git/refs{/sha}\",\"trees_url\":\"https://api.github.com/repos/android/architecture-samples/git/trees{/sha}\",\"statuses_url\":\"https://api.github.com/repos/android/architecture-samples/statuses/{sha}\",\"languages_url\":\"https://api.github.com/repos/android/architecture-samples/languages\",\"stargazers_url\":\"https://api.github.com/repos/android/architecture-samples/stargazers\",\"contributors_url\":\"https://api.github.com/repos/android/architecture-samples/contributors\",\"subscribers_url\":\"https://api.github.com/repos/android/architecture-samples/subscribers\",\"subscription_url\":\"https://api.github.com/repos/android/architecture-samples/subscription\",\"commits_url\":\"https://api.github.com/repos/android/architecture-samples/commits{/sha}\",\"git_commits_url\":\"https://api.github.com/repos/android/architecture-samples/git/commits{/sha}\",\"comments_url\":\"https://api.github.com/repos/android/architecture-samples/comments{/number}\",\"issue_comment_url\":\"https://api.github.com/repos/android/architecture-samples/issues/comments{/number}\",\"contents_url\":\"https://api.github.com/repos/android/architecture-samples/contents/{+path}\",\"compare_url\":\"https://api.github.com/repos/android/architecture-samples/compare/{base}...{head}\",\"merges_url\":\"https://api.github.com/repos/android/architecture-samples/merges\",\"archive_url\":\"https://api.github.com/repos/android/architecture-samples/{archive_format}{/ref}\",\"downloads_url\":\"https://api.github.com/repos/android/architecture-samples/downloads\",\"issues_url\":\"https://api.github.com/repos/android/architecture-samples/issues{/number}\",\"pulls_url\":\"https://api.github.com/repos/android/architecture-samples/pulls{/number}\",\"milestones_url\":\"https://api.github.com/repos/android/architecture-samples/milestones{/number}\",\"notifications_url\":\"https://api.github.com/repos/android/architecture-samples/notifications{?since,all,participating}\",\"labels_url\":\"https://api.github.com/repos/android/architecture-samples/labels{/name}\",\"releases_url\":\"https://api.github.com/repos/android/architecture-samples/releases{/id}\",\"deployments_url\":\"https://api.github.com/repos/android/architecture-samples/deployments\",\"created_at\":\"2016-02-05T13:42:07Z\",\"updated_at\":\"2020-03-08T18:01:31Z\",\"pushed_at\":\"2020-03-02T07:14:54Z\",\"git_url\":\"git://github.com/android/architecture-samples.git\",\"ssh_url\":\"git@github.com:android/architecture-samples.git\",\"clone_url\":\"https://github.com/android/architecture-samples.git\",\"svn_url\":\"https://github.com/android/architecture-samples\",\"homepage\":\"\",\"size\":12211,\"stargazers_count\":35659,\"watchers_count\":35659,\"language\":\"Kotlin\",\"has_issues\":true,\"has_projects\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"forks_count\":9947,\"mirror_url\":null,\"archived\":false,\"disabled\":false,\"open_issues_count\":142,\"license\":{\"key\":\"apache-2.0\",\"name\":\"Apache License 2.0\",\"spdx_id\":\"Apache-2.0\",\"url\":\"https://api.github.com/licenses/apache-2.0\",\"node_id\":\"MDc6TGljZW5zZTI=\"},\"forks\":9947,\"open_issues\":142,\"watchers\":35659,\"default_branch\":\"master\",\"score\":1.0}" +
            "]";

    private static String user = "{\"login\":\"android\",\"id\":32689599,\"node_id\":\"MDEyOk9yZ2FuaXphdGlvbjMyNjg5NTk5\",\"url\":\"https://api.github.com/orgs/android\",\"repos_url\":\"https://api.github.com/orgs/android/repos\",\"events_url\":\"https://api.github.com/orgs/android/events\",\"hooks_url\":\"https://api.github.com/orgs/android/hooks\",\"issues_url\":\"https://api.github.com/orgs/android/issues\",\"members_url\":\"https://api.github.com/orgs/android/members{/member}\",\"public_members_url\":\"https://api.github.com/orgs/android/public_members{/member}\",\"avatar_url\":\"https://avatars3.githubusercontent.com/u/32689599?v=4\",\"description\":\"\",\"name\":\"Android\",\"company\":null,\"blog\":\"https://d.android.com\",\"location\":null,\"email\":null,\"is_verified\":false,\"has_organization_projects\":true,\"has_repository_projects\":true,\"public_repos\":45,\"public_gists\":0,\"followers\":0,\"following\":0,\"html_url\":\"https://github.com/android\",\"created_at\":\"2017-10-10T23:00:21Z\",\"updated_at\":\"2020-01-17T14:07:58Z\",\"type\":\"Organization\"}";

    @Override
    public LiveData<List<GHRepo>> getGHRepos() {

        Type listType = new TypeToken<ArrayList<GHRepo>>(){}.getType();
        List<GHRepo> repos = new Gson().fromJson(listRepos, listType);

        MutableLiveData<List<GHRepo>> liveRepos = new MutableLiveData<List<GHRepo>>();
        liveRepos.setValue(repos);

        return liveRepos;
    }

    @Override
    public LiveData<User> getUser(String login) {

        User repoUser = new Gson().fromJson(user, User.class);

        MutableLiveData<User> liveUser = new MutableLiveData<User>();
        liveUser.setValue(repoUser);
        return liveUser;
    }
}
