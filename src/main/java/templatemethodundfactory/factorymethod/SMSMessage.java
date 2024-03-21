package templatemethodundfactory.factorymethod;

// Implementierung des konkreten Produktes
public class SMSMessage implements Message {
    public void send() {
        System.out.println("Sending SMS message...");
    }
}
