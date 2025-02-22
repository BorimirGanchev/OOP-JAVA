public class SmartHomeApp {
    public static void main(String[] args) {
        SmartHomeManager manager = SmartHomeManager.getInstance();

        SmartDevice light = new SmartDeviceBuilder().setType("light").setSetting1(75).setSetting2("warm").build();
        SmartDevice ac = new SmartDeviceBuilder().setType("ac").setSetting1(22).setSetting2("cool").build();
        SmartDevice speaker = new SmartDeviceBuilder().setType("speaker").setSetting1(50).setSetting2("English").build();

        OldHeater oldHeater = new OldHeater();
        SmartDevice heater = new HeaterAdapter(oldHeater, 3);

        manager.addDevice(light);
        manager.addDevice(ac);
        manager.addDevice(speaker);
        manager.addDevice(heater);

        manager.showDevices();

        light.turnOn();
        ac.turnOn();
        speaker.turnOn();
        heater.turnOn();
    }
}
