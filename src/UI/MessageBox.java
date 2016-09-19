package UI;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageBox {
    public static void show(String infoMessage, String titleBar) {
        show(infoMessage, titleBar, null, AlertType.INFORMATION);
    }

    public static void show(String infoMessage, String titleBar, String headerMessage) {
        show(infoMessage, titleBar, titleBar, AlertType.INFORMATION);
    }

    public static void show(String infoMessage, String titleBar, AlertType alertType) {
        show(infoMessage, titleBar, null, alertType);
    }

    public static void show(String infoMessage, String titleBar, String headerMessage, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
}