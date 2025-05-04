import java.util.ArrayList;
import java.util.List;



abstract class ItineraryBuilder {
    protected Itinerary itinerary;

    public ItineraryBuilder() {
        this.itinerary = new Itinerary();
    }

    public abstract ItineraryBuilder addFlight(String flight);
    public abstract ItineraryBuilder addHotel(String hotel);
     public abstract ItineraryBuilder addActivity(String activity);
    public abstract ItineraryBuilder addTransport(String transport);

    public Itinerary build() {
        validate();
        return itinerary;
    }

    protected void validate() {
       
        if (itinerary.getFlights().isEmpty() && itinerary.getHotels().isEmpty()) {
            throw new IllegalStateException("not enougth info (at least one hotel/flight).");
        }
    }
}


class BusinessItineraryBuilder extends ItineraryBuilder {
    @Override
    public ItineraryBuilder addFlight(String flight) {
        itinerary.getFlights().add(flight);
        return this;
    }

    @Override
    public ItineraryBuilder addHotel(String hotel) {
        itinerary.getHotels().add(hotel);
        return this;
    }

    @Override
    public ItineraryBuilder addActivity(String activity) {
       
        return this;
    }

    @Override
    public ItineraryBuilder addTransport(String transport) {
        itinerary.getTransport().add(transport);
        return this;
    }
}

class VacationItineraryBuilder extends ItineraryBuilder {
    @Override
    public ItineraryBuilder addFlight(String flight) {
        itinerary.getFlights().add(flight);
        return this;
    }

    @Override
    public ItineraryBuilder addHotel(String hotel) {
        itinerary.getHotels().add(hotel);
        return this;
    }

    @Override
    public ItineraryBuilder addActivity(String activity) {
        itinerary.getActivities().add(activity);
        return this;
    }

    @Override
    public ItineraryBuilder addTransport(String transport) {
        itinerary.getTransport().add(transport);
        return this;
    }
}


class Director {
    private ItineraryBuilder builder;

    public Director(ItineraryBuilder builder) {
        this.builder = builder;
    }

    public Itinerary constructBusinessTrip() {
        return builder.addFlight("Flight 1")
                      .addHotel("Hotel 1")
                      .addTransport("Taxi")
                      .build();
    }

    public Itinerary constructVacation() {
        return builder.addFlight("Flight 2")
                      .addHotel("Resort 2")
                      .addActivity("Chilling")
                      .addTransport(" Car")
                      .build();
    }
}


class Itinerary {
    private List<String> flights = new ArrayList<>();
    private List<String> hotels = new ArrayList<>();
    private List<String> activities = new ArrayList<>();
      private List<String> transport = new ArrayList<>();

    public List<String> getFlights() {
        return flights;
    }
public List<String> getHotels() {
        return hotels;
    }

   public List<String> getActivities() {
        return activities;
    }
public List<String> getTransport() {
        return transport;
    }

     @Override
    public String toString() {
         return "Itinerary{" +"flights=" + flights + ", hotels=" + hotels + ", activities=" + activities + ", transport=" + transport +'}';
    }
}
public class main {
    public static void main1(String[] args) {
        
        ItineraryBuilder businessBuilder = new BusinessItineraryBuilder();
        Director director = new Director(businessBuilder);
        Itinerary businessTrip = director.constructBusinessTrip();
        System.out.println("Business Trip: " + businessTrip);

       
        ItineraryBuilder vacationBuilder = new VacationItineraryBuilder();
        director = new Director(vacationBuilder);
        Itinerary vacation = director.constructVacation();
        System.out.println("Vacation: " + vacation);
    }
}

