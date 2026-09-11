package ro.adrian.car.volkswagen;

import ro.adrian.car.vehicle.FuelType;

public class VWPassat extends Volkswagen {

  public VWPassat(float availableFuel, String chassisNumber) {
    super(56, FuelType.DIESEL, 6, 5.27f, availableFuel, 15, chassisNumber);
  }

  @Override
  protected float getGearMultiplier() {
    return 1 - (getCurrentGear() - 1) * 0.10f;
  }

  @Override
  protected float getTireMultiplier() {
    return 1 + ((getTireSize() - 15) * 0.02f);
  }
}
