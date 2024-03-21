package javafx;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.getLabel().textProperty().bind(model.zahlAlsStringProperty());
        view.getButton().setOnAction(e -> model.setZahl(model.getZahl() + 1));
    }
}
