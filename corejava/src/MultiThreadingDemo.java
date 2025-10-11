import model.TicketSystem;

public class MultiThreadingDemo {
    public static void main(String[] args) {
        MultiThreadingDemo demo = new MultiThreadingDemo();
        demo.threadDemo();
        demo.runnableDemo();
        demo.threadStateDemo();
    }

    static class CookingTask extends Thread {
        private final String task;

        CookingTask(String task) {
            this.task = task;
        }

        public void run() {
            System.out.println(task + " is being prepared by " + Thread.currentThread().getName());
        }
    }

    private void threadDemo() {
        new CookingTask("Pasta").start();
        new CookingTask("Salad").start();
    }

    private void runnableDemo() {
        new Thread(() -> System.out.println("Inline Lambda Runnable-1 is running")).start();
        new Thread(() -> System.out.println("Inline Lambda Runnable-2 is running")).start();
    }

    private void threadStateDemo() {
        TicketSystem.ticketSystem = new TicketSystem();
        TicketSystem.mainThread = new Thread(TicketSystem.ticketSystem);

        System.out.println("State after creating mainThread: " + TicketSystem.mainThread.getState());

        TicketSystem.mainThread.start();
        System.out.println("State after starting mainThread: " + TicketSystem.mainThread.getState());
    }
}
