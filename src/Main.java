import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        User[] users = new User[0];
        User user = new User();
        User currentUser = null;
        Managment managment = new Managment();
        CarsInfo carsInfo = new CarsInfo();


        while (true) {
            System.out.println("""
                    1.Регистрация
                    2.Войти
                    3.Выйти
                    """);

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    User registerNewUser = user.register();
                    users = Arrays.copyOf(users, users.length + 1);
                    users[users.length - 1] = registerNewUser;
                    break;


                case "2":
                    currentUser = user.login(users);
                    if (currentUser != null) {
                        System.out.println("Вход выполнен успешно!");
                        Car newCar = carsInfo.info();

                        System.out.println("Машины :");
                        if (newCar != null) {
                            if (!newCar.isBooked()) {
                                BigDecimal carPrice = newCar.getPrice();

                                if (currentUser.getBigDecimal().compareTo(carPrice) >= 0) {

                                    newCar.book();

                                    System.out.println("Вы выбрали машину: " + newCar.getCarsModel());
                                    System.out.println("Цена: " + newCar.getPrice());
                                    System.out.println("Водитель: " + newCar.getDriver().getDriverSurname()
                                            + " " + newCar.getDriver().getDrivername());
                                } else {
                                    System.out.println("Недостаточно средств для покупки машины.");
                                    currentUser.balance(carPrice, currentUser,managment,scanner);
                                }
                            } else {
                                System.out.println("Извините, машина уже забронирована.");
                            }
                        }
                    } else {
                        System.out.println("Ошибка входа. Пожалуйста, проверьте логин и пароль.");
                    }
                    break;


            }


        }

    }
}


//    private static User[] addUserToArray(User[] users, User newUser) {
//        users = Arrays.copyOf(users, users.length + 1);
//        users[users.length - 1] = newUser;
//        return users;
//    }
//}