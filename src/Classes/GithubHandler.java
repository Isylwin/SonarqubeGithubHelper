package Classes;


import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.List;

/**
 * Created by Oscar on 19-9-2016.
 */
public class GithubHandler {
    private GitHub github;
    private String oAuthToken;
    private List<GHRepository> repos;

    public GithubHandler() {

    }

    public void connectToGithub(String oAuthToken) throws IOException {
        this.oAuthToken = oAuthToken;
        github = GitHub.connectUsingOAuth(oAuthToken);
        repos = github.getMyself().listRepositories().asList();
        repos.forEach(c -> System.out.println(c.getFullName()));
    }
}
