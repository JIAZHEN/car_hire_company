package models;

public class Car extends Vehicle {
  private int numSeats;

  public Car(String make, String model, String registrationNumber, float miles,
      float mileage, float carryingCapacity, String status, int numSeats) {
    super(make, model, registrationNumber, miles, mileage, carryingCapacity,
        status);
    this.numSeats = numSeats;
  }

  public int getNumSeats() {
    return numSeats;
  }

  @Override
  public String toString() {
    return "Car [numSeats=" + numSeats + ", toString()=" + super.toString()
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + numSeats;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Car other = (Car) obj;
    if (numSeats != other.numSeats)
      return false;
    return true;
  }
  
}
