package interview.prep.sortingalgorithms;

import java.util.Arrays;

/**
 * @author somendraprakash created on 11/07/20
 */
public class InsersionSort
{

    private static void insertionSort(int[] arr) {
        int key;
        int placeHolderIndex;
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            placeHolderIndex = i - 1;
            while (placeHolderIndex >= 0 && arr[placeHolderIndex] > key) {
                arr[placeHolderIndex + 1] = arr[placeHolderIndex];
                placeHolderIndex = placeHolderIndex - 1;
            }
            arr[placeHolderIndex + 1] = key;
        }
    }

    private static void display(int[] arr) {
        Arrays.stream(arr).forEach(
                element -> System.out.print(element + "\t")
        );
    }

    public static void main(String[] args) {
        System.out.println("Insersion sort : ");
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("before sorting ");
        display(arr);
        insertionSort(arr);
        System.out.println();
        System.out.println("After sorting the array is : ");
        display(arr);
    }

    /**
     * /Library/Java/JavaVirtualMachines/jdk-10.0.2.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ
     * IDEA CE.app/Contents/lib/idea_rt.jar=49872:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile
     * .encoding=UTF-8 -classpath /Users/somendraprakash/Documents/interviewprep/datastructures/out/production
     * /interview-prep interview.prep.sortingalgorithms.InsersionSort
     * Insersion sort :
     * before sorting
     * 10	80	30	90	40	50	70
     * After sorting the array is :
     * 10	30	40	50	70	80	90
     * Process finished with exit code 0
     */

}
