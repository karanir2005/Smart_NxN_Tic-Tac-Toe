package A4Q5;

/**
 * Hello world!
*/


public class App {

    public static void main(String[] args) {
        TextAnalyzer analyzer = new TextAnalyzer("Hello, 1 2 3 mic check. The quick brown fox jumped over the lazy dog. zzz");

        // Calculate average word length and most frequent letter
        analyzer.calculateAverageWordLength();

        // Print words in alphabetical order
        analyzer.printWordsInAlphabeticalOrder();
    }

}
