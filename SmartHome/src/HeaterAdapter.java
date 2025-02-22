class HeaterAdapter implements SmartDevice {
    private OldHeater oldHeater;
    private int level;

    public HeaterAdapter(OldHeater oldHeater, int level) {
        this.oldHeater = oldHeater;
        this.level = level;
    }

    public void turnOn() {
        oldHeater.heatUp(level);
    }

    public String toString() { return "HeaterAdapter[level=" + level + "]"; }
}