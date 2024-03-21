package templatemethodundfactory.templatemethod;

public class GetraenkDemo {

    public static void main(String[] args) {
        GetraenkTemplate tee = new Tee();
        GetraenkTemplate kaffee = new Kaffee();

        System.out.println("Tee wird zubereitet:");
        tee.zubereiten();

        System.out.println("\nKaffee wird zubereitet:");
        kaffee.zubereiten();
    }
}