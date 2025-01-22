    package A4Q2;
import java.util.Arrays; //imported for the Array.sort utility

/**
 * Class that can calculate avearge and medians of the 
 */
public class StatisticsCalculator {
    private int[] data;

    // Constructor that accepts an array of integers
    public StatisticsCalculator(int[] data) {
        updateArray(data);
    }

    // Method to calculate the average of the elements in the array
    public double Avg(){
        return calcAvg();
    }
    private double calcAvg() {
        if (data.length == 0) {
            throw new ArithmeticException("Array is empty. Cannot perform operation.");
        }

        double sum = 0;
        for (int num : data) {
            sum += num;
        }
        double avg = sum / data.length;
        return avg;
    }

    // Method to calculate the median of the elements in the array
    public double Median(){
        return calcMedian();
    }
    private double calcMedian() {
        if (data.length == 0) {
            throw new ArithmeticException("Array is empty. Cannot perform operation.");
        }

        int[] sortedData = data.clone();
        Arrays.sort(sortedData);
        int middle = sortedData.length / 2;
        double median;
        if (sortedData.length % 2 == 0) {
            median = (sortedData[middle - 1] + sortedData[middle]) / 2.0;
        } else {
            median = sortedData[middle];
        }
        return median;
    }

    // Method to update the array with a new set of integers
    public void updateArray(int[] newData) {
        if (newData == null || newData.length == 0) {
            throw new IllegalArgumentException("Invalid input. Array cannot be null or empty.");
        }
        this.data = newData.clone();
    }

    // Method to retrieve a copy of the current array
    public int[] accessArray() {
        return data.clone();
    }
}
