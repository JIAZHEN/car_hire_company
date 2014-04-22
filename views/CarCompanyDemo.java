package views;

import java.util.Scanner;

import controllers.VehiclesController;

public class CarCompanyDemo {
  public static void main(String[] args) {
    VehiclesController vehiclesController = new VehiclesController();
    Terminal terminal = new Terminal(vehiclesController);
    String optionNum = null;
    Scanner keyboard = new Scanner(System.in);
    while(optionNum == null || !optionNum.equals("0")) {
      terminal.showMenu();
      System.out.print("\nEnter your option: ");
      optionNum = keyboard.nextLine();
      terminal.process(Integer.parseInt(optionNum), keyboard);
    }
    keyboard.close();
  }
}
