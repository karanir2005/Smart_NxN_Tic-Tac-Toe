package A4Q4;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
*/

public class App {

    public static void main(String[] args) {
        StringAnalyzer analyzer = new StringAnalyzer("hi hi hi hi hi dfjskh fh hi");

        // Word frequency count
        Map<String, Integer> wordCount = analyzer.wordFrequencyCount();
        System.out.println("Word Frequencies: " + wordCount);

        // Longest word
        try {
            String longestWord = analyzer.findLongestWord();
            System.out.println("Longest Word: " + longestWord);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        // Palindrome check
        try {
            boolean isPalindrome = analyzer.isPalindrome();
            System.out.println("Is Palindrome: " + isPalindrome);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

}
