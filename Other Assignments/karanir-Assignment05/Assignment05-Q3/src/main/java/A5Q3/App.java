package A5Q3;

import java.util.ArrayList;

/**
 * Test class for A5Q2
 */
public class App {
    public static void main(String[] args) {
        //System.out.println("Hello World!");

        //testing classes, creating 2 new car objects.
        Refuel ecoCar = new ElectricCar("Tesla", "Model3", "Red", 2018, 500, 10);
        Refuel gasCar = new GasolineCar("Toyota", "Corolla", "Blue", 2014, 650, 7.5);

        ArrayList<Refuel> carList = new ArrayList<>(); //this dynamic arraylist allows us to add new cars easily.
        carList.add(ecoCar); //adding our testcase cars to the list! 
        carList.add(gasCar);

        for (Refuel car : carList) { //easily add 10 gallons of fuel or 10 kWh of charge to all cars in carList. 
            car.addEnergy(10);
        }

        for (Refuel car : carList) { //add 9999 gallons/kWh of energy to test for overflow. 
            car.addEnergy(9999);
        }
    }        
}

