package week5;

import java.util.concurrent.TimeUnit;

/**
 * Изучить алгоритм пузырьковой сортировки.
 * Написать простую реализацию с замером времени и количеством сравнений и перестановок
 */
public class BubbleSort {
    public static void sort(int[] arr){
        long swapCount = 0;                 // кол-во перестановок
        long compareCount = 0;              // кол-во сравнений
        long time = System.nanoTime();

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                compareCount += 1;
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapCount += 1;
                }
            }
        }
        time = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - time);

        System.out.print("Sort is completed!\nSorted array: ");
        printIntArr(arr);
        System.out.println("\nNumber of comparisons: " + compareCount + "\nNumber of swaps: " + swapCount
                + "\nTime: " + time + " ms");
    }

    public static void printIntArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("(" + arr[i] + ")");
            if (i < arr.length - 1)
                System.out.print(", ");
        }
    }
}
