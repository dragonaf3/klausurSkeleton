package javafxml.beispiel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Model-Klasse für die Laustärkeregelung
 * @author Doro
 */
public class LautstaerkeModel {
	/**
	 * Minimal einstellbare Lautstärke
	 * @return Minimal einstellbare Lautstärke
	 */
	public int getMinLautstaerke() {
		return 30;
	}

	/**
	 * Maximal einstellbare Lautstärke
	 * @return Maximal einstellbare Lautstärke
	 */
	public int getMaxLautstaerke() {
		return 160;
	}

	/**
	 * aktuelle Lautstärke
	 * @return aktuelle Lautstärke
	 */
	public int getLautstaerke() {
		return laustaerke.get();
	}

	/**
	 * aktuelle Lautstärke setzen
	 * @param laustaerke neue Lautsärke
	 */
	public void setLautstaerke(int laustaerke) {
		this.laustaerke.set(laustaerke);
	}
	
	public IntegerProperty lautstaerkeProperty()
	{
		return this.laustaerke;
	}

	/**
	 * Stummschaltung
	 * @return true = stumm
	 */
	public boolean isStumm() {
		return stumm.get();
	}

	/**
	 * Stummschaltung setzen
	 * @param stumm true, wenn stumm geschaltet werden soll
	 */
	public void setStumm(boolean stumm) {
		this.stumm.set(stumm);
	}
	
	public BooleanProperty stummProperty()
	{
		return this.stumm;
	}

	/**
	 * Lautsärke in Dezibel
	 */
	private IntegerProperty laustaerke = new SimpleIntegerProperty(50);
	/**
	 * true, wenn die Lautsprecher stumm geschaltet sind
	 */
	private BooleanProperty stumm = new SimpleBooleanProperty(false);
	
	/**
	 * Balance zwischen den beiden Lautsprechern; eine Zahl zwischen
	 * 0 und 1: 0 = linker Lautsprecher aus, der rechte hat volle Lautstärke,
	 * 1: umgekehrt
	 */
	private ReadOnlyDoubleWrapper balance = new ReadOnlyDoubleWrapper(0.5);
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance.get();
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		if(balance >= 0 && balance <= 1)
			this.balance.set(balance);
	}
	
	public ReadOnlyDoubleProperty balanceProperty()
	{
		return this.balance.getReadOnlyProperty();
	}

	/**
	 * Liste einiger Musikstile
	 */
	private ObservableList<String> stile = 
			FXCollections.observableArrayList("Chamber", "Country", "Cowbell", 
					"Metal", "Polka", "Rock");

	/**
	 * Liste der verfügbaren Musikrichtungen
	 * @return Liste der verfügbaren Musikrichtungen
	 */
	public ObservableList<String> getStile() {
		return stile;
	}
	
	/**
	 * Einstellen der Laustärke bei Auswahl einer neuen 
	 * Musikrichtung
	 * @param selected gewählte Musikrichtung
	 */
	public void laustaerkeAnStilAnpassen(String selected) {
		switch (selected) {
		case "Chamber":
			this.setLautstaerke(80);
			break;
		case "Country":
			this.setLautstaerke(100);
			break;
		case "Cowbell":
			this.setLautstaerke(150);
			break;
		case "Metal":
			this.setLautstaerke(140);
			break;
		case "Polka":
			this.setLautstaerke(120);
			break;
		case "Rock":
			this.setLautstaerke(130);
		}
		//TODO: entfernen, ist ausschließlich zum Testen in
		// der Vorlesung:
		System.out.println("Lautstärke geändert: " + selected + " - " + this.getLautstaerke());
	}

}
