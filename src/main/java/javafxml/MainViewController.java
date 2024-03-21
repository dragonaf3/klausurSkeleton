package javafxml;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainViewController {

    @FXML
    private Label label;

    @FXML
    private void initialize() {
        // Initialisierungslogik hier (wenn nötig)
    }

    @FXML
    private void handleButtonClick() {
        label.setText("Button geklickt!");
    }
}