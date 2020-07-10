package interview.prep.sortingalgorithms;

import java.util.Arrays;

/**
 * @author somendraprakash created on 11/07/20
 */
public class SelectionSort
{
    private static void selectionSort(int[] arr){
        int minIndex ;
        for (int i =0 ; i < arr.length-1; i++){
            minIndex = i;
            for (int j = i + 1; j < arr.length ; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //swap arr[i] and arr[minIndex]
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    private static void display(int[] arr){
        Arrays.stream(arr).forEach(
                s -> System.out.print( s + "\t")
        );
    }

    public static void main(String[] args) {
        System.out.println("Selection sort : ");
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("before sorting ");
        display(arr);
        System.out.println();
        selectionSort(arr);
        System.out.println("After sorting the array is : ");
        display(arr);
    }


    /**
     * out put :
     * Selection sort :
     * before sorting
     * 10	80	30	90	40	50	70
     * After sorting the array is :
     * 10	30	40	50	70	80	90
     */
}
