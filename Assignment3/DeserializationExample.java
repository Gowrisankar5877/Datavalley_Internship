import java.io.*;
import java.util.Scanner;

class Product implements Serializable {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
    }
}

public class DeserializationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();
        
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        
        // Create the Product object with user input
        Product product = new Product(id, name, category, price);
        
        // Serialize the object
        String serializedProduct = serializeProduct(product);
        System.out.println("Serialized Product: " + serializedProduct);
        
        // Deserialize the object
        Product deserializedProduct = deserializeProduct(serializedProduct);
        System.out.println("Deserialized Product: " + deserializedProduct);
        
        scanner.close();
    }

    private static String serializeProduct(Product product) {
        String serializedProduct = null;
        try {
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
            objectOutput.writeObject(product);
            objectOutput.close();
            byteOutput.close();
            serializedProduct = byteOutput.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serializedProduct;
    }

    private static Product deserializeProduct(String serializedProduct) {
        Product product = null;
        try {
            byte[] bytes = serializedProduct.getBytes();
            ByteArrayInputStream byteInput = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInput = new ObjectInputStream(byteInput);
            product = (Product) objectInput.readObject();
            objectInput.close();
            byteInput.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }
}
