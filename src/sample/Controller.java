package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private TextField txtSonarScanner;
    @FXML
    private TextField txtSonarQubeServer;
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

    }
}
