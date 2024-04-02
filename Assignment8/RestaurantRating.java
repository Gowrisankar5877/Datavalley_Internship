import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantRating{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> restaurantCountByRange = new HashMap<>();
        Map<String, Double> totalRatingByRange = new HashMap<>();

    
        System.out.print("Enter the number of restaurants: ");
        int numRestaurants = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numRestaurants; i++) {
            System.out.print("Enter restaurant name: ");
            String restaurantName = scanner.nextLine();

            System.out.print("Enter restaurant rating (1-10): ");
            int restaurantRating = scanner.nextInt();
            scanner.nextLine(); 

            String ratingRange = getRatingRange(restaurantRating);

           
            restaurantCountByRange.put(ratingRange, restaurantCountByRange.getOrDefault(ratingRange, 0) + 1);

           
            totalRatingByRange.put(ratingRange, totalRatingByRange.getOrDefault(ratingRange, 0.0) + restaurantRating);
        }

       
        System.out.println("\nRestaurant rating analysis:");
        for (Map.Entry<String, Integer> entry : restaurantCountByRange.entrySet()) {
            String range = entry.getKey();
            int count = entry.getValue();
            double averageRating = totalRatingByRange.get(range) / count;
            System.out.println("Rating Range: " + range + ", Number of restaurants: " + count + ", Average rating: " + averageRating);
        }

        scanner.close();
    }


    private static String getRatingRange(int rating) {
        if (rating >= 1 && rating <= 5) {
            return "1-5";
        } else if (rating >= 6 && rating <= 10) {
            return "6-10";
        } else {
            return "Unknown";
        }
    }
}
