package javafxml.beispiel;

import java.io.IOException;

import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;

/**
 * LautstärkeController mit FXML-Oberfläche
 * @author Doro
 *
 */
public class LautstaerkeController2 extends LautstaerkeController
{
	@FXML private Slider slider; //@FXML --> wird vom FXMLLoader initialisiert
	@FXML private CheckBox stummCheckBox;
	@FXML private ChoiceBox<String> stilChoiceBox;
	@FXML private Text dbText;

	/**
	 * erzeugt einen neuen Controller mit LautstaerkeOberflaeche2
	 * @param primaryStage Das Hauptfenster der Anwendung
	 */
	public LautstaerkeController2(Stage primaryStage) {
		super(primaryStage);
		try {
			FXMLLoader loader = 
				new FXMLLoader(getClass().
					getResource("/LautstaerkeOberflaeche2.fxml"));
			loader.setController(this);
			Parent v = loader.load();
			
			setView(v);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//wird nach der Erzeugung der Oberflächen-Objekte vom FXMLLoader aufgerufen
	@FXML private void initialize()
	{
		stilChoiceBox.getSelectionModel().selectFirst();
		dbText.textProperty().bind(getModel().lautstaerkeProperty().asString().concat(" dB"));
		slider.valueProperty().bindBidirectional(getModel().lautstaerkeProperty());
		stummCheckBox.selectedProperty().bindBidirectional(getModel().stummProperty());
		stilChoiceBox.valueProperty().addListener((Observable e)-> aendern(stilChoiceBox.getValue()));
	}
}
