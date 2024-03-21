package mvcprinzip;

public class WetterController {
    private WetterdatenModel model;
    private WetterView view;

    public WetterController(WetterdatenModel model, WetterView view) {
        this.model = model;
        this.view = view;
        this.model.addPropertyChangeListener(view);
    }

    public void setTemperatur(double temperatur) {
        model.setTemperatur(temperatur);
    }
}
