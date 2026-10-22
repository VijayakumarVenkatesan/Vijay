public class IntegerToRoman {
    public static String intToRoman(int num) {
        // Roman numeral values and symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Greedy approach
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        int number = 3749; // Example
        System.out.println("Integer: " + number);
        System.out.println("Roman: " + intToRoman(number));
    }
}
