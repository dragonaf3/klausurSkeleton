package mvcprinzip;

public class Demo {
    public static void main(String[] args) {
        WetterdatenModel model = new WetterdatenModel();
        WetterView view = new WetterView();
        WetterController controller = new WetterController(model, view);

        controller.setTemperatur(22.5);
        controller.setTemperatur(23.0);
    }
}