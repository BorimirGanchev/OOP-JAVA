public class Place {
    private String tenantName;
    private double area;
    private int floor;

    public Place(String tenantName, double area, int floor){
        tenantName = "";
        area = 0;
        floor = 0;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area < 0 )
            throw new IllegalArgumentException("Invalid");
        this.area = area;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        if (tenantName.isEmpty())
            throw new IllegalArgumentException("invalid");
        this.tenantName = tenantName;
    }
}
