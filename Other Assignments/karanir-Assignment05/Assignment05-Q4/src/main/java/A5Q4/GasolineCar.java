package A5Q4;

/**
 * Gasoline Car with tank capacity, miles per gallon (+make, model, colour, year extended from Car)
*/

public class GasolineCar extends Car implements Refuel {

    //defines attributes for gasoline car objects
    private double fuel_tank_capacity;
    private double miles_per_gallon;
    private double current_fuel;

    //constructor for gas car class,.
    public GasolineCar(String make, String model, String colour, int year, double fuel_tank_capacity, double miles_per_gallon) {
        super(make, model, colour, year);
        this.fuel_tank_capacity = fuel_tank_capacity;
        this.miles_per_gallon = miles_per_gallon;
        this.current_fuel=0; //makes object with empty tank
    }

    //getter methods for tank capacity and miles/gallon
    public double getMilesPerGallon(){
        return miles_per_gallon;
    }

    public double getFuelTankCapacity(){
        return fuel_tank_capacity;
    }

    public double getCurrentFuel(){
        return current_fuel;
    }

    //methods that use the abstract classes from Car
    
    @Override
    public double calcFuelEff() {
        return miles_per_gallon;
    }

    @Override
    public double calcRange() {
        return miles_per_gallon*fuel_tank_capacity;
    }

    @Override
    public void addEnergy(double amount) {
        if (current_fuel + amount > fuel_tank_capacity) {
            current_fuel = fuel_tank_capacity;
            System.out.println("Fuel Overflow! Filled to max tank level instead.");
            System.out.println("Current fuel: " + current_fuel);
        } else {
            current_fuel += amount;
            System.out.println("Added! Current fuel: " + current_fuel);
        }
    }
}
