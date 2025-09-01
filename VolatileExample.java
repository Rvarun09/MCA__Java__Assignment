public class VolatileExample {

    private static volatile boolean keepRunning = true;

    public static void main(String[] args) {
        System.out.println("Main thread is starting the worker thread.");

        Thread worker = new Thread(() -> {
            while (keepRunning) {
            }
            System.out.println("Worker thread has stopped.");
        });

        worker.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Main thread is setting 'keepRunning' to false.");
        keepRunning = false;
    }
    
}
