public class SumDivisibility {
    public static void main(String[] args) {
        int[] values = {100, 52, 43, 99, 42, 40, 91};
        int sum = 0;
        for (int num : values) {
            if (num % 5 == 0 && num % 2 == 0) {
                sum += num;
            }
        }
        System.out.println("Sum of numbers divisible by 5 and 2: " + sum);
    }
}
