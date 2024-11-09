package bg.sofia.uni.fmi.mjt.vehiclerent;

import bg.sofia.uni.fmi.mjt.vehiclerent.Driver.Driver;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.InvalidRentingPeriodException;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.VehicleAlreadyRentedException;
import bg.sofia.uni.fmi.mjt.vehiclerent.exception.VehicleNotRentedException;
import bg.sofia.uni.fmi.mjt.vehiclerent.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RentalService {
    private final Map<Vehicle, LocalDateTime> rentedVehicles = new HashMap<>();

    public void rentVehicle(Driver driver, Vehicle vehicle, LocalDateTime startOfRent) {
        if (driver == null || vehicle == null || startOfRent == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        if (rentedVehicles.containsKey(vehicle)) {
            throw new VehicleAlreadyRentedException("Vehicle is already rented");
        }
        vehicle.rent(driver, startOfRent);
        rentedVehicles.put(vehicle, startOfRent);
    }

    public double returnVehicle(Vehicle vehicle, LocalDateTime endOfRent) throws InvalidRentingPeriodException {
        if (vehicle == null || endOfRent == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        if (!rentedVehicles.containsKey(vehicle)) {
            throw new VehicleNotRentedException("Vehicle is not rented");
        }
        LocalDateTime startOfRent = rentedVehicles.remove(vehicle);
        if (endOfRent.isBefore(startOfRent)) {
            throw new InvalidRentingPeriodException("End of rent is before start of rent");
        }
        double rentalPrice = vehicle.calculateRentalPrice(startOfRent, endOfRent);
        return rentalPrice + getDriverTax(vehicle.getDriver());
    }

    private double getDriverTax(Driver driver) {
        switch (driver.getAgeGroup()) {
            case JUNIOR:
                return 10;
            case SENIOR:
                return 15;
            default:
                return 0;
        }
    }
}