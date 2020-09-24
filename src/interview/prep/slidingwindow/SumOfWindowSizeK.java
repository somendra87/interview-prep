package interview.prep.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author somendraprakash created on 21/09/20
 */
public class SumOfWindowSizeK
{
    private void sumOfWindowOfSizeK(int[] arr, int k) {
        int size = arr.length;
        int start = 0;
        int windowSum = 0;
        for (int end = 0; end < size; end++) {
            // condition is valid expand window
            windowSum += arr[end];
            //now check if the condition is invalid then SHRINK THE WINDOW
            // k-1 would give the index of the end of window
            if (end >= k - 1) {
                // print the sum
                System.out.print(windowSum + "\t");
                //remove the element which would be outside of the window now
                windowSum = windowSum - arr[start];
                start++;
            }
        }
    }

    int longestSubstringWithAllDistinctCharacters(String input){
        //this is for keeping the frequency of the characters
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int start = 0;
        int strLen = input.length();
        int maxSubstringLengthSoFar = 0;
        for (int end = 0; end < strLen ; end++){
            // what will we do when we see the first character
            char currentCharacter = input.charAt(end);
            frequencyMap.put(currentCharacter, maxSubstringLengthSoFar++);
            if (frequencyMap.get(currentCharacter) == 1 ){
                maxSubstringLengthSoFar = Math.max(maxSubstringLengthSoFar, end - start +1);
            }else{
                //shrinking the window
                while (frequencyMap.get(currentCharacter) >1){
                    frequencyMap.put(currentCharacter, maxSubstringLengthSoFar--);
                    start++;
                }
            }
        }
        return maxSubstringLengthSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 1, 6};// op = 11 | 8 | 9
        int k = 3;
        SumOfWindowSizeK windowSizeK = new SumOfWindowSizeK();
        windowSizeK.sumOfWindowOfSizeK(arr, k);
    }
}
