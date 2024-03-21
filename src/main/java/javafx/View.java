package javafx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
    private Button button = new Button("Erhöhe");
    private Label label = new Label();

    public void start(Stage stage) {
        VBox root = new VBox(10, label, button);
        Scene scene = new Scene(root, 400, 200);

        stage.setTitle("MVC Beispiel mit JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public Button getButton() {
        return button;
    }

    public Label getLabel() {
        return label;
    }
}
