package Practice;
class MyThread implements Runnable {
    public void run() {
        // Code executed by the thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread is running: " + i);
            try {
                Thread.sleep(1000); // pause for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}








public class RbleInterface {
    public static void main(String[] args) {
        // Create object of MyThread
        MyThread obj = new MyThread();
        // Create thread using Runnable object
        Thread t = new Thread(obj);
        // Start the thread
        t.start();
        // Main thread execution
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread: " + i);
        }
    }
}
