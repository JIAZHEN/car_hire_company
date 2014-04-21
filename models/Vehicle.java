package models;

public class Vehicle {
  private String make;
  private String model;
  private String registrationNumber;
  private float miles;
  private float mileage;
  private float carryingCapacity;
  private String status;
  
  public Vehicle(String make, String model, String registrationNumber,
      float miles, float mileage, float carryingCapacity, String status) {
    super();
    this.make = make;
    this.model = model;
    this.registrationNumber = registrationNumber;
    this.miles = miles;
    this.mileage = mileage;
    this.carryingCapacity = carryingCapacity;
    this.status = status;
  }

  public float getMiles() {
    return miles;
  }

  public void setMiles(float miles) {
    this.miles = miles;
  }

  public float getMileage() {
    return mileage;
  }

  public void setMileage(float mileage) {
    this.mileage = mileage;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public float getCarryingCapacity() {
    return carryingCapacity;
  }

  @Override
  public String toString() {
    return "Vehicle [make=" + make + ", model=" + model
        + ", registrationNumber=" + registrationNumber + ", miles=" + miles
        + ", mileage=" + mileage + ", carryingCapacity=" + carryingCapacity
        + ", status=" + status + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Float.floatToIntBits(carryingCapacity);
    result = prime * result + ((make == null) ? 0 : make.hashCode());
    result = prime * result + Float.floatToIntBits(mileage);
    result = prime * result + Float.floatToIntBits(miles);
    result = prime * result + ((model == null) ? 0 : model.hashCode());
    result = prime * result
        + ((registrationNumber == null) ? 0 : registrationNumber.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vehicle other = (Vehicle) obj;
    if (Float.floatToIntBits(carryingCapacity) != Float
        .floatToIntBits(other.carryingCapacity))
      return false;
    if (make == null) {
      if (other.make != null)
        return false;
    } else if (!make.equals(other.make))
      return false;
    if (Float.floatToIntBits(mileage) != Float.floatToIntBits(other.mileage))
      return false;
    if (Float.floatToIntBits(miles) != Float.floatToIntBits(other.miles))
      return false;
    if (model == null) {
      if (other.model != null)
        return false;
    } else if (!model.equals(other.model))
      return false;
    if (registrationNumber == null) {
      if (other.registrationNumber != null)
        return false;
    } else if (!registrationNumber.equals(other.registrationNumber))
      return false;
    if (status == null) {
      if (other.status != null)
        return false;
    } else if (!status.equals(other.status))
      return false;
    return true;
  }
}
