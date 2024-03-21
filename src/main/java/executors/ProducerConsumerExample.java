package executors;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerExample {

    private static final AtomicInteger resourceCount = new AtomicInteger(0);
    private static final Lock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();
    private static final int MAX_RESOURCES = 5;

    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (resourceCount.get() == MAX_RESOURCES) {
                        notFull.await(); // Warte, bis nicht voll
                    }
                    resourceCount.incrementAndGet();
                    System.out.println("Produziert, Anzahl der Ressourcen: " + resourceCount.get());
                    notEmpty.signal(); // Signalisiere, dass nicht leer
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (resourceCount.get() == 0) {
                        notEmpty.await(); // Warte, bis nicht leer
                    }
                    resourceCount.decrementAndGet();
                    System.out.println("Konsumiert, Anzahl der Ressourcen: " + resourceCount.get());
                    notFull.signal(); // Signalisiere, dass nicht voll
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());
        producerThread.start();
        consumerThread.start();
    }
}