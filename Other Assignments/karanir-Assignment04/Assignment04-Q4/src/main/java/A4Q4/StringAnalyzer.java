package A4Q4;

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
    }

    // Method to calculate word frequency count
    public Map<String, Integer> wordFrequencyCount() {
        // Clean the string
        String cleanedString = cleaner.cleanString();
        // Create a map to store word frequencies
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        // Split the string into words based on spaces
        String[] words = cleanedString.split("\\s+");

        // Count the frequency of each word
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        
        return wordCountMap;
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
