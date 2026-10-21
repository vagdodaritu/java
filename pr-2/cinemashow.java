

public class cinemashow {
  

    // Private variables
    private String title;
    private int seatsAvailable;

    // Final capacity
    private final int capacity;

    // Static variable
    private static int totalBooked = 0;

    // Constructor with title and capacity
    public cinemashow(String title, int capacity) {

        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    // Constructor with only title
    public cinemashow(String title) {
        this(title, 100);
    }

    // Book seats
    public boolean book(int n) {

        if (n <= seatsAvailable) {
            seatsAvailable = seatsAvailable - n;
            totalBooked = totalBooked + n;
            return true;
        } else {
            return false;
        }
    }

    // Cancel seats
    public void cancel(int n) {

        seatsAvailable = seatsAvailable + n;

        // Don't allow seats above capacity
        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    // Getter for available seats
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    // Static getter
    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        cinemashow movie = new cinemashow("Avengers", 50);

        // Book 20 seats
        System.out.println("Book 20: " + movie.book(20));
        System.out.println("Seats available: " + movie.getSeatsAvailable());

        // Book 15 seats
        System.out.println("Book 15: " + movie.book(15));
        System.out.println("Seats available: " + movie.getSeatsAvailable());

        // Try to book more than available
        System.out.println("Book 20: " + movie.book(20));
        System.out.println("Seats available: " + movie.getSeatsAvailable());

        // Cancel 10 seats
        movie.cancel(10);
        System.out.println("Cancel 10");
        System.out.println("Seats available: " + movie.getSeatsAvailable());

        // Book 10 seats
        System.out.println("Book 10: " + movie.book(10));
        System.out.println("Seats available: " + movie.getSeatsAvailable());

        // Total successful bookings
        System.out.println("Total booked: " + cinemashow.getTotalBooked());
    }
}

