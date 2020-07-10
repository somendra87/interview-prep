package interview.prep.sortingalgorithms;

import java.util.Arrays;

/**
 * @author somendraprakash created on 11/07/20
 */
public class MergeSort
{
    private static void mergeSortRoutine(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSortRoutine(arr, low, mid);
            mergeSortRoutine(arr, mid + 1, high);
            mergeRoutine(arr, low, mid, high);
        }
    }

    private static void mergeRoutine(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2){
            if (left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1){
            arr[k] = left[i];
            i++;
            k++;
        }

        while ( j < n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    private static void display(int[] arr){
        Arrays.stream(arr).forEach(
                x-> System.out.print(x + "\t")
        );
    }
    public static void main(String[] args) {
        System.out.println("Merge sort : ");
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("before sorting ");
        display(arr);
        mergeSortRoutine(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("After sorting the array is : ");
        display(arr);
    }

    /**
     * /Library/Java/JavaVirtualMachines/jdk-10.0.2.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ
     * IDEA CE.app/Contents/lib/idea_rt.jar=49847:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile
     * .encoding=UTF-8 -classpath /Users/somendraprakash/Documents/interviewprep/datastructures/out/production
     * /interview-prep interview.prep.sortingalgorithms.MergeSort
     * Merge sort :
     * before sorting
     * 10	80	30	90	40	50	70
     * After sorting the array is :
     * 10	30	40	50	70	80	90
     * Process finished with exit code 0
     */
}
