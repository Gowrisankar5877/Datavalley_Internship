import java.util.*;

public class ReplaceCharacterAtIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the original string: ");
        String inputString = scanner.nextLine();

        System.out.print("Enter the index to replace (0 to " + (inputString.length() - 1) + "): ");
        int indexToReplace = scanner.nextInt();

        if (indexToReplace < 0 || indexToReplace >= inputString.length()) {
            System.out.println("Invalid index!");
            return;
        }

       
        System.out.print("Enter the new character: ");
        char newCharacter = scanner.next().charAt(0);


        String modifiedString = replaceCharacterAtIndex(inputString, indexToReplace, newCharacter);

        // Printing the results
        System.out.println("Original String: " + inputString);
        System.out.println("Modified String: " + modifiedString);

        scanner.close();
    }

    public static String replaceCharacterAtIndex(String str, int index, char newChar) {
        if (str == null || index < 0 || index >= str.length()) {
            return str;
        }

        char[] charArray = str.toCharArray();
        charArray[index] = newChar;

        return new String(charArray);
    }
}
