package templatemethodundfactory.abstractfactory;

public class Demo {
    public static void main(String[] args) {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            factory = new WinFactory();
        } else {
            factory = new MacOSFactory();
        }

        Application app = new Application(factory);
        app.paint();
    }
}