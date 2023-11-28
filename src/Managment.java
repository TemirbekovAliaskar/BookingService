import java.math.BigDecimal;
import java.util.Scanner;

public class Managment {

    private Car[] cars = {Car.LEKSUS, Car.TAYOTA, Car.MERSEDES, Car.AUDI, Car.MAZDA, Car.LADA, Car.OPEl, Car.TESLA, Car.BMW, Car.HONDA};
    private Driver[] drivers = {Car.LEKSUS.getDriver(),Car.TAYOTA.getDriver(),Car.MERSEDES.getDriver(),Car.AUDI.getDriver(),Car.MAZDA.getDriver(),Car.LADA.getDriver(),Car.OPEl.getDriver(),Car.TESLA.getDriver(),Car.BMW.getDriver(),Car.HONDA.getDriver()};
    private User[] users;
    private String adminPassword;

    public String getAdminPassword() {
        return adminPassword;
    }

    public String setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return adminPassword;
    }


    private BigDecimal bankNAM = new BigDecimal(90000000);

    public BigDecimal getBankNAM() {
        return bankNAM;
    }


    public Managment() {
        setAdminPassword("Kyrgyz");
    }

    public Managment(Car[] cars, Driver[] drivers, User[] users) {
        this.cars = cars;
        this.drivers = drivers;
        this.users = users;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public Driver[] getDrivers() {
        return drivers;
    }

    public void setDrivers(Driver[] drivers) {
        this.drivers = drivers;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }


    public void creditCar(User currentUser, BigDecimal amount) {
        if (bankNAM.compareTo(amount) >= 0) {
            bankNAM = bankNAM.subtract(amount);
            currentUser.setBigDecimal(currentUser.getBigDecimal().add(amount));
            System.out.println("Вы успешно взяли кредит: " + currentUser.getBigDecimal());
        } else {
            System.out.println("Недостаточно средств в банке для выдачи кредита на сумму " + amount);
        }


    }

    public Car carsInfo(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }
        return null;
    }

    public boolean admin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Admin password :");
        try {
            String pass = scanner.nextLine();
            if (pass.equals(getAdminPassword())) {

                return true;
            } else {
                throw new IncorrectPasswordException("Не правильно пароль!  Вы вышли из сервера . ");
            }

        } catch (IncorrectPasswordException incorrectPasswordException) {
            System.err.println( incorrectPasswordException.getMessage());
            return false;
        }
    }

    public Driver driverInfo(Driver[]drivers){
        for (int i = 0; i < drivers.length ; i++) {
            System.out.println(drivers[i]);
        }
        return  null;
    }

    public void userInfo(User[] users) {
        for (int i = 0; i < users.length; i++) {
            System.out.println("Информация о пользователей  :");
            System.out.println(users[i]);

            }

        }
        public void bank(){
            System.out.println("MAN Bank :  "+getBankNAM());
        }

    }








