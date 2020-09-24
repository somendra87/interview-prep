package interview.prep.heaps;

/**
 * @author somendraprakash created on 16/08/20
 */
public class HeapApp
{
    private void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i > 0; i--) {
            maxHeapify(arr, i);
        }
        for (int ik : arr) {
            System.out.print(ik + "\t");
        }
    }

    private void maxHeapify(int[] arr, int i) {
        int heapSize = 0;
        heapSize = arr.length-1;
        int l = 2 * i;
        int r = (2 * i) + 1;
        int largest = 0;
        if (l <= heapSize && arr[l] > arr[i]) {
            largest = l;
        }else{
            largest = i;
        }
        if (r <= heapSize && arr[r] > arr[largest]){
            largest = r;
        }
        if (largest != i){
            // swap arr[i] arr[largest]
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, largest);
        }

    }

    public static void main(String[] args) {
        int[] arr = {0,1,5,7,8,4,3,10,2};

        HeapApp heapApp = new HeapApp();
        heapApp.buildMaxHeap(arr);
    }
}
