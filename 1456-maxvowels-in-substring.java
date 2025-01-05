import java.util.Arrays;
import java.util.HashSet;

class Solution {
    HashSet<Character> vowelsSet = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public Boolean isVowel(Character c) {
        if (!Character.isAlphabetic(c)) {
            return false;
        }
        return vowelsSet.contains(Character.toLowerCase(c));
    }

    public int maxVowels(String s, int k) {
        Integer currCount = 0;
        Integer maxCount = 0;
        Integer start = 0;
        for (int i = 0; i < k && i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currCount++;
            }
        }
        maxCount = Math.max(maxCount, currCount);

        while (start < s.length()) {
            if (isVowel(s.charAt(start))) {
                currCount--;
            }
            start++;
            if (start + k - 1 < s.length() && isVowel(s.charAt(start + k - 1))) {
                currCount++;
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}