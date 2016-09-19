package Classes;

import Interfaces.PersistencyHandler;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Properties;

/**
 * Created by Oscar on 19-9-2016.
 */
public class PropertiesHandler implements PersistencyHandler {

    private Properties properties;
    private File file;

    public PropertiesHandler(String path) throws IOException {
        properties = new Properties();
        file = new File(path);

        file.createNewFile();

        try (InputStream is = new FileInputStream(file)) {
            properties.load(is);
        }
    }

    @Override
    public String getGithubToken() {
        return getProperty("GithubToken");
    }

    @Override
    public void setGithubToken(String value) throws IOException {
        properties.setProperty("GithubToken", value);
        storeProperties();
    }

    @Override
    public String getSonarQubeToken() {
        return getProperty("SonarQubeToken");
    }

    @Override
    public void setSonarQubeToken(String value) throws IOException {
        properties.setProperty("SonarQubeToken", value);
        storeProperties();
    }

    @Override
    public String getSonarScannerLocation() {
        return getProperty("SonarScannerLocation");
    }

    @Override
    public void setSonarScannerLocation(String value) throws IOException {
        properties.setProperty("SonarScannerLocation", value);
        storeProperties();
    }

    @Override
    public String getSonarQubeServerIP() {
        return getProperty("SonarQubeServerIP");
    }

    @Override
    public void setSonarQubeServerIP(String value) throws IOException {
        properties.setProperty("SonarQubeServerIP", value);
        storeProperties();
    }

    @Override
    public String getSonarQubeServerPort() {
        return getProperty("SonarQubeServerPort");
    }

    @Override
    public void setSonarQubeServerPort(String value) throws IOException {
        properties.setProperty("SonarQubeServerPort", value);
        storeProperties();
    }

    private void storeProperties() throws IOException {
        try (OutputStream os = new FileOutputStream(file)) {
            properties.store(os, LocalDateTime.now().toString());
        }
    }

    private String getProperty(String key) {
        String s = properties.getProperty(key);
        return s != null ? s : "";
    }
}
