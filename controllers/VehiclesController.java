package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Car;
import models.Customer;
import models.Van;
import models.Vehicle;

public class VehiclesController {
  private Map<String, Vehicle> vehicles;
  private Map<Vehicle, Customer> vehicToCust;

  public VehiclesController() {
    super();
    this.vehicles = new HashMap<String, Vehicle>();
    this.vehicToCust = new HashMap<Vehicle, Customer>();
  }
  
  public void createVehicle(Vehicle vehicle) {
    this.vehicles.put(vehicle.getRegistrationNumber(), vehicle);
  }
  
  public void destroyVehicle(String registerationNumber) {
    this.vehicles.remove(registerationNumber);
  }
  
  public String availability() {
    StringBuilder sb = new StringBuilder();
    for (String registerationNumber : this.vehicles.keySet()) {
      sb.append(registerationNumber + ": " + this.vehicles.get(registerationNumber).getStatus());
      sb.append("\n");
    }
    return sb.toString();
  }
  
  public void assignCarToCustomer(String name, String address, String registerationNumber) {
    Customer customer = new Customer(name, address);
    Vehicle vehicle = this.vehicles.get(registerationNumber);
    this.vehicToCust.put(vehicle, customer);
    vehicle.setStatus("hire");
  }
  
  public void updateCarStatus(String registerationNumber, String status) {
    this.vehicles.get(registerationNumber).setStatus(status);
  }
  
  public String reportCarInfo(String registerationNumber) {
    Vehicle vehicle = this.vehicles.get(registerationNumber);
    String info = vehicle.toString();
    if (vehicle instanceof Van) {
      info = ((Van)vehicle).toString();
    } else if (vehicle instanceof Car) {
      info = ((Car)vehicle).toString();
    }
    return info;
  }
  
  public String listTravelledOver(float carMiles, float vanMiles) {
    StringBuilder sb = new StringBuilder();
    for (String registerationNumber : this.vehicles.keySet()) {
      boolean exceedLimit = false;
      Vehicle vehicle = this.vehicles.get(registerationNumber);
      if (vehicle instanceof Van) {
        exceedLimit = vehicle.getMiles() > vanMiles;
      } else if (vehicle instanceof Car) {
        exceedLimit = vehicle.getMiles() > carMiles;
      }
      if (exceedLimit) {
        sb.append("Vehicle: " + registerationNumber + "\n");
      }
    }
    return sb.toString();
  }
}
