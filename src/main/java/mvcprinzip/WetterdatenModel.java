package mvcprinzip;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WetterdatenModel {
    private double temperatur;
    private PropertyChangeSupport support;

    public WetterdatenModel() {
        support = new PropertyChangeSupport(this);
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        double alteTemperatur = this.temperatur;
        this.temperatur = temperatur;
        support.firePropertyChange("temperatur", alteTemperatur, temperatur);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
