package A5Q2;

/**
 * Gasoline Car with tank capacity, miles per gallon (+make, model, colour, year extended from Car)
*/

public class GasolineCar extends Car {

    //defines attributes for gasoline car objects
    private double fuel_tank_capacity;
    private double miles_per_gallon;

    //constructor for gas car class,.
    public GasolineCar(String make, String model, String colour, int year, double fuel_tank_capacity, double miles_per_gallon) {
        super(make, model, colour, year);
        this.fuel_tank_capacity = fuel_tank_capacity;
        this.miles_per_gallon = miles_per_gallon;
    }

    //getter methods for tank capacity and miles/gallon
    public double getMilesPerGallon(){
        return miles_per_gallon;
    }

    public double getFuelTankCapacity(){
        return fuel_tank_capacity;
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
}
