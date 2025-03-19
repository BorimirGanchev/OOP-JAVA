class TicketBookingSystem {
    private int availableTickets;

    public TicketBookingSystem(int tickets) {
        this.availableTickets = tickets;
    }

    public synchronized boolean bookTicket(int ticketsRequested, String customerName) {
        if (ticketsRequested <= availableTickets) {
            availableTickets -= ticketsRequested;
            System.out.println(customerName + " успешно резервира " + ticketsRequested + " билет(а). Оставащи билети: " + availableTickets);
            return true;
        } else {
            System.out.println(customerName + " неуспешен опит за резервиране на " + ticketsRequested + " билет(а). Остават само " + availableTickets);
            return false;
        }
    }
}