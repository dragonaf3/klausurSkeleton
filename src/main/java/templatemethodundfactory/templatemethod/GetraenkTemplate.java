package templatemethodundfactory.templatemethod;

public abstract class GetraenkTemplate {

    // Die Template-Methode, die den Algorithmus definiert
    public final void zubereiten() {
        wasserKochen();
        brauen();
        inTasseGiessen();
        zutatenHinzufuegen();
        sonderaktion();
    }

    // Diese Operationen sind für alle Unterklassen gleich und werden hier implementiert
    private void wasserKochen() {
        System.out.println("Wasser wird gekocht");
    }

    private void inTasseGiessen() {
        System.out.println("Getränk wird in die Tasse gegossen");
    }

    // Diese Operationen müssen von Unterklassen implementiert werden
    protected abstract void brauen();

    protected abstract void zutatenHinzufuegen();

    // Diese Operation ist optional
    protected void sonderaktion() {

    }
}
