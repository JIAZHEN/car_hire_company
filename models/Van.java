package models;

public class Van extends Vehicle {

  private String colour;
  private float capacity;
  
  public Van(String make, String model, String registrationNumber, float miles,
      float mileage, float carryingCapacity, String status, String colour,
      float capacity) {
    super(make, model, registrationNumber, miles, mileage, carryingCapacity,
        status);
    this.colour = colour;
    this.capacity = capacity;
  }

  public String getColour() {
    return colour;
  }

  public float getCapacity() {
    return capacity;
  }

  @Override
  public String toString() {
    return "Van [colour=" + colour + ", capacity=" + capacity + ", toString()="
        + super.toString() + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Float.floatToIntBits(capacity);
    result = prime * result + ((colour == null) ? 0 : colour.hashCode());
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
    Van other = (Van) obj;
    if (Float.floatToIntBits(capacity) != Float.floatToIntBits(other.capacity))
      return false;
    if (colour == null) {
      if (other.colour != null)
        return false;
    } else if (!colour.equals(other.colour))
      return false;
    return true;
  }
  
}
