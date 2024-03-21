package javafx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
    private final SimpleIntegerProperty zahl = new SimpleIntegerProperty();
    private final SimpleStringProperty zahlAlsString = new SimpleStringProperty();

    public Model() {
        zahlAlsString.bind(zahl.asString().concat(" ist die aktuelle Zahl"));
    }

    public final int getZahl() {
        return zahl.get();
    }

    public final void setZahl(int newValue) {
        zahl.set(newValue);
    }

    public StringProperty zahlAlsStringProperty() {
        return zahlAlsString;
    }
}
