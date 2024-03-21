package templatemethodundfactory.factorymethod;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        MessageCreator creator;

        // Entscheidung, welcher Creator basierend auf einer Bedingung verwendet werden soll.
        String messageType = "EMAIL"; // Angenommen, diese Variable wird irgendwie gesetzt.

        if ("EMAIL".equals(messageType)) {
            creator = new EmailMessageCreator();
        } else {
            creator = new SMSMessageCreator();
        }

        creator.sendMessage(); // Sendet eine Nachricht mit dem gewählten Creator.
    }
}
