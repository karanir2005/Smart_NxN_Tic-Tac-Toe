package A4Q3;

/**
 * main method for testing
*/

// App.java
public class App {

    public static void main(String[] args) {
        // Sample string to be cleaned
        String sampleString = " Hello, nice you meet you ! ?   This is  a   test... 1  2 3 ";

        // Create a StringCleaner object with the sample string
        StringCleaner cleaner1 = new StringCleaner(sampleString);
        StringCleaner cleaner2 = new StringCleaner(sampleString);
        StringCleaner cleaner3 = new StringCleaner(sampleString);
        StringCleaner cleaner4 = new StringCleaner(sampleString);

        // Clean the string using the cleanString() method

        // Output the cleaned string
        System.out.println("Original String: " + sampleString);
        System.out.println("Remove punct: " + cleaner1.cleanPunct());
        System.out.println("Lowercase: " + cleaner2.lowercase());
        System.out.println("Remove Spaces: " + cleaner3.cleanSpace());
        System.out.println("All: " + cleaner4.cleanString());
    }
}