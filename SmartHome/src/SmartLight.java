class SmartLight implements SmartDevice {
    private int brightness;
    private String color;

    public SmartLight(int brightness, String color) {
        this.brightness = brightness;
        this.color = color;
    }

    public void turnOn() {
        System.out.println("SmartLight is ON with brightness " + brightness + " and color " + color);
    }

    public String toString() { return "SmartLight[brightness=" + brightness + ", color=" + color + "]"; }
}
