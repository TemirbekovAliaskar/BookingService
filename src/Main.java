import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");

        Scanner scanner = new Scanner(System.in);
        User[] users = new User[0];
        User user = new User();
        User currentUser = null;
        Managment managment = new Managment();


        while (true) {

            System.out.println("""
                    ╔═══════════════════════════════════╗
                    ║           Добро пожаловать        ║
                    ║              в компанию           ║
                    ║   MAN - Meder,Aliaskar,Nurtaazin  ║
                    ╠───────────────────────────────────╣
                    ║          1. Регистрация           ║
                    ║          2. Войти                 ║
                    ║          3. Admin                 ║
                    ║          4. Выход                 ║
                    ╚═══════════════════════════════════╝
                    """);


            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    User registerNewUser = user.register();
                    users = Arrays.copyOf(users, users.length + 1);
                    users[users.length - 1] = registerNewUser;
                    break;
                }


                    case "2": {
                    currentUser = user.login(users);
                    if (currentUser != null) {
                        System.out.println("Вход выполнен успешно!");

                        carWhile:
                        while (true) {
                            Car newCar = Car.info();
                            if (newCar == null) break carWhile;
                            else {

                                if (!newCar.isBooked()) {
                                    BigDecimal carPrice = newCar.getPrice();

                                    if (currentUser.getBigDecimal().compareTo(carPrice) >= 0) {
                                        newCar.book();

                                        System.out.println("Водитель: " + newCar.getDriver().getDriverSurname()
                                                + " " + newCar.getDriver().getDrivername());

                                        currentUser.balance(carPrice, currentUser, managment, scanner);

                                    } else {
                                        System.out.println("Недостаточно средств для покупки машины.");
                                        currentUser.balance(carPrice, currentUser, managment, scanner);
                                    }

                                } else {
                                    System.out.println("Извините, машина уже забронирована.");
                                }
                            }
                        }
                    }
                    break;

                    }


                case "3": {
                    innerLoop:
                    while (true) {
                        if (managment.admin()) {
                            System.out.println("ADMINISTRATOR VIEW:\n");

                            System.out.println("CARS INFORMATION:");
                            managment.carsInfo(managment.getCars());

                            System.out.println("-------------------------");

                            System.out.println("DRIVERS INFORMATION:");
                            managment.driverInfo(managment.getDrivers());

                            System.out.println("--------------------------");

                            System.out.println("USERS INFORMATION:");
                            managment.userInfo(users);

                            System.out.println("BANK INFORMATION:");
                            managment.bank();
                        } else {
                            break innerLoop;
                        }
                    }
                }

                case "4": {
                    System.out.println("Выход из программы.");
                    System.exit(0);
                }

                default: {
                    System.out.println("Некорректный выбор. Повторите ввод.");
                    break;
                }
            }
        }
    }
}