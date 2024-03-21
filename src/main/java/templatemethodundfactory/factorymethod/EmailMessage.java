package templatemethodundfactory.factorymethod;

// Implementierung des konkreten Produktes
public class EmailMessage implements Message {
    public void send() {
        System.out.println("Sending email message...");
    }
}

