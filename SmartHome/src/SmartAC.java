class SmartAC implements SmartDevice {
    private int temperature;
    private String mode;

    public SmartAC(int temperature, String mode) {
        this.temperature = temperature;
        this.mode = mode;
    }

    public void turnOn() {
        System.out.println("SmartAC is ON at " + temperature + "°C in " + mode + " mode.");
    }

    public String toString() { return "SmartAC[temperature=" + temperature + ", mode=" + mode + "]"; }
}
