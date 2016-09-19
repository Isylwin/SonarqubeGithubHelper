package UI;

import Classes.MessageBox;
import Interfaces.PersistencyHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainWindowController {
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

    private PersistencyHandler handler;

    @FXML
    private void openFileDialog(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Please select the Sonar Scanner executable");
        fileChooser.setInitialDirectory(new File("C:/"));

        File sonarScanner = fileChooser.showOpenDialog(new Stage());
        txtSonarScanner.setText(sonarScanner.getAbsolutePath());
    }

    public void setPersistencyHandler(PersistencyHandler handler) {
        this.handler = handler;
    }

    public void loadFromPersistency() {
        txtSonarScanner.setText(handler.getSonarScannerLocation());
        txtSonarQubeServerIP.setText(handler.getSonarQubeServerIP());
        txtSonarQubeServerPort.setText(handler.getSonarQubeServerPort());
        pwfGithubToken.setText(handler.getGithubToken());
        pwfSonarQubeToken.setText(handler.getSonarQubeToken());

        chkGithubRemind.setSelected(!pwfGithubToken.getText().equals(""));
        chkSonarQubeRemind.setSelected(!pwfSonarQubeToken.getText().equals(""));
    }

    public void saveToPersistency() {
        try {
            handler.setGithubToken(pwfGithubToken.getText());
            handler.setSonarQubeToken(pwfSonarQubeToken.getText());
            handler.setSonarQubeServerIP(txtSonarQubeServerIP.getText());
            handler.setSonarQubeServerPort(txtSonarQubeServerPort.getText());
            handler.setSonarScannerLocation(txtSonarScanner.getText());
        } catch (IOException e) {
            e.printStackTrace(System.err);
            MessageBox.show(e.getMessage(), "Exception", Alert.AlertType.ERROR);
        }
    }
}
