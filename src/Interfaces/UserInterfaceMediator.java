package Interfaces;

import java.util.List;

/**
 * Created by Oscar on 19-9-2016.
 */
public interface UserInterfaceMediator {
    String getGithubToken();

    void setGithubToken(String value);

    String getSonarQubeToken();

    void setSonarQubeToken(String value);

    String getSonarScannerLocation();

    void setSonarScannerLocation(String value);

    String getSonarQubeServerIP();

    void setSonarQubeServerIP(String value);

    String getSonarQubeServerPort();

    void setSonarQubeServerPort(String value);

    boolean getGithubTokenRemind();

    void setGithubTokenRemind(boolean value);

    boolean getSonarQubeTokenRemind();

    void setSonarQubeTokenRemind(boolean value);

    void fillRepositoryComboBox(List<String> repositories);

    void fillPullRequestComboBox(List<String> pullRequests);

    void popUpErrorMessage(String message, String title);

    void addListener(UIListener listener);
}
