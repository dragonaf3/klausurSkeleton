package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelTasksExample {

    public static void main(String[] args) {
        // Erstelle einen ExecutorService mit einem Thread-Pool
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Liste zur Speicherung der Future-Objekte, die die Ergebnisse repräsentieren
        List<Future<String>> resultList = new ArrayList<>();

        // Erstelle und reiche mehrere Callable-Aufgaben beim ExecutorService ein
        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            Future<String> result = executor.submit(() -> {
                Thread.sleep(1000); // Simuliere eine Aufgabe, die Zeit benötigt
                return "Ergebnis der Aufgabe " + taskNumber;
            });
            resultList.add(result);
        }

        // Gehe durch die Ergebnisse der Aufgaben
        for (Future<String> future : resultList) {
            try {
                // Warte auf das Ergebnis und drucke es aus
                System.out.println(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Beende den ExecutorService
        executor.shutdown();
    }
}

