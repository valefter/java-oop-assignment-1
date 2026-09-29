package ro.adrian.car.volkswagen;

import ro.adrian.car.vehicle.FuelType;

public class VWGolf extends Volkswagen {

  public VWGolf(float availableFuel, String chassisNumber) {
    super(49, FuelType.DIESEL, 6, 4.68f, availableFuel, 15, chassisNumber);
  }

  @Override
  protected float getTireMultiplier() {
    return 1 + ((getTireSize() - 15) * 0.02f);
  }
}
