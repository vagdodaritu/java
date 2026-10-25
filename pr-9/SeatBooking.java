class Cinema {
    private int seatsLeft = 5;
    private int booked = 0;
    synchronized boolean book(String name) {
        if (seatsLeft == 0) return false;
        seatsLeft--;
        booked++;
        System.out.println(name + " booked a seat");
        return true;
    }
    int getBooked() { return booked; }
    int getSeatsLeft() { return seatsLeft; }
}
public class SeatBooking {
    public static void main(String[] args) throws InterruptedException {
        Cinema cinema = new Cinema();
        Thread[] customers = new Thread[10];
        for (int i = 0; i < customers.length; i++) {
            final String name = "Customer-" + (i + 1);
            customers[i] = new Thread(() -> {
                if (!cinema.book(name)) System.out.println(name + " could not book: full");
            });
            customers[i].start();
        }
        for (Thread t : customers) t.join();
        System.out.println("Successful bookings: " + cinema.getBooked());
        System.out.println("Seats left: " + cinema.getSeatsLeft());
    }
}