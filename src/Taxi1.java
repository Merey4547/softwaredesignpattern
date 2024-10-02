public abstract class Taxi1 {
    protected String driverName;
    protected String license;

    public Taxi1(String driverName, String license) {
        this.driverName = driverName;
        this.license = license;
    }

    public abstract void takePassenger(String passenger);
}

