import java.math.BigDecimal;

public enum Car {



    LEKSUS("Leksus",new BigDecimal(1000),new Driver("Ali","Temir")),
    TAYOTA("TAYOTA",new BigDecimal(700),new Driver("Argen","Bakytbekov")),
    MERSEDES("MERSEDES",new BigDecimal(700),new Driver("Adis","Kazybekov")),
    AUDI("AUDI",new BigDecimal(1200),new Driver("Jigit","Turumbekov")),
    MAZDA("Mazda",new BigDecimal(300),new Driver("Slack","Slackov")),
    LADA("Lada",new BigDecimal(600),new Driver("Baha","Kubanov")),
    OPEl("OPEl",new BigDecimal(500),new Driver("Baha","Kubanov")),
    TESLA("Tesla",new BigDecimal(1200),new Driver("Nuke","Bekov")),
    BMW("Tesla",new BigDecimal(1200),new Driver("Nuke","Bekov")),
    HONDA("Honda",new BigDecimal(1100),new Driver("Atahan","Madumarov"));



    private boolean booked;
    private final String cars;
    private final BigDecimal price;
    private final Driver driver;

    Car(String cars, BigDecimal price, Driver driver) {
        this.cars = cars;
        this.price = price;
        this.driver = driver;
    }

    public String getCarsModel() {
        return cars;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Driver getDriver() {
        return driver;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        if (!booked) {
            booked = true;
        } else {
            System.out.println("Извините, машина уже забронирована.");
        }
    }
}
