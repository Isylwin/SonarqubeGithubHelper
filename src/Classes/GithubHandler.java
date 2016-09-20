package Classes;


import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Oscar on 19-9-2016.
 */
public class GithubHandler {
    private GitHub github;
    private String oAuthToken;
    private HashMap<String, GHRepository> repos = new HashMap<>();
    private HashMap<String, GHPullRequest> pullRequests = new HashMap<>();

    public GithubHandler() {

    }

    public void connectToGithub(String oAuthToken) throws IOException {
        this.oAuthToken = oAuthToken;
        github = GitHub.connectUsingOAuth(oAuthToken);
    }

    public List<String> getRepositoriesNames() throws IOException {
        getRepositoriesFromGithub();
        return repos.keySet().stream().collect(Collectors.toList());
    }

    public List<String> getPullRequestsNames(String repoName) throws IOException {
        getPullRequestsFromGithub(repoName);
        return pullRequests.keySet().stream().collect(Collectors.toList());
    }

    private void getPullRequestsFromGithub(String repoName) throws IOException {
        GHRepository repo = repos.get(repoName);

        List<GHPullRequest> requests = repo.getPullRequests(GHIssueState.OPEN);
        requests.forEach(p -> pullRequests.put(p.getNumber() + ":" + p.getTitle(), p));
    }

    private void getRepositoriesFromGithub() throws IOException {
        List<GHRepository> ghRepositories = github.getMyself().listRepositories().asList();
        ghRepositories.forEach(r -> repos.put(r.getFullName(), r));
    }
}
