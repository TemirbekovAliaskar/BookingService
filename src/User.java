import java.math.BigDecimal;
import java.util.Scanner;

public class User {


    private String name;
    private String lastName;
    private String address;
    private String number;
    private String login;
    private String password;
    private BigDecimal bigDecimal;


    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public User() {
    }

    public User(String name, String lastName, String address, String number, String login, String password, BigDecimal bigDecimal) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.number = number;
        this.login = login;
        this.password = password;
        this.bigDecimal = bigDecimal;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    @Override
    public String toString() {
        return "USER INFORMATION:\n" +
                "  - NAME: " + name +
                "  - LAST NAME: " + lastName +
                "  - ADDRESS: " + address+
                "  - PHONE NUMBER: " + number+
                "  - LOGIN: " + login +
                "  - PASSWORD: " + password +
                "  - BANK: " + bigDecimal;
    }

    //
    Scanner scanner = new Scanner(System.in);

    public User register() {
        User user = new User();

        System.out.println("""
                ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                ┃ Регистрация пользователя        ┃
                ┠─────────────────────────────────┨
                """);

        System.out.print("  Атынызды жазыныз: ");
        user.setName(scanner.nextLine());

        System.out.print("  Фамилиянызды жазыныз: ");
        user.setLastName(scanner.nextLine());

        System.out.print("  Адрес: ");
        user.setAddress(scanner.nextLine());

        System.out.print("  Номер телефона: ");
        user.setNumber(scanner.nextLine());

        user.setLogin(emailTrue());
        user.setPassword(passTrue());

        System.out.print("  Баланс: ");
        user.setBigDecimal(scanner.nextBigDecimal());

        System.out.println("""
                ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                """);

        return user;
    }


    public User login(User[] users) {

        User user1 = new User();
        user1.setLogin(emailTrue());
        user1.setPassword(passTrue());

        for (int i = 0; i < users.length; i++) {

            if (users[i].getLogin().equals(user1.getLogin()) && users[i].getPassword().equals(user1.getPassword())) {
                System.out.println("Welcome  !" + users[i].getName() + " " + users[i].getLastName());
                return users[i];

            }
        }
        return null;
    }


    public String emailTrue() {

        Scanner scanner1 = new Scanner(System.in);
        boolean isTrue = false;

        String login = "";
        while (!isTrue) {
            System.out.println("Email login жаз :");
            login = scanner1.nextLine();
            if (login.endsWith("@gmail.com")) {
                isTrue = true;
            } else System.err.println("@gmail.com жетишсиз!");
        }
        return login;
    }

    public String passTrue() {
        Scanner scanner1 = new Scanner(System.in);
        boolean istrue = false;
        String password = "";

        while (!istrue) {
            System.out.println("Пароль жаз");
            password = scanner1.nextLine();
            if (password.length() > 4) {
                istrue = true;
            } else System.err.println("4 тон жогору болсун парольунуз !");
        }
        return password;

    }


    public void balance(BigDecimal amount, User currentUser, Managment management, Scanner scanner) {
        if (currentUser.getBigDecimal().compareTo(amount) >= 0) {
            currentUser.setBigDecimal(currentUser.getBigDecimal().subtract(amount));
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("  Новый баланс: " + currentUser.getBigDecimal());
            System.out.println("  Ваша машина успешно забронирована!");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        } else {
            System.out.println("""
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    │  Кредит берете?                     │
                    │  1. Да                              │
                    │  2. Нет                             │
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                    """);
            System.out.println("  Ваш выбор ?");

            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("  Введите сумму кредита:");
                    BigDecimal requestedCredit = scanner.nextBigDecimal();
                    scanner.nextLine();
                    management.creditCar(currentUser, requestedCredit);
                    break;
                }
                case "2": {
                    System.out.println("  Хорошо!");
                    break;
                }
                default: {
                    System.out.println("  Некорректный выбор.");
                    break;
                }
            }


        }

    }
}











