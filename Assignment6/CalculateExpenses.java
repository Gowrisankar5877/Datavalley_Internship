import java.util.Scanner;

public class CalculateExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the quantity purchased: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter the price per item: $");
        double pricePerItem = scanner.nextDouble();

        if (quantity <= 0 || pricePerItem <= 0) {
            System.out.println("Invalid input. Quantity and price per item should be positive numbers.");
            return;
        }

        double totalCost = quantity * pricePerItem;
        double discount;

        if (quantity > 50) {
            discount = 0.1 * totalCost;
        } else if (quantity >= 25 && quantity <= 50) {
            discount = 0.05 * totalCost;
        } else {
            discount = 0;
        }

        double totalExpenses = totalCost - discount;
        System.out.printf("Total expenses: $%.2f\n", totalExpenses);
	  System.out.println("Discount is: $A%.2f\n", discount);

        scanner.close();
    }
}
