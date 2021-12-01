import java.util.Arrays;
 
/**
 * Test class to sort array of integers using Quicksort algorithm in Java.
 *
 * @author Cristopher Moreira
 */
public class QuickSort {
 
    public static void main(String args[]) {
        // unsorted integer array
        String[] unsorted = {"Marcos Calderon", "Vatias Ruiz", "Daniela Goretti", "Marcos Hurtado", "Marcos Phillips"};
        System.out.println("Unsorted array :" + Arrays.toString(unsorted));
 
        QuickSortName algorithm = new QuickSortName();
 
        // sorting integer array using quicksort algorithm
        algorithm.sort(unsorted);
 
        // printing sorted array
        System.out.println("Sorted array :" + Arrays.toString(unsorted));
    }
}
 
class QuickSortName {
 
    private String input[];
    private int length;
 
    public void sort(String[] names) {
 
        if (names == null || names.length == 0) {
            return;
        }
 
        this.input = names;
        length = names.length;
        quickSort(0, length - 1);
    }
 
    /*
     * This method implements in-place quicksort algorithm recursively.
     */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;
 
        // pivot is middle index
        String pivot = input[low + (high - low) / 2];
 
        // Divide into two arrays
        while (i <= j) {
            /**
             * As shown in above image, In each iteration, we will identify a
             * number from left side which is greater then the pivot value, and
             * a number from right side which is less then the pivot value. Once
             * search is complete, we can swap both numbers.
             */
            while (input[i].charAt(0) < pivot.charAt(0)) {
                i++;
            }
            while (input[j].charAt(0) > pivot.charAt(0)) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                // move index to next position on both sides
                i++;
                j--;
            }
        }
 
        // calls quickSort() method recursively
        if (low < j) {
            quickSort(low, j);
        }
 
        if (i < high) {
            quickSort(i, high);
        }
    }
 
    private void swap(int i, int j) {
        String temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
