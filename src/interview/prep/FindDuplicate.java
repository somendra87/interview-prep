package interview.prep;

/**
 * @author somendraprakash created on 11/07/20
 */
public class FindDuplicate
{
    private static int duplicate(int[] arr) {
        /* Your class should be named DuplicateInArray
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        for (int i = 0; i < arr.length - 1; i++) {
            int key = arr[i];
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (key == arr[j]) {
                    return key;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 7, 2, 5, 4, 7, 1, 3, 6};
        System.out.println(duplicate(arr));
    }
}
