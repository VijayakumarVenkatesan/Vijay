package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LettersCombinationOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        HashMap<Character, String> phn = new HashMap<>();
        phn.put('2', "abc");
        phn.put('3', "def");
        phn.put('4', "ghi");
        phn.put('5', "jkl");
        phn.put('6', "mno");
        phn.put('7', "pqrs");
        phn.put('8', "tuv");
        phn.put('9', "wxyz");
        backtrack(result, phn, digits, 0, new StringBuilder());
        return result;
    }
    private static void backtrack(List<String> result, HashMap<Character, String> phn,
                           String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = phn.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, phn, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("678"));
    }
}
