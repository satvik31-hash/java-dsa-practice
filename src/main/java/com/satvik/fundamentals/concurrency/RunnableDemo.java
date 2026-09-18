package com.satvik.fundamentals.concurrency;

/**
 * Running work on a second thread via {@link Runnable}.
 *
 * <p>Implementing {@code Runnable} rather than extending {@code Thread} keeps the task
 * separate from the thread that runs it, so the same task can be handed to an executor.
 */
public final class RunnableDemo {

    /** A task that counts to {@code limit}, reporting each step. */
    static final class CountingTask implements Runnable {

        private final String name;
        private final int limit;

        CountingTask(String name, int limit) {
            this.name = name;
            this.limit = limit;
        }

        @Override
        public void run() {
            for (int i = 1; i <= limit; i++) {
                System.out.println(name + ": " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(name + " interrupted");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(new CountingTask("Worker thread", 5));
        worker.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread: " + i);
            Thread.sleep(100);
        }

        worker.join();
        System.out.println("Both threads finished.");
    }
}
