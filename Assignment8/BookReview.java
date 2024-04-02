import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookReview {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ratingRangeCounts = new int[2]; 
        int positiveReviews = 0;
        int neutralReviews = 0;
        int negativeReviews = 0;

       
        System.out.print("Enter the number of books reviewed: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numBooks; i++) {
            System.out.print("Enter book title: ");
            String bookTitle = scanner.nextLine();

            System.out.print("Enter book rating (1-10): ");
            int bookRating = scanner.nextInt();
            scanner.nextLine(); 
    
            if (bookRating >= 1 && bookRating <= 5) {
                ratingRangeCounts[0]++;
            } else if (bookRating >= 6 && bookRating <= 10) {
                ratingRangeCounts[1]++;
            }

        
            if (bookRating >= 8) {
                positiveReviews++;
            } else if (bookRating >= 4) {
                neutralReviews++;
            } else {
                negativeReviews++;
            }
        }

      
        System.out.println("\nBook review analysis:");
        System.out.println("Books rated 1-5 stars: " + ratingRangeCounts[0]);
        System.out.println("Books rated 6-10 stars: " + ratingRangeCounts[1]);
        System.out.println("Positive reviews: " + positiveReviews);
        System.out.println("Neutral reviews: " + neutralReviews);
        System.out.println("Negative reviews: " + negativeReviews);

        scanner.close();
    }
}
