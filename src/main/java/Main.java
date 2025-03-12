import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        System.out.println("Добро пожаловать на гонку автомобилей!");
        System.out.println("Вам необходимо ввести данные автомобилей, а именно: их название и скорость");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Введите название машины №%d:%n", i + 1);
            String nameCar = scanner.nextLine();
            String textSpeedCar;
            int speedCar;
            while (true) {
                System.out.printf("Введите скорость машины №%d:%n", i + 1);
                textSpeedCar = scanner.nextLine();
                try {
                    speedCar = Integer.parseInt(textSpeedCar);
                    if (speedCar > 0 && speedCar <= 250) {
                        break;
                    } else {
                        printErrorMessage();
                    }
                } catch (NumberFormatException e) {
                    printErrorMessage();
                }
            }
            Car car = new Car(nameCar, speedCar);
            race.getLeader(car);
        }
        System.out.println("Самая быстрая машина: " + race.leader);
    }

    static private void printErrorMessage() {
        System.out.println("Неверный ввод, попробуйте еще раз");
    }
}
