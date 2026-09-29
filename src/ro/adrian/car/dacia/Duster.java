package ro.adrian.car.dacia;

import ro.adrian.car.vehicle.FuelType;

public class Duster extends Dacia {

  public Duster(float availableFuel, String chassisNumber) {
    super(52, FuelType.DIESEL, 6, 6.15f, availableFuel, 15, chassisNumber);
  }

  @Override
  protected float getGearMultiplier() {
    return 1 - (getCurrentGear() - 1) * 0.10f;
  }
}
