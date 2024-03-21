package executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskExample {

    public static void main(String[] args) {
        // Erstelle einen ScheduledExecutorService mit einem Thread
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // Plane eine wiederkehrende Aufgabe, die alle 2 Sekunden ausgeführt wird
        scheduler.scheduleAtFixedRate(() ->
                System.out.println("Wiederkehrende Aufgabe ausgeführt um: " + System.currentTimeMillis()), 0, 2, TimeUnit.SECONDS
        );

        // Plane die Beendigung des ScheduledExecutorService nach 10 Sekunden
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("Scheduler wurde beendet.");
        }, 10, TimeUnit.SECONDS);
    }
}