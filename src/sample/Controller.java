package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    @FXML
    private TextField txtSonarScanner;
    @FXML
    private TextField txtSonarQubeServerIP;
    @FXML
    private TextField txtSonarQubeServerPort;
    @FXML
    private Button btnBrowseSonarScanner;
    @FXML
    private Button btnGo;
    @FXML
    private ComboBox cmbGithubRepository;
    @FXML
    private ComboBox cmbGithubPullRequest;
    @FXML
    private PasswordField pwfGithubToken;
    @FXML
    private PasswordField pwfSonarQubeToken;
    @FXML
    private CheckBox chkGithubRemind;
    @FXML
    private CheckBox chkSonarQubeRemind;

    @FXML
    private void openFileDialog(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File sonarScanner = fileChooser.showOpenDialog(new Stage());
        txtSonarScanner.setText(sonarScanner.getAbsolutePath());
    }
}
