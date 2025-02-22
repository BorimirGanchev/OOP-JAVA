class SmartSpeaker implements SmartDevice {
    private int volume;
    private String language;

    public SmartSpeaker(int volume, String language) {
        this.volume = volume;
        this.language = language;
    }

    public void turnOn() {
        System.out.println("SmartSpeaker is ON at volume " + volume + " speaking " + language);
    }

    public String toString() { return "SmartSpeaker[volume=" + volume + ", language=" + language + "]"; }
}
