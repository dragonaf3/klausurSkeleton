package executors.beispiel;

/**
 * Käufer in der Ein-Buch-executors.beispiel.Buchhandlung.
 */
public class Kaeufer {
    /**
     * die executors.beispiel.Buchhandlung
     */
    private Buchhandlung handlung;

    /**
     * erstellt einen Käufer, der in der angegebenen executors.beispiel.Buchhandlung "einkauft"
     *
     * @param handlung die executors.beispiel.Buchhandlung, in der this einkauft
     */
    public Kaeufer(Buchhandlung handlung) {
        this.handlung = handlung;
    }

    /**
     * Der Käufer nimmt nacheinander viele Bücher aus dem Regal
     *
     * @param insgesamt Anzahl der zu kaufenden Bücher
     */
    public void kaufen(int insgesamt) {
        int i = 0;
        while (i < insgesamt && !handlung.isGeschlossen()) {
            int anzahl;
            //synchronized(this.handlung)
            handlung.getZugriffAufAnzahl().lock();
            anzahl = handlung.getAnzahlBuecher();
            while (anzahl <= 0) {
                try {
                    handlung.getAnzahlIstGroesserAlsNull().await();
                } catch (InterruptedException e) {
                    handlung.getZugriffAufAnzahl().unlock();
                    break;
                }
                anzahl = handlung.getAnzahlBuecher();
            }
            anzahl = anzahl - 1;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                handlung.getZugriffAufAnzahl().unlock();
                break;
            }
            handlung.setAnzahlBuecher(anzahl);
            handlung.getZugriffAufAnzahl().unlock();
            System.out.println("executors.beispiel.Kaeufer: " + anzahl);
            i++;
        }
        System.out.println("Käufer verlässt den Laden");
    }
}