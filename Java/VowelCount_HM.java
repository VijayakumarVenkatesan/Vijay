import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VowelCount_HM {
    public static void countVowels(String s1) {
        s1 = s1.toLowerCase().replace(" ", "");
        Map<Character, Integer> vowelCount = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            }
        }
        for (char v : "aeiou".toCharArray()) {
            if (vowelCount.containsKey(v)) {
                System.out.println(v + " " + vowelCount.get(v));
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s1 = in.nextLine();
        countVowels(s1);
    }
}
