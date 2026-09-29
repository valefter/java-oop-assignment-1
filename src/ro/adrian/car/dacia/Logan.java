package ro.adrian.car.dacia;

import ro.adrian.car.vehicle.FuelType;

public class Logan extends Dacia {

  public Logan(float availableFuel, String chassisNumber) {
    super(48, FuelType.PETROL, 5, 5.45f, availableFuel, 15, chassisNumber);
  }
}
