import java.math.BigDecimal;
import java.util.Scanner;

public enum Car {





    LEKSUS(1,"Leksus",new BigDecimal(1000),new Driver("Ali","Temir")),
    TAYOTA(2,"TAYOTA",new BigDecimal(700),new Driver("Argen","Bakytbekov")),
    MERSEDES(3,"MERSEDES",new BigDecimal(700),new Driver("Adis","Kazybekov")),
    AUDI(4,"AUDI",new BigDecimal(1200),new Driver("Jigit","Turumbekov")),
    MAZDA(5,"Mazda",new BigDecimal(300),new Driver("Slack","Slackov")),
    LADA(6,"Lada",new BigDecimal(600),new Driver("Baha","Kubanov")),
    OPEl(7,"OPEl",new BigDecimal(500),new Driver("Baha","Kubanov")),
    TESLA(8,"Tesla",new BigDecimal(1200),new Driver("Nuke","Bekov")),
    BMW(9,"Tesla",new BigDecimal(1200),new Driver("Nuke","Bekov")),
    HONDA(10,"Honda",new BigDecimal(1100),new Driver("Atahan","Madumarov"));



    private boolean booked;
    private final int id;
    private final String cars;
    private final BigDecimal price;
    private final Driver driver;

    Car(int id, String cars, BigDecimal price, Driver driver) {
        this.id = id;
        this.cars = cars;
        this.price = price;
        this.driver = driver;
    }

    public int getId() {
        return id;
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
            booked =  true;
        } else {
            System.out.println("Извините, машина уже забронирована.");
        }
    }

    public static Car info() {
        Car selectedCar = null;
        System.out.println("""
            ╔══════════════════════════════╗
            ║           Меню выбора        ║
            ╠══════════════════════════════╣
            ║ 1. Leksus   - 1000$          ║
            ║ 2. Tayota   - 700$           ║
            ║ 3. Mersedes - 700$           ║
            ║ 4. Audi     - 1200$          ║
            ║ 5. Mazda    - 300$           ║
            ║ 6. Lada     - 600$           ║
            ║ 7. Opel     - 500$           ║
            ║ 8. Tesla    - 1200$          ║
            ║ 9. BMW      - 1200$          ║
            ║ 10. Honda   - 1100$          ║
            ║ 0. Выйти из меню             ║
            ╚══════════════════════════════╝
            """);

        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();
        User user = new User();
        loginlook:
        switch (choice) {

            case "1" -> {
                selectedCar = Car.LEKSUS;
            }
            case "2" -> selectedCar = Car.TAYOTA;
            case "3" -> selectedCar = Car.MERSEDES;
            case "4" -> selectedCar = Car.AUDI;
            case "5" -> selectedCar = Car.MAZDA;
            case "6" -> selectedCar = Car.LADA;
            case "7" -> selectedCar = Car.OPEl;
            case "8" -> selectedCar = Car.TESLA;
            case "9" -> selectedCar = Car.BMW;
            case "10" -> selectedCar = Car.HONDA;
            case "0" -> { return null;}
            default -> {
                System.out.println("Invalid choice");
            }
        }
        if (selectedCar != null) {
            System.out.println("Вы выбрали машину: " + selectedCar.getCarsModel());
            System.out.println("Цена: " + selectedCar.getPrice());
        }
        return selectedCar;
    }

    @Override
    public String toString() {

        return " CAR INFO:   BOOKED: " + booked + "   ID: " + id + "   MODEL: " + cars + "   PRICE: " + price + "   DRIVER: " + driver + "\n\n" + super.toString();

    }
}
