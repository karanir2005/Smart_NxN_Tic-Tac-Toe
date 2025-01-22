package A4Q5;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
*/

public class StringAnalyzer {

    private StringCleaner cleaner;

    // Constructor that uses StringCleaner to initialize and clean the input string
    public StringAnalyzer(String input) {
        cleaner = new StringCleaner(input);
        this.cleaner = cleaner;
    }

    public StringCleaner getCleaner() {
        return cleaner;
    }

    // Method to calculate word frequency count
    public void wordFrequencyCount() {
        // Clean the string
        String cleanedString = cleaner.cleanString();
        
        // Split the string into words based on spaces
        String[] words = cleanedString.split("\\s+");

        // Iterate through words and count frequency manually
        for (int i = 0; i < words.length; i++) {
            // If the word is empty, skip it
            if (words[i].isEmpty()) {
                continue;
            }
            
            int count = 1;
            // Compare this word to the rest of the words
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                    words[j] = ""; // Mark this word as counted by replacing it with an empty string
                }
            }

            // Print the word and its frequency
            
            if (!words[i].isEmpty()) {
                System.out.println(words[i] + ": " + count);
            }
        }
    }

    // Method to find the longest word in the cleaned string
    public String findLongestWord() {
        String cleanedString = cleaner.cleanString();
        
        if (cleanedString.isEmpty()) {
            throw new ArithmeticException("The string is empty, cannot find the longest word.");
        }

        String[] words = cleanedString.split("\\s+");
        String longestWord = words[0];

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    // Method to check if the cleaned string is a palindrome
    public boolean isPalindrome() {
        String cleanedString = cleaner.cleanString();

        if (cleanedString.isEmpty()) {
            throw new ArithmeticException("The string is empty, cannot check for palindrome.");
        }

        // Remove spaces and convert to lowercase
        cleanedString = cleanedString.replaceAll("\\s", "").toLowerCase();

        // Check if the string is a palindrome
        int length = cleanedString.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanedString.charAt(i) != cleanedString.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
