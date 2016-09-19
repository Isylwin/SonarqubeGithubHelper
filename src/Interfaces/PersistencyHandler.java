package Interfaces;

/**
 * Created by Oscar on 19-9-2016.
 */
public interface PersistencyHandler {
    String getGithubToken();
    String getSonarQubeToken();
    String getSonarScannerLocation();
    String getSonarQubeServerIP();
    String getSonarQubeServerPort();

    void setGithubToken();
    void setSonarQubeToken();
    void setSonarScannerLocation();
    void setSonarQubeServerIP();
    void setSonarQubeServerPort();
}
