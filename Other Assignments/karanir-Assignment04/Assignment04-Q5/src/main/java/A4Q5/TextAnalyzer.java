package A4Q5;

/**
 * Hello world!
 */
import java.util.*;

public class TextAnalyzer extends StringAnalyzer {

    // Constructor
    public TextAnalyzer(String input) {
        super(input);  // Call the constructor of StringAnalyzer to initialize the input
    }

    // Method to calculate the average word length and most frequent letter
    public void calculateAverageWordLength() {
        // Clean the string
        String cleanedString = getCleaner().cleanString();

        // Split the string into words
        String[] words = cleanedString.split("\\s+");

        // Calculate total word length and count of words
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }

        // Calculate average word length
        double averageLength = (double) totalLength / words.length;

        // Print the average word length
        System.out.println("Average word length: " + averageLength);

        // Find the most frequent letter in the cleaned string
        findMostFrequentLetter(cleanedString);
    }


    // Method to find the most frequent letter in the cleaned string
    private void findMostFrequentLetter(String cleanedString) {
        // Remove spaces and convert to lowercase for frequency counting
        cleanedString = cleanedString.replaceAll("\\s+", "").toLowerCase();

        // Create a frequency map for letters
        int[] letterFrequency = new int[26];  // For 26 lowercase letters (a-z)

        // Count the frequency of each letter
        for (char ch : cleanedString.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterFrequency[ch - 'a']++; //index 0 for a, 1 for b ...etc. (uses unicode values)
            }
        }

        // Find the most frequent letter
        int maxFrequency = 0;
        char mostFrequentLetter = ' ';
        for (int i = 0; i < letterFrequency.length; i++) {
            if (letterFrequency[i] > maxFrequency) {
                maxFrequency = letterFrequency[i];
                mostFrequentLetter = (char) (i + 'a');
            }
        }

        // Print the most frequent letter
        System.out.println("Most frequent letter: " + mostFrequentLetter);
    }

    // Method to print words in alphabetical order
    public void printWordsInAlphabeticalOrder() {
        // Clean the string using StringCleaner class method
        String cleanedString = getCleaner().cleanString();
    
        // Split the string into words using regular expression
        String[] words = cleanedString.split("\\s+");
    
        // Create a List to hold unique words
        List<String> uniqueWordsList = new ArrayList<>(); //use arraylists so we can easily compare for duplicates and sort the list.
    
        // Add words to the list, ensuring no duplicates
        for (String word : words) {
            // Check if the word is already in the list before adding it
            if (!uniqueWordsList.contains(word)) {
                uniqueWordsList.add(word);
            }
        }
    
        // Sort the list in alphabetical order
        Collections.sort(uniqueWordsList);
    
        // Print the sorted list of words
        System.out.println("Words in alphabetical order:");
        for (String word : uniqueWordsList) {
            System.out.println(word);
        }
    }
}