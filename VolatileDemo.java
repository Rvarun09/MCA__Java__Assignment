class VolatileDemo extends Thread {
    volatile boolean running = true;

    public void run() {
        while (running) {
        }
        System.out.println("Stopped");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo obj = new VolatileDemo();
        obj.start();
        Thread.sleep(1000);
        obj.running = false;
    }
}
