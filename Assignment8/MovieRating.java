import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieRating {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> movieCountByRating = new HashMap<>();
        Map<String, Double> totalRatingByRating = new HashMap<>();

        // Collecting movie ratings from the user
        System.out.print("Enter the number of movies: ");
        int numMovies = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numMovies; i++) {
            System.out.print("Enter movie title: ");
            String movieTitle = scanner.nextLine();

            System.out.print("Enter movie rating (e.g., U, U/A, A): ");
            String movieRating = scanner.nextLine().toUpperCase();

            System.out.print("Enter movie rating (out of 10): ");
            double movieRatingValue = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            // Update movie count by rating
            movieCountByRating.put(movieRating, movieCountByRating.getOrDefault(movieRating, 0) + 1);

            // Update total rating by rating
            totalRatingByRating.put(movieRating, totalRatingByRating.getOrDefault(movieRating, 0.0) + movieRatingValue);
        }

        // Displaying results
        System.out.println("\nMovie ratings analysis:");
        for (Map.Entry<String, Integer> entry : movieCountByRating.entrySet()) {
            String rating = entry.getKey();
            int count = entry.getValue();
            double averageRating = totalRatingByRating.get(rating) / count;
            System.out.println("Category: " + rating + ", Number of movies: " + count + ", Average rating: " + averageRating);
        }

        scanner.close();
    }
}
