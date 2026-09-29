package ro.adrian.car.volkswagen;

import ro.adrian.car.vehicle.Car;
import ro.adrian.car.vehicle.FuelType;

public abstract class Volkswagen extends Car {

  public Volkswagen(
      int fuelTankSize,
      FuelType fuelType,
      int gears,
      float consumptionPer100Km,
      float availableFuel,
      int tireSize,
      String chassisNumber) {
    super(
        fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, tireSize, chassisNumber);
  }
}
