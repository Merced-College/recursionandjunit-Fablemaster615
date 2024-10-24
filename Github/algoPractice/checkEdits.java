public class checkEdits {
    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "bae";
        System.out.println(checkIfOneEdit(str1, str2));
    }

    public static boolean checkIfOneEdit(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        if (str2.length() > str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        if ((str1.length() - str2.length()) > 1) {
            return false;
        }
        if (str1.length() - str2.length() >= 2)
            return false;
        int counter = 0;
        int i = 0, j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (counter == 1) {
                    return false;
                }
                if (str1.length() == str2.length()) {
                    j++;
                }
                counter++;
            } else {
                j++;
            }
            i++;
        }

        return true;
    }
}
