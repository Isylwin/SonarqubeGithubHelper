package UI;

import Interfaces.UserInterfaceMediator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable, UserInterfaceMediator {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pwfGithubToken.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {

            }
        });
    }

    @FXML
    private void openFileDialog(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Please select the Sonar Scanner executable");
        fileChooser.setInitialDirectory(new File("C:/"));

        File sonarScanner = fileChooser.showOpenDialog(new Stage());
        txtSonarScanner.setText(sonarScanner.getAbsolutePath());
    }

    private void fillRepositoryComboBox(ObservableList repos) {
        cmbGithubRepository.setItems(repos);
    }

    @Override
    public String getGithubToken() {
        return pwfGithubToken.getText();
    }

    @Override
    public void setGithubToken(String value) {
        pwfGithubToken.setText(value);
    }

    @Override
    public String getSonarQubeToken() {
        return pwfSonarQubeToken.getText();
    }

    @Override
    public void setSonarQubeToken(String value) {
        pwfSonarQubeToken.setText(value);
    }

    @Override
    public String getSonarScannerLocation() {
        return txtSonarScanner.getText();
    }

    @Override
    public void setSonarScannerLocation(String value) {
        txtSonarScanner.setText(value);
    }

    @Override
    public String getSonarQubeServerIP() {
        return txtSonarQubeServerIP.getText();
    }

    @Override
    public void setSonarQubeServerIP(String value) {
        txtSonarQubeServerIP.setText(value);
    }

    @Override
    public String getSonarQubeServerPort() {
        return txtSonarQubeServerPort.getText();
    }

    @Override
    public void setSonarQubeServerPort(String value) {
        txtSonarQubeServerPort.setText(value);
    }

    @Override
    public boolean getGithubTokenRemind() {
        return chkGithubRemind.isSelected();
    }

    @Override
    public void setGithubTokenRemind(boolean value) {
        chkGithubRemind.setSelected(value);
    }

    @Override
    public boolean getSonarQubeTokenRemind() {
        return chkSonarQubeRemind.isSelected();
    }

    @Override
    public void setSonarQubeTokenRemind(boolean value) {
        chkSonarQubeRemind.setSelected(value);
    }

    @Override
    public void popUpErrorMessage(String message, String title) {
        MessageBox.show(message, title, Alert.AlertType.ERROR);
    }
}
