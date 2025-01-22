package A5Q2;

/**
 * Abstract class Car with make, model, fuel efficiency and range methods
*/

public abstract class Car {

    //defines attributes for car objects (colour and year added just for fun!)
    private String make;
    private String model;
    private String colour;
    private int year;

    //constructor for Car class, makes the arguments recieved equal to the attributes defined above.
    public Car(String make, String model, String colour, int year) {
        this.make=make;
        this.model=model;
        this.colour=colour;
        this.year=year;
    }

    //getter methods for make and model
    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    //additional getter methods for attributes
    public String getColour(){
        return colour;
    }

    public int getYear(){
        return year;
    }

    //abstract methods created to be used by subclasses
    public abstract double calcFuelEff();

    public abstract double calcRange();
}
