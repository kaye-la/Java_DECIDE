package com.kaye_la;

import week5.BubbleSort;

public class TestWeek5 {
    // Bubble sort - test
    public static void run(){
        System.out.println("-----------Bubble sort - Test-----------");
        int[] arr = new int[1000];

        for (int i = 0; i < arr.length; i++){
            arr[i] = ((int) (Math.random() * 1001) + 627);
        }
        System.out.print("Unsorted array: ");
        BubbleSort.printIntArr(arr);
        BubbleSort.sort(arr);
    }
}
