package A4Q5;

/**
 * Hello world!
*/


public class StringCleaner {

    private String input;

    // Constructor to initialize the input string
    public StringCleaner(String input) {
        this.input = input;
    }

    // Private method to remove punctuation from a string
    private String removePunctuation(String input) {
        // Remove all punctuation characters using regex
        return input.replaceAll("[\\p{Punct}]", "");
    }

    // Private method to convert the string to lowercase
    private String convertToLowercase(String input) {
        // Convert string to lowercase
        return input.toLowerCase();
    }

    // Private method to remove extra spaces (leading, trailing, and multiple spaces between words)
    private String removeExtraSpaces(String input) {
        // Trim leading/trailing spaces and replace multiple spaces with a single space
        return input.trim().replaceAll("\\s+", " ");
    }

    // Public method to clean the string using all the preprocessing steps
    public String cleanString() {
        
        input = removePunctuation(input);
        input = convertToLowercase(input);
        input = removeExtraSpaces(input);
        return input;
    }
    public String lowercase() {
       
        input = convertToLowercase(input);
        return input;
    }
    public String cleanPunct() {
        
        input = removePunctuation(input);
       
        return input;
    }
    public String cleanSpace() {
        
       
        input = removeExtraSpaces(input);
        return input;
    }
    
}
