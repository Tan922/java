package model.ticket;

public class TicketBooking implements Runnable {
    @Override
    public void run() {

        try {
            // Timed waiting
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of bookingThread while mainThread is waiting: " + TicketSystem.mainThread.getState());

        try {
            // Another timed waiting
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
