import java.math.BigDecimal;

public class Managment {

    private Car[] cars;
    private Driver[] drivers;
    private User[] users;

    private BigDecimal bankNAM = new BigDecimal(90000000);

    public BigDecimal getBankNAM() {
        return bankNAM;
    }


    public Managment() {
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

}

