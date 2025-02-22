class SmartDeviceFactory {
    public static SmartDevice createDevice(String type, int setting1, String setting2) {
        switch (type.toLowerCase()) {
            case "light":
                return new SmartLight(setting1, setting2);
            case "ac":
                return new SmartAC(setting1, setting2);
            case "speaker":
                return new SmartSpeaker(setting1, setting2);
            default:
                throw new IllegalArgumentException("Unknown device type");
        }
    }
}