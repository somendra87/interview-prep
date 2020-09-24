package interview.prep.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author somendraprakash created on 06/09/20
 */
public class MaxNumberOfVowels
{
    private Set<Character> vowels;
    private int vowelCount = 0;

    MaxNumberOfVowels() {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    int getMaxNumOfVowelsInString(String s, int k) {
        //1. Process for first k elements
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelCount++;
            }
        }

        //keep track of left most and right most character of the window
        int leftMostCharacter = 0;
        int rightMostCharacter = k - 1; // as window size is fixed
        int maxVowelsCount = vowelCount;

        //look in the remaining window
        while (rightMostCharacter < s.length() - 1) {
            if (vowels.contains(s.charAt(leftMostCharacter))) {
                vowelCount--;
            }
            leftMostCharacter++;
            rightMostCharacter++;
            if (vowels.contains(s.charAt(rightMostCharacter))) {
                vowelCount++;
                maxVowelsCount = Math.max(maxVowelsCount, vowelCount);
            }
        }
        return maxVowelsCount;
    }

    public static void main(String[] args) {
        MaxNumberOfVowels maxNumberOfVowels = new MaxNumberOfVowels();
        int maxVal = maxNumberOfVowels.getMaxNumOfVowelsInString("abciiidefoooooooo", 5);
        System.out.println(maxVal);
    }
}
