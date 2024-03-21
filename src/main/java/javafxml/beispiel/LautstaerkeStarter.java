package javafxml.beispiel;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Startet die Lautstärkeregelung
 */
public class LautstaerkeStarter extends Application {
    @Override
    public void start(Stage primaryStage) {
        LautstaerkeController controller = new LautstaerkeController2(primaryStage);
        Parent lc = controller.getView();
        Scene scene = new Scene(lc, 320, 343);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Audio Configuration");
        primaryStage.show();
    }
}
