package A5Q6;

/**
 * Abstract class Car with make, model, fuel efficiency and range methods
*/

public abstract class LuxuryCar extends Car {

    //defines attributes for LuxuryCars (massage seats, sunroof);
    private boolean has_massage_seats;
    private boolean has_sunroof;
    
    //constructor for LuxuryCar class, makes the arguments recieved equal to the attributes defined above.
    public LuxuryCar(String make, String model, String colour, int year, boolean has_massage_seats, boolean has_sunroof) {
        super (make, model, colour, year);
        this.has_massage_seats=has_massage_seats;
        this.has_sunroof=has_sunroof;
    }

    //getter methods for make and model

    public boolean getMassageSeats(){
        return has_massage_seats;
    }

    public boolean getSunroof(){
        return has_sunroof;
    }

    //abstract methods created to be used by subclasses
    public abstract double calcLuxuryTax();
}
