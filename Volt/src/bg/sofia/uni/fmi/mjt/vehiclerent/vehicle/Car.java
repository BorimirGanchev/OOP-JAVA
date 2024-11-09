package bg.sofia.uni.fmi.mjt.vehiclerent.vehicle;

import bg.sofia.uni.fmi.mjt.vehiclerent.exception.InvalidRentingPeriodException;

import java.time.Duration;
import java.time.LocalDateTime;

public class Car extends Vehicle {
    private static final short PRICE_PER_SEAT = 5;
    private final FuelType fuelType;
    private final int numberOfSeats;
    private final double pricePerWeek;
    private final double pricePerDay;
    private final double pricePerHour;

    public Car(String id, String model, FuelType fuelType, int numberOfSeats, double pricePerWeek, double pricePerDay, double pricePerHour) {
        super(id, model);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.pricePerWeek = pricePerWeek;
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }

    @Override
    public double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent) throws InvalidRentingPeriodException {
        if (startOfRent.isAfter(endOfRent)) {
            throw new InvalidRentingPeriodException("Start of rent is after end of rent");
        }
        Duration duration = Duration.between(startOfRent, endOfRent);
        long weeks = duration.toDays() / 7;
        long days = duration.toDays() % 7;
        long hours = duration.toHours() % 24 + 1;
        long fuelPrice = fuelType.getDailyTax() * (duration.toDays() + 1);
        return weeks * pricePerWeek + days * pricePerDay + hours * pricePerHour + numberOfSeats * PRICE_PER_SEAT + fuelPrice;
    }
}