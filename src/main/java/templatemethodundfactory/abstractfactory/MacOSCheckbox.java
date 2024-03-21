package templatemethodundfactory.abstractfactory;

// Konkretes Produkt
public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in MacOS style");
    }
}
