import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;
        boolean continueInput = true;

        while (continueInput) {
            System.out.print("Enter a number (enter -1 to stop): ");
            number = scanner.nextInt();

            if (number == -1) {
                continueInput = false;
            } else {
                sum += number;
                count++;

                if (number > largest) {
                    largest = number;
                }

                if (number < smallest) {
                    smallest = number;
                }
            }
        }

        if (count == 0) {
            System.out.println("No numbers entered.");
        } else {
            double average = (double) sum / count;

            System.out.println("Largest number entered: " + largest);
            System.out.println("Smallest number entered: " + smallest);
            System.out.printf("Average of all numbers entered: %.2f\n", average);
        }

        scanner.close();
    }
}
