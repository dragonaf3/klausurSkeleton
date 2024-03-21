package templatemethodundfactory.factorymethod;

//Die Fabrik kann ein interface oder eine abstrakte Klasse sein
public abstract class MessageCreator {
    // Die Factory Methode, die das Message-Objekt erzeugt.
    public abstract Message createMessage();

    // Die Methode, die mit dem Produkt arbeitet, bleibt für alle Creator gleich.
    public void sendMessage() {
        Message msg = createMessage();
        msg.send(); // Aufruf der Methode, die vom konkreten Produkt definiert wird.
    }
}