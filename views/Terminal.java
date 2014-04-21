package views;

import java.util.Scanner;

import controllers.VehiclesController;

import models.Car;
import models.Van;
import models.Vehicle;

public class Terminal {
  
  private VehiclesController vehiclesController;
  
  public Terminal(VehiclesController vehiclesController) {
    super();
    this.vehiclesController = vehiclesController;
  }

  public void showMenu() {
    System.out.println();
    System.out.println("*****   Welcome to Car Hire Company *****\n");      
    System.out.println("1...Add a vehicle from the fleet");      
    System.out.println("2...Remove a vehicle from the fleet");      
    System.out.println("3...List the availability of vehicles");      
    System.out.println("4...Assign the vehicle to customer");
    System.out.println("5...Assign the vehicle for free");
    System.out.println("6...Assign the vehicle to maintain");
    System.out.println("7...Report a vehicle by registeration number");
    System.out.println("8...List cars that have travelled in excess of 50,000 miles " +
    		                    "and the vans that have travelled more than 80,000 miles");
    System.out.println("0...Quit system");      
  }
  
  public void addVehicleHints() {
    System.out.println("***");
    System.out.print("  Input a car info as '1, String make, String model, String registrationNumber, float miles, ");
    System.out.println("float mileage, float carryingCapacity, String status, int numSeats'");
    
    System.out.print("  Input a van info as '2, String make, String model, String registrationNumber, float miles, ");
    System.out.println("float mileage, float carryingCapacity, String status, String colour, float capacity'");
    System.out.println("***");
    System.out.print("Vehicle info: ");
  }
  
  public void assignVehicleHints() {
    System.out.println("***");
    System.out.println("  Input as the format 'name, address, vehicle registration number'");
    System.out.println("***");
    System.out.print("Assign info: ");
  }
  
  public Vehicle createVehicleFromString(String input) {
    String[] params = input.split("\\s*,\\s*");
    Vehicle vehicle = null;
    if (params[0].equals("1")) {
      vehicle = new Car(params[1], params[2], params[3], Float.parseFloat(params[4]), 
                        Float.parseFloat(params[5]), Float.parseFloat(params[6]), params[7], 
                        Integer.parseInt(params[8]));
    } else if (params[0].equals("2")) {
      vehicle = new Van(params[1], params[2], params[3], Float.parseFloat(params[4]), 
                        Float.parseFloat(params[5]), Float.parseFloat(params[6]), params[7], 
                        params[8], Float.parseFloat(params[9]));
    }
    return vehicle;
  }
  
  public void process(int optionNum, Scanner keyboard) {
    switch (optionNum) {
      case 0:
        System.out.println("Thank you for using our system, see you.");
        break;
      case 1:
        this.addVehicleHints();
        try {
          Vehicle vehicle = this.createVehicleFromString(keyboard.nextLine());
          this.vehiclesController.createVehicle(vehicle);
          System.out.println("Successfully added " + this.vehiclesController.reportCarInfo(vehicle.getRegistrationNumber()));
        } catch (Exception e) {
          System.out.println("Sorry, the input format is incorrect");
        }
        break;
      case 2:
        System.out.print("Please enter the registration number to delete: ");
        try {
          String registrationNumber = keyboard.nextLine();
          this.vehiclesController.destroyVehicle(registrationNumber);
          System.out.println("Successfully deleted vehicle[registerNumber: " + registrationNumber + "]");
        } catch (Exception e) {
          System.out.println("Sorry, the input is incorrect");
        }
        break;
      case 3:
        System.out.println("Below are the avaibility of all vehicles: ");
        System.out.println(this.vehiclesController.availability());
        break;
      case 4:
        this.assignVehicleHints();
        try {
          String[] params = keyboard.nextLine().split("\\s*,\\s*");
          this.vehiclesController.assignCarToCustomer(params[0], params[1], params[2]);
          System.out.println("Successfully assgin vehicle[registerNumber: " + params[2] + "]");
        } catch (Exception e) {
          System.out.println("Sorry, the input is incorrect");
        }
        break;
      case 5:
        System.out.print("Vehicle registration number to be free: ");
        try {
          String registrationNumber = keyboard.nextLine().trim();
          this.vehiclesController.updateCarStatus(registrationNumber, "available");
          System.out.println("Successfully update vehicle[registerNumber: " + registrationNumber + "]");
        } catch (Exception e) {
          System.out.println("Sorry, the input is incorrect");
        }
        break;
      case 6:
        System.out.print("Vehicle registration number to maintain: ");
        try {
          String registrationNumber = keyboard.nextLine().trim();
          this.vehiclesController.updateCarStatus(registrationNumber, "maintenance");
          System.out.println("Successfully update vehicle[registerNumber: " + registrationNumber + "]");
        } catch (Exception e) {
          System.out.println("Sorry, the input is incorrect");
        }
        break;
      case 7:
        System.out.print("Vehicle registration number to report: ");
        try {
          String registrationNumber = keyboard.nextLine().trim();
          System.out.println(this.vehiclesController.reportCarInfo(registrationNumber));
        } catch (Exception e) {
          System.out.println("Sorry, the input is incorrect");
        }
        break;
      case 8:
        System.out.println();
        System.out.println(this.vehiclesController.listTravelledOver(50000.0f, 80000.0f));
        break;
      default:
        System.out.println("Sorry, we don't have that option.");
        break;
    }
  }
  
  public static void main(String[] args) {
    VehiclesController vehiclesController = new VehiclesController();
    Terminal terminal = new Terminal(vehiclesController);
    String optionNum = null;
    while(optionNum == null || !optionNum.equals("0")) {
      terminal.showMenu();
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nEnter your option: ");
      optionNum = keyboard.nextLine();
      terminal.process(Integer.parseInt(optionNum), keyboard);
    }
  }
}
