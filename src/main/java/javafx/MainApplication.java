package javafx;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        View view = new View();
        new Controller(model, view);
        view.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}