package A5Q6;

import java.util.ArrayList;

/**
 * Rushil Karani
 * prints info of a fleet of cars
 * by adding a luxury sedan object to the app class, we show how it seamlessly integrates with the rest of the cars in fleet.
*/

public class App {

    public static void main(String[] args) {
        ArrayList<Car> fleet = new ArrayList<>(); //creates an array list of Car objects, for any type of car

        // Add instances of Gas and Electric cars to the fleet of cars - will be used for tesing.
        fleet.add(new GasolineCar("Toyota", "Corolla", "Blue", 2014, 650, 7.5));
        fleet.add(new GasolineCar("Honda", "Civic", "Blue", 2021, 480, 8));
        fleet.add(new ElectricCar("Tesla", "Model3", "Red", 2018, 500, 10));
        fleet.add(new ElectricCar("Nissan", "Leaf", "Green", 2020, 600, 11));
        fleet.add(new LuxurySedan("Mercedes", "S-Class", "White", 2024, false, true, 100000));

        printFleetDetails(fleet); //prints make, model, Fuel Efficiency, Range.
        calculateTotalRange(fleet); //prints the sum of range of all the cars.
    }

    public static void printFleetDetails(ArrayList<Car> fleet) {
        System.out.println("Fleet Details:\n");
        for (Car car : fleet) { //loops through all cars in fleet
            System.out.println("Make and Model: " + car.getMake()+" " + car.getModel()); //prints make/model

            //prints fuel or battery efficiency based on type of car.
            if (car instanceof GasolineCar || car instanceof LuxuryCar) {
                System.out.println("Fuel Efficiency: " + car.calcFuelEff() + " miles/gallon");
            } 
            else if (car instanceof ElectricCar) {
                System.out.println("Battery Efficiency: " + car.calcFuelEff() + " miles/kWh");
            } 
                        
            System.out.println("Range: " + car.calcRange() + " miles\n"); //prints range in miles.
        }
    }

    
    //method to calculate the total range of all cars in the fleet.
    public static void calculateTotalRange(ArrayList<Car> fleet) {
        double total_range = 0; //innitialize variable total range to 0 
        for (Car car : fleet) { //loops through all cars in fleet
            total_range += car.calcRange(); //adds range of all cars to total range one by one.
        }
        System.out.println("Total Range of all cars: " + total_range + " miles"); //prints total range.
    }
}



/*
 *  else if (car instanceof LuxuryCar) {
        LuxuryCar luxCar = (LuxuryCar) car; //casting the car type object to luxury car, so we can access the methods in luxury car class
        System.out.println("Fuel Efficiency: " + car.calcFuelEff() + " miles/gallon");
        System.out.println("Luxury Tax: $" + luxCar.calcLuxuryTax());
        System.out.println("Massage Seats: " + (luxCar.getMassageSeats() ? "Yes" : "No"));
        System.out.println("Sunroof: " + (luxCar.getSunroof() ? "Yes" : "No"));
    }
 */
