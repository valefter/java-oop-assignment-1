package ro.adrian.car;

import ro.adrian.car.dacia.Dacia;
import ro.adrian.car.dacia.Logan;
import ro.adrian.car.vehicle.Car;
import ro.adrian.car.vehicle.Vehicle;
import ro.adrian.car.volkswagen.VWGolf;
import ro.adrian.car.volkswagen.VWPassat;

public class Main {

  public static void main(String[] args) {

    //  Car car1 = new Car(); // this should not compile.
    //  Car car2 = new Dacia(27, "oiqe0934hkkadsn"); // this should not compile! If I want to create
    // a Dacia car, I will need to create an instance of a Dacia model.

    carExample();
    vehicleExample();
    optionalExample();
  }

  private static void carExample() {
    Car car =
        new Logan(
            27, "oiqe0934hkkadsn"); // Logan can extend from Dacia, while Dacia extends from Car

    car.start();
    car.shiftGear(1);
    car.drive(0.01); // drives 0.01 KMs

    car.shiftGear(2);
    car.drive(0.02);

    car.shiftGear(3);
    car.drive(0.5);

    car.shiftGear(4);
    car.drive(0.5);

    car.shiftGear(4);
    car.drive(0.5);

    car.shiftGear(5);
    car.drive(10);

    car.shiftGear(4);
    car.drive(0.5);

    car.shiftGear(3);
    car.drive(0.1);
    car.stop();

    float availableFuel = car.getAvailableFuel();
    System.out.printf("Combustibil disponibil -> %.2f\n", availableFuel);

    float fuelConsumedPer100Km = car.getAverageFuelConsumption();
    System.out.printf("Consum mediu -> %.2f\n", fuelConsumedPer100Km);
    System.out.println("----------------------------------------");
  }

  private static void vehicleExample() {
    Vehicle vehicle = new VWGolf(30, "1987ddkshik289"); // available fuel and chassis number

    vehicle.start();
    vehicle.drive(1);
    vehicle.stop();

    Car car = (Car) vehicle;

    float availableFuel = car.getAvailableFuel();
    System.out.printf("Combustibil disponibil -> %.2f\n", availableFuel);

    float fuelConsumedPer100Km = car.getAverageFuelConsumption();
    System.out.printf("Consum mediu -> %.2f\n", fuelConsumedPer100Km);
    System.out.println("----------------------------------------");
  }

  private static void optionalExample() {
    Car car = new VWPassat(30, "PASSAT123");

    car.setTireSize(17);

    car.start();
    car.shiftGear(1);
    car.drive(10);

    car.shiftGear(3);
    car.drive(10);

    car.shiftGear(5);
    car.drive(10);
    car.stop();

    float availableFuel = car.getAvailableFuel();
    System.out.printf("Combustibil disponibil -> %.2f\n", availableFuel);

    float fuelConsumedPer100Km = car.getAverageFuelConsumption();
    System.out.printf("Consum mediu -> %.2f\n", fuelConsumedPer100Km);
    System.out.println("----------------------------------------");
  }
}
