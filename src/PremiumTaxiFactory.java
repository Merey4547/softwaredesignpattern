public class PremiumTaxiFactory extends Factory {
    @Override
    public Taxi createTaxi(String driverName, String license) {
        return new PremiumTaxi(driverName, license);
    }
}
