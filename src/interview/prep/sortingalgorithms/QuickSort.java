package interview.prep.sortingalgorithms;

import java.util.Arrays;

/**
 * @author somendraprakash created on 11/07/20
 */
public class QuickSort
{
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            //pivot
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < arr.length-1; j++) {
            if (arr[j] < pivot) {
                // increment i
                i = i + 1;
                //swap arr[j] and arr[i]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap arr[i + 1] and  arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static void display(int[] arr){
        Arrays.stream(arr).forEach(
                x -> System.out.print(x + "\t")
        );
    }

    public static void main(String[] args) {
        System.out.println("Quick sort : ");
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("before sorting ");
        display(arr);
        System.out.println();
        System.out.println("After sorting using quick sort");
        quickSort(arr, 0, arr.length - 1);
        display(arr);
    }

    /**
     * output :
     * Quick sort :
     * before sorting
     * 10	80	30	90	40	50	70
     * After sorting using quick sort
     * 10	30	40	50	70	80	90
     */
}
