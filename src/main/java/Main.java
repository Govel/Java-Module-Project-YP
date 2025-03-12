import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        System.out.println("Добро пожаловать на гонку автомобилей!");
        System.out.println("Вам необходимо ввести данные автомобилей, а именно: их название и скорость");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Введите название машины №%d:%n", i + 1);
            String nameCar = scanner.next();
            String textSpeedCar;
            int speedCar;
            while (true) {
                System.out.printf("Введите скорость машины №%d:%n", i + 1);
                textSpeedCar = scanner.next();
                try {
                    speedCar = Integer.parseInt(textSpeedCar);
                    if (speedCar > 0 && speedCar <= 250) {
                        break;
                    } else {
                        showErrorMessage();
                    }
                } catch (NumberFormatException e) {
                    showErrorMessage();
                }
            }
            Car car = new Car(nameCar, speedCar);
            race.getLeader(car);
        }
        System.out.println("Самая быстрая машина: " + race.leader);
    }

    static private void showErrorMessage() {
        System.out.println("Неверный ввод, попробуйте еще раз");
    }
}

class Car {
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {
    String leader = "";
    int distance = 0;

    public void getLeader(Car car) {
        int newDistance = car.speed * 24;
        if (newDistance > distance) {
            distance = newDistance;
            leader = car.name;
        }
    }


}

