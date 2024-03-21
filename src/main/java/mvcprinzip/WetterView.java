package mvcprinzip;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WetterView implements PropertyChangeListener {
    public WetterView() {
        // Die View könnte hier UI-Komponenten initialisieren.
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("temperatur".equals(evt.getPropertyName())) {
            System.out.println("Aktualisierte Temperatur: " + evt.getNewValue() + " Grad");
        }
    }
}
