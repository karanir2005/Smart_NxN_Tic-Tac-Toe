package A5Q6;

/**
 * electric Car with battery capacity and miles per kWh (+make, model, colour, year extended from Car)
*/

public class ElectricCar extends Car implements Refuel {

    //defines attributes for electric car objects
    private double battery_capacity;
    private double miles_per_kWh;
    private double current_battery; //stores current battery level

    //constructor for electric car class.
    public ElectricCar(String make, String model, String colour, int year, double battery_capacity, double miles_per_kWh) {
        super(make, model, colour, year);
        this.battery_capacity = battery_capacity;
        this.miles_per_kWh = miles_per_kWh;
        this.current_battery = 0; //makes car with no battery
    }

    //getter methods for battery capacity and miles/kwh +current battery capacity
    public double getMilesPerKWh(){
        return miles_per_kWh;
    }

    public double getBatteryCapacity(){
        return battery_capacity;
    }

    public double getCurrentBattery(){
        return current_battery;
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

    @Override
    public void addEnergy(double amount) {
        if (current_battery + amount > battery_capacity) {
            current_battery = battery_capacity;
            System.out.println("Battery Overflow! Charged to max battery level instead.");
            System.out.println("Current battery: " + current_battery);
        } else {
            current_battery += amount;
            System.out.println("Added! Current battery: " + current_battery);
        }
    }
}
