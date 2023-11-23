import java.util.Scanner;

public class CarsInfo {

    private Car selectedCar;

    public Car info() {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                1. Leksus price : 1000$
                2. Tayota price : 700$
                3. Mersedes price : 1400$
                4. Audi price : 3000$
                5. Mazda price : 300$
                6. Lada price : 600$
                7. Opel price : 500$
                8. Tesla price : 2000$
                9. BMW price : 900$
                10. Honda price : 1100$
                
                0. Exit menu 
                """);

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> selectedCar = Car.LEKSUS;
                case "2" -> selectedCar = Car.TAYOTA;
                case "3" -> selectedCar = Car.MERSEDES;
                case "4" -> selectedCar = Car.AUDI;
                case "5" -> selectedCar = Car.MAZDA;
                case "6" -> selectedCar = Car.LADA;
                case "7" -> selectedCar = Car.OPEl;
                case "8" -> selectedCar = Car.TESLA;
                case "9" -> selectedCar = Car.BMW;
                case "10" -> selectedCar = Car.HONDA;
                case "0" -> System.exit(0);
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


    }

}









