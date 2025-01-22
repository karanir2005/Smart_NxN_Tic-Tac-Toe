package A5Q6;

/**
 * Gasoline Car with tank capacity, miles per gallon (+make, model, colour, year extended from Car)
*/

public class HybridCar extends Car {

    //defines attributes for gasoline car objects
    private double fuel_tank_capacity;
    private double miles_per_gallon;
    private double current_fuel;

    private double battery_capacity;
    private double miles_per_kWh;
    private double current_battery;

    //overloaded constructor for hybrid cars with fuel and charge set to 0 automatically.
    public HybridCar(String make, String model, String colour, int year, double fuel_tank_capacity, double miles_per_gallon, double battery_capacity, double miles_per_kWh) {
        super(make, model, colour, year);
        this.fuel_tank_capacity = fuel_tank_capacity;
        this.miles_per_gallon = miles_per_gallon;
        this.current_fuel=0; //makes object with empty tank
        this.battery_capacity = battery_capacity;
        this.miles_per_kWh = miles_per_kWh;
        this.current_battery=0; //makes object with empty battery
    }

    //overloaded constructor for hybrid cars where the starting amount of fuel and charge can be customised.
    public HybridCar(String make, String model, String colour, int year, double fuel_tank_capacity, double miles_per_gallon,
                    double current_fuel, double battery_capacity, double miles_per_kWh, double current_battery) {

        super(make, model, colour, year);
        this.fuel_tank_capacity = fuel_tank_capacity;
        this.miles_per_gallon = miles_per_gallon;
        this.current_fuel=current_fuel;
               
        this.battery_capacity = battery_capacity;
        this.miles_per_kWh = miles_per_kWh;
        this.current_battery = current_battery; 
    }

    //getter methods for tank capacity and miles/gallon + current fuel level
    public double getMilesPerGallon(){
        return miles_per_gallon;
    }

    public double getFuelTankCapacity(){
        return fuel_tank_capacity;
    }

    public double getCurrentFuel(){
        return current_fuel;
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
        if (battery_capacity==0){
            return miles_per_gallon;
        }
        else{
            return ((miles_per_gallon+miles_per_kWh)/2);
        }
    }

    @Override
    public double calcRange() {
        double total_range = miles_per_gallon*fuel_tank_capacity + miles_per_kWh*battery_capacity;
        return total_range;
    }

    //@Override //we dont override here, since the addEnergy method does not follow same parameter list as the Refuel interface.

    //overloaded method for adding equal amounts of fuel and charge to car. 
    public void addEnergy(double amount) {
        if (battery_capacity!=0) {
            if (current_battery + amount > battery_capacity) {
                current_battery = battery_capacity;
                System.out.println("Battery Overflow! Charged to max battery level instead.");
                System.out.println("Current battery: " + current_battery);
            } else {
                current_battery += amount;
                System.out.println("Added! Current battery: " + current_battery);
            }
        }

        if (current_fuel + amount > fuel_tank_capacity) {
            current_fuel = fuel_tank_capacity;
            System.out.println("Fuel Overflow! Filled to max tank level instead.");
            System.out.println("Current fuel: " + current_fuel);
        } else {
            current_fuel += amount;
            System.out.println("Added! Current fuel: " + current_fuel);
        }
    }


    //overloaded method for adding a specific type of energy (gas/fuel)
    public void addEnergy(double amount, String type) {
        if (type.equalsIgnoreCase("fuel")) {
            if (current_fuel + amount > fuel_tank_capacity) {
                current_fuel = fuel_tank_capacity;
                System.out.println("Fuel Overflow! Filled to max tank level instead.");
                System.out.println("Current fuel: " + current_fuel);
            } else {
                current_fuel += amount;
                System.out.println("Added! Current fuel: " + current_fuel);
            }
        }
        else if (type.equalsIgnoreCase("charge")){
            if (battery_capacity!=0) {
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
        else{
            System.out.println("Specify the fuel type to add.\"fuel\" or \"gas\". ");
        }
    }

    //overloaded method for adding different amounts of fuel and charge.
    public void addEnergy(double amt_fuel, double amt_charge){
        if (battery_capacity!=0) {
            if (current_battery + amt_charge > battery_capacity) {
                current_battery = battery_capacity;
                System.out.println("Battery Overflow! Charged to max battery level instead.");
                System.out.println("Current battery: " + current_battery);
            } else {
                current_battery += amt_charge;
                System.out.println("Added! Current battery: " + current_battery);
            }
        }

        if (current_fuel + amt_fuel > fuel_tank_capacity) {
            current_fuel = fuel_tank_capacity;
            System.out.println("Fuel Overflow! Filled to max tank level instead.");
            System.out.println("Current fuel: " + current_fuel);
        } else {
            current_fuel += amt_fuel;
            System.out.println("Added! Current fuel: " + current_fuel);
        }
    }
}
