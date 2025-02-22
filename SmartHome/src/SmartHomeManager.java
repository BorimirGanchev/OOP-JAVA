public class SmartHomeManager {
    private static SmartHomeManager instance;
    private List<SmartDevice> devices = new ArrayList<>();

    private SmartHomeManager() {}

    public static synchronized SmartHomeManager getInstance() {
        if (instance == null) {
            instance = new SmartHomeManager();
        }
        return instance;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
        System.out.println(device.getClass().getSimpleName() + " added.");
    }

    public void showDevices() {
        System.out.println("Connected devices:");
        for (SmartDevice device : devices) {
            System.out.println("- " + device);
        }
    }
}