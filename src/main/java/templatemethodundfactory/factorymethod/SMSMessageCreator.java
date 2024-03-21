package templatemethodundfactory.factorymethod;

// Diese Klasse implementiert die Factory Methode, um konkrete Produkte zu erzeugen.
public class SMSMessageCreator extends MessageCreator {
    @Override
    public Message createMessage() {
        return new SMSMessage();
    }
}
