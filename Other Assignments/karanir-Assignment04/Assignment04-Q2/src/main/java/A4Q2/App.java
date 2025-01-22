package A4Q2;

/**
 * main class for testing Statistics Calculator!
 */
public class App {
    public static void main(String[] args) {
        try {
            int[] data = {10, 20, 30, 40, 50};
            StatisticsCalculator calculator = new StatisticsCalculator(data);

            System.out.printf("Average: %.2f\n", calculator.Avg());
            System.out.printf("Median: %.2f\n", calculator.Median());

            // Example of handling an exception
            int[] emptyData = {};
            calculator.updateArray(emptyData); // Should handle exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
