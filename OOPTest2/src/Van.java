class Van extends Vehicle {
    double capacityCharge;

    public Van(String brand, String model, double capacityCharge) {
        super(brand, model);
        this.capacityCharge = capacityCharge;
    }

    public double calculateDailyRate() {
        return 0.5 * capacityCharge;
    }
}