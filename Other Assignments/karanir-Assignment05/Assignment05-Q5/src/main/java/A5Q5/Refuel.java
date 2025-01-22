package A5Q5;

/**
 * new interface for refueling the cars 
*/

public interface Refuel {

    void addEnergy(double amount); //method for adding energy to gas/eco cars.


    //overloaded methods for hybrid cars.
    //void addEnergy(double amount, String type); //overloaded method for adding a specific type of energy to cars.

    //void addEnergy(double amount_fuel, double amount_charge); //overloaded method for adding both types of energy to one car.
    
} 