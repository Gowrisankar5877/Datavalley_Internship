import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentScore{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> scores = new ArrayList<>();


        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter score for student " + (i + 1) + ": ");
            double score = scanner.nextDouble();
            scanner.nextLine(); 
            scores.add(score);
        }


        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        double average = sum / scores.size();

       
        Collections.sort(scores);


        double median;
        if (scores.size() % 2 == 0) {
            median = (scores.get(scores.size() / 2) + scores.get(scores.size() / 2 - 1)) / 2.0;
        } else {
            median = scores.get(scores.size() / 2);
        }

        int aboveAverage = 0;
        int atAverage = 0;
        int belowAverage = 0;

        for (double score : scores) {
            if (score > average) {
                aboveAverage++;
            } else if (score == average) {
                atAverage++;
            } else {
                belowAverage++;
            }
        }

      
        System.out.println("\nScore Analysis:");
        System.out.println("Average Score: " + average);
        System.out.println("Median Score: " + median);
        System.out.println("Students above average: " + aboveAverage);
        System.out.println("Students at average: " + atAverage);
        System.out.println("Students below average: " + belowAverage);

        scanner.close();
    }
}
