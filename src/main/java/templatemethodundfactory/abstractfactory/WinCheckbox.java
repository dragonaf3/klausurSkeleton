package templatemethodundfactory.abstractfactory;

// Konkretes Produkt
public class WinCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style");
    }
}
