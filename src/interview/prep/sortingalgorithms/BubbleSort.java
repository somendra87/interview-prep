package interview.prep.sortingalgorithms;

import java.util.Arrays;

/**
 * @author somendraprakash created on 11/07/20
 */
public class BubbleSort
{
    private static void bubbleSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n -1 ; i++) {
            for (int j = 0; j < n - i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void display(int[] arr){
        Arrays.stream(arr).forEach(
                x-> System.out.print(x + "\t")
        );
    }

    public static void main(String[] args) {
        System.out.println("Bubble sort : ");
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("before sorting ");
        display(arr);
        bubbleSort(arr);
        System.out.println();
        System.out.println("After sorting the array is : ");
        display(arr);
    }

    /**
     * /Library/Java/JavaVirtualMachines/jdk-10.0.2.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ
     * IDEA CE.app/Contents/lib/idea_rt.jar=49851:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile
     * .encoding=UTF-8 -classpath /Users/somendraprakash/Documents/interviewprep/datastructures/out/production
     * /interview-prep interview.prep.sortingalgorithms.BubbleSort
     * Bubble sort :
     * before sorting
     * 10	80	30	90	40	50	70
     * After sorting the array is :
     * 10	30	40	50	70	80	90
     * Process finished with exit code 0
     */
}
