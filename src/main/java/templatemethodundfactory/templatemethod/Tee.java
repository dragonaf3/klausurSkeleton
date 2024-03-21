package templatemethodundfactory.templatemethod;

public class Tee extends GetraenkTemplate {

    @Override
    protected void brauen() {
        System.out.println("Tee wird gezogen");
    }

    @Override
    protected void zutatenHinzufuegen() {
        System.out.println("Zitrone hinzufügen");
    }
}

