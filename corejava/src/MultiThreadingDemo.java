
public class MultiThreadingDemo {
    public static void main(String[] args) {
        MultiThreadingDemo demo = new MultiThreadingDemo();
        demo.threadDemo();
        demo.runnableDemo();
    }

    static class CookingTask extends Thread {
        private final String task;

        CookingTask(String task) {
            this.task = task;
        }

        public void run() {
            System.out.println(task + " is being prepared by " +
                    Thread.currentThread().getName());
        }
    }

    private void threadDemo() {
        Thread t1 = new CookingTask("Pasta");
        Thread t2 = new CookingTask("Salad");
        Thread t3 = new CookingTask("Dessert");
        Thread t4 = new CookingTask("Rice");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private void runnableDemo() {
        Runnable r1 = () -> System.out.println("Runnable r1 is running");
        Runnable r2 = () -> System.out.println("Runnable r2 is running");
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
