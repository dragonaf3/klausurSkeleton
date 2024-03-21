package javafxml.beispiel;

import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Startpunkt der Lautstärkeregelungsanwendung und Controller für
 * die Ereignisse der Oberfläche
 *
 * @author Doro
 */
public abstract class LautstaerkeController {
    /**
     * Das Model mit den aktuellen Daten der Lautstärke
     */
    private LautstaerkeModel model;
    /**
     * Die View, die die aktuelle Lautsärke anzeigt
     */
    private Parent view;
    /**
     * Das Hauptfenster der Anwendung
     */
    private Stage stage;

    /**
     * erstellt einen neuen Controller mit LautstaerkeModel
     *
     * @param primaryStage das Hauptfenster der Anwendung
     */
    public LautstaerkeController(Stage primaryStage) {
        this.stage = primaryStage;
        model = new LautstaerkeModel();
    }

    /**
     * Ereignisbehandlung für die Auswahl einer neuen
     * Musikrichtung
     *
     * @param selected Index der gewählten Musikrichtung
     */
    protected void aendern(String selected) {
        model.laustaerkeAnStilAnpassen(selected);
    }

    /**
     * Schließen des Fensters
     */
    public void schliessen() {
        stage.close();
    }

    /**
     * gibt die aktuell angezeigte Oberfläche zurück
     *
     * @return die aktuell angezeigte Oberfläche
     */
    public Parent getView() {
        return this.view;
    }

    /**
     * setzt die View dieses Controllers
     *
     * @param view die aktuelle View
     */
    protected void setView(Parent view) {
        this.view = view;
    }

    /**
     * gibt das Model dieses Controllers zurück
     *
     * @return das aktuelle LautstaerkeModel
     */
    public LautstaerkeModel getModel() {
        return this.model;
    }
}
