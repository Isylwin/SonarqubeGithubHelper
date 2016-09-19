package Interfaces;

import java.io.IOException;

/**
 * Created by Oscar on 19-9-2016.
 */
public interface PersistencyHandler {
    String getGithubToken();

    void setGithubToken(String value) throws IOException;

    String getSonarQubeToken();

    void setSonarQubeToken(String value) throws IOException;

    String getSonarScannerLocation();

    void setSonarScannerLocation(String value) throws IOException;

    String getSonarQubeServerIP();

    void setSonarQubeServerIP(String value) throws IOException;

    String getSonarQubeServerPort();

    void setSonarQubeServerPort(String value) throws IOException;
}
