//Anthony Rocci | 10-24-2024
//Recursion Practice Class

public class Recursion {
    public static void main(String[] args) {
        // Test cases
        System.out.println(count8(8)); // Expected Outcome: 1
        System.out.println(count8(8102)); // Expected Outcome: 1
        System.out.println(count8(8810)); // Expected Outcome: 2
        System.out.println(count8(8888)); // Expected Outcome: 4
        System.out.println(count8(884568)); // Expected Outcome: 3
        System.out.println(count8(888888888)); // Expected Outcome: 9
    }

    public static int count8(int n) {
        // Base Case
        if (n == 0)
            return 0;

        // Check rightmost digit
        int rightmostDigit = n % 10;

        // If rightmost digit is 8
        if (rightmostDigit == 8) {
            return 1 + count8(n / 10);
        } else {
            // If the rightmost digit is not 8, just proceed to the next digit
            return count8(n / 10);
        }

    }

}