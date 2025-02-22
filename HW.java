import java.util.*;

public class ArrayCalculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        double[] numbers = new double[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        }

        double sum = calculateSum(numbers);
        double average = sum / n;
        double max = Arrays.stream(numbers).max().getAsDouble();
        double min = Arrays.stream(numbers).min().getAsDouble();
        double stdDev = calculateStandardDeviation(numbers, average);
        double median = calculateMedian(numbers);

        System.out.println("\nResults:");
        System.out.printf("Sum: %.2f\n", sum);
        System.out.printf("Average: %.2f\n", average);
        System.out.printf("Maximum: %.2f\n", max);
        System.out.printf("Minimum: %.2f\n", min);
        System.out.printf("Standard Deviation: %.2f\n", stdDev);
        System.out.printf("Median: %.2f\n", median);

        Arrays.sort(numbers);
        System.out.println("\nArray in ascending order:");
        for (double num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static double calculateSum(double[] numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    private static double calculateStandardDeviation(double[] numbers, double mean) {
        double sum = 0;
        for (double num : numbers) {
            sum += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sum / numbers.length);
    }

    private static double calculateMedian(double[] numbers) {
        double[] sorted = numbers.clone();
        Arrays.sort(sorted);
        int n = sorted.length;
        if (n % 2 == 0) {
            return (sorted[n / 2 - 1] + sorted[n / 2]) / 2.0;
        } else {
            return sorted[n / 2];
        }
    }
}
