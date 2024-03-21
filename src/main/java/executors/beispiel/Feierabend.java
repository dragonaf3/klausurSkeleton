//package executors.beispiel;
//
///**
// * beendet einen Thread
// *
// * @author Doro
// */
//public class Feierabend implements Runnable {
//
//    private Thread t;
//
//    /**
//     * erstellt einen executors.beispiel.Feierabend für den angegebenen Thread
//     *
//     * @param t anzuhaltender Thread
//     */
//    public Feierabend(Thread t) {
//        this.t = t;
//    }
//
//    /**
//     * beendet des Thread nach angemessener Wartezeit
//     */
//    public void run() {
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//        }
//        t.interrupt();
//    }
//}
