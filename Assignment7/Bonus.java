import java.util.Scanner;

public class Bonus{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for current year and year of joining
        System.out.print("Enter the current year: ");
        int currentYear = scanner.nextInt();
        System.out.print("Enter the year of joining: ");
        int yearOfJoining = scanner.nextInt();

        // Calculating years of service
        int yearsOfService = currentYear - yearOfJoining;

        // Checking conditions for bonus
        if (yearsOfService > 5) {
            System.out.println("Congratulations! You have been awarded a bonus of Rs. 5000/-");
        } else if (yearsOfService >= 3 && yearsOfService <= 5) {
            System.out.println("Congratulations! You have been awarded a bonus of Rs. 3000/-");
        } else {
            System.out.println("Sorry, no bonus is awarded.");
        }

        scanner.close();
    }
}
