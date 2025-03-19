import java.util.Random;

class Customer implements Runnable {
    private TicketBookingSystem bookingSystem;
    private String name;
    private Random random = new Random();

    public Customer(TicketBookingSystem bookingSystem, String name) {
        this.bookingSystem = bookingSystem;
        this.name = name;
    }

    @Override
    public void run() {
        int ticketsRequested = random.nextInt(5) + 1; // Искане за 1 до 5 билета
        bookingSystem.bookTicket(ticketsRequested, name);
    }
}