package A5Q2;

/**
 * Test class for A5Q2
 */
public class App {
    public static void main(String[] args) {
        //System.out.println("Hello World!");

        //testing classes, creating 2 new car objects.
        Car ecoCar = new ElectricCar("Tesla", "Model3", "Red", 2018, 500, 10);
        Car gasCar = new GasolineCar("Toyota", "Corolla", "Blue", 2014, 650, 7.5);

        //print eco car info
        System.out.println("Make and Model: "+ecoCar.getMake()+" "+ecoCar.getModel());
        System.out.println("Colour and Year: "+ecoCar.getColour()+" "+ecoCar.getYear());
        System.out.println("Fuel Efficiency: "+ecoCar.calcFuelEff()+" miles/kWh.");
        System.out.println("Range: "+ecoCar.calcRange()+" miles.");

        //print gas car info
        System.out.println("Make and Model: "+gasCar.getMake()+" "+gasCar.getModel());
        System.out.println("Colour and Year: "+gasCar.getColour()+" "+gasCar.getYear());
        System.out.println("Fuel Efficiency: "+gasCar.calcFuelEff()+" miles/kWh.");
        System.out.println("Range: "+gasCar.calcRange()+" miles.");
    }        
}

