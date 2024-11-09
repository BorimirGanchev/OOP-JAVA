package bg.sofia.uni.fmi.mjt.vehiclerent.vehicle;

import bg.sofia.uni.fmi.mjt.vehiclerent.Driver.Driver;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.InvalidRentingPeriodException;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.VehicleAlreadyRentedException;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.VehicleNotRentedException;

import java.time.LocalDateTime;

public abstract class Vehicle {
    private final String id;
    private final String model;
    private Driver driver;
    private LocalDateTime startRentTime;

    public Vehicle(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public void rent(Driver driver, LocalDateTime startRentTime) {
        if (this.driver != null) {
            throw new VehicleAlreadyRentedException("Vehicle is already rented");
        }
        this.driver = driver;
        this.startRentTime = startRentTime;
    }

    public void returnBack(LocalDateTime rentalEnd) throws InvalidRentingPeriodException {
        if (rentalEnd == null) {
            throw new IllegalArgumentException("Rental end time cannot be null");
        }
        if (this.driver == null) {
            throw new VehicleNotRentedException("Vehicle is not rented");
        }
        if (rentalEnd.isBefore(this.startRentTime)) {
            throw new InvalidRentingPeriodException("Rental end time is before start rent time");
        }
        this.driver = null;
        this.startRentTime = null;
    }

    public abstract double calculateRentalPrice(LocalDateTime startOfRent, LocalDateTime endOfRent) throws InvalidRentingPeriodException;

    public Driver getDriver() {
        return driver;
    }
}