public class OddPositionsCharacters {
    public static void main(String[] args) {
        String text = "type here to search";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != ' ' && i % 2 == 0) {
                System.out.print(c);
            }
        }
    }
}
