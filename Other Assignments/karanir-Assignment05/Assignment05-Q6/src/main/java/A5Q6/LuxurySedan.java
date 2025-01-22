package A5Q6;

/**
 * Luxury Car with cost (+make, model, colour, year extended from Car and +massage seats and sunroof from Luxury car)
*/

public class LuxurySedan extends LuxuryCar {

    //defines attributes for luxury car objects
    private double cost;

    //constructor for luxury car class,.
    public LuxurySedan(String make, String model, String colour, int year, boolean has_massage_seats, boolean has_sunroof, double cost) {
        super(make, model, colour, year, has_massage_seats, has_sunroof);
        this.cost = cost;
    }

    //getter method for cost
    public double getCost(){
        return cost;
    }

    //methods that use the abstract classes from Car
    @Override
    public double calcFuelEff() {
        return 40; //assume a fixed amount for now
    }

    @Override
    public double calcRange() {
        return 7000; //assume a fixed amount for all luxury sedans
    }

    //methods that use the abstract classes from LuxuryCar
    @Override
    public double calcLuxuryTax() {
        double lux_tax=cost*0.05; //assume luxury tax is 5% of cost.
        if (getMassageSeats()) {
            lux_tax += 500; // Add fixed tax for massage seats
        }
        if (getSunroof()) {
            lux_tax += 300; // Add fixed tax for sunroof
        }
        return lux_tax;
    }
}
