package A5Q2;

/**
 * electric Car with battery capacity and miles per kWh (+make, model, colour, year extended from Car)
*/

public class ElectricCar extends Car {

    //defines attributes for electric car objects
    private double battery_capacity;
    private double miles_per_kWh;

    //constructor for electric car class.
    public ElectricCar(String make, String model, String colour, int year, double battery_capacity, double miles_per_kWh) {
        super(make, model, colour, year);
        this.battery_capacity = battery_capacity;
        this.miles_per_kWh = miles_per_kWh;
    }

    //getter methods for battery capacity and miles/kwh
    public double getMilesPerKWh(){
        return miles_per_kWh;
    }

    public double getBatteryCapacity(){
        return battery_capacity;
    }

    //methods that use the abstract classes from Car
    
    @Override
    public double calcFuelEff() {
        return miles_per_kWh;
    }
    
    @Override
    public double calcRange() {
        return miles_per_kWh*battery_capacity;
    }
}
