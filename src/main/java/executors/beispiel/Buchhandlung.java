package executors.beispiel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Diese Klasse simuliert eine Buchandlung als Test für Thread-Programmierung.
 * Leider gibt es hier nur ein Buch zu kaufen, sodass nur die Anzahl der im Regal
 * stehenden Exemplare des Buches interessant ist.
 */
public class Buchhandlung {

    private ReentrantLock zugriffAufAnzahl = new ReentrantLock();
    private Condition anzahlIstGroesserAlsNull = zugriffAufAnzahl.newCondition();

    /**
     * @return the anzahlIstGroesserAlsNull
     */
    protected Condition getAnzahlIstGroesserAlsNull() {
        return anzahlIstGroesserAlsNull;
    }

    /**
     * @return the zugriffAufAnzahl
     */
    public ReentrantLock getZugriffAufAnzahl() {
        return zugriffAufAnzahl;
    }

    /**
     * Anzahl der Bücher im Regal
     */
    private int anzahlBuecher = 0;
    /**
     * ob die executors.beispiel.Buchhandlung geschlossen ist oder nicht
     */
    private boolean geschlossen = false;

    /**
     * @return true, wenn die executors.beispiel.Buchhandlung geschlossen ist
     */
    public boolean isGeschlossen() {
        return geschlossen;
    }

    /**
     * schließt oder öffnet die executors.beispiel.Buchhandlung
     *
     * @param geschlossen true = geschlossen, false = offen
     */
    public void setGeschlossen(boolean geschlossen) {
        this.geschlossen = geschlossen;
    }

    /**
     * liefert die Anzahl der im Regal stehenden Bücher
     *
     * @return Anzahl der Bücher im Regal
     */
    public int getAnzahlBuecher() {
        return anzahlBuecher;
    }

    /**
     * ändert die Anzahl der Bücher im Regal
     *
     * @param anzahlBuecher neue Anzahl Bücher
     */
    public void setAnzahlBuecher(int anzahlBuecher) {
        this.anzahlBuecher = anzahlBuecher;
    }

    /**
     * stellt nacheinander insgesamt viele Bücher ins Regal
     */
    public void auffuellen() {
        int anzahl;
        getZugriffAufAnzahl().lock();
        anzahl = this.getAnzahlBuecher();
        anzahl = anzahl + 1;
        this.setAnzahlBuecher(anzahl);
        if (anzahl > 0) anzahlIstGroesserAlsNull.signalAll();
        getZugriffAufAnzahl().unlock();
        System.out.println("im Regal: " + anzahl);
    }

    /**
     * schliesst die executors.beispiel.Buchhandlung nach der angegebenen Wartezeit
     *
     * @param wartezeit Wartezeit in Millisekunden
     */
    public void schliessen(int wartezeit) {
        try {
            Thread.sleep(wartezeit);
        } catch (InterruptedException e) {
        }
        this.setGeschlossen(true);
    }

    /**
     * lässt Buchhändler und Käufer arbeiten
     *
     * @param args wird nicht benutzt
     */
    public static void main(String[] args) {
        Buchhandlung zauberbuch = new Buchhandlung();
        Kaeufer kaeufer = new Kaeufer(zauberbuch);

        Runnable kaeuferTask = () -> kaeufer.kaufen(100);

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.submit(kaeuferTask);
        }

        ScheduledExecutorService serviceOhneSchleifen = Executors.newScheduledThreadPool(0);
        Runnable zauberTask = () -> zauberbuch.auffuellen();
        Future<?> verkaeuferEnde;
        verkaeuferEnde = serviceOhneSchleifen.scheduleAtFixedRate(zauberTask, 0, 5, TimeUnit.MILLISECONDS);
        Future<Integer> ergebnis = serviceOhneSchleifen.schedule(() -> {
            verkaeuferEnde.cancel(false);
            service.shutdownNow();
            return zauberbuch.getAnzahlBuecher();
        }, 3, TimeUnit.SECONDS);
        System.out.println("Zauber, zauber, zauber...");
        try {
            System.out.println("Anzahl der Bücher zu Ladenschluss: " + ergebnis.get());
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
		
/*		Runnable feierabend = () -> buchUndZeitschrift.schliessen(200);
		Thread tf = new Thread(feierabend);
		tf.start();
*/		
/*		Runnable feierabend2 = new executors.beispiel.Feierabend(Thread.currentThread());
		Thread tf2 = new Thread(feierabend2);
		tf2.start();
*/
    }

}










