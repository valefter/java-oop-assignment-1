package ro.adrian.car.vehicle;

public abstract class Car implements Vehicle {

  protected final int fuelTankSize;
  protected final FuelType fuelType;
  protected final int gears;
  protected final float consumptionPer100Km;
  protected float availableFuel;
  protected int tireSize;
  protected String chassisNumber;

  private boolean isRunning;
  private int currentGear;
  private float fuelConsumed;
  private double drivenKilometers;

  public Car(
      int fuelTankSize,
      FuelType fuelType,
      int gears,
      float consumptionPer100Km,
      float availableFuel,
      int tireSize,
      String chassisNumber) {
    this.fuelTankSize = fuelTankSize;
    this.fuelType = fuelType;
    this.gears = gears;
    this.consumptionPer100Km = consumptionPer100Km;
    this.availableFuel = availableFuel;
    this.tireSize = tireSize;
    this.chassisNumber = chassisNumber;
  }

  @Override
  public void start() {
    isRunning = true;
    currentGear = 1;
    fuelConsumed = 0;
    drivenKilometers = 0;
    System.out.println("Mașina a pornit!");
  }

  @Override
  public void stop() {
    isRunning = false;
    currentGear = 0;
    System.out.println("Mașina s-a oprit!");
  }

  @Override
  public void drive(double kilometers) {
    if (!isRunning) {
      System.out.println("Mașina nu este pornită!");
      return;
    }

    if (kilometers < 0) {
      System.out.println("Kilometri nu pot fi negativi!");
      return;
    }

    float consumption = calculateConsumption(kilometers);

    if (consumption > availableFuel) {
      System.out.println("Nu există suficient combustibil!");
      return;
    }

    availableFuel -= consumption;
    fuelConsumed += consumption;
    drivenKilometers += kilometers;
  }

  public void shiftGear(int gear) {
    if (!isRunning) {
      System.out.println("Nu poți schimba viteza dacă motorul nu este pornit!");
      return;
    }

    if (gear < 1 || gear > gears) {
      System.out.println(
          "Treaptă de viteză invalidă! Această mașină acceptă doar trepte în intervalul 1-"
              + gears);
      return;
    }
    currentGear = gear;
  }

  public int getTireSize() {
    return tireSize;
  }

  public void setTireSize(int tireSize) {
    this.tireSize = tireSize;
  }

  public float getAvailableFuel() {
    return availableFuel;
  }

  public void setAvailableFuel(float availableFuel) {
    this.availableFuel = availableFuel;
  }

  public void setChassisNumber(String chassisNumber) {
    this.chassisNumber = chassisNumber;
  }

  protected int getCurrentGear() {
    return currentGear;
  }

  public String getChassisNumber() {
    return chassisNumber;
  }

  public float getAverageFuelConsumption() {
    if (drivenKilometers == 0) {
      return 0;
    }

    return (float) ((fuelConsumed / drivenKilometers) * 100);
  }

  protected float getGearMultiplier() {
    return 1.0f;
  }

  protected float getTireMultiplier() {
    return 1.0f;
  }

  private float calculateConsumption(double kilometers) {
    float gearMultiplier = getGearMultiplier();
    float tireMultiplier = getTireMultiplier();

    return (float) ((consumptionPer100Km / 100) * kilometers * gearMultiplier * tireMultiplier);
  }
}
