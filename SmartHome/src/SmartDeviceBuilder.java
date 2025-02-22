class SmartDeviceBuilder {
    private String type;
    private int setting1;
    private String setting2;

    public SmartDeviceBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public SmartDeviceBuilder setSetting1(int setting1) {
        this.setting1 = setting1;
        return this;
    }

    public SmartDeviceBuilder setSetting2(String setting2) {
        this.setting2 = setting2;
        return this;
    }

    public SmartDevice build() {
        return SmartDeviceFactory.createDevice(type, setting1, setting2);
    }
}