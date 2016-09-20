package UI;

import Classes.GithubHandler;
import Classes.PropertiesHandler;
import Interfaces.PersistencyHandler;
import Interfaces.UIListener;
import Interfaces.UserInterfaceMediator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application implements UIListener {

    private PersistencyHandler persistencyHandler;
    private UserInterfaceMediator mainUI;
    private GithubHandler githubHandler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        persistencyHandler = new PropertiesHandler("config.properties");
        githubHandler = new GithubHandler();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = loader.load();
        mainUI = loader.getController();
        mainUI.addListener(this);

        loadFromPersistency();

        primaryStage.setTitle("SonarQube Helper");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void loadFromPersistency() {
        mainUI.setSonarScannerLocation(persistencyHandler.getSonarScannerLocation());
        mainUI.setSonarQubeServerIP(persistencyHandler.getSonarQubeServerIP());
        mainUI.setSonarQubeServerPort(persistencyHandler.getSonarQubeServerPort());

        String githubToken = persistencyHandler.getGithubToken();
        String sonarQubeToken = persistencyHandler.getSonarQubeToken();

        mainUI.setGithubToken(githubToken);
        mainUI.setSonarQubeToken(sonarQubeToken);

        mainUI.setSonarQubeTokenRemind(!sonarQubeToken.equals(""));

        if (!githubToken.equals("")) {
            mainUI.setGithubTokenRemind(true);

            githubTokenChanged(githubToken);
            //fillRepositoryComboBox(null);
        }
    }

    public void saveToPersistency() {
        try {
            persistencyHandler.setGithubToken(mainUI.getGithubToken());
            persistencyHandler.setSonarQubeToken(mainUI.getSonarQubeToken());
            persistencyHandler.setSonarQubeServerIP(mainUI.getSonarQubeServerIP());
            persistencyHandler.setSonarQubeServerPort(mainUI.getSonarQubeServerPort());
            persistencyHandler.setSonarScannerLocation(mainUI.getSonarScannerLocation());
        } catch (IOException e) {
            e.printStackTrace(System.err);
            mainUI.popUpErrorMessage(e.getMessage(), "Exception");
        }
    }

    @Override
    public void githubTokenChanged(String token) {
        if (token.length() < 40)
            return;

        try {
            githubHandler.connectToGithub(token);

            mainUI.fillRepositoryComboBox(githubHandler.getRepositories());
        } catch (IOException e) {
            e.printStackTrace(System.err);
            mainUI.popUpErrorMessage(e.getMessage(), "Exception");
        }
    }

    @Override
    public void repositoryChanged(String repository) {
        try {
            mainUI.fillPullRequestComboBox(githubHandler.getPullRequests(repository));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
