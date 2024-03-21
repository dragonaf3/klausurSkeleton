package templatemethodundfactory.templatemethod;

public class Kaffee extends GetraenkTemplate {

    @Override
    protected void brauen() {
        System.out.println("Kaffee wird durch den Filter gegossen");
    }

    @Override
    protected void zutatenHinzufuegen() {
        System.out.println("Milch und Zucker hinzufügen");
    }

    @Override
    protected void sonderaktion() {
        System.out.println("Warmhalten");
    }
}
