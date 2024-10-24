public class RecursionHi {

    public static void main(String[] args) {
        System.out.println(countHiNextToX("xxhixx"));
    }

    public static int countHi(String str) {

        // Check for null
        if (str == null)
            return 0;

        // Base Case
        if (str.length() < 2)
            return 0;

        char char1 = str.toLowerCase().charAt(0);
        char char2 = str.toLowerCase().charAt(1);

        // Check pair of letters for 'hi'
        if (char1 == 'h' && char2 == 'i')
            return 1 + countHi(str.substring(2)); // Send in string minus first char

        return countHi(str.substring(1)); // If pair isnt 'hi' loop recursively

    }

    public static int countHiNextToX(String str) {
        // Check for null
        if (str == null)
            return 0;

        // Base Case
        if (str.length() < 3)
            return 0;

        char char1 = str.toLowerCase().charAt(0);
        char char2 = str.toLowerCase().charAt(1);
        char char3 = str.toLowerCase().charAt(2);

        // Check pair of letters for 'hi'
        if (char1 == 'h' && char2 == 'i')
            return 1 + countHiNextToX(str.substring(2)); // Send in string minus first char

        if (char1 == 'x' && char2 == 'h' && char3 == 'i')
            return countHiNextToX(str.substring(3));

        return countHiNextToX(str.substring(1)); // If pair isnt 'hi' loop recursively

    }
}
